/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Henrik
 */
public class Comment {
    private User owner;
    private String message;
    private long time;

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
    private Date date;
    private String stamp;
    
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
    
    public void setMessage(String message){
        this.message=message;
    }
    
    public Comment copy(){
        Comment c=new Comment();
        c.owner=owner;
        c.message=message;
        return c;
    }
    
    public String getDate() {
        date = new Date(getTime());
        DateFormat formatter = new SimpleDateFormat("hh:mm EEEEEEEEEE");
        stamp = formatter.format(date);
        return stamp;
    }
    
    public String toString(){
        return message;
    }
    
}
