package com.mariia.runtotals;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Map<Person, List<Run>> personToLengthMap = new HashMap<>();

        System.out.println("Enter name: ");

        while(true) {

            String name = console.nextLine();

            if (name.equals("q")) {
                break;
            }
            Person person = new Person(name);

            System.out.println("Enter run length: ");

            int runLength = Integer.parseInt(console.nextLine());

            try {
                Run run = new Run(runLength);
                var existedList = personToLengthMap.get(person);
                if (existedList != null) {
                    existedList.add(run);

                    System.out.println("Name: " + person);
                    int sum = 0;
                    for (Run runInLoop : existedList) {
                        sum += runInLoop.getRunLength();
                    }
                    System.out.println("Sum " + sum);
                    System.out.println("Sum " + existedList.stream().map(Run::getRunLength).reduce(Integer::sum).orElse(0));

                } else {
                    var list = new ArrayList<Run>();
                    list.add(run);
                    personToLengthMap.put(person, list);

                    System.out.println("Name: " + person);
                    for (Run runs : list) {
                        System.out.println(runs);
                    }

                }
            } catch (Exception e) {
                System.out.println("You didn't enter a number, enter correct number ");
            }
            System.out.println("Enter name");
        }
    }
}
