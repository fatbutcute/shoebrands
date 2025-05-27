package com.example.shoestore.repository;

import com.example.shoestore.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> { }
