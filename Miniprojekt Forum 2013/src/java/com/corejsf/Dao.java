/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corejsf;



import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Lizette
 */
@Named()
@ApplicationScoped
public class Dao {

 // private  List<Comment> comments;
  //private  List<Post> posts;
  private  List<Category> categories;
  private  List<User> users;
  private static Dao uniqueInstance;
  
  public Dao(){
      //comments=new ArrayList<Comment>();
      //posts=new ArrayList<Post>();
      categories=new ArrayList<Category>();
      users=new ArrayList<User>();
  }
  
    public static Dao getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Dao();
        }
        return uniqueInstance;
    }
    
   // public List<Comment> getAllComments(){
   //     return new ArrayList<Comment>(comments);
   // }
    
   // public List<Post> getAllPosts(){
   //     return new ArrayList<Post>(posts);
   // }
    
    public List<Category> getAllCategories(){
        return new ArrayList<Category> (categories);
    }
    
    public List<User> getAllUsers(){
        return new ArrayList<User>(users);
    }
    
  //  public void addComment(Comment comment) {
  //	if (!comments.contains(comment)){
  //          comments.add(comment);
  //      }
  // }
    
  //  public void addPost(Post post) {
  //	if (!posts.contains(post)){
  //         posts.add(post);
  //      }
  //  }
    
    public void addCategory(Category category) {
	if (!categories.contains(category)){
            categories.add(category);
        }
    }
   
    public void addUser(User user) {
	if (!users.contains(user)){
            users.add(user);
        }
    }
    
   // public void deleteComment(Comment comment) {
   //	comments.remove(comment);
   // }
    
  //  public void deletePost(Post post) {
  //	posts.remove(post);
  //  }
    
    public void removeCategory(Category category) {
  	categories.remove(category);
   }
    
    public void removeUser(User user) {
	users.remove(user);
    }
      
}
