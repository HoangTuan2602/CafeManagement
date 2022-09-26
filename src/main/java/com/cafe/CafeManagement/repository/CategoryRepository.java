package com.cafe.CafeManagement.repository;

import com.cafe.CafeManagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
