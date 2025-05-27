
package com.example.shoestore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shoe")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }
}
