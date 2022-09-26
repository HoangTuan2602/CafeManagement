package com.cafe.CafeManagement.service;

import com.cafe.CafeManagement.dto.AccountDTO;

import java.util.List;

public interface AccountService{
    AccountDTO create(AccountDTO accountDTO);

    AccountDTO update(AccountDTO accountDTO, long id);

    AccountDTO del(long id);

    List<AccountDTO> getAllAccounts();

    AccountDTO findById(long id);
}
