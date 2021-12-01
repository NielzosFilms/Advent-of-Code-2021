package day1;

import helpers.ReadFile;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Day1 {

    public static void main(String[] args) {
        System.out.println("Day1");
        ArrayList<String> lines = ReadFile.getLines("src/day1/day_1_puzzle_input.txt");

        AtomicInteger increaseCount = new AtomicInteger();
        lines.stream().reduce((str1, str2) -> {
            if(Integer.parseInt(str1) < Integer.parseInt(str2)) increaseCount.getAndIncrement();
            return str2;
        });
        System.out.println(increaseCount.get());
    }
}
