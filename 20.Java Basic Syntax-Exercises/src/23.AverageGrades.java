package ObjectsAndClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AverageGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Pupil> pupils = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            ArrayList<Double> grades = Arrays.stream(input)
                    .skip(1)
                    .map(Double::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
            Pupil pupil = new Pupil(name, grades);
            pupils.add(pupil);
        }
        pupils.stream()
                .filter(student -> student.getAverage() >= 5.00)
                .sorted(Comparator.comparing(Pupil::getName)
                        .thenComparing(Pupil::getAverage, Comparator.reverseOrder()))
                .forEach(student -> {
                    System.out.printf("%s -> %.2f%n", student.getName(), student.getAverage());

                });
    }
}


class Pupil {
    private String name;
    private ArrayList<Double> grades;

    Pupil(String name, ArrayList<Double> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        double sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        return sum / grades.size();
    }

}