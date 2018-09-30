package com.mode.sample_2_factory.insurance;


public class PersonInjuryPolicyProducer implements PolicyProducer
{
    public AutoInsurance getPolicyObj() //Fruit sample_2_factory()
    {
        return new PersonalInjuryProtection();
    }
}
