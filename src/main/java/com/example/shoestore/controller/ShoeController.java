package com.example.shoestore.controller;

import com.example.shoestore.entity.Shoe;
import com.example.shoestore.service.ShoeService;
import com.example.shoestore.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shoes")
public class ShoeController {
    private final ShoeService shoeService;
    private final BrandService brandService;

    public ShoeController(ShoeService shoeService, BrandService brandService) {
        this.shoeService = shoeService;
        this.brandService = brandService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("shoes", shoeService.findAll());
        return "shoes/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("shoe", new Shoe());
        model.addAttribute("brands", brandService.findAll());
        return "shoes/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Shoe shoe) {
        shoeService.save(shoe);
        return "redirect:/shoes";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("shoe", shoeService.findById(id));
        model.addAttribute("brands", brandService.findAll());
        return "shoes/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        shoeService.deleteById(id);
        return "redirect:/shoes";
    }
}
