package com.horses.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name= "Owner_table")
public class Owner 
{
	@Id
	@Column(name = "OWNR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private String city;
	@JsonIgnore
	@OneToMany(mappedBy = "myOwner", fetch = FetchType.EAGER)
	private Set<Horse> myHorse = new HashSet<Horse>();
	@JsonIgnore
	@ManyToMany(mappedBy = "theOwners", fetch = FetchType.EAGER)
	private Set<Stable> myStables=new HashSet<Stable>();
	
	
	
	
	public Owner(String firstname, String lastname, Date birthday, String city, Set<Horse> myHorse,
			Set<Stable> myStables) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.city = city;
		this.myHorse = myHorse;
		this.myStables = myStables;
	}

	public Owner(String firstname, String lastname, Date birthday, String city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.city = city;
	}

	public Owner() {
		super();
	}
	@Override
	public String toString() {
		return "Owner [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthday=" + birthday
				+ ", city=" + city + ", myHorse=" + myHorse + "]";
	}
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getCity() {
		return city;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Set<Horse> getMyHorse() {
		return myHorse;
	}

	public void setMyHorse(Set<Horse> myHorse) {
		this.myHorse = myHorse;
	}

	public Set<Stable> getMyStables() {
		return myStables;
	}
	public void setMyStables(Set<Stable> myStables) {
		this.myStables = myStables;
	}
	
	
}
