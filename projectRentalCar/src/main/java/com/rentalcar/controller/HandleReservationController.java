package com.rentalcar.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rentalcar.entity.Reservation;
import com.rentalcar.dao.ReservationDao;

import com.rentalcar.dao.impl.ReservationDaoImpl;

/**
 * Servlet implementation class UpdateReservationController
 */
@WebServlet("/reservation/update")
public class HandleReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReservationDao reservationDao = ReservationDaoImpl.getInstance();  

    public HandleReservationController() {
     
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // TODO Auto-generated method stub   //ritrasmetto le informazioni per gestire nella pagina di gestione delle prenotazioni
		   Locale.setDefault(Locale.ITALIAN);
		   HttpSession currentSession = request.getSession();
		    String tempInizio= request.getParameter("dataInizio");
	        String tempFine =request.getParameter("dataFine");
	        String targa = request.getParameter("targa");
	        String id = request.getParameter("idReservation");
	        System.out.println(tempInizio+" temp inizio "+tempFine+ " tempfine");
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        formatter = formatter.withLocale( Locale.ITALIAN );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
	        LocalDate dataInizio = LocalDate.parse(tempInizio, formatter);
	        LocalDate dataFine = LocalDate.parse(tempFine, formatter);
	   
    			if (id == "" || id == null)
    	            request.getRequestDispatcher("/").forward(request, response);
    	        else {
    	       
    	            
    	          
    	 
    	        
    	 		   request.setAttribute("dataInizio",tempInizio);
    	 	       request.setAttribute("dataFine",tempFine);
    	 	       request.setAttribute("targa",targa);
    	 	       request.setAttribute("idReservation",id);
    	       
    	     
    	            request.getRequestDispatcher("/HandleReservation.jsp").forward(request, response);
    	
	        
	}

}
}
