/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Henrik
 */
public class Category {
    private List<Post> posts = new ArrayList<>();;
    private User owner;
    private String title;
    private long time;
    private Date date;
    private String stamp;
    
    public Category(User owner, String title){
        this.owner = owner;
        this.title = title;
        
    }

    Category() {
        this(null, "");
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title=title;
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
    
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    public String getDate() {
        date = new Date(getTime());
        DateFormat formatter = new SimpleDateFormat("hh:mm EEEEEEEEEE");
        stamp = formatter.format(date);
        return stamp;
    }
    
    public Category copy(){
        Category c=new Category();
        c.owner=owner;
        c.title=title;
        return c;
    }
}
