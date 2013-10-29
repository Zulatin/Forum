/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Casper
 */
public class User {
    private int age;
    private String username;
    private int passeword;
    private String name;
    private boolean admin=false;
    
     public User(String name, int age, String username, int password){
        this.name=name;
        this.age=age;
        this.username=username;
        this.passeword=password;
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

    public int getPasseword() {
        return passeword;
    }

    public void setPasseword(int passeword) {
        this.passeword = passeword;
    }
     public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
   
    
}
