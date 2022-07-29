package com.example.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MonthController.class)
@RunWith(SpringRunner.class)
public class MonthControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    public void shouldReturnMonthAbbreviationOnValidGetRequest() throws Exception {
        String outputJson = "Sep";mockMvc.perform(
                        get("/monthAbbreviation/9")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(outputJson));}

    @Test
    public void shouldReturn422ForInvalidMonthAbbreviationId() throws Exception {
        mockMvc.perform(
                        get("/monthAbbreviation/999")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

}