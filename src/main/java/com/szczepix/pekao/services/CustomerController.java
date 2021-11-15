package com.szczepix.pekao.services;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pekao24.api.domains.customer.CustomerService;
import pl.pekao24.api.domains.customer.dto.CustomerDetailsResponse;
import pl.pekao24.api.domains.customer.dto.CustomerProfileBasicResponse;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/profile/basic", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerProfileBasicResponse> getProfileBasic() {
        return ResponseEntity.ok(this.customerService.profileBasic());
    }

    @GetMapping(value = "/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDetailsResponse> getDetails() {
        return ResponseEntity.ok(this.customerService.details());
    }
}
