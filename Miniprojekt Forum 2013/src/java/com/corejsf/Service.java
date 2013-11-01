
package com.corejsf;


import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Named;

@Named(value="service")
@ApplicationScoped
public class Service {
    
    
    private Dao dao;
    private Category currentCategory;
    private Post currentPost;
    
    public Service() {
    }
    
    //Added to prevent double amount of links on the website
    @PostConstruct
    public void makeCategory(){
        dao = Dao.getInstance();
        User u = new User("Lizette", 25, "Liz", "111");
        u.setAdmin(true);
        dao.addUser(u);
        
        User u2 = new User("Tobias", 22, "Toby", "222");
        u2.setAdmin(true);
        dao.addUser(u2);
        
        User u3 = new User("Casper", 21, "Casp", "333");
        u3.setAdmin(true);
        dao.addUser(u3);
        
        User u4 = new User("Henrik", 34, "Zulatin", "444");
        u4.setAdmin(true);
        dao.addUser(u4);
        
        User u5 = new User("Dummy", 99, "Dummy", "555");
        dao.addUser(u5);
        
        Category c=new Category(u,"Fagligt");
        dao.addCategory(c);
        
        Category c1=new Category(u2,"Fritid");
        dao.addCategory(c1);
        
        Category c2=new Category(u3,"Computer");
        dao.addCategory(c2);
        
        Category c3=new Category(u4,"Opskrifter");
        dao.addCategory(c3);
        
        Post p = new Post(u5, "TEST");
        c2.addPost(p);
        
        Comment com = new Comment(u5, "SVIN");
        p.addComment(com);
        
    }
    
    public void addUser(User user){
        dao.addUser(user);
    }
    
    public void removeUser(User user){
        dao.deleteUser(user);
    }
    
    public List<User> getUsers(){
        return dao.getAllUsers();
    }
    public User getValidUser(User user) {
        User result=null;
        for (User u : getUsers()) {
            if (u.getName().equals(user.getName())
                    && u.getPassword().equals(user.getPassword())) {
                result=u;
            }
        }
        return result;
    }
    
    public List<Comment>getComments(){
        return dao.getAllComments();
    }
    
    public List<Post>getPosts(){
        return dao.getAllPosts();
    }
    
    public List<Category>getCategories(){
        return dao.getAllCategories();
    }
    
    public void addCategory(Category category){
        dao.addCategory(category);
    }
    
    public void removeCategory(Category category){
        dao.deleteCategory(category);
    }
    
    public void deleteUser(User u){
        for (Category c : getCategories()){
            for (Post p : c.getPosts()){
                for (Comment c2 : p.getComments()){
                    if (c2.getOwner().equals(u)){
                        dao.deleteComment(c2);
                    }
                }
                if (p.getOwner().equals(u)){
                    dao.deletePost(p);
                }
            }
            if (c.getOwner().equals(u)){
                dao.deleteCategory(c);
            }
        }
    }
    
    public String setCurrentCategory(String title){
        currentCategory = findCategory(title);
        return "posts";
    }
    
    public Category getCurrentCategory(){
        return currentCategory;
    }
    
    public Category findCategory(String title){
        Category result = null;
        boolean found = false;
        Iterator<Category> itr = getCategories().iterator();
        while (!found && itr.hasNext()){
            Category temp = itr.next();
            if (temp.getTitle().equals(title)){
                result = temp;
                found = true;
            }
        }
        return result;
    }
    
    public String setCurrentPost(String message){
        currentPost = findCurrentPost(message);
        return "comments";
    }
    
    public Post findCurrentPost(String message){
        Post result = null;
        boolean found = false;
        Iterator<Post> itr = currentCategory.getPosts().iterator();
        while (!found && itr.hasNext()){
            Post temp = itr.next();
            if (temp.getMessage().equals(message)){
                result = temp;
                found = true;
            }
        }
        return result;
    }
    
    public Post getCurrentPost(){
        return currentPost;
    }
    
}
