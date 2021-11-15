package com.szczepix.pekao.services;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pekao24.api.domains.loan.LoanService;
import pl.pekao24.api.domains.loan.dto.LoanDetailsResponse;
import pl.pekao24.api.domains.loan.dto.LoanOfferResponse;
import pl.pekao24.api.domains.loan.dto.LoanSummaryResponse;

@RestController
@RequestMapping("loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(final LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping(value = "/offer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanOfferResponse> getLoanOffer() {
        return ResponseEntity.ok(this.loanService.offer());
    }

    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanSummaryResponse[]> getLoanSummary() {
        return ResponseEntity.ok(this.loanService.summary());
    }

    @GetMapping(value = "/details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanDetailsResponse> getLoadDetails(@PathVariable String id) {
        return ResponseEntity.ok(this.loanService.details(id));
    }
}
