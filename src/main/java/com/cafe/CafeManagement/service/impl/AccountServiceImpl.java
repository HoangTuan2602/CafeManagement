package com.cafe.CafeManagement.service.impl;

import com.cafe.CafeManagement.dto.AccountDTO;
import com.cafe.CafeManagement.entity.Account;
import com.cafe.CafeManagement.exception.InvalidRequestException;
import com.cafe.CafeManagement.repository.AccountRepository;
import com.cafe.CafeManagement.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<AccountDTO> accountDTOList = new ArrayList<>();
        accountRepository.findAll().stream().forEach(account -> accountDTOList.add(new AccountDTO(account)));
        return accountDTOList;
    }

    @Override
    public AccountDTO findById(long id) {
        boolean exists = accountRepository.existsById(id);
        if (exists) {
            Optional<Account> account = accountRepository.findById(id);
            return new AccountDTO(account.get());
        }
        return null;
    }

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        if (accountDTO.isNull())
            throw new InvalidRequestException("Invalid request. Please check again!");
        Account account = Account.builder()
                .userName(accountDTO.getUserName())
                .password(accountDTO.getPassword())
                .role(accountDTO.isRole())
                .build();
        return new AccountDTO(accountRepository.save(account));
    }

    @Override
    public AccountDTO update(AccountDTO accountDTO, long id) {
        if (accountDTO.isNull())
        {
            throw new InvalidRequestException("Invalid request. Please check again!");
        }
        Account updateAccount = accountRepository.findById(id)
                .map(account -> {
                    account.setUserName(accountDTO.getUserName());
                    account.setPassword(accountDTO.getPassword());
                    account.setRole(accountDTO.isRole());
                    return accountRepository.save(account);
                }).orElseGet(() -> {
                    accountDTO.setId(id);
                    return accountRepository.save(Account.builder()
                            .id(accountDTO.getId())
                            .userName(accountDTO.getUserName())
                            .password(accountDTO.getPassword())
                            .role(accountDTO.isRole())
                            .build());
                });
        return new AccountDTO(updateAccount);
    }

    @Override
    public AccountDTO del(long id) {
        boolean exists = accountRepository.existsById(id);
        if (exists) {
            Optional<Account> deleteAccount = accountRepository.findById(id);
            accountRepository.deleteById(id);
            return new AccountDTO(deleteAccount.get());
        }
        return null;
    }
}
