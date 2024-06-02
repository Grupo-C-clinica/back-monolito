package com.example.back_monolito.Dto;

public class TokenDto {

    private String token;
    private Integer id;
    private String rol;

    public TokenDto() {
    }

    public TokenDto(String token, Integer id, String rol) {
        this.token = token;
        this.id = id;
        this.rol = rol;
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

    @Override
    public String toString() {
        return "TokenDTO{" +
                "token='" + token + '\'' +
                ", id=" + id +
                ", rol=" + rol +
                '}';
    }
}
