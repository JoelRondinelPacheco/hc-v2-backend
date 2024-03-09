package com.cleancoders.hackacode.sale.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemMySQLRepository extends JpaRepository<SaleItemEntity, Long> {
}
