package com.infosys.infygo.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.infosys.infygo.user.entity.User;

public class UserDTO {

	@NotBlank(message = "{user.id.must}")
	private String userId;

	@NotEmpty(message = "{user.password.must}")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{9,}$", message = "{user.password.invalid}")
	private String password;

	@NotBlank(message = "{user.name.must}")
	private String name;
	private String city;

	@NotNull(message = "{user.email.must}")
	@Email(message = "{user.email.invalid}")
	private String email;

	@NotNull(message = "{user.phone.must}")
	private Long phone;

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

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", password=" + password + ", name=" + name + ", city=" + city + ", email="
				+ email + ", phone=" + phone + "]";
	}

	// Converts DTO into Entity
	public User createEntity() {

		User userEntity = new User();
		userEntity.setUserId(this.userId);
		userEntity.setPassword(this.password);
		userEntity.setName(this.name);
		userEntity.setCity(this.city);
		userEntity.setEmail(this.email);
		userEntity.setPhone(this.phone);

		return userEntity;
	}

	// Converts Entity into DTO
	public static UserDTO valueOf(User userEntity) {

		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userEntity.getUserId());
		userDTO.setPassword(userDTO.getPassword());
		userDTO.setName(userDTO.getName());
		userDTO.setCity(userDTO.getCity());
		userDTO.setEmail(userDTO.getEmail());
		userDTO.setPhone(userDTO.getPhone());

		return userDTO;
	}

}
