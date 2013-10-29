/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package com.corejsf;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Tobias
 */


@Named
@SessionScoped
public class UserBean implements Serializable{
    
    private User validUser;
    @Inject
    private Service service;
    
    private User user = new User();
    private User selected;
    
    public boolean isSelected(){
        return selected != null;
    }
    
    public String newUser(){
        selected = null;
        user = new User();
        return "userDetail";
    }
    
    public String selectUser(User selected){
        this.selected = selected;
        user = selected.copy();
        return "userDetail";
    }
    
    public String createUser(){
        service.addUser(user);
        return toUserList();
    }
    
    public String updateUser(){
        selected.update(user);
        return toUserList();
    }
    
    public String deleteUser() {
        service.removeUser(selected);
        return toUserList();
    }
    
    public List<User> getUsers(){
        return service.getUsers();
    }
    
    public String toUserList(){
        selected = null;
        return "userList";
    }
    
    public User getUser() {
	return user;
    }
        
    public String login() {
	validUser = service.getValidUser(user);
	if (validUser != null) {
		user.update(validUser);
		return "welcome";
	} else {
		user = new User();
		return "error";
		}
	}
    
    
}
