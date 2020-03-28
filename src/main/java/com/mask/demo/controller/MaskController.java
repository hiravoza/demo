package com.mask.demo.controller;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mask.demo.model.MaskedObj;
import com.mask.demo.model.ResponseObj;
import com.mask.demo.service.MaskService;

@RestController
@Validated
public class MaskController {
	
	@Autowired
	MaskService maskService;
	
	@GetMapping(value = "/mask")
    public ResponseObj getEventsByDateRangeAndShipCode(
			@Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$",
                message = "Invalid Email address format")
    			@RequestParam(required = false) String email,
    		@Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}",
                message = "Phone Number format must be (123) 456-7890")
    			@RequestParam(required = false) String phoneNumber
    		) {
        
		MaskedObj maskedObj = new MaskedObj();
		
		if(email != null) {
			maskedObj.setEmail(maskService.maskEmail(email));
		}
		
		if(phoneNumber != null) {
			maskedObj.setPhoneNumber(maskService.maskPhoneNumber(phoneNumber));
		}
		
		return new ResponseObj(200, "SUCCESS", maskedObj);
    }
}
