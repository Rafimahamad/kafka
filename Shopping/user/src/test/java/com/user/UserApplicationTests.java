package com.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@WebMvcTest(UserController.class)
class UserApplicationTests {

//	@Autowired
//	private MockMvc mockMvc;

//	@Mock
//	private UserService userService;

//	@InjectMocks
//	private UserController controller;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testCreateUser() throws Exception{
//
//		UserDto user=new UserDto();
//		user.setUserId(12345);
//		user.setEmailId("rafi@gmail.com");
//		user.setName("Rafi");
//
//		Mockito.doNothing().when(userService).saveUser(Mockito.any(UserDto.class));
//
//		mockMvc.perform(MockMvcRequestBuilders.post("/user")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(" {\"userId\":\"12345\",\"emailId\": \"rafi@gmail.com\",\"name\":\"Rafi\"}" )
//				.accept(MediaType.APPLICATION_JSON)
//		         ).andExpect(status().isCreated());
//
//	}


}
