package com.corejsf;



import java.io.Serializable;
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
public class CommentBean implements Serializable {
    private Comment comment=new Comment();
    private Comment selected;
    @Inject 
    private UserBean user;
    /**
     * Creates a new instance of CommentBean
     */
    public CommentBean() {
    }
    
    public Comment getComment(){
        comment.setOwner(user.getLoginUser());
        comment.setTime(System.currentTimeMillis());
        return comment;
    }
    
    public String newComment(){
        selected=null;
        comment=new Comment();
        comment.setOwner(user.getLoginUser());
        return "comments";
    }
    
}
