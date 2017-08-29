package com.example.cheesemvn.models;

import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


public class User {

    @NotNull
    @Size(min=1, max=16)
    private String username;


    @NotNull
    @Size(min=3, max=15, message = "")
    @Pattern(regexp = "[a-zA-Z0-9]+@[A-Za-z0-9_.]+", message = "exam-p_le67@mail.com")
    private String email;

    private int userId;

    public static int nextId;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9_]{3,16}", message = "letters, numbers and underscores allowed(3,16)")
    private String password;

    private Date date;

    public User(){
        userId = nextId;
        nextId++;
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.userId=nextId;


    }

    public Date getDate() {
        if (date == null){
            Calendar cal = Calendar.getInstance();
            date = cal.getTime();
//            date = new Date();
        }
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
