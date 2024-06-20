package com.joelrondinelpacheco.hackacode.common.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiError {
        private HttpStatus status;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private LocalDateTime timestamp;
        private String message;
        private List<ApiSubError> subErrors;
        /*
        url??
        backendmessage??
         */

}
