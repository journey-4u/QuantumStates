package com.company;

public class Complex {

    private double a;
    private double b;

    public Complex()
    {

    }

    public Complex(double a, double b)
    {
        this.a = a;
        this.b = b;
    }

    public double getIm()
    {
        return this.b;
    }

    public double getRe()
    {
        return this.a;
    }

    public void setIm(double b)
    {
        this.b = b;
    }

    public void setRe(double a)
    {
        this.a = a;
    }

    public static void printZ(Complex Z)
    {
        if (Z.b >= 0)
        {
            System.out.println(Z.a + " + " + Z.b + "i");
        }
        if (Z.b < 0)
        {
            System.out.println(Z.a + " - " + -Z.b + "i");
        }
    }

    public String toString()
    {
        String ZString = new String();
        if (this.b >= 0)
        {
            ZString = this.a + " + " + this.b + "i";
        }
        if (this.b < 0)
        {
            ZString = this.a + " - " + -this.b + "i";
        }

        return ZString;
    }

    public static Complex Add(Complex z1, Complex z2)
    {
        Complex Z = new Complex();
        Z.a = z1.a + z2.a;
        Z.b = z1.b + z2.b;
        return Z;
    }

    public static Complex Subtract(Complex z1, Complex z2)
    {
        Complex Z = new Complex();
        Z.a = z1.a - z2.a;
        Z.b = z1.b - z2.b;
        return Z;
    }

    public static Complex Minus(Complex z)
    {
        Complex Z = new Complex();
        Z.a = -z.a;
        Z.b = -z.b;
        return Z;
    }

    public static Complex Multiply(Complex z1, Complex z2)
    {
        Complex Z = new Complex();
        Z.a = (z1.a * z2.a) - (z1.b * z2.b);
        Z.b = (z1.a * z2.b) + (z1.b * z2.a);
        return Z;
    }

    public static Complex Multiply(double A, Complex z)
    {
        Complex Z = new Complex();
        Z.a = A * z.a;
        Z.b = A * z.b;
        return Z;
    }

    public static Complex Multiply(Complex z,double A)
    {
        Complex Z = new Complex();
        Z.a = A * z.a;
        Z.b = A * z.b;
        return Z;
    }

    public static Complex Divide(Complex Z, double A)
    {
        Complex Result = new Complex(Z.a / A,Z.b/A);
        return Result;
    }

    public static Complex Divide(double A,Complex Z)
    {
        Complex Result = Multiply(A,Z.Reciprocal());
        return Result;
    }
    public static Complex Divide(Complex Numerator,Complex Denominator)
    {
        Complex Result = Multiply(Numerator,Denominator.Reciprocal());
        return Result;
    }

    public double Modulus()
    {
        double abs = Math.sqrt((this.a * this.a + this.b * this.b));
        return (abs);
    }

    public double ModulusSq()
    {
        double abs =(this.a * this.a + this.b * this.b);
        return (abs);
    }

    public double Argument()
    {
        double theta = Math.atan(this.b / this.a);
        return (theta);
    }

    public Complex Conjugate()
    {
        var con = new Complex();
        con.a = this.a;
        con.b = -this.b;

        return con;
    }

    public Complex Reciprocal()
    {
        double ResultA = this.a / (this.a*this.a - this.b*this.b);
        double ResultB = this.b / (this.b*this.b - this.a*this.a);

        Complex Result = new Complex(ResultA, ResultB);
        return Result;
    }

    public static Complex Pow(Complex Z, int n)
    {
        Complex result = new Complex(1,0);

        if(n > 0)
        {
            for (int i = 1; i <= n; i++)
            {
                result = Complex.Multiply(result, Z);
            }
        }

        if(n < 0)
        {
            for (int i = 1; i <= Math.abs(n); i++)
            {
                result = Complex.Multiply(result, Z.Reciprocal());
            }
        }

       return result;
    }

    // Curently only supports integers, need to add support for negative integers, then non-integer real numbers, then complex numbers


    public static Boolean Equals(Complex z1, Complex z2)
    {
        if (z1.a == z2.a && z1.b == z2.b)
            return true;
        else
            return false;
    }

    public static Complex parseComplex(double a)
    {
        Complex Z = new Complex(a,0);
        return Z;
    }

}
