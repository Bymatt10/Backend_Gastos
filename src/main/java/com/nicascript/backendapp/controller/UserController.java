package com.nicascript.backendapp.controller;

import com.nicascript.backendapp.response.StandardResponseDto;
import com.nicascript.backendapp.response.userDto.UserDto;
import com.nicascript.backendapp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.nicascript.backendapp.response.StandardResponseDto.GenerateHttpResponse;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public ResponseEntity<StandardResponseDto> getAllUser() {
        var response = userService.getAllUser();
        return GenerateHttpResponse(response);
    }

    @PostMapping("/create")
    public ResponseEntity<StandardResponseDto> createUser(@RequestBody @Valid UserDto userDto) {
        var response = userService.createUser(userDto);
        return GenerateHttpResponse(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StandardResponseDto> deleteById(@PathVariable Long id) {
        var response = userService.deleteById(id);
        return GenerateHttpResponse(response);
    }
    @PutMapping("/edit/{id}")
    public  ResponseEntity<StandardResponseDto>editUser(@PathVariable Long id, @RequestBody UserDto user){
        var response = userService.editUser(id, user);
        return GenerateHttpResponse(response);
    }
}
