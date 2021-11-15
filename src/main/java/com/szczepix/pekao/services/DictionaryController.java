package com.szczepix.pekao.services;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pekao24.api.domains.dictionary.DictionaryService;
import pl.pekao24.api.domains.dictionary.dto.DictionaryBankDataGetResponse;
import pl.pekao24.api.domains.dictionary.dto.DictionaryTransactionCategoriesResponse;

@RestController
@RequestMapping("dictionary")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    public DictionaryController(final DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping(value = "/transaction-categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DictionaryTransactionCategoriesResponse> getTransactionCategories() {
        return ResponseEntity.ok(this.dictionaryService.transactionCategories());
    }

    @GetMapping(value = "/bank/data/get/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DictionaryBankDataGetResponse> getBankDataGet(@PathVariable String accountNumber) {
        return ResponseEntity.ok(this.dictionaryService.bankDataGet(accountNumber));
    }
}
