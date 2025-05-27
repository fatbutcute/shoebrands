
package com.example.shoestore.service;

import com.example.shoestore.entity.Shoe;
import com.example.shoestore.repository.ShoeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShoeService {
    private final ShoeRepository repository;

    public ShoeService(ShoeRepository repository) {
        this.repository = repository;
    }

    public List<Shoe> findAll() { return repository.findAll(); }
    public Shoe findById(Long id) { return repository.findById(id).orElse(null); }
    public Shoe save(Shoe shoe) { return repository.save(shoe); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
