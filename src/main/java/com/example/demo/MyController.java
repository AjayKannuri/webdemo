package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/xyz")
	@ResponseBody
	public String abc()
	{
		return  "welcome.html";
	}
	
	@RequestMapping("/greet")
	public String demo() {
		return "welcome.html";
	}
	
	@RequestMapping("/")
	public String  login()
	{
		return "login";
		
	}
	
	@RequestMapping("/welcome")
	@ResponseBody
	@GetMapping
	public String loginProcess(@RequestParam("uname")String name,@RequestParam("upwd") String pwd)
	{
		System.out.println("username :"+ name +" password: "+pwd);
		return "<h1> welcome to dbs "+name+"</h1>"+"from get mapping";
	}
	
	@RequestMapping("/welcome2")
	@PostMapping
	public String loginProcessPostMapping(HttpServletRequest req)
	{
		//System.out.println("username :"+ name +" password: "+pwd);
		//return "<h1> welcome to dbs "+name+"</h1>"+" from post mapping";
		String user = req.getParameter("uname");
		String password = req.getParameter("upwd");
		HttpSession session = req.getSession();
		session.setAttribute("username",user);
		return "welcome";
	}
	@RequestMapping("/welcome3")
	public ModelAndView loginProcess3(User user)					// automatically injected into the user class.....
	{
		//System.out.println("username :"+ name +" password: "+pwd);
		//return "<h1> welcome to dbs "+name+"</h1>"+" from post mapping";
//		String user = req.getParameter("uname");
//		String password = req.getParameter("upwd");
//		HttpSession session = req.getSession();
//		session.setAttribute("username",user);
		System.out.println("Username : "+ user.getUname());
		System.out.println("Password : "+ user.getUpwd());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject(user);
		if(user.getUname().contentEquals(user.getUpwd()))
			mv.setViewName("welcome");
		else
			mv.setViewName("Invalid");
		return mv;
	}

}
