//responsavel por decodificar text
package com.barbarasousa.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String tex) {
		try {
			return URLDecoder.decode(tex, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
