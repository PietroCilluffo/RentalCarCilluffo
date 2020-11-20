package com.rentalcar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "superuser")

public class SuperUser implements Serializable {

	/**
	 * 
	 */
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
	
	 
	 public SuperUser() {
		 
	 }
	 
	 public SuperUser(String nome, String cognome, String email, String password) {
		 this.nome = nome;
		 this.cognome = cognome;
		 this.email = email;
		 this.password = password;
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
