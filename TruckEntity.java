package com.amdocs.CargoManagementSystem.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TruckEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Truck_ID")
	private long truckid;
	@Column(name = "RegistrationNumber")
	private String reg_no;
	@Column(name = "RCNumber")
	private String rc;
	@Column(name = "Tonnage")
	private int tonnage;
	@Column(name = "TruckModel")
	private String modelname;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	
    @ManyToOne
    @JoinColumn(name = "cargoid")
    private Cargo cargo;
	
	public TruckEntity() {
		//Default Constructor
	}
	public TruckEntity(long truckid, String reg_no, String rc, int tonnage, String modelname) {
		super();
		this.truckid = truckid;
		this.reg_no = reg_no;
		this.rc = rc;
		this.tonnage = tonnage;
		this.modelname = modelname;
	}

	public long getTruckid() {
		return truckid;
	}
	public void setTruckid(long truckid) {
		this.truckid = truckid;
	}

	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getRc() {
		return rc;
	}
	public void setRc(String rc) {
		this.rc = rc;
	}

	public int getTonnage() {
		return tonnage;
	}
	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}

	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}