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
        return "velkommen";
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
        return "velkommen";
    }
    
    public String addPost(){
        selected.addPost(post.getPost());
        return post.toPosts();
    }
    
    public String removePost(Post post){
        category.removePost(post);
        return "velkommen";
    }
    
    public List<Post> getPosts(){
        return selected.getPosts();
        
    }
}
