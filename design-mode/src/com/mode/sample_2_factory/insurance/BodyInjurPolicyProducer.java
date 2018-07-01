package com.mode.sample_2_factory.insurance;


public class BodyInjurPolicyProducer implements PolicyProducer
{
    public AutoInsurance getPolicyObj() //Fruit sample_2_factory()
    {
        return new BodyInjurLiability();
    }
}
