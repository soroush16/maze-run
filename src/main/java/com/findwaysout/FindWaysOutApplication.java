package com.findwaysout;

import com.findwaysout.implementation.Solution;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FindWaysOutApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FindWaysOutApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Solution solutionImpl = new Solution();
        solutionImpl.countMinimumSteps("map1.txt");
    }
}
