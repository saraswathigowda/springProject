package com.ltChallenge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltChallenge.beans.UserBeans;
import com.ltChallenge.model.UserModel;


@WebServlet("/profile")
public class Profile extends HttpServlet{

	private static final long serialVersionUID = -1432429474441395733L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		RequestDispatcher rd;
		UserModel usermodel = new UserModel();
		String username=request.getParameter("username");
		System.out.println("USERNAME"+username);
		UserBeans userbean = usermodel.viewProfile(username);
		request.setAttribute("userbean", userbean);
		rd=request.getRequestDispatcher("ViewProfile.jsp");
		rd.forward(request, response);
	}
}

