package com.spring.model;
	
	public class TouristData {
		private Integer id;
		private String name;
		private String tourPackage;
		private Double cost;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer Id) {
			id = Id;
		}
		public String getName() {
			return name;
		}
		public void setName(String Name) {
			name = Name;
		}
		public String getTourPackage() {
			return tourPackage;
		}
		public void setTourPackage(String TourPackage) {
			tourPackage = TourPackage;
		}
		public Double getCost() {
			return cost;
		}
		public void setCost(Double Cost) {
			cost = Cost;
		}
		
		public TouristData() {
			super();
		}
		
		public TouristData(Integer Id, String Name, String TourPackage, Double Cost) {
			super();
			id = Id;
			name = Name;
			tourPackage = TourPackage;
			cost = Cost;
		}
		@Override
		public String toString() {
			return "TouristData [Id=" + id + ", Name=" + name + ", TourPackage=" + tourPackage + ", Cost=" + cost + "]";
		}
		
		
		
	

}
