package com.mode.sample_2_factory.house;


public class EconomyBuildingFactory extends BuildingFactory {


   public House getHouse()
   {
	   return new EconomyHouse("Economy house");

   }
   public Condo getCondo()
   {
	   return new EconomyCondo("Economy condo");
   }
} // End of class
