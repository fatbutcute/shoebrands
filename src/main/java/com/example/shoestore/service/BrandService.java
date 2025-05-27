package com.example.shoestore.service;

import com.example.shoestore.entity.Brand;
import com.example.shoestore.repository.BrandRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandService {
    private final BrandRepository repository;

    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public List<Brand> findAll() { return repository.findAll(); }
    public Brand findById(Long id) { return repository.findById(id).orElse(null); }
    public Brand save(Brand brand) { return repository.save(brand); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
