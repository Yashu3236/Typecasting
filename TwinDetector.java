
import java.io.File;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNo;
    private int age;

    public Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getAge() {
        return age;
    }

    public boolean hasSameAge(Student other) {
        return this.age == other.getAge();
    }

    public boolean isTwin(Student other) {
        return this.rollNo == other.getRollNo()
                && hasSameAge(other);
    }
}

public class TwinDetector {
    public static void main(String[] args) throws Exception {
        Student[] students = new Student[500];
        int count = 0;

        try (Scanner sc = new Scanner(new File("students.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (count >= students.length) {
                    throw new IllegalStateException(
                            "More than 500 student records found.");
                }

                String[] parts = line.split(",");

                if (parts.length != 3) {
                    throw new IllegalArgumentException(
                            "Invalid student record: " + line);
                }

                String name = parts[0].trim();
                int rollNo = Integer.parseInt(parts[1].trim());
                int age = Integer.parseInt(parts[2].trim());

                students[count] = new Student(name, rollNo, age);
                count++;
            }
        }

        System.out.println("Loaded " + count + " students.");
        System.out.println("\n=== Twin Pairs Found ===");

        int pairs = 0;

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (students[i].isTwin(students[j])) {
                    pairs++;

                    System.out.println(
                            "Pair " + pairs + ": "
                            + students[i].getName() + ", "
                            + students[j].getName()
                            + " (Roll: " + students[i].getRollNo()
                            + ", Age: " + students[i].getAge() + ")");
                }
            }
        }

        System.out.println("\nTotal twin pairs: " + pairs);
    }
}
