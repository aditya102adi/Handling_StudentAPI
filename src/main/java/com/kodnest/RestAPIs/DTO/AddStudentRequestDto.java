package com.kodnest.RestAPIs.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddStudentRequestDto {
    @NotBlank(message = "Name is Required")
    @Size(min = 3, max = 30, message = "Name should be min 3 and max 3 characters")
    private String name;


    @Email
    @NotBlank(message = "Email is Required")
    private String email;


    public AddStudentRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
