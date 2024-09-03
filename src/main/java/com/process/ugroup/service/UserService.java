package com.process.ugroup.service;

import com.process.ugroup.entity.Group;
import com.process.ugroup.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    User getByUserName(String userName);
    //void deleteUser(int id);
    //List<User> getUsers();

    void addUserToGroup(String user, String group);
    //void removeUserFromGroup(User user, Group group);
}
