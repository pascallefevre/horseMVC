package com.horses.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table (name= "Horse_table")
public class Horse 
{
	
	@Id
	@Column(name = "HORS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Enumerated(EnumType.STRING)
	private EColor color;
	@JsonIgnore
	@ManyToOne
	@JoinColumn (name="OWNR_ID")
	private Owner myOwner;
	@JsonIgnore
	@ManyToOne
	@JoinColumn (name="STBL_ID")
	private Stable myStable;
	
	
	
	
	public Horse(String name, Date birthday, EColor color, Owner myOwner, Stable myStable) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.color = color;
		this.myOwner = myOwner;
		this.myStable = myStable;
	}
	
	public Horse(String name, Date birthday, EColor color) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.color = color;
	}

	public Horse() {
		super();
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public Owner getMyOwner() {
		return myOwner;
	}
	public Stable getMyStable() {
		return myStable;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setMyOwner(Owner myOwner) {
		this.myOwner = myOwner;
	}
	public void setMyStable(Stable myStable) {
		this.myStable = myStable;
	}
	
	public EColor getColor() {
		return color;
	}
	public void setColor(EColor color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Horse [id=" + id + ", name=" + name + ", birthday=" + birthday + ", myOwner=" + myOwner + ", myStable="
				+ myStable + "]";
	}
	
	
}