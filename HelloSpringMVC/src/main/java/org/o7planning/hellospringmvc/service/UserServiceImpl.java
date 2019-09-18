package org.o7planning.hellospringmvc.service;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.o7planning.hellospringmvc.dao.UserDAO;
import org.o7planning.hellospringmvc.model.User;
import org.o7planning.hellospringmvc.model.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	public void createUser(UserInfor userInfor) {
		userDAO.createUser(userInfor);
	}
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDAO.getUser(id);
	}
	@Override
	public void deleteUer(int id) {
		// TODO Auto-generated method stub
		userDAO.deleteUser(id);
	}
	@Override
	public void editUser(UserInfor userInfor) {
		// TODO Auto-generated method stub
		userDAO.editUser(userInfor);
	}
	@Override
	public void showPhoto(HttpServletResponse response,int id) throws IOException {
		userDAO.showPhoto(response, id);
		
	}
	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		return userDAO.getUserByUsernameAndPassword(username, password);
	}
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.getUserByUsername(username);
	}
	
}
