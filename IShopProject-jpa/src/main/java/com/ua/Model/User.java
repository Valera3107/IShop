package com.ua.Model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String email;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "role")
	private String role;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	public User() {
	}

	public User(Integer id, String email, String name, String surname, String role, String login, String password) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.login = login;
		this.password = password;
	}

	public User(String email, String name, String surname, String role, String login, String password) {
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.login = login;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(name, user.name)
				&& Objects.equals(surname, user.surname) && Objects.equals(role, user.role)
				&& Objects.equals(login, user.login) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email, name, surname, role, login, password);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", email='" + email + '\'' + ", name='" + name + '\'' + ", surname='" + surname
				+ '\'' + ", role='" + role + '\'' + ", login='" + login + '\'' + ", password='" + password + '\'' + '}';
	}
}
