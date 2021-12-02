package day2;

import helpers.ReadFile;

import java.util.ArrayList;

public class Day2 {

    public static void main(String[] args) {
        ArrayList<String> lines = ReadFile.getLines("src/day2/day_2_puzzle_input.txt");

        part1(lines);
        part2(lines);
    }

    private static void part1(ArrayList<String> lines) {
        int horizontalDistance = 0;
        int depth = 0;

        for(String line : lines) {
            String[] split = splitString(line);

            switch (split[0]) {
                case "forward" -> horizontalDistance += toInt(split[1]);
                case "down" -> depth += toInt(split[1]);
                case "up" -> depth -= toInt(split[1]);
            }
        }

        System.out.println("Squared position part1: " + (horizontalDistance * depth));
    }

    private static void part2(ArrayList<String> lines) {
        int horizontalDistance = 0;
        int depth = 0;
        int aim = 0;

        for(String line : lines) {
            String[] split = splitString(line);

            switch (split[0]) {
                case "forward" -> {
                    horizontalDistance += toInt(split[1]);
                    depth += aim * toInt(split[1]);
                }
                case "down" -> aim += toInt(split[1]);
                case "up" -> aim -= toInt(split[1]);
            }
        }

        System.out.println("Squared position part2: " + (horizontalDistance * depth));
    }

    private static String[] splitString(String str) {
        return str.split(" ");
    }

    private static Integer toInt(String str) {
        return Integer.parseInt(str);
    }
}
