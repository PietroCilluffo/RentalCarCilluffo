package com.rentalcar.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rentalcar.dao.UserDao;
import com.rentalcar.entity.User;
import com.rentalcar.util.HibernateUtil;
import com.rentalcar.entity.Reservation;
import com.rentalcar.entity.SuperUser;

public class UserDaoImpl implements UserDao{
	 private static UserDaoImpl userDaoImpl = null;
     
	    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	     
	    public int saveUser(User user) {
	        Session session = this.sessionFactory.openSession();
	        
	        Transaction transaction = session.beginTransaction();
	       
	        int id = (int)session.save(user);
	        transaction.commit();
	        session.close();
	         
	        return id;     
	    }
	    
	    public int saveUser(SuperUser user) {
	        Session session = this.sessionFactory.openSession();
	        
	        Transaction transaction = session.beginTransaction();
	       
	        int id = (int)session.save(user);
	        transaction.commit();
	        session.close();
	         
	        return id;     
	    }
	    public void updateUser(User user) {
	        Session session = this.sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(user);
	        transaction.commit();
	        session.close();
	    }
	 
	    public void deleteUser(int id) {
	        Session session = this.sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        User user = session.get(User.class, id);
	        session.delete(user);
	        transaction.commit();
	        session.close();
	    }
	 
	    public User findUserById(int id) {
	        Session session = this.sessionFactory.openSession();
	        User user = session.get(User.class, id);
	        session.close();
	         
	        return user;
        }
	    public User findUserByEmail(String email) {
	    	
	    	
	        Session session = this.sessionFactory.openSession();
	        User user = new User();
	        List<User> userList = session.createCriteria(User.class).list();
	        
	       for(User lib : userList){
	    
	    	    String temp = lib.getEmail();
	        
	           if(temp.equals(email)) {
	        	   user.setId(lib.getId());
	        	   user.setNome(lib.getNome());
	        	   user.setCognome(lib.getCognome());
	        	   user.setEmail(lib.getEmail());
	        	   user.setPassword(lib.getPassword());
	        	
	           }
	      
	        }
	   
	        session.close();
	         
	        return user;
        }
	    
	    public SuperUser findSuperUserById(int id) {
	        Session session = this.sessionFactory.openSession();
	        SuperUser user = session.get(SuperUser.class, id);
	        session.close();
	         
	        return user;
        }
	    public SuperUser findSuperUserByEmail(String email) {
	        Session session = this.sessionFactory.openSession();
	        SuperUser user = new SuperUser();
	        List<SuperUser> userList = session.createCriteria(SuperUser.class).list();
	        
	       for(SuperUser lib : userList){
	    
	    	    String temp = lib.getEmail();
	        
	           if(temp.equals(email)) {
	        	   user.setId(lib.getId());
	        	   user.setNome(lib.getNome());
	        	   user.setCognome(lib.getCognome());
	        	   user.setEmail(lib.getEmail());
	        	   user.setPassword(lib.getPassword());
	        	  
	           }
	      
	        }
	   
	        session.close();
	         
	        return user;
        }
	    @SuppressWarnings("unchecked")
	    public List<User> findAllUsers() {
	    
	        Session session = this.sessionFactory.openSession();

	        Transaction tx = session.beginTransaction();
	       
	        Query query = session.createQuery(" FROM User U ");
	       
	        List<User> results = query.list();
          
           
	        tx.commit();
	        session.close();
	        return results;
	    }
	    
	    public List<User> findUsersbyNome(String nome){
	    	 Session session = this.sessionFactory.openSession();

		        Transaction tx = session.beginTransaction();
		       
		        Query query = session.createQuery(" FROM User U WHERE U.nome = :nome ");
		        query.setParameter("nome", nome);
		        List<User> results = query.list();
	          
	           
		        tx.commit();
		        session.close();
		        return results;
	    }
	    
	    public List<User> findUsersbyCognome(String cognome){
	    	 Session session = this.sessionFactory.openSession();

		        Transaction tx = session.beginTransaction();
		       
		        Query query = session.createQuery(" FROM User U WHERE U.cognome = :cognome ");
		        query.setParameter("cognome", cognome);
		        List<User> results = query.list();
	          
	           
		        tx.commit();
		        session.close();
		        return results;
	    }
	    
	    
	    
	    public static UserDao getInstance() {
	        if(userDaoImpl == null)
	        	userDaoImpl = new UserDaoImpl();
	    
	        return userDaoImpl;
	    }

}
