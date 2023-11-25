package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int nextTruckId = 1;
	private String name;
	private String foodType;
	private double rating;
	private int truckId;
	
	
	
	public FoodTruck(String name, String foodType, double rating) {
		super();
		this.truckId = nextTruckId;
		nextTruckId++;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}


	public int getTruckId() {
		return truckId;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFoodType() {
		return foodType;
	}


	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "truck id = " + truckId + ", name = " + name + ", food type = " + foodType + ", rating = " + rating;
	}
	 
}
