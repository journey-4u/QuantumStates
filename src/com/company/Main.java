package com.company;

public class Main {

    public static TwoStateSystem Hamiltonian(TwoStateSystem System){

        return System;
    }

    public static SpinHalfSystem Sz(SpinHalfSystem System){

        System = new SpinHalfSystem(Complex.Multiply(0.5,System.c0),Complex.Multiply(0.5,Complex.Minus(System.c1)));
        return System;
    }

    public static void main(String[] args) {

	    Complex Z = new Complex(2,1);
        //Complex.printZ(Z);
        Complex Z2 = Complex.Add(Z,new Complex(2,-5));
        //.printZ(Z2);

        SpinHalfSystem Phi = new SpinHalfSystem(Z,Z2);

        System.out.println(Phi.toString());
        System.out.println(Sz(Phi).toString());

        // hbar \u0127
        // Down Arrow, \u2191
        // Down Arrow, \u2193
    }
}
