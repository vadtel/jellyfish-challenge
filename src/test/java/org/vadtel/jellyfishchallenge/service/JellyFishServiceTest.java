package org.vadtel.jellyfishchallenge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class JellyFishServiceTest {

    private static final String INPUT =
                    "5 3\r\n" +
                    "1 1 E RFRFRFRF\r\n" +
                    "3 2 N FRRFLLFFRRFLL\r\n" +
                    "0 3 W LLFFFLFLFL";

    private static final String OUTPUT =
                    "11E\r\n" +
                    "33NLOST\r\n" +
                    "23S";



    @Test
    void firstTest() {
        JellyFishService service = new JellyFishService(INPUT);
        service.start();
        String result = service.getResult();
        assertEquals(OUTPUT, result);

    }
}