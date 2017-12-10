/*
 * Copyright (c) 2011 Tah Wei Hoon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License Version 2.0,
 * with full text available at http://www.apache.org/licenses/LICENSE-2.0.html
 *
 * This software is provided "as is". Use at your own risk.
 */
package com.myopicmobile.textwarrior.common;

/**
 * Singleton class containing the symbols and operators of the Javascript language
 */
public class LanguageJavascript extends Language {
	private static Language _theOne = null;
	
	private final static String[] keywords = {
			"abstract","arguments","boolean","break","byte",
			"case","catch","char","class","const",
			"continue","debugger","default","delete","do",
			"double","else","enum","eval","export",
			"extends","false","final","finally","float",
			"for","function","goto","if","implements",
			"import","in","instanceof","int","interface",
			"let","long","native","new","null",
			"package","private","protected","public","return",
			"short","static","super","switch","synchronized",
			"this","throw","throws","transient","true",
			"try","typeof","var","void","volatile",
			"while","with","yield"
	};
	private final static char[] BASIC_OPERATORS = {
			'(', ')', '{', '}', '.', ',', ';', '=', '+', '-',
			'/', '*', '&', '!', '|', ':', '[', ']', '<', '>',
			'?', '~', '%', '^'
	};
	private  final  static  String[] funtions={

			"print"

	};
	public static Language getInstance(){
		if(_theOne == null){
			_theOne = new LanguageJavascript();
		}
		return _theOne;
	}
	
	private LanguageJavascript(){
		setKeywords(keywords);
		setOperators(BASIC_OPERATORS);
		setNames(funtions);
	}

	public boolean isLineAStart(char c){
		return false;
	}
}
