package com.hoangnt.service.user;

import com.hoangnt.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> allUser();

    void addUser(UserDTO userDTO);
}
