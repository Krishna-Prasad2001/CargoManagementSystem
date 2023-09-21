package com.amdocs.CargoManagementSystem.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CARGO")
public class Cargo {
	@Id
	@Column(name = "CargoID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "SenderName")
	private String sname;
	@Column(name = "PhoneNumber")
	private String phonenumber;
	@Column(name = "Email")
	private String email;
	@Column(name = "CargoType")
	private String cargotype;
	
	@OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
	    private Set<TruckEntity> order = new HashSet<>();
	
		public Cargo(String sname, String phonenumber, String email, String cargotype) {
		super();
		this.sname = sname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.cargotype = cargotype;
	}

	public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargotype() {
		return cargotype;
	}
	public void setCargotype(String cargotype) {
		this.cargotype = cargotype;
	}

		public Cargo() {
		// TODO Auto-generated constructor stub
	}
}
