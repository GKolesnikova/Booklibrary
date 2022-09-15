package com.example.booklibrary.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllBooks_returnsAllBook() throws Exception {
       // GIVEN

        String expectJson = """
                [
                    {
                        "title": "Hans im Glück",
                        "author": "Jacob Grimm",
                        "id": "1"
                    },
                    {
                        "title": "Java ist auch eine Insel",
                        "author": "Christian Ullenboom",
                        "id": "2"
                    },
                    {
                        "title": "Die besten Flachwitze für Coaches",
                        "author": "Dominic",
                        "id": "3"
                    }
                ]
                """;

       // WHEN & THEN
       mockMvc.perform(get("/book"))
               .andExpect(status().isOk())
               .andExpect(content().json(expectJson));
    }


    @Test
    void getBookById_returnsBook() throws Exception {
        // GIVEN

        String expectJson = """
                
                    {
                        "title": "Hans im Glück",
                        "author": "Jacob Grimm",
                        "id": "1"
                    }
                
                """;

        // WHEN & THEN
        mockMvc.perform(get("/book/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectJson));

    }


}