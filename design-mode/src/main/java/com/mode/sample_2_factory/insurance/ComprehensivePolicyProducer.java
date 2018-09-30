package com.mode.sample_2_factory.insurance;


public class ComprehensivePolicyProducer implements PolicyProducer
{
    public AutoInsurance getPolicyObj() //Fruit sample_2_factory()
    {
        return new ComprehensiveCoverage();
    }
}
