package com.app.config.test;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.spring.model.UserModel;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	Gson gson;

	@Test
	public void getUserDummy() throws Exception {
		String json = gson.toJson(new UserModel("abc", "def"));
		mvc.perform(
				MockMvcRequestBuilders.get("/user/dummy").accept(
						MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo(json)));
	}

	@Test
	public void postValidUser() throws Exception {

		String json = gson.toJson(new UserModel("xyz", "abc"));

		mvc.perform(
				MockMvcRequestBuilders.post("/user/validate")
						.contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}

	@Test
	public void postInvalidUser() throws Exception {
		String json = gson.toJson(new UserModel("xyz", "abc1"));

		mvc.perform(
				MockMvcRequestBuilders.post("/user/validate")
						.contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().is(11401));
	}

}