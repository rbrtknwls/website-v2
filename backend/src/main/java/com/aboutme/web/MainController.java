package com.aboutme.web;

import com.aboutme.model.Response;
import com.aboutme.service.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/v1/")
@RequiredArgsConstructor
public class MainController {

    @Autowired
    RoutingService routingService;
    @GetMapping(value = "/getInfo/{infoType}")
    public ResponseEntity<Response<Object>> getDateAndTime(@PathVariable String infoType) {

        return Response.buildSuccessfulResponse(routingService.getResponse(infoType));
    }
}