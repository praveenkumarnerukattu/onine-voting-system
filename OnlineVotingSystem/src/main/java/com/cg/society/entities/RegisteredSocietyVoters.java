package com.cg.society.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


 @Data
@NoArgsConstructor
@Entity
@Table(name = "RegisteredSocietyVoters_Table")

public class RegisteredSocietyVoters {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer voterId;
	
	@Column(name="Voter_Card_No")
	@NotNull
	private String voterIdCardNo;
	
	@Column(name="First_Name")
	@NotNull
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Gender")
	@NotNull
	private String gender;
	
	@Column(name="Password")
	@NotNull
	private String password;
	
	@Column(name="ResCategory")
	private String reservationCategory;
	
	@Column(name= "Mobile")
	private String mobileno;
	
	@Column(name="Email")
	@Email(message="Please enter valid email ID")
	private String emailid;
	
	@Column(name="Address_1")
	@NotNull
	private String address1;
	
	@Column(name="Address_2")
	private String address2; 
	
	@Column(name="mandal")
	@NotNull
	private String mandal;
	
	@Column(name="District")
	@NotNull
	private String district;
	
	@Column(name= "Pincode")
	@NotNull
	private Integer pincode;
	
	@OneToOne(cascade =CascadeType.ALL)
	CooperativeSociety Society;
	
	@Column(name="CastedVote")
	@NotNull
	private boolean castedVote;

	/*public static boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}*/
	
	
	
	
	

}