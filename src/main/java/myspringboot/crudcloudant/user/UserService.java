package myspringboot.crudcloudant.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cloudant.client.api.CloudantClient;

@Service
public class UserService {

	@Autowired
	private CloudantClient client;

	@Value("${cloudant.dbname}")
	private String databaseName;

	public List<User> getAllUsers() {
		List<User> users = null;
		try {
			users = client.database(databaseName, false).getAllDocsRequestBuilder().includeDocs(true).build()
					.getResponse().getDocsAs(User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getUser(String id) {
		User user = null;
		try {
			user = client.database(databaseName, false).find(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void addUser(User user) {
		try {
			client.database(databaseName, false).save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUser(String id, User user) {
		try {
			User usertemp = client.database(databaseName, false).find(User.class, id);
			if(usertemp != null) {
				user.set_rev(usertemp.get_rev());
				client.database(databaseName, false).update(user);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(String id) {
		try {
			User user = client.database(databaseName, false).find(User.class, id);
			if (user != null) {
				client.database(databaseName, false).remove(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
