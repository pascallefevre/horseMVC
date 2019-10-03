package com.horses.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	@OneToMany(mappedBy = "myStable", fetch = FetchType.EAGER)
	private Set<Horse> theHorses = new HashSet<Horse>();
	@JsonIgnore
	@ManyToMany
	@JoinTable (name="OWNR_STBL", joinColumns = @JoinColumn(name= "STBL_ID"), 
			inverseJoinColumns = @JoinColumn (name= "OWNR_ID"))
	private Set<Owner> theOwners =new HashSet<Owner>();
	
	
	public Stable(String name, String city, Set<Horse> theHorses, Set<Owner> theOwners) {
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
	public Set<Horse> getTheHorses() {
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
	public void setTheHorses(Set<Horse> theHorses) {
		this.theHorses = theHorses;
	}
	
	public Set<Owner> getTheOwners() {
		return theOwners;
	}
	public void setTheOwners(Set<Owner> theOwners) {
		this.theOwners = theOwners;
	}
	@Override
	public String toString() {
		return "Stable [id=" + id + ", name=" + name + ", city=" + city + ", theHorses=" + theHorses + "]";
	}
	
	
	
}
