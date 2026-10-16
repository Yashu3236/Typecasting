import java.io.File;
import java.util.Scanner;
class Student{
    private String name;
    private int rollNum;
    private int age;
    public Student(String name, int rollNum, int age){
        this.name = name;
        this.rollNum = rollNum;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getRollNum() {
        return rollNum;
    }
    public int getAge() {
        return age;
    }
    public boolean hasSameAge(Student other){
        return this.age==other.getAge();
    }
    public boolean isTwin(Student other){
        boolean sameage = this.hasSameAge(other);
        boolean sameroll = (this.rollNum == other.getRollNum());
        return sameage && sameroll;
    }
}







public class TwinDetector{
    public static void main(String[] args) throws Exception {
        Student[] students = new Student[500];
        int count = 0;
        Scanner sc = new Scanner(new File("sudents.txt"));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.isBlank()) continue;
            String[] parts = line.split(",");
            String name = parts[0];
            int rollNum = Integer.parseInt(parts[1]);
            int age = Integer.parseInt(parts[2]);
            students[count] = new Student(name, rollNum, age);
            count++;

        }
        sc.close();

        System.out.println("Total entries = "+count);
        System.out.println(("\n==============Pairs Detected===================="));
        int pairs=0;
        for(int i=0; i<count; i++){
            for(int j = i+1; j<count; j++){
                if(students[i].isTwin(students[j])){
                    pairs++;
                    System.out.println("Pair:" +pairs+" Name: "+students[i].getName()+","+students[j].getName());

                }
            }
        }
        System.out.println("Total number of twins = "+pairs);

    }

}