package com.yitsol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yitsol.entity.AuthRequest;
import com.yitsol.utils.JwtUtils;

@Controller
@RequestMapping
public class LoginController {

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showPage() {
		return "user";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		ModelAndView model = new ModelAndView();
		if (authRequest.getUserName().equals("admin") && authRequest.getPassword().equals("admin")) {
			model.setViewName("/admin");
		} else {
			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
			} catch (Exception e) {
				throw new Exception("Invalid Username/Password");
			}
			model.addObject("msg", jwtUtils.generateToken(authRequest.getUserName()));
			model.setViewName("/token");
		}
		return model;
	}
}
