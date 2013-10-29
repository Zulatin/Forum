/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

public class User {
    private int age;
    private String username;
    private int password;
    private String name;
    private boolean admin=false;
    
     public User(String name, int age, String username, int password){
        this.name=name;
        this.age=age;
        this.username=username;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
     public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    //Methods used in Userbean to registrer and updating User
    //Possibly missing a couple of update methods
     public User() {
        this("", 0, "", 0);
    }
    
       public void update(User user) {
		name = user.name;
		password = user.password;
    }
   
    
}

