package myspringboot.crudcloudant.user;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void getAllUsersTest() throws Exception {
		
		List<User> mockUsers = new ArrayList<>();
		mockUsers.add(new User("test_userid_1","test_firstname_1","test_lastname_1","test_email_1"));
		mockUsers.add(new User("test_userid_2","test_firstname_2","test_lastname_2","test_email_2"));
		mockUsers.add(new User("test_userid_3","test_firstname_3","test_lastname_3","test_email_3"));
				
		Mockito.when(userService.getAllUsers()).thenReturn(mockUsers);
		String uri = "/users";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		
		// get request test
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedResult = this.mapToJson(mockUsers);
		String testResult = result.getResponse().getContentAsString();
		
		assertThat(testResult).isEqualTo(expectedResult);
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper  objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
