package com.mask.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaskedObj {
	String email;
	String phoneNumber;
	
}
