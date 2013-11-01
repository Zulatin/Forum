/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Lizette
 */
@ManagedBean
@RequestScoped
public class CommentBean {
    private Comment comment=new Comment();
    
    @Inject 
    private PostBean post;
    /**
     * Creates a new instance of CommentBean
     */
    public CommentBean() {
    }
    
    public Comment getComment(){
        return comment;
    }
    
    public String createComment(){
        return post.addComment(comment);
    }
    
    public String removeComment(){
        return post.removeComment(comment);
    }
    
}
