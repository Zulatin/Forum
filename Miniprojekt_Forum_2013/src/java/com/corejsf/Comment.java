/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

/**
 *
 * @author Henrik
 */
public class Comment {
    private User owner;
    private String message;
    
    public Comment(){
    }
    
    public Comment(User owner, String message){
        this.owner = owner;
        this.message = message;
    }
    
    public User getOwner(){
        return owner;
    }
    
    public String getMessage(){
        return message;
    }
    
    public Comment copy(){
        Comment c=new Comment();
        c.owner=owner;
        c.message=message;
        return c;
    }
    
}
