package com.process.ugroup.service.impl;

import com.process.ugroup.entity.Group;
import com.process.ugroup.repository.GroupRepository;
import com.process.ugroup.service.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }
}
