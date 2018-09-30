package com.mode.sample_2_factory.house;


public class SuperHouse implements House
{
  		private String name;

  		public SuperHouse(String cName)
  		{
    			name = cName;
  		}

  		public String getHouseInfo()
  		{
			return "superHouse.html";
	    }

	    public String getHouseFeatures()
		{
			return "Super House ";
  		}

} // End of class


