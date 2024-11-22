package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.Customer;
import com.teceats.teceatsapi.model.Sale;
import com.teceats.teceatsapi.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(Long id) {
        return saleRepository.findById(id);
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    public Sale updateSale(Long id, Sale updatedSale) {
        Optional<Sale> existingSaleOpt = saleRepository.findById(id);
        if (existingSaleOpt.isPresent()) {
            Sale existingSale = existingSaleOpt.get();

            // Actualizar los campos necesarios
            existingSale.setFechaVenta(updatedSale.getFechaVenta());
            existingSale.setTotal(updatedSale.getTotal()); // Asegúrate de que el tipo de dato es compatible

            // Actualizar el cliente relacionado
            Customer updatedCustomer = updatedSale.getCliente();
            if (updatedCustomer != null) {
                existingSale.setCliente(updatedCustomer);
            }

            // Guardar la venta actualizada en la base de datos
            return saleRepository.save(existingSale);
        } else {
            throw new RuntimeException("Sale not found with id " + id);
        }
    }
}
