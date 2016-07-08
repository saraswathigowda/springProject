package com.ltChallenge.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ltChallenge.database.DBConnection;

public class FriendModule {
	public int acceptRequest(int friendStatusId, int status){
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("update tblfriend_status set status_id=?,response_time=now() where friend_status_id=?");
	        ps.setInt(1, status);
	        ps.setInt(2, friendStatusId);
	        System.out.println("ps"+ps);
	       status= ps.executeUpdate();
	        con.close();
	        ps.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}

	public int rejectRequest(int friendStatusId, int status){
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("update tblfriend_status set status_id=?,response_time=now() where friend_status_id=?");
	        ps.setInt(1, status);
	        ps.setInt(2, friendStatusId);
	        System.out.println("ps"+ps);
	        status= ps.executeUpdate();
	        con.close();
	        ps.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
}
