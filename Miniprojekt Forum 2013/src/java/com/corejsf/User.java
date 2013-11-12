/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

public class User {
    private int age;
    private String username;
    private String password;
    private String name;
    private boolean admin=false;
    private boolean sel=false;
    
     public User() {
        this("",0,"","");
    }
    
     public User(String name, int age, String username, String password){
        this.name=name;
        this.age=age;
        this.username=username;
        this.password=password;
    }

    public boolean isSel(){
        return sel;
    }
    
    public void setSel(boolean sel){
        this.sel=sel;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
   
    
    public void update(User user) {
		name = user.name;
		password = user.password;
                username = user.username;
                age = user.age;
                admin = user.admin;
    }
    
     public User copy(){
        User user = new User();
        user.name = name;
        user.age = age;
        user.password = password;
        user.admin = admin;
        user.username = username;
        return user;  
    }
    
    
    
}

