package com.hemza.rental_backend.dto;


/**
 * Cette classe est utilisée pour encapsuler le token JWT
 * renvoyé au client après une authentification ou un enregistrement réussi.
 */
public class AuthSuccess {

    private String token;

    public AuthSuccess() {
    }

    public AuthSuccess(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
