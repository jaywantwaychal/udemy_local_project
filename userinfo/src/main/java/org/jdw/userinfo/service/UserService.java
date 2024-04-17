package org.jdw.userinfo.service;

import org.jdw.userinfo.dto.UserDTO;
import org.jdw.userinfo.entity.User;
import org.jdw.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO addUser(UserDTO userDTO) {
        User user = User.builder()
                .name(userDTO.getName())
                .password(userDTO.getPassword())
                .address(userDTO.getAddress())
                .city(userDTO.getCity()).build();
        User savedUser = userRepository.save(user);
        UserDTO savedUserDTO = UserDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .password(savedUser.getPassword())
                .address(savedUser.getAddress())
                .city(savedUser.getCity()).build();
        return savedUserDTO;

    }

    public ResponseEntity<UserDTO> getUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
           User savedUser = user.get();

            UserDTO savedUserDTO = UserDTO.builder()
                    .id(savedUser.getId())
                    .name(savedUser.getName())
                    .password(savedUser.getPassword())
                    .address(savedUser.getAddress())
                    .city(savedUser.getCity()).build();
            return new ResponseEntity<>(savedUserDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
