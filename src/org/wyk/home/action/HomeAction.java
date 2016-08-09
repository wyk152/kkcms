package org.wyk.home.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//跳转到首页
	public String execute(){
		return "home";
	}
}
