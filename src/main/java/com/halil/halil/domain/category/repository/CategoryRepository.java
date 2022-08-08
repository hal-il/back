package com.halil.halil.domain.category.repository;

import com.halil.halil.domain.category.entity.Category;
import com.halil.halil.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
