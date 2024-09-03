package com.process.ugroup;

import com.process.ugroup.entity.Group;
import com.process.ugroup.entity.User;
import com.process.ugroup.service.GroupService;
import com.process.ugroup.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@SpringBootApplication
public class UgroupApplication implements CommandLineRunner {

	private final UserService userService;
	private final GroupService groupService;

	public UgroupApplication(UserService userService, GroupService groupService) {
		this.userService = userService;
		this.groupService = groupService;
	}

    @Override
	public void run(String... args) throws Exception {
		// add user
		userService.addUser(new User(null,"admin", null));
		userService.addUser(new User(null,"user", null));

		// add group
		groupService.addGroup(new Group(null, "USER", null));
		groupService.addGroup(new Group(null, "ADMIN", null));

		// add user to group
		userService.addUserToGroup("user", "USER");
		userService.addUserToGroup("admin", "USER");
		userService.addUserToGroup("admin", "ADMIN");

		// get user information
		User user = userService.getByUserName("admin");
		System.out.println("Username: " + user.getUserName());
		System.out.println("Group: ");
		for (Group group : user.getGroups()) {
			System.out.println(group.getGroupName());
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(UgroupApplication.class, args);
	}

}
