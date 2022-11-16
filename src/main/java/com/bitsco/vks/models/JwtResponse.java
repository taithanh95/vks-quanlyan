package com.bitsco.vks.models;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;
    private String userId;


    public JwtResponse(String jwttoken, String userId) {

        this.jwttoken = jwttoken;
        this.userId = userId;
    }

    public String getToken() {

        return this.jwttoken;

    }
    public String getUserId() {

        return this.userId;

    }

}
