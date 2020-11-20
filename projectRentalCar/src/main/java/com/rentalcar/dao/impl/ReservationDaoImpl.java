package com.rentalcar.dao.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rentalcar.dao.ReservationDao;
import com.rentalcar.dao.UserDao;
import com.rentalcar.entity.Reservation;
import com.rentalcar.entity.User;
import com.rentalcar.entity.Vehicle;
import com.rentalcar.util.HibernateUtil;
public class ReservationDaoImpl implements ReservationDao{
	 private static ReservationDaoImpl reservationDaoImpl = null;
     
	    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    public int saveReservation(Reservation reservation) {
	        Session session = this.sessionFactory.openSession();
	        
	        Transaction transaction = session.beginTransaction();
	       
	        int id = (int)session.save(reservation);
	        transaction.commit();
	        session.close();
	         
	        return id;     
	    }
	    
	    public void updateReservation(Reservation reservation) {
	        Session session = this.sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(reservation);
	        transaction.commit();
	        session.close();
	    }
	    
	    public void deleteReservation(int id) {
	        Session session = this.sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        Reservation reservation = session.get(Reservation.class, id);
	        session.delete(reservation);
	        transaction.commit();
	        session.close();
	    }
	 
	    public List<Object[]> findReservationById(int id) {
	        Session session = this.sessionFactory.openSession();
	   
	        Transaction tx = session.beginTransaction();
	       
	        Query query = session.createQuery(" FROM Reservation R, Vehicle V "
	        		+ " WHERE R.vehicle.targa = V.targa AND R.user.id =  :id");
	        query.setParameter("id", id);
	        List<Object[]> results = query.list();
          
           
	        tx.commit();
	        session.close();
	     
	      
	         
	        return results;
}
	    
	   public int findUserById(int id) {
		   Session session = this.sessionFactory.openSession();
		   
	        Transaction tx = session.beginTransaction();
	       
	        Query query = session.createQuery(" SELECT U FROM Reservation R, User U "
	        		+ " WHERE R.user.id = U.id AND R.id =  :id");
	        query.setParameter("id", id);
	        User result = (User)query.uniqueResult();
	        int idUser = result.getId();
         
          
	        tx.commit();
	        session.close();
	     
	      
		   return idUser;
	   }
	    @SuppressWarnings("unchecked")
	    public List<Reservation> findAllReservations() {
	    
	        Session session = this.sessionFactory.openSession();
	        List<Reservation> reservationList = session.createCriteria(Reservation.class).list();
	      
	        session.close();
	         
	        return reservationList;
	    }
	    
	    
	    public static ReservationDao getInstance() {
	        if(reservationDaoImpl == null)
	        	reservationDaoImpl = new ReservationDaoImpl();
	    
	        return reservationDaoImpl;
	    }

}
