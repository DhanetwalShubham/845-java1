package com.lti.service;

import java.util.HashMap;

public class InMemoryLoginService {

	private HashMap<String, String> users = new HashMap<String, String>();
	
	public InMemoryLoginService() {
		users.put("shubham", "123");
		users.put("surbhi", "456");
		users.put("annie", "789");
	}
	
	public boolean authenticate(String uname, String pwd) {
		if(users.containsKey(uname) && users.get(uname).equals(pwd))
			return true;
		else 
			return false;
		/*if(uname.equals("shubham") && pwd.equals("123"))
			return true;
		else
			return false;*/
	}

}
