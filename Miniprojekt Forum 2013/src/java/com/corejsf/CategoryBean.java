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
 * @author Tobias
 */
@Named
@ApplicationScoped
public class CategoryBean implements Serializable {
    private Category category=new Category();
    private Category selected;
 
    @Inject
    private PostBean post;
    @Inject
    private Service service;
    @Inject
    private UserBean user;
   
    /**
     * Creates a new instance of CategoryBean
     */
    public CategoryBean() {
    }
    
    public Category getCategory(){
        category.setOwner(user.getLoginUser());
        return category;
    }
    
    public boolean isSelected(){
        return selected!=null;
    }
    
    public String selectCategory(Category selected){
        this.selected=selected;
        category=selected.copy();
        return "posts";
    }
    
    public String newCategory(){
        selected=null;
        category=new Category();
        category.setOwner(user.getLoginUser());
        return "welcome";
    }
    
    public String createCategory(){
        service.addCategory(category);
        return newCategory();
    }
    
    public List<Category> getCategories(){
        return service.getCategories();
    }
    
    public String removeCategory(){
        service.removeCategory(category);
        return "welcome";
    }
    
    public String addPost(){
        selected.addPost(post.getPost());
        post.getPost().setTime(System.currentTimeMillis());
        return post.toPosts();
    }
    
    public String removePost(Post post){
        category.removePost(post);
        return "welcome";
    }
    
    public List<Post> getPosts(){
        return selected.getPosts();
        
    }
}
