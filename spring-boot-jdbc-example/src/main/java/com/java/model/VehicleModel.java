package com.java.model;

public class VehicleModel {
	int vId;
	String vType;
	String vRegNo;
	String vOwner;
	String vManfactureDate;
	public VehicleModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VehicleModel(int vId, String vType, String vRegNo, String vOwner,
			String vManfactureDate) {
		super();
		this.vId = vId;
		this.vType = vType;
		this.vRegNo = vRegNo;
		this.vOwner = vOwner;
		this.vManfactureDate = vManfactureDate;
	}
	public VehicleModel(String vType, String vRegNo, String vOwner,
			String vManfactureDate) {
		super();
		this.vType = vType;
		this.vRegNo = vRegNo;
		this.vOwner = vOwner;
		this.vManfactureDate = vManfactureDate;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getvType() {
		return vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
	public String getvRegNo() {
		return vRegNo;
	}
	public void setvRegNo(String vRegNo) {
		this.vRegNo = vRegNo;
	}
	public String getvOwner() {
		return vOwner;
	}
	public void setvOwner(String vOwner) {
		this.vOwner = vOwner;
	}
	public String getvManfactureDate() {
		return vManfactureDate;
	}
	public void setvManfactureDate(String vManfactureDate) {
		this.vManfactureDate = vManfactureDate;
	}
	

}
