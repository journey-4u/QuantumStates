package com.company;

public class SpinHalfSystem extends TwoStateSystem{

    SpinHalfSystem()
    {
        this.c0 = new Complex(0,0);
        this.c1 = new Complex(0,0);
    }

    SpinHalfSystem(Complex c0, Complex c1)
    {
        this.c0 = c0;
        this.c1 = c1;
    }

    public static SpinHalfSystem Add(SpinHalfSystem system1, SpinHalfSystem system2)
    {
        SpinHalfSystem ResultantSystem = new SpinHalfSystem(Complex.Add(system1.c0,system2.c0),Complex.Add(system1.c1,system2.c1));
        return ResultantSystem;
    }

    public static SpinHalfSystem Multiply(Complex Z, SpinHalfSystem system)
    {
        SpinHalfSystem ResultantSystem = new SpinHalfSystem(Complex.Multiply(Z,system.c0),Complex.Multiply(Z,system.c1));
        return ResultantSystem;
    }

    @Override
    public String toString(){

        String SystemString = new String();

        SystemString = "("+this.c0.toString()+")"+"|\u2191\u3009"+ " + ("+this.c1.toString()+")"+"|\u2193\u27E9";

        return SystemString;

    }
}
