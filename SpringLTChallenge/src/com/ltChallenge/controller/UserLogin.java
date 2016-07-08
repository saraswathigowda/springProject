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

@WebServlet("/login")
public class UserLogin extends HttpServlet {
		
		private static final long serialVersionUID = -477152211272249281L;

			public void doPost(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
				//System.out.println("login inn"); 
				RequestDispatcher rd = null;
				UserModel usermodel = new UserModel();
				UserBeans userbean = new UserBeans();
				userbean.setUsername(request.getParameter("usr"));
				userbean.setPassword(request.getParameter("pass"));
				
				int userid = usermodel.authuntication(userbean);
				//System.out.println(request.getMethod());
				System.out.println("userid"+userid);
				if(userid>0){
					 rd = request.getRequestDispatcher ("ChooseOption.jsp"); 
					 
					 HttpSession session=request.getSession();  
			         session.setAttribute("userid",userid);   

					request.setAttribute("msg", "login is successful");
				}
				else{
					 rd = request.getRequestDispatcher("Message.jsp");

					request.setAttribute("msg", "login failed");
				}
				
				rd.forward(request, response);
			}
}
				


