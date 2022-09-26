package com.cafe.CafeManagement.dto;

import com.cafe.CafeManagement.entity.Category;
import com.cafe.CafeManagement.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private long id;
    private String name;
    private String description;
    private List<Product> products;

    public boolean isNull() {
        return Stream.of(id, name, description, products)
                .allMatch(Objects::isNull);
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
    }
}
