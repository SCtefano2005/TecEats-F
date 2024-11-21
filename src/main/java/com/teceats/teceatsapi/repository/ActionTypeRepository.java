package com.teceats.teceatsapi.repository;

import com.teceats.teceatsapi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionTypeRepository extends JpaRepository<ActionType, Long> {
}
