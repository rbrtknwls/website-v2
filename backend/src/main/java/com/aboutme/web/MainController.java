package com.aboutme.web;

import com.aboutme.model.Response;
import com.aboutme.service.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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