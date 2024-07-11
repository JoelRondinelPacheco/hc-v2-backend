package com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence;

import com.joelrondinelpacheco.hackacode.common.PersistenceAdapter;
import com.joelrondinelpacheco.hackacode.common.domain.EntityAlreadyExistsException;
import com.joelrondinelpacheco.hackacode.common.domain.PersistenceException;
import com.joelrondinelpacheco.hackacode.paymentmethod.adapter.out.persistence.mapper.PaymentMethodMapper;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.out.PaymentMethodPersistencePort;
import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

@PersistenceAdapter
public class PaymentMethodPersistenceMySQLAdapter implements PaymentMethodPersistencePort {

    @Autowired
    private PaymentMethodMySQLRepository paymentMethodMySQLRepository;

    @Autowired
    private PaymentMethodMapper mapper;

    @Override
    public PaymentMethod newPaymentMethod(PaymentMethod paymentMethod) {
     try {
        PaymentMethodEntity paymentMethodEntity = this.paymentMethodMySQLRepository.save(this.mapper.domainToEntity(paymentMethod));

        PaymentMethod paymentMethodSaved = this.mapper.entityToDomain(paymentMethodEntity);
        paymentMethodSaved.setId(paymentMethodEntity.getId());

        return paymentMethodSaved;
    } catch (DuplicateKeyException e) {
        throw new EntityAlreadyExistsException("Payment Method: " + paymentMethod.getType() + ", already exists.");
    } catch (ConstraintViolationException | DataIntegrityViolationException e) {
        throw new PersistenceException((e.getMessage()));
    }
    }

    @Override
    public PaymentMethod edit(PaymentMethod body) {
        PaymentMethodEntity paymentMethodEntity = this.mapper.domainToEntity(body);
        paymentMethodEntity.setId(body.getId());

        return this.mapper.entityToDomain(this.paymentMethodMySQLRepository.save(paymentMethodEntity));
    }
}
