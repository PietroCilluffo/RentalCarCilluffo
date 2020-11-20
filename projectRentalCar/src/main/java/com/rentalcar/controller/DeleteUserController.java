package com.rentalcar.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.rentalcar.dao.UserDao;
import com.rentalcar.dao.impl.UserDaoImpl;
import com.rentalcar.entity.User;
 
@WebServlet("/user/delete")
public class DeleteUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDao userDao = UserDaoImpl.getInstance();
    public DeleteUserController() {
        // Do Nothing
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String custId = request.getParameter("custId");
 
        if (custId == "" || custId == null)
            request.getRequestDispatcher("/").forward(request, response);
        else {
            int id = Integer.parseInt(custId);
            
 
            userDao.deleteUser(id);
 
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
}
