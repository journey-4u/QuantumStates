package com.company;

public class Main {

    public static TwoStateSystem Hamiltonian(TwoStateSystem System){

        return System;
    }

    public static SpinHalfSystem Sz(SpinHalfSystem System){

        System = new SpinHalfSystem(Complex.Multiply(0.5,System.c0),Complex.Multiply(0.5,Complex.Minus(System.c1)));
        return System;
    }

    public static SpinHalfSystem Sx(SpinHalfSystem System){

        System = new SpinHalfSystem(Complex.Multiply(0.5,System.c1),Complex.Multiply(0.5,System.c0));
        return System;
    }

    public static SpinHalfSystem Sy(SpinHalfSystem System){

        System = new SpinHalfSystem(Complex.Multiply(new Complex(0,-0.5),System.c1),Complex.Multiply(new Complex(0,0.5),System.c0));
        return System;
    }

    public static void main(String[] args) {

        Complex Z = new Complex(0.0710678118,0.70710678118);

        SpinHalfSystem Electron = new SpinHalfSystem(Z,Z);

        System.out.println(Electron);
        System.out.println(Sz(Electron));
        System.out.println(Sx(Electron));
        System.out.println(Sy(Electron));

    }
}
