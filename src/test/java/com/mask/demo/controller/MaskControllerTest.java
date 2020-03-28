package com.mask.demo.controller;

import com.mask.demo.service.MaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MaskControllerTest {

    @MockBean
    private MaskService maskService;

    @Test
    public void checkIfEmailIsMaked() {
        String email = "a*c@yahoo.com";
        Mockito.when(maskService.maskEmail("abc@yahoo.com")).thenReturn(email);
    }

    @Test
    public void checkIfPhoneIsMaked() {
        String phoneNumber = "(123) ***-7890";
        Mockito.when(maskService.maskPhoneNumber("(123) 456-7890")).thenReturn(phoneNumber);
    }
}
