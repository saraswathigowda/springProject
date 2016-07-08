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

@WebServlet("/listrequest")
public class ListFriendRequest extends HttpServlet{

	private static final long serialVersionUID = -8631267654863816703L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		RequestDispatcher rd=req.getRequestDispatcher("ListFriendsRequest.jsp");
		UserModel usermodel=new UserModel();
		HttpSession session=req.getSession();  
        int userid=(int) session.getAttribute("userid");

		ArrayList<UserBeans> al = usermodel.listRequest(userid);
		req.setAttribute("userbean", al);
		//System.out.println("");
		//req.setAttribute("userbean", userbean);
		rd.forward(req, res);
	}
}