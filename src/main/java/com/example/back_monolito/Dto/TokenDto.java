package com.example.back_monolito.Dto;

public class TokenDto {

    private String token;
    private Integer id;
    private String rol;
    private String name;

    public TokenDto() {
    }

    public TokenDto(String token, Integer id, String rol, String name) {
        this.token = token;
        this.id = id;
        this.rol = rol;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TokenDto{" +
                "token='" + token + '\'' +
                ", id=" + id +
                ", rol='" + rol + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
