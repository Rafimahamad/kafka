package com.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private int statusCode;
    private String message;
    private String field; // For capturing the failed field name
    private String status;
    private String path;
    private LocalDateTime timestamp;
}
