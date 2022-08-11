package ru.kirzhoy.lesson4.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kirzhoy.lesson4.HomeWork4;
import ru.kirzhoy.lesson4.TriangleSidesLengthExeption;
import static org.assertj.core.api.Assertions.assertThat;

public class HomeWork4Test {
    private static Logger logger = LoggerFactory.getLogger("HomeWork4Test");

    @Test
    @DisplayName("Проверка метода вычисления площади треугольника по трем сторонам")
    void triangleTest() throws TriangleSidesLengthExeption {
        Assertions.assertEquals(HomeWork4.triangleArea(6,5,8), 14.9812,0.001);
        logger.info("info");
    }

    @Test
    @DisplayName("Проверка исключения в методе вычисления площади треугольника")
    void triangleNegativeTest(){
        Assertions.assertThrows(TriangleSidesLengthExeption.class, () -> HomeWork4.triangleArea(5,-1,15));
        logger.error("error");
    }

    @Test
    @DisplayName("Проверка метода вычисления площади треугольника по трем сторонам с помощью AssertJ")
    void triangleTestAssertJ() throws TriangleSidesLengthExeption {
        assertThat(HomeWork4.triangleArea(5,4,3)).isEqualTo(6.0);
        logger.info("error");
    }
}
