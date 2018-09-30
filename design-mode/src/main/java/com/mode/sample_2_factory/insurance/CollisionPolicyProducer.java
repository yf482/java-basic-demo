package com.mode.sample_2_factory.insurance;


public class CollisionPolicyProducer implements PolicyProducer
{
    public AutoInsurance getPolicyObj() //Fruit sample_2_factory()
    {
        return new CollisionCoverage();
    }
}
