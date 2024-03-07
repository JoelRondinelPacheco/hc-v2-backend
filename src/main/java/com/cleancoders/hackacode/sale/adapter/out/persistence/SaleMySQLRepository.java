package com.cleancoders.hackacode.sale.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface SaleMySQLRepository extends JpaRepository<SaleEntity, Long> {
//    @Query("SELECT s FROM SaleEntity s WHERE DAY(s.createdAt) = DAY(:createdAt) AND MONTH(s.createdAt) = MONTH(:createdAt) AND YEAR(s.createdAt) = YEAR(:createdAt)")
//    List<SaleEntity> byDay(@Param("createdAt") Date createdAt);

    List<SaleEntity> findByCreatedAt(LocalDate localDate);

    List<SaleEntity> findByCreatedAtBetween(LocalDate startOfDay, LocalDate endOfDay);

    @Query(value = "SELECT * FROM sale s WHERE MONTH(s.created_at) = :mes", nativeQuery = true)
    List<SaleEntity> fetchByMonth(@Param("mes") int mes);
    @Query(value = "SELECT * FROM sale s WHERE MONTH(s.created_at) = :month AND YEAR(s.created_at) = :year", nativeQuery = true)
    List<SaleEntity> fetchByMonthAndYear(@Param("month") int month, @Param("year") int year);

    @Query(value = "SELECT * FROM sale s WHERE MONTH(s.created_at) = :month AND YEAR(s.created_at) = :year AND DAY(s.created_at) = :day", nativeQuery = true)
    List<SaleEntity> fetchByMonthAndYearAndDay(@Param("month") int month, @Param("year") int year, @Param("day") int day);


}

