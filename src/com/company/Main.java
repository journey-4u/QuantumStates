package com.company;

import javafx.scene.transform.MatrixType;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;

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

    public static SpinHalfSystem SPlus(SpinHalfSystem System){

        SpinHalfSystem Result = new SpinHalfSystem();
        Result =  SpinHalfSystem.Add(Sx(System), SpinHalfSystem.Multiply(new Complex(0,1),Sy(System)) )   ;
        return Result;
    }

    public static SpinHalfSystem SMinus(SpinHalfSystem System){

        SpinHalfSystem Result = new SpinHalfSystem();
        Result =  SpinHalfSystem.Add(Sx(System), SpinHalfSystem.Multiply(new Complex(0,-1),Sy(System)) )   ;
        return Result;
    }



    public static void main(String[] args) {

        Complex Z = new Complex(0.0710678118,0.70710678118);

        SpinHalfSystem Electron = new SpinHalfSystem(Z,Z);

        SpinHalfSystem Up = new SpinHalfSystem(new Complex(1,0), new Complex(0,0));
        SpinHalfSystem Down = new SpinHalfSystem(new Complex(0,0), new Complex(1,0));


        System.out.println("__________________________________________________________________________");

        System.out.println(SMinus(Up));
        System.out.println(SMinus(Down));






    }
}
