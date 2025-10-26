/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author islam
 */
public class StudentDatabase implements InterfaceOfDatabase {

    private ArrayList<Student> students;
    private String filename;

    public StudentDatabase(String filename) {
        this.filename = filename;
        students = new ArrayList<>();
    }

    @Override
    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        students = new ArrayList<Student>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Student student = createStudentFrom(line);
            students.add(student);
        }
    }

    @Override
    public Student createStudentFrom(String line) {
        String[] tokens = line.split(",");
        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String gender = tokens[3];
        String department = tokens[4];
        double gpa = Double.parseDouble(tokens[5]);
        Student student = new Student(id, name, age, gender, department, gpa);
        return student;
    }

    @Override
    public boolean contains(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void insertStudent(Student student) {
        students.add(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (studentId == students.get(i).getStudentId()) {
                students.remove(i);
            }
        }
    }

    @Override
    public void updateStudent(int studentId, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (studentId == students.get(i).getStudentId()) {
                students.remove(i);
                students.add(updatedStudent);
            }
        }
    }

    @Override
    public ArrayList<Student> getStudentsArrayList() {
        return students;
    }

    @Override
    public void saveToFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        for (Student student : students) {
            pw.println(student.lineRepresentation());
        }
        pw.close();
    }
}
