package com.cafe.CafeManagement.dto;

import com.cafe.CafeManagement.entity.Bill;
import com.cafe.CafeManagement.entity.Tbl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
public class TblDTO {
    private long id;
    private String name;
    private boolean status;

    private List<Bill> bills;

    public boolean isNull()
    {
        return Stream.of(id, name, status)
                .allMatch(Objects::isNull);
    }

    public TblDTO(Tbl tbl)
    {
        this.id = tbl.getId();
        this.name = tbl.getName();
        this.status = tbl.isStatus();
    }
}
