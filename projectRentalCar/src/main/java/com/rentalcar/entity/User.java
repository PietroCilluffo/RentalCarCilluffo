package com.rentalcar.entity;
import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;



@Entity
@Table(name = "user")


public class User implements Serializable{

	private static final long serialVersionUID = 1L;

@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)

 
 @Column(name = "id")
 private int id;
 
 @Column(name = "nome")
 private String nome;
 
 @Column(name = "cognome")
 private String cognome;
 
 @Column(name = "email")
 private String email;

 @Column(name = "password")
 private String password;

 @OneToMany (mappedBy = "user",cascade = CascadeType.REMOVE)
 private List<Reservation> reservations;
	public List<Reservation> getReservation() {
		return reservations;
	}
 //buona pratica scrivere un costruttore vuoto
 public User() {
	 
 }
 
 public User(String nome, String cognome, String email, String password) {
	 this.nome = nome;
	 this.cognome = cognome;
	 this.email = email;
	 this.password = password;

	 
 }


public List<Reservation> getReservations() {
	return reservations;
}
public void setReservations(List<Reservation> reservations) {
	this.reservations = reservations;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}