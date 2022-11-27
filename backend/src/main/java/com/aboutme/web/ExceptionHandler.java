package com.aboutme.web;

import com.aboutme.exception.CouldNotFindData;
import com.aboutme.model.Response;
import com.aboutme.service.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CouldNotFindData.class)
    public ResponseEntity<Response<Object>> handleException(CouldNotFindData ex) {
        return Response.buildFailedResponse(List.of(ex));
    }
}