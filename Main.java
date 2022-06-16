package com.company;

import java.util.Scanner;

class OneClass {
    double a, b, c;

    public OneClass(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    void Count(double a, double b, double c){
        System.out.println(a * Math.pow(b, c));
    }
}

class TwoClass {
    double a, b, c;

    public TwoClass(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    void Count(double a, double b, double c){
        System.out.println(a * Math.pow(b, c));
    }
}

@FunctionalInterface
interface Converter<One, Two>{
    Two convert(One o);

    static <One> boolean isNotNull(One o){
        return o != null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Выражение: a * b ^ c");
        System.out.print("a = ");
        double a = in.nextDouble();
        System.out.print("b = ");
        double b = in.nextDouble();
        System.out.print("c = ");
        double c = in.nextDouble();
        OneClass oc = new OneClass(a, b, c);
        Converter<OneClass, TwoClass> converter = x -> new TwoClass(x.a, x.b, x.c);
        TwoClass tw = converter.convert(oc);
        tw.Count(a, b, c);
    }
}