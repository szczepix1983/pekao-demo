package com.szczepix.pekao.services;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pekao24.api.domains.moneytransfer.MoneyTransferService;
import pl.pekao24.api.domains.moneytransfer.dto.MoneyTransferHistoryResponse;
import pl.pekao24.api.domains.moneytransfer.dto.MoneyTransferPredefinedListResponse;

@RestController
@RequestMapping("money-transfer")
public class MoneyTransferController {

    private final MoneyTransferService moneyTransferService;

    public MoneyTransferController(final MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @GetMapping(value = "/predefined/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MoneyTransferPredefinedListResponse> getPredefinedList() {
        return ResponseEntity.ok(this.moneyTransferService.predefinedList());
    }

    @GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MoneyTransferHistoryResponse> getHistory() {
        return ResponseEntity.ok(this.moneyTransferService.history());
    }
}
