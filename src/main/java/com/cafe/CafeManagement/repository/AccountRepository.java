package com.cafe.CafeManagement.repository;

import com.cafe.CafeManagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
