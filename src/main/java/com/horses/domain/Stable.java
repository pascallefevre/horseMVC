package com.horses.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "Stable_table")
public class Stable 
{
	@Id
	@Column(name = "STBL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;
	@OneToMany(mappedBy = "myStable")
	private List<Horse> theHorses = new ArrayList<Horse>();
	
	@ManyToMany
	@JoinTable (name="OWNR_STBL", joinColumns = @JoinColumn(name= "STBL_ID"), 
			inverseJoinColumns = @JoinColumn (name= "OWNR_ID"))
	private List<Owner> theOwners =new ArrayList<Owner>();
	
	
	public Stable(String name, String city, List<Horse> theHorses, List<Owner> theOwners) {
		super();
		this.name = name;
		this.city = city;
		this.theHorses = theHorses;
		this.theOwners = theOwners;
	}
	
	public Stable(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Stable() {
		super();
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public List<Horse> getTheHorses() {
		return theHorses;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setTheHorses(List<Horse> theHorses) {
		this.theHorses = theHorses;
	}
	
	public List<Owner> getTheOwners() {
		return theOwners;
	}
	public void setTheOwners(List<Owner> theOwners) {
		this.theOwners = theOwners;
	}
	@Override
	public String toString() {
		return "Stable [id=" + id + ", name=" + name + ", city=" + city + ", theHorses=" + theHorses + "]";
	}
	
	
	
}
