package org.vadtel.jellyfishchallenge;

import org.vadtel.jellyfishchallenge.service.JellyFishService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        String instructions = new String(Files.readAllBytes(Paths.get("src/main/resources/input.txt")));

        JellyFishService service = new JellyFishService(instructions);
        service.start();
        String result = service.getResult();

        System.out.println(result);
    }


}
