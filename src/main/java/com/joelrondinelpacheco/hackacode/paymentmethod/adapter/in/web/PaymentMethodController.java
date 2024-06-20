package com.joelrondinelpacheco.hackacode.paymentmethod.adapter.in.web;

import com.joelrondinelpacheco.hackacode.paymentmethod.application.dto.NewPaymentMethodDTO;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.in.PaymentMethodPersistence;
import com.joelrondinelpacheco.hackacode.paymentmethod.application.port.in.PaymentMethodSelector;
import com.joelrondinelpacheco.hackacode.paymentmethod.domain.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment-method")
public class PaymentMethodController {


    private final PaymentMethodPersistence paymentMethodPersistence;
    private final PaymentMethodSelector paymentMethodSelector;

    public PaymentMethodController(PaymentMethodPersistence paymentMethodPersistence, PaymentMethodSelector paymentMethodSelector) {
        this.paymentMethodPersistence = paymentMethodPersistence;
        this.paymentMethodSelector = paymentMethodSelector;
    }

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
}
