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

    @Override
    public String toString(){

        String SystemString = new String();

        SystemString = "("+this.c0.toString()+")"+"|\u2191\u3009"+ " + ("+this.c1.toString()+")"+"|\u2193\u27E9";

        return SystemString;

    }
}
