package com.mask.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseObj {
	int statusCode;
	String message;
	Object response;
}
