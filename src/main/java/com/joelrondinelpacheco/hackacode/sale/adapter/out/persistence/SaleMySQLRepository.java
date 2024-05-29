package com.joelrondinelpacheco.hackacode.sale.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface SaleMySQLRepository extends JpaRepository<SaleEntity, Long> {
//    @Query("SELECT s FROM SaleEntity s WHERE DAY(s.createdAt) = DAY(:createdAt) AND MONTH(s.createdAt) = MONTH(:createdAt) AND YEAR(s.createdAt) = YEAR(:createdAt)")
//    List<SaleEntity> byDay(@Param("createdAt") Date createdAt);

    List<SaleEntity> findByCreatedAt(LocalDate localDate);

    List<SaleEntity> findByCreatedAtBetween(LocalDate startOfDay, LocalDate endOfDay);

    @Query(value = "SELECT * FROM sale s WHERE MONTH(s.created_at) = :mes", nativeQuery = true)
    Page<SaleEntity> fetchByMonth(@Param("mes") int mes, Pageable pageable);
    @Query(value = "SELECT * FROM sale s WHERE MONTH(s.created_at) = :month AND YEAR(s.created_at) = :year", nativeQuery = true)
    Page<SaleEntity> fetchByMonthAndYear(@Param("month") int month, @Param("year") int year, Pageable pageable);

    @Query(value = "SELECT * FROM sale s WHERE MONTH(s.created_at) = :month AND YEAR(s.created_at) = :year AND DAY(s.created_at) = :day", nativeQuery = true)
    Page<SaleEntity> fetchByMonthAndYearAndDay(@Param("month") int month, @Param("year") int year, @Param("day") int day, Pageable pageable);


}

