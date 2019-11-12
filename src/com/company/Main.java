package com.company;

import javafx.scene.transform.MatrixType;

import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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

    public static SpinHalfSystem simpleHamiltonian(SpinHalfSystem system){
        double hbar = 0.00000000000000000000000000000000010545718;

        Complex upCo = Complex.Multiply(0.5*hbar,system.c1);
        Complex downCo = Complex.Multiply(0.5*hbar,system.c0);



        SpinHalfSystem ResultantSystem = new SpinHalfSystem(upCo,downCo);

        return ResultantSystem;

    }

    public static SpinHalfSystem simpleTimeEvolution(SpinHalfSystem system,double t){
        double hbar = 0.00000000000000000000000000000000010545718;

        SpinHalfSystem ZerothTerm = system;
        SpinHalfSystem FirstTerm =   SpinHalfSystem.Multiply(new Complex(0,-(t/hbar)), simpleHamiltonian(system));
        SpinHalfSystem SecondTerm =   SpinHalfSystem.Multiply(new Complex(-((t*t)/(hbar*hbar)),0), simpleHamiltonian(simpleHamiltonian(system)));
        SpinHalfSystem ThirdTerm =   SpinHalfSystem.Multiply(new Complex(0,((t*t*t)/(hbar*hbar*hbar))), simpleHamiltonian(simpleHamiltonian(simpleHamiltonian(system))));


        SpinHalfSystem ResultantSystem = ZerothTerm;
        ResultantSystem = SpinHalfSystem.Add(ResultantSystem,FirstTerm);
        ResultantSystem = SpinHalfSystem.Add(ResultantSystem,SecondTerm);
        ResultantSystem = SpinHalfSystem.Add(ResultantSystem,ThirdTerm);

        return ResultantSystem;
        // Results are more accurate the less time that has progressesd
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        Complex Z = new Complex(0.70710678118,0);

        SpinHalfSystem upElectron = new SpinHalfSystem(new Complex(1,0),new Complex(0,0));
        SpinHalfSystem downElectron = new SpinHalfSystem(new Complex(0,0),new Complex(1,0));

        SpinHalfSystem upElectron2 = new SpinHalfSystem(new Complex(0,1),new Complex(0,0));
        SpinHalfSystem downElectron2 = new SpinHalfSystem(new Complex(0,0),new Complex(0,1));

        SpinHalfSystem Electron = new SpinHalfSystem(new Complex(0.5,0),new Complex(0.866,0));

        System.out.println(upElectron);
        System.out.println(downElectron);
        System.out.println(upElectron2);
        System.out.println(downElectron2);
        System.out.println(Electron);
        System.out.println(System.getProperty("user.dir"));

        double Time = 4;
        int precision = 4;
        double deltaT = Time / Math.pow(10,precision);
        var N = (int) Math.pow(10,precision);
        SpinHalfSystem altState = simpleTimeEvolution(Electron,deltaT);
        PrintWriter writer = new PrintWriter("D:/the-file-name.txt", "UTF-8");
        for(int i = 0; i <N ;i++)
        {
            altState = simpleTimeEvolution(altState,deltaT);
            writer.println(altState);
        }
        System.out.println(altState);
        SpinHalfSystem finalState = altState;
        System.out.println(Electron);
        System.out.println(finalState);
        System.out.println("__________________________________________________________________________");
        System.out.println(Electron.State0Probability() + "     :     "+ Electron.State1Probability());
        System.out.println(finalState.State0Probability() + "     :     "+ finalState.State1Probability());
        System.out.println("__________________________________________________________________________");



    }
}
