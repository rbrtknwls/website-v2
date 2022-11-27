package com.aboutme.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AllArgsConstructor
@Builder
public class Response<T> {
    private Boolean success;
    private List<String> errors;
    private T data;



    public static ResponseEntity<Response<Object>> buildSuccessfulResponse (Object data) {
        return new ResponseEntity<>(
                Response.builder()
                        .success(true)
                        .errors(null)
                        .data(data)
                        .build(),
                HttpStatus.OK
        );
    }

    public static ResponseEntity<Response<Object>> buildFailedResponse (List<String> errors) {
        return new ResponseEntity<>(
                Response.builder()
                        .success(false)
                        .errors(errors)
                        .data(null)
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
