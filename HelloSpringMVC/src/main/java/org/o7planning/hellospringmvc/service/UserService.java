package org.o7planning.hellospringmvc.service;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.o7planning.hellospringmvc.model.User;
import org.o7planning.hellospringmvc.model.UserInfor;





public interface UserService {
	public List<User> getUsers();
    public User getUser( int id);
	public void createUser(UserInfor userInfor);
	public void deleteUer(int id);
	public void editUser(UserInfor userInfor);
	public void showPhoto(HttpServletResponse response,int id) throws IOException;
	public User getUserByUsernameAndPassword(String username, String password);
	public User getUserByUsername(String username);
}
