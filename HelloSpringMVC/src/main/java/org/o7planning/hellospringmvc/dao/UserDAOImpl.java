package org.o7planning.hellospringmvc.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import org.o7planning.hellospringmvc.model.User;
import org.o7planning.hellospringmvc.model.UserInfor;
import org.o7planning.hellospringmvc.service.UserService;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@Autowired
	private UserService userService;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
	 
	public List<User> getUsers(){
        Criteria cr = getCurrentSession().createCriteria(User.class);
        
        return cr.list();
    }

	@Override
	public void createUser(UserInfor userInfor) {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setUsername(userInfor.getUsername());
		user.setMail(userInfor.getMail());
		user.setPhone(userInfor.getPhone());
		user.setPassword(userInfor.getPassword());
		 byte[] image = userInfor.getAvatar().getBytes();
		 user.setAvatar(image);
		 user.setAddress(userInfor.getAddress());
		 user.setRole(userInfor.getRole());
		getCurrentSession().save(user);
	}
	

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
	    User user = (User) getCurrentSession().get(User.class,id);
        return user;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = userService.getUser(id);
		getCurrentSession().delete(user);
	}

	@SuppressWarnings("null")
	@Override
	public void editUser(UserInfor userInfor) {
		User userUd = new User();
		User beginUser = (User) getCurrentSession().get(User.class, userInfor.getId());
		userUd.setId(userInfor.getId());
		userUd.setUsername(userInfor.getUsername());
		userUd.setMail(userInfor.getMail());
		userUd.setPhone(userInfor.getPhone());
		userUd.setPassword(userInfor.getPassword());
		userUd.setAddress(userInfor.getAddress());
		userUd.setRole(userInfor.getRole());
		byte[] image;
	  System.out.println("userdao ok userInfor.getAvatar() "+userInfor.getAvatar().getSize());
		 if(userInfor.getAvatar()==null||userInfor.getAvatar().getSize()==0) {
			 System.out.println("userdao ok uer "+userUd.getUsername());
			 image = beginUser.getAvatar();
			 userUd.setAvatar(image);
		 } 
		 else {
			 image = userInfor.getAvatar().getBytes();
			 userUd.setAvatar(image);
		 }
		 System.out.println("userdao ok uername  "+userUd.getUsername());
		 System.out.println("userdao ok avatar"+userUd.getAvatar().length);
		 getCurrentSession().merge(userUd);
		
	}

	@Override
	public User getUserInfor(int id) {
		User user = (User) getCurrentSession().get(User.class,id);
		
        return user;
	}

	@Override
	public void showPhoto(HttpServletResponse response,int id) throws IOException {
		response.setContentType("image/jpeg");
        System.out.println("getuserphotobyid: ok ok  vs id="+id);
        User user = userService.getUser(id);
		response.setHeader("Content-Disposition", "inline;filename=\""+ user.getUsername() + "\"");
		response.setContentType("image/jpeg");
		byte[] bytes = user.getAvatar();
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		Criteria cr = getCurrentSession().createCriteria(User.class);
        cr.add(Restrictions.eq("username",username));
        cr.add(Restrictions.eq("password",password));
        User user = (User) cr.list().get(0);		
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		Criteria cr = getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("username", username));
		
		User user = (User) cr.list().get(0);
		return user;
	}

	
}
