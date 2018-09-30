package com.mode.sample_3_composite.airforce;

/*================================*/
/* Represents a kind of airforce  */
/*================================*/

public abstract class Transporter implements Airforce{

	public static final String FEATURES = "Transporters ";

    public String getDescription(){
	    return FEATURES;
	}

	public abstract String fight();
}
