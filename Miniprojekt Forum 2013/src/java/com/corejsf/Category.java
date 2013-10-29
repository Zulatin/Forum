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
public class Category {
    private List<Post> posts;
    private User owner;
    private String title;
    
    public Category(User owner, String title){
        posts = new ArrayList<>();
        this.owner = owner;
        this.title = title;
        
    }
    
    public String getTitle(){
        return title;
    }
    
    public void addPost(Post p){
        posts.add(p);
    }
    
    public void removePost(Post p){
        posts.remove(p);
    }
    
    public List<Post> getPosts(){
        return new ArrayList<>(posts);
    }
    
    public User getOwner(){
        return owner;
    }
}
