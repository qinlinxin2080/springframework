package com.alex.sf.thinking.ioc.overview.domain;

import com.alex.sf.thinking.ioc.overview.annotation.Super;

/**
 * @author alex_qlx
 */
@Super
public class SuperUser extends User {

    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "role='" + role + '\'' +
                "} " + super.toString();
    }
}
