package com.joelrondinelpacheco.hackacode.common.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiSubError {
        private String field;
        private Object rejectedValue;
        private String message;
}
