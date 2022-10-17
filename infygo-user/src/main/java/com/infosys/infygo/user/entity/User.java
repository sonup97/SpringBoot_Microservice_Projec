package com.infosys.infygo.user.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@Column(nullable = false, length = 20)
	private String userId;
	@Column(nullable = false, length = 20)
	private String password;
	@Column(nullable = false, length = 30)
	private String name;
	@Column(nullable = false, length = 38)
	private String city;
	@Column(nullable = false, length = 30)
	private String email;
	@Column(nullable = false, length = 10)
	private Long phone;

//	@OneToMany(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "userId")
//	private Set<Ticket> userid;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

//	public Set<Ticket> getUserid() {
//		return userid;
//	}
//
//	public void setUserid(Set<Ticket> userid) {
//		this.userid = userid;
//	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", password=" + password + ", name=" + name + ", city=" + city + ", email="
				+ email + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, email, name, password, phone, userId);//, userid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(city, other.city) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(userId, other.userId);
				//&& Objects.equals(userid, other.userid);
	}
	
	

}
