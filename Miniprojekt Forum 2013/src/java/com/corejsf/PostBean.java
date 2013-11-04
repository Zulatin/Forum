/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;



import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Lizette
 */
@Named("postBean")
@RequestScoped
public class PostBean implements Serializable {
    private Post post=new Post();
    @Inject
    private CommentBean comment;
    private Post selected;
    
    public PostBean(){
    }
    
    public Post getPost(){
        return post;
    }
    
    public boolean isSelected(){
        return selected!=null;
    }
    
    public String selectPost(Post selected){
        this.selected=selected;
        post=selected.copy();
        return "Comment";
    }
    
    public String newPost(){
        selected=null;
        post=new Post();
        return "post";
    }
    public String addComment(){
        post.addComment(comment.getComment());
        return "";
    }
    
    public String removeComment(){
        post.removeComment(comment.getComment());
        return "";
    }
}
