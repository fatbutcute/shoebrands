package com.example.shoestore.repository;

import com.example.shoestore.entity.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoe, Long> { }
