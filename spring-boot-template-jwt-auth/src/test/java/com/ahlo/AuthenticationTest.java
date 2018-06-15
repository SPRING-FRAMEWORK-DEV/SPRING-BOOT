package com.ahlo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;

import com.ahlo.model.User;

public class AuthenticationTest extends AbstractMvcTest {
	
	
	@Override
	protected void doInit() throws Exception {
		deleteUsers();
		signupUser("Alex123", "password", 20, 2345).andExpect(status().isCreated());
	}

	@Test
	public void userRepositoryWithoutTokenIsForbidden() throws Exception {
		 mockMvc.perform(get("/user/1")).andExpect(status().is(401));
	}

	@Test
	public void userRepositoryWithTokenIsAllowed() throws Exception {
		final String token = getAuthToken("Alex123", "password"); // get login token
		final ResultActions resultActions 	=mockMvc.perform(get("/user").header("Authorization", "Bearer " +token)); // get response as result actions
	    resultActions.andExpect(status().isOk());// check status
	    String response= resultActions.andReturn().getResponse().getContentAsString();// get response as string
	    
	    User[] user=mapper.readValue(response, User[].class);// convert string response to pojo
	    assertEquals("Alex123", user[0].getUsername()); // do assert
	}

	@Test
	public void loginOk() throws Exception {
		ResultActions actions = login("Alex123", "password");
		actions.andExpect(status().isOk()).andExpect(jsonPath("$.token").exists()).andReturn();
	}

	@Test
	public void loginNok() throws Exception {
		login("Alex123", "wrongPassword").andExpect(status().is(HttpStatus.UNAUTHORIZED.value()));
	}

}
