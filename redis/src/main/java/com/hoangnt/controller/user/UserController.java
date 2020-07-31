package com.hoangnt.controller.user;

import com.hoangnt.model.dto.UserDTO;
import com.hoangnt.model.entity.User;
import com.hoangnt.model.response.BaseResponse;
import com.hoangnt.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/")
public class UserController {

    private UserService userService;
    private RedisTemplate redisTemplate;

    @Autowired
    UserController(RedisTemplate redisTemplate) {
        this.userService = userService;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping(value = "userSearch/{name}")
    public String allUserSearch(@PathVariable String name) {
        redisTemplate.opsForValue().set("loda","hello world");

        // In ra màn hình Giá trị của key "loda" trong Redis
        return redisTemplate.opsForValue().get("loda").toString();
    }

//    @PostMapping(value = "user")
//    public ResponseEntity<BaseResponse<Void>> add(@RequestBody UserDTO userDTO) {
//        System.out.println(userDTO);
//        userService.addUser(userDTO);
//        return ResponseEntity.ok(new BaseResponse<Void>());
//    }
//
//    @GetMapping(value = "user")
//    public ResponseEntity<BaseResponse<List<UserDTO>>> all() {
//        return ResponseEntity.ok(new BaseResponse<List<UserDTO>>(userService.allUser()));
//    }
}
