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
 
@WebServlet("/user/register")
public class AddandUpdateUserController extends HttpServlet {
    private static final long serialVersionUID = 1L; //probabile problema?
 
    private UserDao userDao =UserDaoImpl.getInstance();
 
    public AddandUpdateUserController() {
        // Do Nothing
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/").forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { //sono l'admin, aggiungo o modifico un utente
    	
        String custId = request.getParameter("id");
        String firstName = request.getParameter("nome");
        String lastName = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("------------------------------password "+password);
  
 
        User user = new User(firstName, lastName, email,password);
        if(email.equals("super@rentalcar")) {
        	SuperUser superuser = new SuperUser(firstName, lastName, email,password);
        	userDao.saveUser(superuser);
        }else {
        	   if (custId == null || custId == "")
                   userDao.saveUser(user);
                else {
                    int id = Integer.parseInt(custId);
                    user.setId(id);
                    userDao.updateUser(user);
                }
        }
     
 
        response.sendRedirect(request.getContextPath() + "/home");
    }
 
}