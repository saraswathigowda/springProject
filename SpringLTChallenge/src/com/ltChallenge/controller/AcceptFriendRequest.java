package com.ltChallenge.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltChallenge.model.FriendModule;
import com.ltChallenge.model.UserModel;

@WebServlet("/acceptrequest")
public class AcceptFriendRequest extends HttpServlet{
	private static final long serialVersionUID = 6947408103330736176L;
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		RequestDispatcher rd=req.getRequestDispatcher("Message.jsp");
		FriendModule friendmodel=new FriendModule();
		int statusid=(Integer.parseInt(req.getParameter("status_Id")));
		//System.out.println("statusid"+statusid);
		int status=friendmodel.acceptRequest(statusid,1);
		if(status>0){
			req.setAttribute("msg", "Updated successfully");
		}
		else{
			req.setAttribute("msg", "Updation failed");
		}
		rd.forward(req, res);
	}
}
	


