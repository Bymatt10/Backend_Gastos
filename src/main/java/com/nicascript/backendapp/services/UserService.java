package com.nicascript.backendapp.services;

import com.nicascript.backendapp.entity.UserEntity;
import com.nicascript.backendapp.repository.UserRepository;
import com.nicascript.backendapp.response.StandardResponseDto;
import com.nicascript.backendapp.response.userDto.UserDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public StandardResponseDto getAllUser() {
        var list = userRepository.findAll();
        return new StandardResponseDto(HttpStatus.OK, list);
    }

    public StandardResponseDto createUser(UserDto userDto) {
        var save = userRepository.save(new UserEntity(userDto));
        return new StandardResponseDto(HttpStatus.CREATED, save);
    }

    public StandardResponseDto editUser(Long id, UserDto userDto) {
        var searchUser = userRepository.findById(id);
        if (searchUser.isEmpty()) {
            return new StandardResponseDto(HttpStatus.NOT_FOUND);
        }
        var updateReserve = userRepository.save(new UserEntity(id, userDto));
        return new StandardResponseDto(HttpStatus.OK, updateReserve);
    }

    public StandardResponseDto deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            return new StandardResponseDto(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return new StandardResponseDto(HttpStatus.OK);
    }
}
