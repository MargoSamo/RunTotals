package com.mariia.runtotals;

import java.util.*;

public class Main {
    static Map<Person, List<Run>> personToLengthMap = new HashMap<>();
    static Map<Person, List<ReversePushUp>> personToExerciseMap = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter exercise: \n" +
                "r - run \n" +
                "rp - reverse push ups");

        var typeUserInput = scanner.nextLine();
        ExerciseType exerciseType;
        if (typeUserInput.equals(ExerciseType.RUN.shortName)) {
            exerciseType = ExerciseType.RUN;
        } else if (typeUserInput.equals(ExerciseType.REVERSE_PUSH_UP.shortName)) {
            exerciseType = ExerciseType.REVERSE_PUSH_UP;
        } else {
            exerciseType = ExerciseType.UNDEFINED;
        }

        processUserExercise(exerciseType, scanner);

    }

    private static void processUserExercise(ExerciseType type, Scanner scanner) {
        System.out.println("Enter name: ");

        while(true) {

            String name = scanner.nextLine();

            if (name.equals("q")) {
                break;
            }
            Person person = new Person(name);
            if (type == ExerciseType.RUN) {
                processRun(scanner, person);
            } else if (type == ExerciseType.REVERSE_PUSH_UP) {
                processExercise(scanner, person);
            } else if (type == ExerciseType.UNDEFINED) {
                System.out.println("You didn't enter a exercise, enter correct exercise");
            }
        }
    }

    private static void processExercise(Scanner scanner, Person person) {
        System.out.println("Enter push up: ");

        int upExercise = Integer.parseInt(scanner.nextLine());

        try {

            ReversePushUp reversePushUp = new ReversePushUp(upExercise);
            var existedList = personToExerciseMap.get(person);
            if (existedList != null) {
                existedList.add(reversePushUp);

                System.out.println("Name: " + person);
                int sum = 0;
                for (ReversePushUp reversePushUpInLoop : existedList) {
                    sum += reversePushUpInLoop.getUpExercise();
                }
                System.out.println("Sum " + existedList.stream().map(ReversePushUp::getUpExercise).reduce(Integer::sum).orElse(0));

            } else {
                var list = new ArrayList<ReversePushUp>();
                list.add(reversePushUp);
                personToExerciseMap.put(person, list);

                System.out.println("Name: " + person);
                for (ReversePushUp revers : list) {
                    System.out.println(revers);
                }
            }
        } catch (Exception e) {
            System.out.println("You didn't enter a number, enter correct number ");
        }
        System.out.println("Enter name");
    }

    private static void processRun(Scanner scanner, Person person) {
        System.out.println("Enter run length: ");

        int runLength = Integer.parseInt(scanner.nextLine());

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

    private enum ExerciseType {
        UNDEFINED(null), RUN("r"), REVERSE_PUSH_UP("rp");

        private final String shortName;

        ExerciseType(String shortName) {
            this.shortName = shortName;
        }
    }
}
