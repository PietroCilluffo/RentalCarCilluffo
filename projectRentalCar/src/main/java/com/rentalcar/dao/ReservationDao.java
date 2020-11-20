package com.rentalcar.dao;

import java.util.List;
import java.util.Map;

import com.rentalcar.entity.Reservation;
import com.rentalcar.entity.User;
import com.rentalcar.entity.Vehicle;
public interface ReservationDao {
	
	int saveReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(int id);
    List<Object[]>   findReservationById(int id);
    List<Reservation> findAllReservations();
    
    int findUserById(int id);
   
    
}
