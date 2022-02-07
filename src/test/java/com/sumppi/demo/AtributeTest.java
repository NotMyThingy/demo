package com.sumppi.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AtributeTest {

    @Autowired
    private MockMvc mockMvc;

    /*
     * VASTAUKSEN STATUS OK, 200
     */
    @Test
    public void statusOk() throws Exception {
        mockMvc.perform(get("/kofi"))
                .andExpect(status().isOk());
    }

    /*
     * KONTROLLERI PALAUTTAA MODELISSA ATRIBUUTIN
     */
    @Test
    public void modelHasAttributeMessages() throws Exception {
        mockMvc.perform(get("/kofi"))
                .andExpect(model().attributeExists("kaffet"));
    }

}
