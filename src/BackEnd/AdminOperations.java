/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author islam
 */
public class AdminOperations {

    private StudentDatabase studentDatabase;

    // Constructor to set the filename
    public AdminOperations() throws IOException, ClassNotFoundException {
        studentDatabase = new StudentDatabase("Students.txt");
        studentDatabase.readFromFile();

    }

    public boolean addStudent(Student student) throws IOException, ClassNotFoundException {
        if (studentDatabase.contains(student.getStudentId())) {
            return false;
        } else {
            studentDatabase.insertStudent(student);
            return true;
        }
    }
    
    public ArrayList<Student> getStudents() {
        return studentDatabase.getStudentsArrayList();
    }

    public void deleteStudent(int studentId) throws IOException {
        studentDatabase.deleteStudent(studentId);
    }

    public void updateStudent(int studentId, Student updatedStudent) throws IOException {
        studentDatabase.updateStudent(studentId, updatedStudent);
    }

    public void logout() throws FileNotFoundException {
        studentDatabase.saveToFile();
    }
}
