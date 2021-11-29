package de.tekup.vue.repos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.tekup.vue.ui.models.User;
import lombok.Getter;

@Repository
public class UserDB {
	
	@Getter private static List<User> users;
	
	
	static{
		users = new ArrayList<>();
		users.add(new User(1,"user1", "user1", "user1@gmail.com", LocalDate.parse("1999-09-08")));
		users.add(new User(2,"user2", "user2", "user2@gmail.com", LocalDate.parse("2000-09-08")));
	}
	
	public static void addUser(User user) {
		if(user.getId()==0)
			user.setId(users.size()+1);
		if(user.getId()!=0)
			users.removeIf(u->u.getId()==user.getId());
		users.add(user);
	}
	
	public static void deleteUser(int id) {
		users.removeIf(user-> user.getId()==id);
	}
	
	public static User getUser(int id) {
		return users.stream()
		.filter(user-> user.getId()==id)
		.findFirst().get();
	}

}
