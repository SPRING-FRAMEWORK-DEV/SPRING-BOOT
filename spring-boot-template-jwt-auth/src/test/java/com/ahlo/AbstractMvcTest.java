package com.ahlo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ahlo.Application;
import com.ahlo.dao.EmployeeDao;
import com.ahlo.dao.UserDao;
import com.ahlo.model.LoginUser;
import com.ahlo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")

public class AbstractMvcTest {
	protected MockMvc mockMvc;
	protected ObjectMapper mapper = new ObjectMapper();
	private static Set<Class> inited = new HashSet<>();

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@Autowired
	private UserDao userDao;

	@Autowired
	EmployeeDao employeeDao;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
				.addFilters(this.springSecurityFilterChain).build();
	}

	@Before
	public void init() throws Exception {
		if (!inited.contains(getClass())) {
			doInit();
			inited.add(getClass());
		}
	}

	protected void doInit() throws Exception {
	}

	protected String json(Object o) throws IOException {
		return mapper.writeValueAsString(o);
	}

	public ResultActions signupUser(String username, String password, int age, int salary)
			throws IOException, Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(age);
		user.setSalary(salary);

		return mockMvc.perform(post("/signup").content(json(user)).contentType(MediaType.APPLICATION_JSON));

	}

	protected ResultActions login(String username, String password) throws Exception {
		final LoginUser auth = new LoginUser();
		auth.setUsername(username);
		auth.setPassword(password);

		return mockMvc
				.perform(post("/token/generate-token").content(json(auth)).contentType(MediaType.APPLICATION_JSON));
	}

	protected String extractToken(MvcResult result) throws UnsupportedEncodingException {
		return JsonPath.read(result.getResponse().getContentAsString(), "$.token");
	}

	protected void deleteUsers() {
		userDao.deleteAll();
	}

	protected String getAuthToken(String userName, String password) throws UnsupportedEncodingException, Exception {
		return extractToken(login(userName, password).andReturn());
	}

}
