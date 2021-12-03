package day3;

import helpers.ReadFile;

import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<String> lines = ReadFile.getLines("src/day3/day_3_puzzle_input.txt");
        part1(lines);
        part2(lines);
    }

    private static void part1(ArrayList<String> lines) {
        ArrayList<Integer> bitCounts = new ArrayList<>();

        for(Character character : lines.get(0).toCharArray()) {
            bitCounts.add(0);
        }

        for(String line : lines) {
            for(int i = 0; i < line.toCharArray().length; i++) {
                if(line.toCharArray()[i] == '1') {
                    bitCounts.set(i, bitCounts.get(i) + 1);
                }
            }
        }

        StringBuilder epsilonRate = new StringBuilder();
        StringBuilder gammaRate = new StringBuilder();
        for(Integer bitCount : bitCounts) {
            if(bitCount > lines.size() - bitCount) {
                epsilonRate.append("1");
                gammaRate.append("0");
            } else {
                epsilonRate.append("0");
                gammaRate.append("1");
            }
        }

        int power = Integer.parseInt(epsilonRate.toString(), 2) * Integer.parseInt(gammaRate.toString(), 2);
        System.out.print("Power usage: " + power);
    }

    private static void part2(ArrayList<String> lines) {
        ArrayList<String> linesCopy = new ArrayList<>(lines);

        //i dunno anymore bro
        int index = 0;
        while (linesCopy.size() > 1) {
            int bitCount = 0;
            for(String line : linesCopy) {
                if(line.charAt(index) == '1') {
                    bitCount++;
                }
            }
            Character keepCharacter = '0';
            if (bitCount <= linesCopy.size() - bitCount) {
                keepCharacter = '1';
            }
            ArrayList<String> newLines = new ArrayList<>();
            for (String line : linesCopy) {
                if (line.charAt(index) != keepCharacter) {
                    newLines.add(line);
                }
            }
            linesCopy = newLines;
        }
    }
}
