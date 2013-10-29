
package com.corejsf;


import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value="service")
@ApplicationScoped
public class Service {
    
    private List<User> users= new ArrayList<>();

	public Service() {
            User u = new User("Lizette", 25, "Liz", 111);
            u.setAdmin(true);
            users.add(u);
            
            User u2 = new User("Tobias", 22, "Toby", 222);
            u2.setAdmin(true);
            users.add(u2);
            
            User u3 = new User("Casper", 21, "Casp", 333);
            u3.setAdmin(true);
            users.add(u3);
            
            User u4 = new User("Henrik", 34, "Zulatin", 444);
            u4.setAdmin(true);
            users.add(u4);
            
            User u5 = new User("Dummy", 99, "Dummy", 555);
            users.add(u5);
	}
        
        public void addUser(User user){
            users.add(user);
        }
        
        public void removeUser(User user){
            users.remove(user);
        }
        
        public List<User> getUsers(){
            return users;
        }
	public User getValidUser(User user) {
		for (User u : users) {
			if (u.getName().equals(user.getName())
					&& u.getPassword()==user.getPassword()) {
				return u;
			}
		}
		return null;
	}

}
