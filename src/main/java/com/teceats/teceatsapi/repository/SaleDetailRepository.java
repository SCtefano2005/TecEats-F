package com.teceats.teceatsapi.repository;

import com.teceats.teceatsapi.model.SaleDetail;
import com.teceats.teceatsapi.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
    List<SaleDetail> findBySale(Sale sale);
}
