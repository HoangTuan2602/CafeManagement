package com.cafe.CafeManagement.controller;

import com.cafe.CafeManagement.dto.AccountDTO;
import com.cafe.CafeManagement.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountDTO findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping()
    public AccountDTO create(@RequestBody AccountDTO accountDTO) {
        return accountService.create(accountDTO);
    }

    @PutMapping("/{id}")
    public AccountDTO update(@RequestBody AccountDTO model, @PathVariable Long id) {
        return accountService.update(model, id);
    }

    @DeleteMapping("/{id}")
    public AccountDTO del(@PathVariable Long id) {
        return accountService.del(id);
    }
}
