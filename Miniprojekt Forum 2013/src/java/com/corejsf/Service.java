
package com.corejsf;


import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value="service")
@ApplicationScoped
public class Service {
    
    private List<User> users= new ArrayList<User>();

	public Service() {
		users.add(new User("Niels",30,"Tarzan", 111));
		users.add(new User("Janne",25,"Jane", 222));
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
