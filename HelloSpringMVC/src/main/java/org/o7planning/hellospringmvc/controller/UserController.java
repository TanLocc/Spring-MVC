package org.o7planning.hellospringmvc.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.o7planning.hellospringmvc.model.User;
import org.o7planning.hellospringmvc.model.UserInfor;
import org.o7planning.hellospringmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;


@SuppressWarnings("unused")
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private SessionFactory sessionFactory ;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String getall(Model model) {
		System.out.println("usercontroller: ok");
		List<User> userList = userService.getUsers();
		
		model.addAttribute("userList", userList);
           
		return "UserList";

	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "createusermodel";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createuserAction(@RequestParam("name") String name, 
			@RequestParam("userName") String author,
			@RequestParam("publisher") String publisher, 
			@RequestParam("price") int price) {

		UserInfor newuser = new UserInfor();
		newuser.setUsername(name);
		
      	return "redirect:getall";
	}
	
	
	@RequestMapping(value = "/createmodel", method = RequestMethod.POST)
	public String createUserActionModel(@ModelAttribute("user") @Validated UserInfor userInfor) throws IOException {
		
		System.out.println("usrname: "+userInfor.getUsername());
		//System.out.println("usrname: "+avatar.getContentType());
		
		//Session session = sessionFactory.getCurrentSession() ;
		//Blob blob = Hibernate.getLobCreator(session).createBlob(avatar.getBytes());
		//user.setAvatar(blob);
		userService.createUser(userInfor);

		return "redirect:getall";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUserAction(@RequestParam("id") int id) throws IOException {
		
	
		userService.deleteUer(id);

		return "redirect:getall";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(Model model, @RequestParam("id") int id) {
		User user = userService.getUser(id);
		user.setAvatar(null);
		model.addAttribute("user",user);
		
		
		return "editusermodel";
	}
	
	@RequestMapping(value = "/editmodel", method = RequestMethod.POST)
	public String editUserActionModel(@ModelAttribute("user") @Validated UserInfor userInfor) throws IOException {
		
		System.out.println("usrname: "+userInfor.getUsername());
		
		userService.editUser(userInfor);

		return "redirect:getall";
	}
	
	@RequestMapping(value = "/getUserPhoto",method = RequestMethod.GET)
	public void getUserPhoto(HttpServletResponse response, @RequestParam("id") int id) throws Exception {
		
        userService.showPhoto(response,id);
		
	}
	
	

	
}
