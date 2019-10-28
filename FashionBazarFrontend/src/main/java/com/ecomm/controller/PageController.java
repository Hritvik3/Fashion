package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class PageController {
	@RequestMapping(value="/")
	public String showHomePage()
	{
		System.out.println("----Home Page----");
		return "home";
	}
	@RequestMapping(value="/Login")
	public String showLoginPage()
	{
		System.out.println("----Login----");
		return "Login";
	}
	@RequestMapping(value="/Register")
	public String showRegisterPage()
	{
		System.out.println("----Register----");
		return "Register";
	}

}
