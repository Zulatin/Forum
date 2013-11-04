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
 * @author Tobias
 */
@Named
@RequestScoped
public class CategoryBean implements Serializable {
    private Category category=new Category();
    private Category selected;
    
    @Inject
    private Service service;
    @Inject
    private PostBean post;
    /**
     * Creates a new instance of CategoryBean
     */
    public CategoryBean() {
    }
    
    public Category getCategory(){
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
        return "posts";
    }
    
    public String createCategory(){
        service.addCategory(category);
        return "Post";
    }
    
    public String removeCategory(){
        service.removeCategory(category);
        return "Category";
    }
    
    public String addPost(){
        category.addPost(post.getPost());
        return "Posts";
    }
    
    public String removePost(){
        category.removePost(post.getPost());
        return "";
    }
}
