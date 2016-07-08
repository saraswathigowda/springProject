package com.ltChallenge.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltChallenge.beans.UserBeans;
import com.ltChallenge.model.UserModel;

@WebServlet("/search")
public class SearchUser extends HttpServlet{
	
	private static final long serialVersionUID = -3210910657113181336L;

	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
		//System.out.println("inndasdasd");
		//HttpSession  session = req.getSession();
		String username =req.getParameter("username");
		//System.out.println("usrname"+username);
		UserModel usermodel = new UserModel();
		ArrayList<UserBeans> al = usermodel.searchUser(username);
		req.setAttribute("userbean", al);
		RequestDispatcher rd = req.getRequestDispatcher("DisplayList.jsp");
		rd.forward(req, res);
	}
}
	