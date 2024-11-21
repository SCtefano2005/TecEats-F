package com.teceats.teceatsapi.controller;


import com.teceats.teceatsapi.model.SaleDetail;
import com.teceats.teceatsapi.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sale-details")
public class SaleDetailController {

    private final SaleDetailService saleDetailService;

    @Autowired
    public SaleDetailController(SaleDetailService saleDetailService) {
        this.saleDetailService = saleDetailService;
    }

    @GetMapping
    public ResponseEntity<List<SaleDetail>> getAllSaleDetails() {
        List<SaleDetail> saleDetails = saleDetailService.getAllSaleDetails();
        return new ResponseEntity<>(saleDetails, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDetail> getSaleDetailById(@PathVariable Long id) {
        Optional<SaleDetail> saleDetail = saleDetailService.getSaleDetailById(id);
        return saleDetail.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SaleDetail> createSaleDetail(@RequestBody SaleDetail saleDetail) {
        SaleDetail newSaleDetail = saleDetailService.createSaleDetail(saleDetail);
        return new ResponseEntity<>(newSaleDetail, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDetail> updateSaleDetail(@PathVariable Long id, @RequestBody SaleDetail updatedSaleDetail) {
        try {
            SaleDetail saleDetail = saleDetailService.updateSaleDetail(id, updatedSaleDetail);
            return new ResponseEntity<>(saleDetail, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSaleDetail(@PathVariable Long id) {
        saleDetailService.deleteSaleDetail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
