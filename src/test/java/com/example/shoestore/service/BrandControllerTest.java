package com.example.shoestore.service;
import com.example.shoestore.entity.Brand;
import com.example.shoestore.repository.BrandRepository;
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
public class BrandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BrandRepository brandRepository;

    @BeforeEach
    public void setup() {
        brandRepository.deleteAll();
    }

    @Test
    public void testListBrandsReturnsOK() throws Exception {
        mockMvc.perform(get("/brands"))
                .andExpect(status().isOk())
                .andExpect(view().name("brands/list"));
    }

    @Test
    public void testCreateFormView() throws Exception {
        mockMvc.perform(get("/brands/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("brands/form"));
    }

    @Test
    public void testSaveBrand() throws Exception {
        mockMvc.perform(post("/brands/save")
                        .param("name", "TestBrand"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/brands"));
    }

    @Test
    public void testDeleteBrand() throws Exception {
        Brand b = new Brand();
        b.setName("DeleteMe");
        b = brandRepository.save(b);
        mockMvc.perform(get("/brands/delete/" + b.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/brands"));
    }
}