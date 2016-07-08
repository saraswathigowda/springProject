package com.ltChallenge.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ltChallenge.beans.UserBeans;
import com.ltChallenge.model.UserModel;

@WebServlet("/create")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 544856462921276899L;

	  private ServletFileUpload uploader = null;
		@Override
		public void init() throws ServletException{
			DiskFileItemFactory fileFactory = new DiskFileItemFactory();
			File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
			fileFactory.setRepository(filesDir);
			this.uploader = new ServletFileUpload(fileFactory);
		}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		Calendar cal = Calendar.getInstance();
		Date dt=cal.getTime();
		SimpleDateFormat formatterofimages = new SimpleDateFormat("yyyymmddHmsS");
		System.out.println(request.getParts());
				
		String dateInString ="2012-09-10"; 
		Date date;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

		RequestDispatcher rd = request.getRequestDispatcher("Message.jsp");
		UserModel usermodel = new UserModel();
		UserBeans userbean = new UserBeans();
		
		try {

			List<FileItem> fileItemsList = uploader.parseRequest(request); 
			System.out.println("fileItemsList"+fileItemsList);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			
			date = formatter.parse(dateInString);
			String df=formatter.format(date);
			userbean.setDob(java.sql.Date.valueOf(df));
		
			
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				
				if (fileItem.isFormField()) {
					 String name = fileItem.getFieldName();
					    String value = fileItem.getString();
					   
					switch (name) {
					case "username":
							userbean.setUsername(value);
						break;
					case "pass":
							userbean.setPassword(value);
						break;
					case "fname":
							userbean.setFirst_name(value);
						break;
					case "lname":
							userbean.setLast_name(value);
						break;
					case "phone":
							userbean.setPhone(value);
						break;
					case "email":
							userbean.setEmail(value);
					case "houseaddress":
							userbean.setHouse_address(value);
						break;
					case "school":
						userbean.setSchool(value);
						break;
					case "schooladdress":
						userbean.setSchool_address(value);
						break;
					case "fathername":
						userbean.setFather_name(value);

						break;
					case "mothername":
						userbean.setMother_name(value);
						break;
					case "dob":
						userbean.setDob(java.sql.Date.valueOf(value));
						break;
					case "gender":
						userbean.setGender(value);
						break;
					default:
						break;
					}
				}
			}
			
			
			int userid=0;
			 userid = usermodel.register(userbean, userid);
			
			if(userid>0){
				fileItemsIterator = fileItemsList.iterator();
			
			while(fileItemsIterator.hasNext()){
				FileItem fileItems = fileItemsIterator.next(); 
				if (!fileItems.isFormField()) {
				String path = fileItems.getName(); 
				int index=path.lastIndexOf("\\");
				String fname=path.substring(index+1);
				System.out.println(fname);
				String exten = fname.substring(fname.lastIndexOf('.'),fname.length());
				
				String imagefileString=formatterofimages.format(dt)+userid+exten;
				
				File dirfiles = new File("d:\\UploadedFiles\\"+userid);
				if (!dirfiles.exists()) {
					if (dirfiles.mkdir()) {
						System.out.println("Directory is created!");
					} else {
						System.out.println("Failed to create directory!");
					}
				}
String savepath="d:/UploadedFiles/"+userid+"/"+imagefileString+"."+exten;
				File file = new File("d:/UploadedFiles/"+userid, imagefileString);
				fileItems.write(file);
				usermodel.uploadImage(userid,savepath);
				request.setAttribute("msg", "User is created");
				}
		    }
			}
		}
		
		catch (Exception pe) {
		pe.printStackTrace();
    	}
	}
}
				
		
