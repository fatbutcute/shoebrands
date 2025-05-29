package com.example.shoestore.service;
import com.example.shoestore.entity.Brand;
import com.example.shoestore.entity.Shoe;
import com.example.shoestore.repository.BrandRepository;
import com.example.shoestore.repository.ShoeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ShoeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private BrandRepository brandRepository;

    private Long testBrandId;

    @BeforeEach
    public void setup() {
        shoeRepository.deleteAll();
        brandRepository.deleteAll();
        Brand brand = new Brand();
        brand.setName("TestBrand");
        testBrandId = brandRepository.save(brand).getId();
    }

    @Test
    public void testListShoesReturnsOK() throws Exception {
        mockMvc.perform(get("/shoes"))
                .andExpect(status().isOk())
                .andExpect(view().name("shoes/list"));
    }

    @Test
    public void testCreateShoeFormView() throws Exception {
        mockMvc.perform(get("/shoes/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("shoes/form"));
    }

    @Test
    public void testSaveShoe() throws Exception {
        mockMvc.perform(post("/shoes/save")
                        .param("model", "AirTest")
                        .param("brand.id", testBrandId.toString()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/shoes"));
    }

    @Test
    public void testDeleteShoe() throws Exception {
        Shoe shoe = new Shoe();
        shoe.setModel("DeleteShoe");
        shoe.setBrand(brandRepository.findById(testBrandId).orElse(null));
        shoe = shoeRepository.save(shoe);
        mockMvc.perform(get("/shoes/delete/" + shoe.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/shoes"));
    }
}