package com.example.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.client.models.AddressInfo;
import com.example.client.models.UserInfo;
import com.example.client.service.UserService;
import com.example.client.service.UserServiceImpl;

@Controller
public class DemoClientController {

	@RequestMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("name", "Jahir");
		return "index";
	}
	
	@RequestMapping("/userList")
	public String getUserList(Model model) throws Exception{
		UserService service = new UserServiceImpl();
		List<UserInfo> userList = service.getUserList();
		model.addAttribute("userList", userList);
		return "listview";
	}
	
	
	@RequestMapping(value="/newUser")
	public String showNewUser(Model model){
		UserInfo u = new UserInfo();
		u.setAddressInfo(new AddressInfo());
		model.addAttribute("userInfo", u);
		model.addAttribute("action", "/addUser");
		return "detailview";
	}
	
	@RequestMapping(value="/showUser/{userId}")
	public String getUserDetail(@PathVariable("userId") long id, Model model) throws Exception{
		UserService service = new UserServiceImpl();
		UserInfo userInfo = service.getUserInfo(id);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("action", "/updateUser");
		return "detailview";
	}
	
	@RequestMapping(value="/deleteUser/{userId}")
	public String deleteUserDetail(@PathVariable("userId") long id, Model model) throws Exception{
		UserService service = new UserServiceImpl();
//		service.deleteUserInfo(id);
		List<UserInfo> userList = service.getUserList();
		model.addAttribute("userList", userList);
		return "listview";
	}
	
	@RequestMapping(value="/addUser")
	public String addUserDetail(@ModelAttribute("userInfo") UserInfo user, Model model) throws Exception{
		UserService service = new UserServiceImpl();
		service.addUser(user);
		List<UserInfo> userList = service.getUserList();
		model.addAttribute("userList", userList);
		return "listview";
	}
	
	@RequestMapping(value="/updateUser")
	public String updateUserDetail(@ModelAttribute("userInfo") UserInfo user, Model model) throws Exception{
		
		UserService service = new UserServiceImpl();
		service.updateUser(user);
		System.out.println(user.getUserId()+":::"+user.getUserName());
		List<UserInfo> userList = service.getUserList();
		model.addAttribute("userList", userList);
		return "listview";
	}
}
