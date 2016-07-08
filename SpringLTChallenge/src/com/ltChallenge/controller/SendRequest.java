package com.ltChallenge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltChallenge.model.UserModel;

@WebServlet("/sendrequest")
public class SendRequest extends HttpServlet{

	private static final long serialVersionUID = 9141243046402516300L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		 RequestDispatcher rd=req.getRequestDispatcher ("SearchUser.jsp");
		 UserModel usermodel = new UserModel();
		 HttpSession session=req.getSession();  
         int userid=(int) session.getAttribute("userid");   
         String toUsername=req.getParameter("username");
		 int status=usermodel.sendRequest(userid, toUsername); 

		req.getParameter("userid");
		if(status>0){
			req.setAttribute("msg", "sent request succesfully");
		}
		else{
			req.setAttribute("msg", "sent request failed");
		}
		rd.forward(req, res);
	}   
}





