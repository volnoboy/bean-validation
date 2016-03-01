package com.volnoboy.validator;

import java.net.MalformedURLException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Volodymyr Volnoboy
 * @since 2/29/16 8:20 PM
 */
public class URLValidator implements ConstraintValidator<URL, String> {

	private String protocol;

	private String host;

	private int port;

	@Override
	public void initialize(URL url) {
		this.protocol = url.protocol();
		this.host = url.host();
		this.port = url.port();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		java.net.URL url = null;

		try {
			url = new java.net.URL(value);
		} catch (MalformedURLException e) {
			return false;
		}

		if (protocol != null && protocol.length() > 0 && !url.getProtocol().equals(protocol)) return false;

		if (host != null && host.length() > 0 && !url.getHost().startsWith(host)) return false;

		if (port != -1 && url.getPort() != port) return false;

		return true;
	}


}
