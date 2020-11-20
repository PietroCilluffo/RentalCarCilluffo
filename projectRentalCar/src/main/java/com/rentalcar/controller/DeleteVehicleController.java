package com.rentalcar.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.rentalcar.dao.VehicleDao;

import com.rentalcar.dao.impl.VehicleDaoImpl;
import com.rentalcar.entity.Vehicle;
@WebServlet("/vehicle/delete")
public class DeleteVehicleController extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 VehicleDao vehicleDao = VehicleDaoImpl.getInstance();
	    public DeleteVehicleController() {
	        // Do Nothing
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        String Id = request.getParameter("id");
	 
	        if (Id == "" || Id == null)
	            request.getRequestDispatcher("/").forward(request, response);
	        else {
	            int id = Integer.parseInt(Id);
	   
	 
	            vehicleDao.deleteVehicle(id);
	 
	            response.sendRedirect(request.getContextPath() + "/home");
	        }
	    }
}
