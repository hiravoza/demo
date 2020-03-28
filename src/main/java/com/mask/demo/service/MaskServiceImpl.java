package com.mask.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MaskServiceImpl implements MaskService {
	
	@Override
	public String maskPhoneNumber(String phoneNumber) {
		return String.format("%s%s%s", phoneNumber.substring(0, 6), "***", phoneNumber.substring(9, 14));
	}

	@Override
	public String maskEmail(String email)  {
		String[] parts = email.split("@");
        
		String strId = "";
        if(parts[0].length() < 3) {
			strId = maskString(parts[0], 0, parts[0].length());
		} else {
			strId = maskString(parts[0], 1, parts[0].length() - 1);
		}

        return strId + "@" + parts[1];
	}
	
	private static String maskString(String strText, int start, int end) {
			int maskLength = end - start;
	        StringBuilder sbMaskString = new StringBuilder(maskLength);
	        
	        for(int i = 0; i < maskLength; i++){
	            sbMaskString.append('*');
	        }
	        
	        return strText.substring(0, start)   + sbMaskString.toString()  + strText.substring(start + maskLength);
	    }

}
