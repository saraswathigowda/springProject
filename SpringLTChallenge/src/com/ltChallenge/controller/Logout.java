package com.ltChallenge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {  

	private static final long serialVersionUID = -4930258266825180772L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            response.setContentType("text/html");  
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");  
            HttpSession session=request.getSession();  
            session.removeAttribute("userid");
            rd.forward(request, response);
    }  
}  