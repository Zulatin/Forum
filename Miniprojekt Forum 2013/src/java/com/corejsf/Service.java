
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
    
    public Service() {
    }
    
    //Added to prevent double amount of links on the website
    @PostConstruct
    public void makeCategory(){
        dao = Dao.getInstance();
        
        //Users on the website
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
        
        //Categories on the website        
        Category c=new Category(u,"Fagligt");
        c.setTime(System.currentTimeMillis());
        dao.addCategory(c);
        
        Category c1=new Category(u2,"Fritid");
        c1.setTime(System.currentTimeMillis());
        dao.addCategory(c1);
        
        Category c2=new Category(u3,"Computer");
        c2.setTime(System.currentTimeMillis());
        dao.addCategory(c2);
        
        Category c3=new Category(u4,"Opskrifter");
        c3.setTime(System.currentTimeMillis());
        dao.addCategory(c3);
        
        //Posts on the website 
         Post p = new Post(u, "Valg af bøger");
         p.setTime(System.currentTimeMillis());
        c.addPost(p);
        
        Post p2 = new Post(u2, "Køb af hest");
        p2.setTime(System.currentTimeMillis());
        c1.addPost(p2);
        
        Post p3 = new Post(u3, "Valg af bærbar");
        p3.setTime(System.currentTimeMillis());
        c2.addPost(p3);
        
        Post p4 = new Post(u4, "Opskrift til tomatsuppe, lol");
        p4.setTime(System.currentTimeMillis());
        c3.addPost(p4);
        
//        Comments on website 
        Comment com = new Comment(u5, "Skal jeg købe en mac?");
        com.setTime(System.currentTimeMillis());
        p3.addComment(com);
        
        Comment com1 = new Comment(u2, "Mac er lort!");
        com1.setTime(System.currentTimeMillis());
        p3.addComment(com1);
        
        
        
    }
    
    public void addUser(User user){
        dao.addUser(user);
    }
    
    public void removeUser(User user){
        dao.removeUser(user);
    }
    
    public List<User> getUsers(){
        return dao.getAllUsers();
    }
    public User getValidUser(User user) {
        User result=null;
        for (User u : getUsers()) {
            if (u.getUsername().equals(user.getUsername())
                    && u.getPassword().equals(user.getPassword())) {
                result=u;
            }
        }
        return result;
    }
    
    public List<Category>getCategories(){
        return dao.getAllCategories();
    }
    
    public void addCategory(Category category){
        dao.addCategory(category);
    }
    
    public void removeCategory(Category category){
        dao.removeCategory(category);
    }
    
    public void deleteUser(User u){
        for (Category c : getCategories()){
            for (Post p : c.getPosts()){
                for (Comment c2 : p.getComments()){
                    if (c2.getOwner().equals(u)){
                        p.removeComment(c2);
                    }
                }
                if (p.getOwner().equals(u)){
                    c.removePost(p);
                }
            }
            if (c.getOwner().equals(u)){
                dao.removeCategory(c);
            }
        }
        dao.removeUser(u);
    }
    
}