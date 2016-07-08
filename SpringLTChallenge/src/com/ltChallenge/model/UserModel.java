package com.ltChallenge.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ltChallenge.beans.UserBeans;
import com.ltChallenge.controller.UpdateUser;
import com.ltChallenge.database.DBConnection;

public class UserModel {
		public int authuntication(UserBeans userbean){
			
			int id=0;
		      try{
		    	 Connection con=	DBConnection.getConnection();
		         PreparedStatement ps =con.prepareStatement("select * from tbluser_details where username=? and password=?");
		         ps.setString(1, userbean.getUsername());
		         ps.setString(2, userbean.getPassword());
		         ResultSet rs =ps.executeQuery();
		         while(rs.next()){
		        	 	id= rs.getInt("userId");
		         }
		         	con.close();
			        ps.close();
			        rs.close();
		      }
		      catch(Exception e)
		      {
		          e.printStackTrace();
		      }
		         return id; 
		}
		
		public int register(UserBeans userbean, int userid){
			 int status=0;
			 try{
			        Connection con=	DBConnection.getConnection();
			        ResultSet rs = null;

			        PreparedStatement ps=con.prepareStatement ("insert into tbluser_details (first_name, last_Name, email, phone, gender, father_name, mother_name, username, password, home_address, school, school_address, dob) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			        ps.setString(1, userbean.getFirst_name());
			        ps.setString(2, userbean.getLast_name());
			        ps.setString(3, userbean.getEmail());
			        ps.setString(4, userbean.getPhone());
			        ps.setString(5, userbean.getGender());
			        ps.setString(6, userbean.getFather_name());
			        ps.setString(7, userbean.getMother_name());
			        ps.setString(8, userbean.getUsername());
			        ps.setString(9, userbean.getPassword());
			        ps.setString(10, userbean.getHouse_address());
			        ps.setString(11, userbean.getSchool());
			        ps.setString(12, userbean.getSchool_address());
			        ps.setDate(13, (java.sql.Date) userbean.getDob());

			       status=ps.executeUpdate();
			       rs = ps.getGeneratedKeys();
		            if(rs.next()){
		                 userid=rs.getInt(1);
		                 //System.out.println("USERID"+userid);
		            }
			        con.close();
			        ps.close();
			        rs.close();
			        }
			        catch(Exception se)
			        {
			            se.printStackTrace();
			        }
	         		return userid;
			      }
		
		public ArrayList<UserBeans> searchUser(String username){
			ArrayList<UserBeans> userarray = new ArrayList<UserBeans>();

			UserBeans userbean = new UserBeans();
	        Connection con=	DBConnection.getConnection();
			try{
				con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT username, first_name, last_Name, email, image_url FROM tbluser_details WHERE  username LIKE ?");
				
				ps.setString(1, "%"+username+"%"); 

				ResultSet rs = ps.executeQuery();
				while(rs.next()){
				//System.out.println("Name:"+rs.getString("first_name"));
				userbean.setUsername(rs.getString("username"));
				userbean.setFirst_name(rs.getString("first_name"));
				userbean.setLast_name(rs.getString("last_name"));
				userbean.setEmail(rs.getString("email"));
				userbean.setImage_url(rs.getString("image_url"));
				userarray.add(userbean);
				}
				con.close();
		        ps.close();
		        rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return userarray;
		}
		
		public UserBeans viewProfile(String username){
			UserBeans userbean = new UserBeans();
			Connection con=null;
			try{
				con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select username, first_name, last_Name, email, school, school_address, father_name, mother_name, phone, gender from tbluser_details where username=?");
				
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
				userbean.setFirst_name(rs.getString("first_name"));
				userbean.setLast_name(rs.getString("last_name"));
				userbean.setEmail(rs.getString("email"));
				userbean.setSchool(rs.getString("school"));
				userbean.setSchool_address(rs.getString("school_address"));
				userbean.setFather_name(rs.getString("father_name"));
				userbean.setMother_name(rs.getString("mother_name"));
				userbean.setPhone(rs.getString("phone"));
				userbean.setGender(rs.getString("gender"));
				userbean.setUsername(rs.getString("username"));
				}
				con.close();
		        ps.close();
		        rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return userbean;
		} 
		
		public int sendRequest(int fromUserId, String toUsername){
	    	 int status=0;
//System.out.println("toUsername"+toUsername);
		      try{
		    	 Connection con=DBConnection.getConnection();
		    	 
		    	 int toUserId=0;
		    	 PreparedStatement ps = con.prepareStatement("select userid from tbluser_details where username=?");
				 ps.setString(1,toUsername);
				 System.out.println("ps"+ps);
				 
		         ResultSet rs =ps.executeQuery();
		         while(rs.next()){
		        	 toUserId= rs.getInt("userId");
		         } 
		         //System.out.println("toUserId"+toUserId); 
		         ps.close();
		         rs.close();
		         
		         if(toUserId>0 && (fromUserId!=toUserId)){
		        	 
		        	 ps=con.prepareStatement("insert into tblfriend_status (from_friend_id, to_friend_id, status_id, sent_time) values(?,?,0,now())");
			         ps.setInt(1,fromUserId);
			         ps.setInt(2, toUserId);
			         //System.out.println("ps"+ps);
			         status=ps.executeUpdate();
		         }
		         else {
		        	 System.out.println("Error in sending request!");
		         }
		         	con.close();
			        ps.close();
			        rs.close();
		      }
		      catch(Exception e){
		    	  e.printStackTrace();
		      }
			return status;
		}
		
		public ArrayList<UserBeans> listRequest(int userid){
			ArrayList<UserBeans> userbeanarray = new ArrayList<UserBeans>(); 
			
			try{
				Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select fd.friend_status_id, ud.first_name, ud.last_Name,ud.email, ud.username, ud.image_url, ud.userId from tbluser_details ud,tblfriend_status fd where fd.to_friend_id=? and fd.from_friend_id=ud.userId");
				
				ps.setInt(1, userid);
				
		        ResultSet rs = ps.executeQuery();
		        while(rs.next()){
		        	UserBeans userbean = new UserBeans();
		        	System.out.println(rs.getString("first_name"));
					userbean.setFirst_name(rs.getString("first_name"));
					userbean.setLast_name(rs.getString("last_name"));
					userbean.setEmail(rs.getString("email"));
					userbean.setUsername(rs.getString("username"));
					userbean.setFriend_id(rs.getInt("friend_status_id"));
					userbean.setId(rs.getInt("userId"));
					userbean.setImage_url(rs.getString("image_url"));
					userbeanarray.add(userbean);
					
		        }
		        con.close();
		        ps.close();
		        rs.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return userbeanarray;
		}
		
		public UserBeans viewAccountDetails(int userId){
		    boolean infoIsValid = true;
		    String errorMessage = "";

			UserBeans userbean = new UserBeans();
			Connection con=null;
			try{
				 con=	DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select first_name, last_Name, school, school_address, father_name, mother_name, phone, gender, dob, home_address from tbluser_details where userId=?");
				
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();
				
				int count=0;
				while(rs.next()){
						userbean.setFirst_name(rs.getString("first_name"));
						userbean.setLast_name(rs.getString("last_name"));
						//userbean.setEmail(rs.getString("email"));
						userbean.setSchool(rs.getString("school"));
						userbean.setSchool_address(rs.getString("school_address"));
						userbean.setFather_name(rs.getString("father_name"));
						userbean.setMother_name(rs.getString("mother_name"));
						userbean.setPhone(rs.getString("phone"));
						userbean.setGender(rs.getString("gender"));
						//userbean.setUsername(rs.getString("username"));
						userbean.setHouse_address(rs.getString("home_address"));
						userbean.setDob(rs.getDate("dob"));
						count=count+1;
					}
					con.close();
					ps.close();
					rs.close();
					
					if(count > 1) {
						infoIsValid = false;
						errorMessage = errorMessage.concat("Duplicate Userame Found. Please create new Username" + "\n");
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return userbean;
		} 
		
		public int updateUser(UserBeans userbean, int userid){
		int status=0;
		try{
			
			//System.out.println("value from servlet"+userbean.getFirst_name());
			Connection con=DBConnection.getConnection();
			 PreparedStatement ps =con.prepareStatement("update tbluser_details set first_name=?, last_Name=?, school=?, school_address=?, father_name=?, mother_name=?, phone=?, gender=?, dob=?, home_address=? where userId=?");
			 ps.setString(1, userbean.getFirst_name());
		     ps.setString(2, userbean.getLast_name());
		     ps.setString(3, userbean.getSchool());	
		     ps.setString(4, userbean.getSchool_address());
		     ps.setString(5, userbean.getFather_name());
		     ps.setString(6, userbean.getMother_name());
		     ps.setString(7,userbean.getPhone());
		     ps.setString(8, userbean.getGender());
		     ps.setDate(9, (java.sql.Date) userbean.getDob());
		     ps.setString(10, userbean.getHouse_address());
		     ps.setInt(11, userid);
		     //System.out.println("ps"+ps);
			 status=ps.executeUpdate();
			 
			 con.close();
		     ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	} 
		 
	public int uploadImage(int userid, String path){
		int status=0;
		try{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("update tbluser_details set image_url=? where userId=?");
 	        ps.setString(1, path);
 	        ps.setInt(2, userid);
			status=ps.executeUpdate();
			//System.out.println("PS::::"+ps);
			con.close();
			ps.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<UserBeans> listFriends(int userid){
		ArrayList<UserBeans> userbeanarray = new ArrayList<UserBeans>();
		UserBeans userbean = new UserBeans();
		try{
			Connection con = DBConnection.getConnection();
			String query="SELECT distinct tfs.from_friend_id, tfs.to_friend_id, tfs.sent_time, tud.first_name, tud.last_Name, tud.email FROM  tbluser_details tud left join tblfriend_status tfs on tfs.from_friend_id=tud.userId where tfs.from_friend_id=? or tfs.to_friend_id=? and  tfs.status_id=1";
			PreparedStatement ps = con.prepareStatement(query);
			
			//ps.setInt(1, userbean.getFriend_id());
			ps.setInt(1, userid);
			ps.setInt(2, userid);

			//ps.setDate(3, (java.sql.Date)userbean.getSent_time());
			//System.out.println("ps.........."+ps);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	        	//UserBeans userbean = new UserBeans();
	        	userbean.setFriend_id(rs.getInt("from_friend_id"));
	        	
				userbean.setTo_friend_id(rs.getInt("to_friend_id"));  
				userbean.setSent_time(rs.getDate("sent_time"));
				userbean.setFirst_name(rs.getString("first_name"));
				userbean.setLast_name(rs.getString("last_Name"));
				//userbean.setStatus_id(rs.getInt("status_id"));
				userbean.setEmail(rs.getString("email"));
				
				userbeanarray.add(userbean);
	        }
	        con.close();
	        ps.close();
	        rs.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return userbeanarray;
	}
}









