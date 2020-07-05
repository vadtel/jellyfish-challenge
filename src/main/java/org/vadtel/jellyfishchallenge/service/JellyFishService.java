package org.vadtel.jellyfishchallenge.service;

import org.vadtel.jellyfishchallenge.exception.InvalidJellyFishInstructionInputData;
import org.vadtel.jellyfishchallenge.model.Jellyfish;
import org.vadtel.jellyfishchallenge.model.Orientation;
import org.vadtel.jellyfishchallenge.model.Tank;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JellyFishService {
    private Tank tank;
    private String instruction;

    public JellyFishService(String instruction) {
        this.instruction = instruction;
    }

    public void start() {
        String[] lines = instruction.split("[\r\n]+");
        int[] coordinates = Stream.of(lines[0].split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        if (coordinates.length == 2) {
            createTank(coordinates);
        } else {
            throw new InvalidJellyFishInstructionInputData("Enter the correct coordinates");
        }

        for (int i = 1; i < lines.length; i++) {
            String[] s = lines[i].split(" ");
            if (s.length == 4) {
                doJellyFishInstruction(s);
            } else {
                throw new InvalidJellyFishInstructionInputData("Error in " + i + " instruction");
            }
        }


    }
    private void createTank(int[] coordinates){
        tank = new Tank(coordinates[0], coordinates[1]);
    }

    private void doJellyFishInstruction(String[] instruction) {
        Jellyfish jellyfish = tank.addJellyfish(Integer.parseInt(instruction[0]),
                                                Integer.parseInt(instruction[1]),
                                                Orientation.parseOrientation(instruction[2]));

        instruction[3].chars()
                .mapToObj(ch -> Character.toString((char) ch))
                .forEach(jellyfish::doInstruction);

    }

    public String getResult(){
       return tank.getJellyFishes().stream()
                .map(Jellyfish::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
