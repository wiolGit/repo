package com.example.projecta.config;

import org.springframework.stereotype.Component;

import com.google.common.base.CharMatcher;



@Component
public class StringOperation {


	public String remoweLeadAndTrailChar(String str, char s1, char s2) {
		
		String rob = removeLeadingChar(str, s1);
		rob = removeTrailingChar(rob, s2);
		return rob;

	}
	

	
	private String removeLeadingChar(String s, char sym) {
	    return CharMatcher.is(sym).trimLeadingFrom(s);
	}
	 
	private String removeTrailingChar(String s, char sym) {
	    return CharMatcher.is(sym).trimTrailingFrom(s);
	}
	

}
