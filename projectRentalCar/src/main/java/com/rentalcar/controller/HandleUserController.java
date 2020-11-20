package com.rentalcar.controller;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentalcar.dao.ReservationDao;
import com.rentalcar.dao.UserDao;
import com.rentalcar.dao.impl.ReservationDaoImpl;
import com.rentalcar.dao.impl.UserDaoImpl;
import com.rentalcar.entity.Reservation;
import com.rentalcar.entity.User;
import com.rentalcar.entity.Vehicle;
 
@WebServlet("/user/handle")
public class HandleUserController extends HttpServlet {  //lato admin gestisco per utente le sue prenotazioni, trasmetto le info alla pagina di gestione in base
    private static final long serialVersionUID = 1L;  //all'utente selezionato
    private ReservationDao reservationDao = ReservationDaoImpl.getInstance();
    private UserDao userDao = UserDaoImpl.getInstance();
    public HandleUserController() {
        // Do Nothing
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  //
 
        String custId = request.getParameter("custId");
 
        if (custId == "" || custId == null)
            request.getRequestDispatcher("/").forward(request, response);
        else {
            int id = Integer.parseInt(custId);
            
            User user = userDao.findUserById(id);
 
            request.setAttribute("user", user);
            List<Object[]> reservations_ve = reservationDao.findReservationById(id);
            List<Reservation> reservations = new ArrayList<Reservation>();
            List<Vehicle> vehicles = new ArrayList<Vehicle>();
           for(int i = 0; i< reservations_ve.size(); i++) {
        	   Object[] res = ( Object[] )reservations_ve.get(i);
        	   Reservation r = (Reservation)res[0];
               Vehicle v = (Vehicle)res[1];
               reservations.add(r);
               vehicles.add(v);
               LocalDate tempI = r.getDataInizio();
               
               tempI = tempI.plusDays(1);
            
               r.setDataInizio(tempI);
               LocalDate tempF = r.getDataFine();
               tempF = tempF.plusDays(1);
               r.setDataFine(tempF);
             
           }
            
            
            
  
         
           
           
	    	request.setAttribute("reservationList", reservations);
	    	request.setAttribute("vehicleList", vehicles);
	    	 
 
            request.getRequestDispatcher("/HandleUser.jsp").forward(request, response);
        }
    }
}