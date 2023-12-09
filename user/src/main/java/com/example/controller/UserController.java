package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/reg")
    public int userReg(@RequestBody User user) {
        User u = userMapper.selectByUsername(user.getUsername());
        if (u != null) {
            //username exits
            return 2;
        } else {
            userMapper.add(user);
            return 1;
            //add user
        }
    }

    @RequestMapping("/login")
    public int userLogin(@RequestBody User user) {
        User u = userMapper.selectByUsername(user.getUsername());
        if (u != null) {
            if (u.getPassword().equals(user.getPassword())) {
                return 1;//pws correct
            }
            return 2;//fault
        }
        return 3;//can't found username
    }

    @RequestMapping("/user/findId")
    public int findId(@RequestBody User user) {
        int id = user.getId();
        return id;
    }

    @RequestMapping("user/findAll")
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        return users;
    }

}
