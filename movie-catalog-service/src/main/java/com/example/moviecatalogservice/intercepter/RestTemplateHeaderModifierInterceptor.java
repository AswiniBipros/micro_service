package com.example.moviecatalogservice.intercepter;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		request.getHeaders().add("Foo", "bar");
		ClientHttpResponse response = execution.execute(request, body);
		response.getHeaders().add("Foo", "bar");
		return response;
	}
}