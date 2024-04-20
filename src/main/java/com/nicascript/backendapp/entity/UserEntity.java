package com.nicascript.backendapp.entity;


import com.nicascript.backendapp.response.userDto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = " email", nullable = false)
    private String email;


    @Column(name = "password", nullable = false)
    private String password;

    public UserEntity(UserDto userDto) {
        this.id =userDto.getId();
        this.username = userDto.getUsername();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();

    }
    public UserEntity(Long id , UserDto userDto) {
        this.id = id;
        this.username = userDto.getUsername();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();

    }
}

