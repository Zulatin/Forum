/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;



import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Lizette
 */
@Named("commentBean")
@RequestScoped
public class CommentBean implements Serializable {
    private Comment comment=new Comment();
    /**
     * Creates a new instance of CommentBean
     */
    public CommentBean() {
    }
    
    public Comment getComment(){
        return comment;
    }
    
    
}
