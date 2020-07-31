package com.hoangnt.service.user.impl;

import com.hoangnt.model.dto.UserDTO;
import com.hoangnt.model.entity.User;
import com.hoangnt.repository.UserRepository;
import com.hoangnt.service.user.UserService;
import com.hoangnt.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserDTO userDTO) {
        userRepository.save(ObjectMapperUtils.map(userDTO, User.class));
    }


    @Override
    public List<UserDTO> allUser() {
        return ObjectMapperUtils.mapAll((List<User>)userRepository.findAll(), UserDTO.class);
    }

}
