package com.demo.demo.dtos;

import com.demo.demo.enumerations.EGender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    @NotBlank(message = "first name is required")
    private String firstName;

    @NotBlank(message = "last name is required")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp="\\d{10}",message = "Phone number must be exactly 10 digits")
    private String phone;

    @NotNull(message = "Gender can not be null")
    private EGender gender;

    @NotBlank(message = "password is required")
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter and one digit")
    private String password;
}
