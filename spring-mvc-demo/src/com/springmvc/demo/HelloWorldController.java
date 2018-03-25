package com.springmvc.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//This a kind of nesting all the methods or the mappings under one single parent,for
//example when you two different controllers with the same method mappings like
//@RequestMapping("/showForm")
//public String showForm()
//and another controller @RequestMapping("/showForm")
//public String showFormTwo() you can resolve that
@RequestMapping("/parent")
public class HelloWorldController {
	

	
	//need a controller method to show the initial HTML form
	//sub mapppings relative to /parent
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	//need a controller method to  process the HTML form
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	// new a controller method to read form data and
		// add data to the model

		@RequestMapping("/processFormVersionTwo")	
		public String letsShoutDude(HttpServletRequest request, Model model) {
			
			// read the request parameter from the HTML form
			String theName = request.getParameter("studentName");
			
			// convert the data to all caps
			theName = theName.toUpperCase();
			
			// create the message
			String result = "Yo! " + theName;
			
			// add message to the model
			model.addAttribute("message", result);
					
			return "helloworld";
		}
		@RequestMapping("/processFormVersionThree")	
		//here the @RequestParam annotation take the value from ,form data and assigns to 
		//theName attribute
		//here we are passing the empty model object and later adding data to the model object
		public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
			
			// read the request parameter from the HTML form
			//String theName = request.getParameter("studentName");
			
			// convert the data to all caps
			theName = theName.toUpperCase();
			
			// create the message
			String result = "Yo! New" + theName;
			
			// add message to the model
			model.addAttribute("message", result);
					
			return "helloworld";
		}
}
