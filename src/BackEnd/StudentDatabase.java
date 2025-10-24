/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author islam
 */
public interface StudentDatabase {
    boolean addStudent(Student student) throws IOException, ClassNotFoundException;
    boolean deleteStudent(int studentId) throws IOException;
    boolean updateStudent(int studentId, Student updatedStudent) throws IOException;
    Student searchStudentById(int studentId);
    ArrayList<Student> searchStudentByName(String name);
    ArrayList<Student> getAllStudents();
    void saveStudentData() throws IOException;
    void loadStudentData() throws IOException, ClassNotFoundException;
}