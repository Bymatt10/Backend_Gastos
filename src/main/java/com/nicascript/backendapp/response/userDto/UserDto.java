package com.nicascript.backendapp.response.userDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private  Long id;

    @NotBlank(message = "username can't be null")
    private String username;

    @NotNull(message = "email can't be null")
    private String email;

    @NotNull(message = "password can't not be null")
    private String password;
}
