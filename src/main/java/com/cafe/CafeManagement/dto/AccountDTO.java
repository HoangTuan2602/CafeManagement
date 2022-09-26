package com.cafe.CafeManagement.dto;

import com.cafe.CafeManagement.entity.Account;
import com.cafe.CafeManagement.entity.Staff;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
public class AccountDTO {
    private long id;
    private String userName;
    private String password;
    private boolean role;
    private List<Staff> staffs;

    public boolean isNull() {
        return Stream.of(id, userName, password, role, staffs)
                .allMatch(Objects::isNull);
    }

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.userName = account.getUserName();
        this.password = account.getPassword();
        this.role = account.isRole(); // True - admin, False - staff
    }
}
