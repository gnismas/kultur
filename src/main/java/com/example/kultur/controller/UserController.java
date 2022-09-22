package com.example.kultur.controller;

import com.example.kultur.model.User;
import com.example.kultur.userservice.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> create(@RequestBody User user) {
        List<User> userList = iUserService.findAll();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equalsIgnoreCase(user.getName())) {
                return new ResponseEntity<>(user.getName() + " already exists", HttpStatus.OK);
            }
        }
        iUserService.save(user);
        return new ResponseEntity<>("New User :\"" + user.getName() + "\" created", HttpStatus.OK);
    }
}