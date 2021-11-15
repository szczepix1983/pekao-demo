package com.szczepix.pekao.services;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pekao24.api.domains.account.AccountService;
import pl.pekao24.api.domains.account.dto.AccountCardDebitSummaryResponse;
import pl.pekao24.api.domains.account.dto.AccountLimitsResponse;
import pl.pekao24.api.domains.account.dto.AccountSummaryResponse;
import pl.pekao24.api.domains.account.dto.AccountTransactionsResponse;

@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(final AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountSummaryResponse[]> getSummary() {
        return ResponseEntity.ok(this.accountService.summary());
    }

    @GetMapping(value = "/card/debit/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountCardDebitSummaryResponse[]> getCardDebitSummary() {
        return ResponseEntity.ok(this.accountService.cardDebitSummary());
    }

    @GetMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountTransactionsResponse[]> getTransactions(@RequestParam String accountIds,
                                                                         @RequestParam String dateFrom,
                                                                         @RequestParam String dateTo,
                                                                         @RequestParam boolean synchronize) {
        return ResponseEntity.ok(this.accountService.transactions(
                accountIds, dateFrom, dateTo, synchronize));
    }

    @GetMapping(value = "/limits/{accountIds}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountLimitsResponse> getLimits(@PathVariable String accountIds) {
        return ResponseEntity.ok(this.accountService.limits(accountIds));
    }
}
