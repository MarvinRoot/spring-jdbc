package com.spring.jdbc.hoxtify.model.filter;

public class UserFilter extends Filter{
    private String username;
    private String password;
    private String email;

    public UserFilter(long entityId) {
        super(entityId);
    }
    public UserFilter() {
    }

    public UserFilter(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean hasUsernameSet() {
        return username != null && !username.equals("");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean hasPasswordSet() {
        return password != null && !password.equals("");
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean hasEmailSet() {
        return email != null && !email.equals("");
    }
}
