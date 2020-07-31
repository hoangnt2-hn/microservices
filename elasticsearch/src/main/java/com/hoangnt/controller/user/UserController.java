package com.hoangnt.controller.user;

import com.hoangnt.model.dto.UserDTO;
import com.hoangnt.model.entity.User;
import com.hoangnt.model.response.BaseResponse;
import com.hoangnt.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "userSearch/{name}")
    public ResponseEntity<BaseResponse<List<UserDTO>>> allUserSearch(@PathVariable String name) {
        return ResponseEntity.ok(new BaseResponse<List<UserDTO>>(userService.allUserElasticsearch(name)));
    }
}
