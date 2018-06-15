package com.ahlo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import com.ahlo.model.EmployeeVO;
import com.ahlo.response.AhloResponse;

public class EmployeeCrudITest extends AbstractMvcTest {

	@Before
	public void before() {
		employeeDao.deleteAll();
	}

	@After
	public void after() {
		employeeDao.deleteAll();
	}

	@Override
	protected void doInit() throws Exception {
		deleteUsers();
		signupUser("Alex123", "password", 20, 2345).andExpect(status().isCreated());
	}

	@Test
	public void addEmployeeTest() throws IOException, Exception {

		final String token = getAuthToken("Alex123", "password"); // get login token
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setFirstName("monami");
		employeeVO.setLastName("vo");
		employeeVO.setEmail("monami@gmail.com");

		ResultActions resultActions = mockMvc.perform(post("/employee/").header("Authorization", "Bearer " + token)
				.content(json(employeeVO)).contentType(MediaType.APPLICATION_JSON)); // get

		resultActions.andExpect(status().isOk());// check status
		String response = resultActions.andReturn().getResponse().getContentAsString();// get response as string
		AhloResponse ahloResponse = mapper.readValue(response, AhloResponse.class);// convert string response to pojo
		assertNotNull(ahloResponse.getData());

		String data = mapper.writeValueAsString(ahloResponse.getData());

		EmployeeVO[] employeeVOs = mapper.readValue(data, EmployeeVO[].class);

		assertTrue(employeeVOs.length == 1);
		Arrays.stream(employeeVOs).forEach(e -> {
			assertTrue(e.getEmail().equals("monami@gmail.com"));
		});

		// duplicate email insertion not allowed
		resultActions = mockMvc.perform(post("/employee/").header("Authorization", "Bearer " + token)
				.content(json(employeeVO)).contentType(MediaType.APPLICATION_JSON)); // get
		resultActions.andExpect(status().is(HttpStatus.FOUND.value()));

	}

	@Test
	public void getAllEmployeesTest() throws UnsupportedEncodingException, Exception {
		final String token = getAuthToken("Alex123", "password"); // get login token
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setFirstName("monami");
		employeeVO.setLastName("vo");
		employeeVO.setEmail("monami@gmail.com");

		ResultActions resultActions = mockMvc.perform(post("/employee/").header("Authorization", "Bearer " + token)
				.content(json(employeeVO)).contentType(MediaType.APPLICATION_JSON)); // get

		resultActions.andExpect(status().isOk());// check status

		EmployeeVO employeeVO1 = new EmployeeVO();
		employeeVO1.setFirstName("monami");
		employeeVO1.setLastName("vo");
		employeeVO1.setEmail("monami.1@gmail.com");

		resultActions = mockMvc.perform(post("/employee/").header("Authorization", "Bearer " + token)
				.content(json(employeeVO1)).contentType(MediaType.APPLICATION_JSON)); // get

		resultActions.andExpect(status().isOk());// check status

		// do get all
		resultActions = mockMvc.perform(get("/employee/").header("Authorization", "Bearer " + token));
		String response = resultActions.andReturn().getResponse().getContentAsString();// get response as string
		AhloResponse ahloResponse = mapper.readValue(response, AhloResponse.class);// convert string response to pojo
		assertNotNull(ahloResponse.getData());

		String data = mapper.writeValueAsString(ahloResponse.getData());

		EmployeeVO[] employeeVOs = mapper.readValue(data, EmployeeVO[].class);

		assertTrue(employeeVOs.length == 2);

		int count = 0;
		for (EmployeeVO emp : employeeVOs) {
			if (emp.getEmail().equals("monami@gmail.com"))
				count = count + 1;

			if (emp.getEmail().equals("monami.1@gmail.com"))
				count++;
		}

		assertEquals(count, 2);

	}

	@Test
	public void getEmployeeByIdTest() throws IOException, Exception {
		final String token = getAuthToken("Alex123", "password"); // get login token
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setFirstName("monami");
		employeeVO.setLastName("vo");
		employeeVO.setEmail("monami@gmail.com");

		ResultActions resultActions = mockMvc.perform(post("/employee/").header("Authorization", "Bearer " + token)
				.content(json(employeeVO)).contentType(MediaType.APPLICATION_JSON)); // get
		resultActions.andExpect(status().isOk());// check status

		String response = resultActions.andReturn().getResponse().getContentAsString();
		AhloResponse ahloResponse = mapper.readValue(response, AhloResponse.class);// convert string response to pojo
		assertNotNull(ahloResponse.getData());
		String data = mapper.writeValueAsString(ahloResponse.getData());
		EmployeeVO[] employeeVOs = mapper.readValue(data, EmployeeVO[].class);
		assertTrue(employeeVOs.length == 1);

		long id = employeeVOs[0].getEmployeeId();

		// do get by id
		resultActions = mockMvc.perform(get("/employee/" + id).header("Authorization", "Bearer " + token));
		response = resultActions.andReturn().getResponse().getContentAsString();// get response as string
		ahloResponse = mapper.readValue(response, AhloResponse.class);// convert string response to pojo
		assertNotNull(ahloResponse.getData());

		data = mapper.writeValueAsString(ahloResponse.getData());

		employeeVOs = mapper.readValue(data, EmployeeVO[].class);

		assertTrue(employeeVOs.length == 1);

		for (EmployeeVO emp : employeeVOs) {
			assertTrue(emp.getEmail().equals("monami@gmail.com"));
		}
	}

}
