package com.gcit.lms.entities;

// Generated Feb 5, 2014 3:10:53 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * TblLogins generated by hbm2java
 */
@Entity
@Table(name = "tbl_logins", catalog = "library")
public class Logins implements java.io.Serializable {

	private int userId;
	private User user;
	private String login;
	private String password;

	public Logins() {
	}

	public Logins(User user, String login, String password) {
		this.user = user;
		this.login = login;
		this.password = password;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "tblUser"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "userId", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getTblUser() {
		return this.user;
	}

	public void setTblUser(User user) {
		this.user = user;
	}

	@Column(name = "login", nullable = false, length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
