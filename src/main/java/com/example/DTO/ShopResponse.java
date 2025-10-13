package com.example.DTO;

import com.example.model.Shop;

public class ShopResponse {
	  private Shop shop;
	    private double distanceInKm;
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public double getDistance() {
			return distance;
		}
		public void setDistance(double distance) {
			this.distance = distance;
		}
		public boolean isOpen() {
			return isOpen;
		}
		public void setOpen(boolean isOpen) {
			this.isOpen = isOpen;
		}

		private Long id;
	    private String name;
	    private String city;
	    private double latitude;
	    private double longitude;
	    private double distance;
	    private boolean isOpen;
	    public ShopResponse() {}
	    public ShopResponse(Shop shop, double distanceInKm) {
	        this.shop = shop;
	        this.distanceInKm = distanceInKm;
	    }

	    public Shop getShop() {
	        return shop;
	    }

	    public void setShop(Shop shop) {
	        this.shop = shop;
	    }

	    public double getDistanceInKm() {
	        return distanceInKm;
	    }

	    public void setDistanceInKm(double distanceInKm) {
	        this.distanceInKm = distanceInKm;
	    }
}
