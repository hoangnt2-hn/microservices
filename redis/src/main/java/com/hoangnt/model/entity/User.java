package com.hoangnt.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RedisHash("user")
public class User {

    @Id
    private String id;
    private String name;
}
