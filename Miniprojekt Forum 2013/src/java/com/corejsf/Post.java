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
public class Post {
    private List<Comment> comments;
    private User owner;
    private String message;
    private long time;
    private Date date;
    private String stamp;
    
    
    
    public Post(){
        comments=new ArrayList<>();
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
    
    public void setOwner(User owner){
        this.owner = owner;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void setMessage(String message){
        this.message=message;
    }
    
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
    
    public String getDate() {
        date = new Date(getTime());
        DateFormat formatter = new SimpleDateFormat("hh:mm EEEEEEEEEE dd/MM-yyyy");
        stamp = formatter.format(date);
        return stamp;
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
