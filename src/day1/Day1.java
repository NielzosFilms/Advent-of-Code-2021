package day1;

import helpers.ReadFile;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Day1 {

    public static void main(String[] args) {
        ArrayList<String> lines = ReadFile.getLines("src/day1/day_1_puzzle_input.txt");

        AtomicInteger increaseCount = new AtomicInteger();
        lines.stream().reduce((str1, str2) -> {
            if (Integer.parseInt(str1) < Integer.parseInt(str2)) increaseCount.getAndIncrement();
            return str2;
        });
        System.out.println("Part 1 answer: " + increaseCount.get());

        int prevSum = -1;
        int increaseCount2 = 0;
        for (int i = 0; i < lines.size()-2; i++) {
            int sum = Integer.parseInt(lines.get(i)) +
                        Integer.parseInt(lines.get(i + 1)) +
                        Integer.parseInt(lines.get(i + 2));

            if (sum > prevSum && prevSum != -1) {
                increaseCount2++;
            }
            prevSum = sum;
        }
        System.out.println("Part 2 answer: " + increaseCount2);
    }
}
