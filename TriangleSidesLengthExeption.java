package ru.kirzhoy.lesson4;

public class TriangleSidesLengthExeption extends Throwable {
    public TriangleSidesLengthExeption(){
        System.out.println("The length of each side can't be less than 1");
    }
}
