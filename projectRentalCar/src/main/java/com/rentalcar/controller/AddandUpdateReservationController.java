package com.rentalcar.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rentalcar.entity.User;
import com.rentalcar.entity.Vehicle;
import com.rentalcar.dao.ReservationDao;
import com.rentalcar.dao.impl.ReservationDaoImpl;
import com.rentalcar.dao.VehicleDao;
import com.rentalcar.dao.impl.VehicleDaoImpl;
import com.rentalcar.entity.Reservation;

@WebServlet("/reservation/add")
public class AddandUpdateReservationController extends HttpServlet {
    private static final long serialVersionUID = 1L; 
 
    private ReservationDao reservationDao = ReservationDaoImpl.getInstance();
    private VehicleDao vehicleDao = VehicleDaoImpl.getInstance();
   
 
    public AddandUpdateReservationController() {
        // Do Nothing
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) //ricarico la pagina a seconda del filtro selezionato per effettuare la prenotazione
            throws ServletException, IOException {  //passo per get perchè sono solo due parametri
    	if(request.getParameter("filtro") == null) {
    		List< Vehicle> vehicles = vehicleDao.findAllVehicles();
        	request.setAttribute("vehicleList", vehicles);
    	}else {
    		String catSel = request.getParameter("selezione");
       	    String filtro = request.getParameter("filtro");
       	    if(filtro.equals("")) {
       	    	List< Vehicle> vehicles = vehicleDao.findAllVehicles();
            	request.setAttribute("vehicleList", vehicles);
       	    }else {
       	     if(catSel.equals("modello")) {
           	     System.out.println(filtro);
           		List< Vehicle> vehicles = vehicleDao.findVehicleByModello(filtro);
            	request.setAttribute("vehicleList", vehicles);
           	 }
           	 if(catSel.equals("anno")) {
           		 System.out.println(filtro);
           		List< Vehicle> vehicles = vehicleDao.findVehicleByAnno(filtro);
            	request.setAttribute("vehicleList", vehicles);
           	 }
           	 if(catSel.equals("casa")) {
           		 System.out.println(filtro);
           		List< Vehicle> vehicles = vehicleDao.findVehicleByCasa(filtro);
            	request.setAttribute("vehicleList", vehicles);
           	 }
       	    }
       	
    	}
    	
  
    	
        request.getRequestDispatcher("/addReservation.jsp").forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Locale.setDefault(Locale.ITALIAN);
    	HttpSession currentSession = request.getSession();
        String custId = request.getParameter("id");
        String tempInizio= request.getParameter("dataInizio");
        String tempFine =request.getParameter("dataFine");
        
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale( Locale.ITALIAN );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate dataInizio = LocalDate.parse(tempInizio, formatter);
        LocalDate dataFine = LocalDate.parse(tempFine, formatter);
     
       
      
       
        String targa = request.getParameter("targa");
        String id = request.getParameter("idReservation");
        System.out.println(id+ "id Reservation");
        if(id == null || id == "") { //sto aggiungendo una prenotazione e sono l'user
        	  
          	 int idUserInt = (int)currentSession.getAttribute("id");
          
      
              User user = new User();
              user.setId(idUserInt);
              
              Vehicle vehicle = new Vehicle();
              vehicle.setTarga(targa);
              Reservation reservation = new Reservation(user,dataInizio, dataFine,vehicle);
              
            
                 reservationDao.saveReservation(reservation);
        }else {     //non sto effettuando un inserimento
        	
        	if(currentSession.getAttribute("isSuper").equals(1)) { //sono l'admin e sto aggiornando la prenotazione
        		int idRes = Integer.parseInt(id);
           	 int idUserInt = reservationDao.findUserById(idRes);
           	
                  
           	 User user = new User();
                user.setId(idUserInt);
                
                Vehicle vehicle = new Vehicle();
                vehicle.setTarga(targa);
              
                Reservation reservation = new Reservation(user,dataInizio, dataFine,vehicle);
                
           	  
           	  reservation.setId(idRes);
           	  reservation.setApprovazione(true);
           	  reservationDao.updateReservation(reservation);
        		
        	}else { //sono l'utente e sto cercando di modificare la prenotazione
        		
        		int idRes = Integer.parseInt(id);
              	 int idUserInt = reservationDao.findUserById(idRes);
              	
                     
              	 User user = new User();
                   user.setId(idUserInt);
                   
                   Vehicle vehicle = new Vehicle();
                   vehicle.setTarga(targa);
                 
                   Reservation reservation = new Reservation(user,dataInizio, dataFine,vehicle);
                   
              	  
              	  reservation.setId(idRes);
             	  reservationDao.updateReservation(reservation);
        	}
        }
     
      
 
        response.sendRedirect(request.getContextPath() + "/home");
    }
 
}
