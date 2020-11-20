package com.rentalcar.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.rentalcar.dao.UserDao;
import com.rentalcar.dao.impl.UserDaoImpl;
import com.rentalcar.entity.SuperUser;
import com.rentalcar.entity.User;

@WebServlet(urlPatterns = {"", "/login"})
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L; //probabile problema?

	private UserDao userDao =UserDaoImpl.getInstance();

	public  LoginController(){

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String email = request.getParameter("email");
		String password = request.getParameter("password");
        System.out.println(" dataFine");
		User user = userDao.findUserByEmail(email);
		
		if(password.equals(user.getPassword())) {  //se la password è corretta
			HttpSession oldSession = request.getSession(false);   //ricavo la sessione e la setto

			if(oldSession!=null) {
				oldSession.invalidate();

			}    
			HttpSession currentSession = request.getSession(); 
			int id = user.getId();
            currentSession.setAttribute("nome", user.getNome());
			currentSession.setAttribute("email", email);
			currentSession.setAttribute("id",id);
			currentSession.setAttribute("isSuper", 0);
			response.sendRedirect(request.getContextPath() + "/home");

		}else {

			SuperUser superuser = userDao.findSuperUserByEmail(email);
			if(password.equals(superuser.getPassword())) {
				HttpSession oldSession = request.getSession(false);   //ricavo la sessione e la setto

				if(oldSession!=null) {
					oldSession.invalidate();

				}    
				HttpSession currentSession = request.getSession(); 
				int id = superuser.getId();
				currentSession.setAttribute("nome", superuser.getNome());
				currentSession.setAttribute("email", email);
				currentSession.setAttribute("id",id);
				currentSession.setAttribute("isSuper", 1);
				response.sendRedirect(request.getContextPath() + "/home");
			}else {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}




		}

	}
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  response.sendRedirect(request.getContextPath() + "/login.jsp");
	  }
}
