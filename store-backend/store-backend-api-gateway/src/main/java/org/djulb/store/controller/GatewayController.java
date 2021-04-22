package org.djulb.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/database")
public class GatewayController {

    @RequestMapping("")
    public String main () {
        return "hello from GatewayController";
    }

}
