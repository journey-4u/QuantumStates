package com.company;

public class TwoStateSystem {

    public Complex c0;
    public Complex c1;

    TwoStateSystem()
    {
        this.c0 = new Complex(0,0);
        this.c1 = new Complex(0,0);
    }

    TwoStateSystem(Complex c0, Complex c1)
    {
        this.c0 = c0;
        this.c1 = c1;
    }


    public double State0Probability()
    {
        return this.c0.ModulusSq();
    }

    public double State1Probability()
    {
        return this.c1.ModulusSq();
    }

    public static TwoStateSystem Add(TwoStateSystem system1, TwoStateSystem system2)
    {
        TwoStateSystem ResultantSystem = new TwoStateSystem(Complex.Add(system1.c0,system2.c0),Complex.Add(system1.c1,system2.c1));
        return ResultantSystem;
    }

    public static TwoStateSystem Multiply(Complex Z, TwoStateSystem system)
    {
        TwoStateSystem ResultantSystem = new TwoStateSystem(Complex.Multiply(Z,system.c0),Complex.Multiply(Z,system.c1));
        return ResultantSystem;
    }

    public String toString(){

        String SystemString = new String();

        SystemString = "("+this.c0.toString()+")"+"|0\u3009"+ " + ("+this.c1.toString()+")"+"|1\u27E9";

        return SystemString;

    }

}
