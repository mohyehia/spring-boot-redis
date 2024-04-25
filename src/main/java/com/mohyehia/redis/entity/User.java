package com.mohyehia.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("USERS")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private int salary;

    @TimeToLive
    private long timeToLive;
}
