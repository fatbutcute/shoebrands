package com.example.shoestore.controller;
import com.example.shoestore.entity.Brand;
import com.example.shoestore.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("brands", service.findAll());
        return "brands/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("brand", new Brand());
        return "brands/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Brand brand) {
        service.save(brand);
        return "redirect:/brands";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("brand", service.findById(id));
        return "brands/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/brands";
    }
}
