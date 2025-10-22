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
public interface StudentDatabase {
    void addStudent(Student student) throws IOException;
    boolean deleteStudent(int studentId);
    boolean updateStudent(int studentId, Student updatedStudent) throws IOException;
    Student searchStudentById(int studentId);
    ArrayList<Student> searchStudentByName(String name);
    ArrayList<Student> getAllStudents();
    void savetData(String filename) throws IOException;
    void loadData(String filename) throws IOException, ClassNotFoundException;
}
