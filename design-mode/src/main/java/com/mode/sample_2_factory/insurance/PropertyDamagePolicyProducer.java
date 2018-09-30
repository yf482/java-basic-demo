package com.mode.sample_2_factory.insurance;


public class PropertyDamagePolicyProducer implements PolicyProducer
{
    public AutoInsurance getPolicyObj() //Fruit sample_2_factory()
    {
        return new PropertyDamageLiability();
    }
}
