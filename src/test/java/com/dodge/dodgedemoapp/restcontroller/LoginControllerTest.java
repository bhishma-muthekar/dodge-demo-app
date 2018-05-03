package com.dodge.dodgedemoapp.restcontroller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dodge.dodgedemoapp.entity.User;
import com.dodge.dodgedemoapp.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LoginController.class)
public class LoginControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private UserRepository userRepositoryMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void test() throws Exception {
		User user = new User("testUser", "testPassword", "ADMIN");
		
		ObjectMapper mapper = new ObjectMapper();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/login").content(mapper.writeValueAsString(user)).accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testSave() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/save-user"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
