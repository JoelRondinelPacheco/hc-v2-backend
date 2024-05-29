package com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.repository;

import com.joelrondinelpacheco.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceMySQLRepository extends JpaRepository<ServiceEntity, Long> {
    //@Query("SELECT new com.cleancoders.hackacode.service.application.dto.ServicePriceInfo(s.id, s.price) FROM ServiceEntity s WHERE s.id IN :ids")
  /*  @Query("SELECT s.id AS id, s.price AS price FROM ServiceEntity s WHERE s.id IN :ids")
    List<ServicePriceInfo> findAllServicePriceInfo(@Param("ids") List<Long> ids);*/
/*
    @Query("SELECT s.id AS id, s.price AS price FROM ServiceEntity s WHERE s.id = :id")
    ServicePriceInfoImpl findServiceProjection(@Param("id") Long id);
*/
}
