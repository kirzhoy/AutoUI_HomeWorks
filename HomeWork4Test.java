package ru.kirzhoy.lesson4.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.kirzhoy.lesson4.HomeWork4;
import ru.kirzhoy.lesson4.TriangleSidesLengthExeption;

public class HomeWork4Test {
    @Test
    void triangleTest() throws TriangleSidesLengthExeption {
        Assertions.assertEquals(HomeWork4.triangleArea(6,5,8), 14.9812,0.001);
    }

    @Test
    void triangleNegativeTest(){
        Assertions.assertThrows(TriangleSidesLengthExeption.class, () -> HomeWork4.triangleArea(5,-1,15));
    }
}
