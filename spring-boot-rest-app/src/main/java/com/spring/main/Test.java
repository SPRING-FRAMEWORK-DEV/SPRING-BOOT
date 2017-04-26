package com.spring.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		@SuppressWarnings("rawtypes")
		Map map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");

		headers.setAll(map);

		@SuppressWarnings("rawtypes")
		Map req_payload = new HashMap();
		req_payload.put("userName", "xyz");
		req_payload.put("password", "abc1");

		@SuppressWarnings("rawtypes")
		HttpEntity request = new HttpEntity(req_payload, headers);
		String url = "http://localhost:9999/spring-boot-rest/user/validate";

		ResponseEntity<?> response = new RestTemplate().postForEntity(url,
				request, String.class);

		System.out.println(response.getBody());
	}

}
