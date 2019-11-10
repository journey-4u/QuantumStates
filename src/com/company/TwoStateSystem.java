package com.company;

public class TwoStateSystem {

    public Complex c0;
    public Complex c1;

    TwoStateSystem()
    {
        this.c0 = c0;
        this.c1 = c1;
    }

    TwoStateSystem(Complex c0, Complex c1)
    {
        this.c0 = c0;
        this.c1 = c1;
    }

    public String toString(){

        String SystemString = new String();

        SystemString = "("+this.c0.toString()+")"+"|0\u3009"+ " + ("+this.c1.toString()+")"+"|1\u27E9";

        return SystemString;

    }

}
