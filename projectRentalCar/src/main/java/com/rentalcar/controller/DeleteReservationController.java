package com.rentalcar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentalcar.dao.ReservationDao;
import com.rentalcar.dao.UserDao;
import com.rentalcar.dao.impl.ReservationDaoImpl;
import com.rentalcar.dao.impl.UserDaoImpl;
@WebServlet("/reservation/delete")
public class DeleteReservationController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	ReservationDao reservationDao = ReservationDaoImpl.getInstance();
	public DeleteReservationController() {
		
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String idReservation = request.getParameter("idReservation");
 
        if (idReservation == "" || idReservation == null)
            request.getRequestDispatcher("/").forward(request, response);
        else {
            int id = Integer.parseInt(idReservation);
            
 
            reservationDao.deleteReservation(id);
 
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
}
