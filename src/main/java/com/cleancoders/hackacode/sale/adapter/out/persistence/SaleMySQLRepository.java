package com.cleancoders.hackacode.sale.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SaleMySQLRepository extends JpaRepository<SaleEntity, Long> {
}
