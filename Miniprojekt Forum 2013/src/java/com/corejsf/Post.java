/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrik
 */
public class Post {
    private List<Comment> comments;
    private User owner;
    private String message;
    
    public Post(){
    }
    
    public Post(User owner, String message){
        comments = new ArrayList<>();
        this.owner = owner;
        this.message = message;
    }
    
    public void addComment(Comment c){
        comments.add(c);
    }
    
    public void removeComment(Comment c){
        comments.remove(c);
    }
    
    public List<Comment> getComments(){
        return new ArrayList<>(comments);
    }
    
    public User getOwner(){
        return owner;
    }
    
    public String getMessage(){
        return message;
    }
    
    @Override
    public String toString(){
        return message;
    }
    
    public Post copy(){
        Post p=new Post();
        p.owner=owner;
        p.message=message;
        return p;
    }
    
}
