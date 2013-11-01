/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Tobias
 */
@ManagedBean
@RequestScoped
public class CategoryBean implements Serializable {
    private Category category=new Category();
    private Category selected;
    
    @Inject
    private Service service;
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
    
    public String createCategory(){
        service.addCategory(category);
        return "Post";
    }
    
    public String removeCategory(){
        service.removeCategory(category);
        return "Category";
    }
    
    public String addPost(Post post){
        category.addPost(post);
        return "Posts";
    }
    
    public String removePost(Post post){
        category.removePost(post);
        return "";
    }
    
}
