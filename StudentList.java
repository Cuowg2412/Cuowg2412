package phan3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentList {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Cảm", 20, 3.5));
        students.add(new Student("An", 21, 3.7));
        students.add(new Student("Toàn", 19, 3.2));

        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<STUDENTS>").append("\n");
        for (Student student : students) {
            xmlBuilder.append("<STUDENT>").append("\n");
            xmlBuilder.append("<Name>").append(student.getName()).append("</Name>").append("\n");
            xmlBuilder.append("<Age>").append(student.getAge()).append("</Age>").append("\n");
            xmlBuilder.append("<GPA>").append(student.getGpa()).append("</GPA>").append("\n");
            xmlBuilder.append("</STUDENT>").append("\n");
        }
        xmlBuilder.append("</STUDENTS>");

        // Ghi dữ liệu vào file XML
        String xmlFilePath = "student_list.xml";
        try {
            FileWriter fileWriter = new FileWriter(xmlFilePath);
            fileWriter.write(xmlBuilder.toString());
            fileWriter.close();
            System.out.println("Danh sách sinh viên đã được lưu vào file XML.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Student {
        private String name;
        private int age;
        private double gpa;

        public Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getGpa() {
            return gpa;
        }
    }
}

