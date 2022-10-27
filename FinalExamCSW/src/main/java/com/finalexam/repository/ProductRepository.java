package com.finalexam.repository;

import com.finalexam.entity.ProductEntity;
import com.finalexam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
