package org.jdw.userinfo.controller;

import org.jdw.userinfo.dto.UserDTO;
import org.jdw.userinfo.entity.User;
import org.jdw.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
}
