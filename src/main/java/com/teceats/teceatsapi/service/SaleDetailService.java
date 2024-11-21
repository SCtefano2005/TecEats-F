package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.SaleDetail;
import com.teceats.teceatsapi.model.Sale;
import com.teceats.teceatsapi.repository.SaleDetailRepository;
import com.teceats.teceatsapi.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SaleDetailService {

    private final SaleDetailRepository saleDetailRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public SaleDetailService(SaleDetailRepository saleDetailRepository, SaleRepository saleRepository) {
        this.saleDetailRepository = saleDetailRepository;
        this.saleRepository = saleRepository;
    }

    public List<SaleDetail> getAllSaleDetails() {
        return saleDetailRepository.findAll();
    }

    public Optional<SaleDetail> getSaleDetailById(Long id) {
        return saleDetailRepository.findById(id);
    }

    public SaleDetail createSaleDetail(SaleDetail saleDetail) {
        SaleDetail newSaleDetail = saleDetailRepository.save(saleDetail);
        updateSaleTotal(saleDetail.getSale().getId());
        return newSaleDetail;
    }

    public SaleDetail updateSaleDetail(Long id, SaleDetail updatedSaleDetail) {
        Optional<SaleDetail> existingSaleDetailOpt = saleDetailRepository.findById(id);
        if (existingSaleDetailOpt.isPresent()) {
            SaleDetail existingSaleDetail = existingSaleDetailOpt.get();
            existingSaleDetail.setSale(updatedSaleDetail.getSale());
            existingSaleDetail.setDish(updatedSaleDetail.getDish());
            existingSaleDetail.setCantidad(updatedSaleDetail.getCantidad());
            existingSaleDetail.setSubtotal(updatedSaleDetail.getSubtotal());

            SaleDetail updatedDetail = saleDetailRepository.save(existingSaleDetail);
            updateSaleTotal(existingSaleDetail.getSale().getId());
            return updatedDetail;
        } else {
            throw new RuntimeException("SaleDetail not found with id " + id);
        }
    }

    public void deleteSaleDetail(Long id) {
        Optional<SaleDetail> saleDetailOpt = saleDetailRepository.findById(id);
        saleDetailOpt.ifPresent(saleDetail -> {
            saleDetailRepository.deleteById(id);
            updateSaleTotal(saleDetail.getSale().getId());
        });
    }

    private void updateSaleTotal(Long saleId) {
        Optional<Sale> saleOpt = saleRepository.findById(saleId);
        if (saleOpt.isPresent()) {
            Sale sale = saleOpt.get();
            List<SaleDetail> saleDetails = saleDetailRepository.findBySale(sale);

            BigDecimal total = saleDetails.stream()
                    .map(SaleDetail::getSubtotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            sale.setTotal(total);
            saleRepository.save(sale);
        }
    }
}
