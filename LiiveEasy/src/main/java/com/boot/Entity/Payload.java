package com.boot.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "payload-entity")
public class Payload {

	

	@NotEmpty
	private String loadingPoint;

	@NotEmpty
	private String unloadingPoint;

	@NotEmpty
	private String productType;

	@NotEmpty
	private String truckType;

	@NotNull
	private int noOfTruck;

	@NotNull
	private double weight;

	private String comment;

	@Id
	private String shipperId;

	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;

	public Payload() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Payload(@NotEmpty String loadingPoint, @NotEmpty String unloadingPoint, @NotEmpty String productType,
			@NotEmpty String truckType, @NotNull int noOfTruck, @NotNull double weight, String comment,
			String shipperId, @NotNull LocalDate date) {
		super();
		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.noOfTruck = noOfTruck;
		this.weight = weight;
		this.comment = comment;
		this.shipperId = shipperId;
		this.date = date;
	}

	public String getLoadingPoint() {
		return loadingPoint;
	}

	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}

	public String getUnloadingPoint() {
		return unloadingPoint;
	}

	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public int getNoOfTruck() {
		return noOfTruck;
	}

	public void setNoOfTruck(int noOfTruck) {
		this.noOfTruck = noOfTruck;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getShipperId() {
		return shipperId;
	}

	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	
}
