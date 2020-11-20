package com.rentalcar.dao;

import java.util.List;
import com.rentalcar.entity.User;
import com.rentalcar.entity.SuperUser;
public interface UserDao {
    int saveUser(User User);
    
    int saveUser(SuperUser User);
 
    void updateUser(User User);
 
    void deleteUser(int id);
 
    User findUserById(int id);
    
    User findUserByEmail(String email);
    
    SuperUser findSuperUserById(int id);
    
    SuperUser findSuperUserByEmail(String email);
 
    List<User> findAllUsers();
    
    List<User> findUsersbyNome(String nome);
    
    List<User> findUsersbyCognome(String cognome);
    
}
