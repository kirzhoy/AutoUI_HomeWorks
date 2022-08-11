package ru.kirzhoy.lesson4;

public class HomeWork4 {

    public static void main(String[] args) {
        try {
            triangleArea(2,5,9);
        } catch (TriangleSidesLengthExeption e) {
            throw new RuntimeException(e);
        }
    }
    public static double triangleArea (double a, double b, double c) throws TriangleSidesLengthExeption {
        if (a <=0 || b <=0 || c <=0) {
            throw new TriangleSidesLengthExeption();
        }
        double hp = (a + b + c)/2;
        return Math.sqrt(hp*(hp-a)*(hp-b)*(hp-c));

    }
}
