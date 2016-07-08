package com.ltChallenge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltChallenge.beans.UserBeans;
import com.ltChallenge.model.UserModel;

@WebServlet("/account")
public class UserAccount extends HttpServlet{
	private static final long serialVersionUID = -1432429474441395733L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		RequestDispatcher rd;
		UserModel usermodel = new UserModel();
		
		String username=request.getParameter("username");
		HttpSession session = request.getSession();
		int userid=(int) session.getAttribute("userid");
		UserBeans userbean = usermodel.viewAccountDetails(userid);
		request.setAttribute("userbean", userbean);
		rd=request.getRequestDispatcher("Account.jsp");
		rd.forward(request, response);
	}
}

