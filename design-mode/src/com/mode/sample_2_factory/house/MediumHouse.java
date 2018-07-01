package com.mode.sample_2_factory.house;


public class MediumHouse implements House
{
  		private String name;

  		public MediumHouse(String cName)
  		{
    			name = cName;
  		}

  		public String getHouseInfo()
  		{
			return "mediumHouse.html";
	    }

	    public String getHouseFeatures()
		{
			return "Medium House ";
  		}

} // End of class
