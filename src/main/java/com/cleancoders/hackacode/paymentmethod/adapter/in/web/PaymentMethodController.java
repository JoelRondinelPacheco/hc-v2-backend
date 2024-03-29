package com.cleancoders.hackacode.paymentmethod.adapter.in.web;

import com.cleancoders.hackacode.paymentmethod.application.dto.NewPaymentMethodDTO;
import com.cleancoders.hackacode.paymentmethod.application.port.in.PaymentMethodPersistence;
import com.cleancoders.hackacode.paymentmethod.application.port.in.PaymentMethodSelector;
import com.cleancoders.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment-method")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodPersistence paymentMethodPersistence;
    @Autowired
    private PaymentMethodSelector paymentMethodSelector;

    @PostMapping
    public ResponseEntity<PaymentMethod> newPaymentMethod(@RequestBody NewPaymentMethodDTO body) {
        return ResponseEntity.ok(this.paymentMethodPersistence.newPaymentMethod(body));
    }

    @GetMapping
    public ResponseEntity<Page<PaymentMethod>> getPaginated(Pageable pageable) {
        return ResponseEntity.ok(this.paymentMethodSelector.getAll(pageable));
    }

    @PutMapping
    public ResponseEntity<PaymentMethod> editMethod(@RequestBody PaymentMethod body) {
        return ResponseEntity.ok(this.paymentMethodPersistence.edit(body));
    }

    /*
    TODO EDIT
     */

}
