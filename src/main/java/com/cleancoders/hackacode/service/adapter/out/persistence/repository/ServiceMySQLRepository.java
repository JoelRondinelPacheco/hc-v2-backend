package com.cleancoders.hackacode.service.adapter.out.persistence.repository;

import com.cleancoders.hackacode.service.adapter.out.persistence.entity.ServiceEntity;
import com.cleancoders.hackacode.service.application.dto.ServicePriceInfo;
import com.cleancoders.hackacode.service.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceMySQLRepository extends JpaRepository<ServiceEntity, Long> {

    @Query("SELECT new com.cleancoders.hackacode.service.application.dto.ServicePriceInfo(s.id, s.price) FROM ServiceEntity s WHERE s.id IN :idd")
    List<ServicePriceInfo> findAllServicePriceInfo(@Param("ids") List<Long> ids);
}
