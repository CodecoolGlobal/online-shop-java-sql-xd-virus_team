package com.codecool.xdvirus.onlineShop.model;

public class User {
    private int id;
    private String login;
    private String password;
    private int permission;

    public User(int id, String login, String password, int permission) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getPermission() {
        return permission;
    }

    @Override
    public String toString() {
        return this.id + " " +
                this.login + " " +
                this.password + " " +
                this.permission;
    }
}
