package com.kodnest.RestAPIs.DTO;


import lombok.Data;

@Data
public class StudentDto {
    private long id;
    private String name;
    private String email;

    public StudentDto(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public StudentDto() {

    }

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}
