package com.ltChallenge.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltChallenge.beans.UserBeans;
import com.ltChallenge.model.UserModel;

@WebServlet("/listfriends")
public class ListFriends extends HttpServlet{
	private static final long serialVersionUID = -4948413250567452141L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		RequestDispatcher rd=req.getRequestDispatcher("ListFriends.jsp");
		UserModel usermodel=new UserModel();
		UserBeans userbean = new UserBeans();

		HttpSession session=req.getSession();  
        int userid=(int) session.getAttribute("userid");

		ArrayList<UserBeans> al = usermodel.listFriends(userid); 
		req.setAttribute("userbean", al);
		rd.forward(req, res);
	}
}

