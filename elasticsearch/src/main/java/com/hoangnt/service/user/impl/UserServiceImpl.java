package com.hoangnt.service.user.impl;

import com.hoangnt.model.dto.UserDTO;
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
    public List<UserDTO> allUserElasticsearch(String name) {
        return ObjectMapperUtils.mapAll(userRepository.findByName(name), UserDTO.class);
    }

}
