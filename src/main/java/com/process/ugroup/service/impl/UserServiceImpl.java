package com.process.ugroup.service.impl;

import com.process.ugroup.entity.Group;
import com.process.ugroup.entity.User;
import com.process.ugroup.repository.GroupRepository;
import com.process.ugroup.repository.UserRepository;
import com.process.ugroup.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public UserServiceImpl(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void addUserToGroup(String userName, String groupName) {
        User user = userRepository.findByUserName(userName);
        Group group = groupRepository.findByGroupName(groupName);
        group.getUsers().add(user);
    }
}
