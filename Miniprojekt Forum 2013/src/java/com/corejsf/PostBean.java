/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;


import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Lizette
 */
@Named
@RequestScoped
public class PostBean {
    private Post post=new Post();
    @Inject
    private CategoryBean category;
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
    
    public String createPost(){
      return category.addPost(post); 
    }
    
    public String deletePost(){
        return category.removePost(post);
    }
    
    public String addComment(Comment comment){
        post.addComment(comment);
        return "";
    }
    
    public String removeComment(Comment comment){
        post.removeComment(comment);
        return "";
    }
}
