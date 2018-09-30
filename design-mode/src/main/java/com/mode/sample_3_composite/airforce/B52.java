package com.mode.sample_3_composite.airforce;


public class B52 extends Bomber{

	public static final String FEATURES = "B52H StratoFortress";


    public String getDescription(){
	    return FEATURES;
	}

	public String fight(){
		return FEATURES + " Ready to fight!";

	}

}
