/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;



import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Lizette
 */
@Named()
@ApplicationScoped
public class PostBean implements Serializable {
    private Post post=new Post();
    private Post selected=null;
    @Inject
    private CommentBean comment;
  
    
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
        return "comments";
    }
    
    public String newPost(){
        selected=null;
        post=new Post();
        return "post";
    }
    
    
    public List<Comment>getComments(){
        return selected.getComments();
    }
    
    public String addComment(){
        selected.addComment(comment.getComment());
        return "comments";
    }
    
    public String removeComment(){
        post.removeComment(comment.getComment());
        return "";
    }
    
    public String toPosts(){
        this.newPost();
        return "posts";
    }
}
