package com.hoangnt.service.user;

import com.hoangnt.model.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<UserDTO> allUserElasticsearch(String name);
}
