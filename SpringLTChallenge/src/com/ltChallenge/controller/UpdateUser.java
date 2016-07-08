package com.ltChallenge.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ltChallenge.beans.UserBeans;
import com.ltChallenge.model.UserModel;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet{

	private static final long serialVersionUID = 2273508690708903354L;
	
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
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Calendar cal = Calendar.getInstance();
		Date dt=cal.getTime();
		SimpleDateFormat formatterofimages = new SimpleDateFormat("yyyymmddHmsS");
		
		System.out.println(request.getParts());
		RequestDispatcher rd = request.getRequestDispatcher("Message.jsp");
		UserModel usermodel = new UserModel();
		UserBeans userbean = new UserBeans();
		
		HttpSession session = request.getSession();
		int userid=(int) session.getAttribute("userid");
		
		String dateInString ="2012-09-10"; 
		Date date;
		try {
			date = formatter.parse(dateInString);
			String df=formatter.format(date);
			userbean.setDob(java.sql.Date.valueOf(df));
			
			List<FileItem> fileItemsList = uploader.parseRequest(request); 
			System.out.println("fileItemsList"+fileItemsList);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			
			
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				
				if (fileItem.isFormField()) {
					 String name = fileItem.getFieldName();
					    String value = fileItem.getString();
					   
					switch (name) {
					case "first_name":
								userbean.setFirst_name(value);
						break;
					case "last_name":
						userbean.setLast_name(value);
						break;
					case "phone":
						userbean.setPhone(value);
						break;
					case "house_address":
						userbean.setHouse_address(value);

						break;
					case "school":
						userbean.setSchool(value);

						break;
					case "school_address":
						userbean.setSchool_address(value);

						break;
					case "father_name":
						userbean.setFather_name(value);

						break;
					case "mather_name":
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
				else { 
					String path = fileItem.getName(); 
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

					File file = new File("d:/UploadedFiles/"+userid, imagefileString);
					fileItem.write(file);
					usermodel.uploadImage(userid, path);

			    }
			}
		} 
			 catch (ParseException pe) {
					pe.printStackTrace();
			 }
		
		 	catch (Exception e) {
				e.printStackTrace();
			}
		
			int status = usermodel.updateUser(userbean, userid);
			if(status>0){
				request.setAttribute("msg",  "User is updated");
			}
			else{
			request.setAttribute("msg",  "User updation failed");
			}
			rd.forward(request, response);
		}
}
	
	
	
