package com.rentalcar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentalcar.dao.VehicleDao;
import com.rentalcar.dao.impl.VehicleDaoImpl;
import com.rentalcar.entity.Reservation;
import com.rentalcar.entity.User;
import com.rentalcar.entity.Vehicle;

/**
 * Servlet implementation class UpdateVehicleController
 */
@WebServlet("/vehicle/handle")
public class HandleVehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private VehicleDao vehicleDao = VehicleDaoImpl.getInstance(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleVehicleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		// TODO Auto-generated method stub
		  String custId = request.getParameter("custId");
		 
	        if (custId == "" || custId == null)
	            request.getRequestDispatcher("/").forward(request, response);
	        else {
	            int id = Integer.parseInt(custId);
	            
	            Vehicle vehicle = vehicleDao.findVehicleById(id);
	 
	            request.setAttribute("vehicle", vehicle);
	       
	     
	            request.getRequestDispatcher("/HandleVehicle.jsp").forward(request, response);
	}

}
}
