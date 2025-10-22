/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/**
 *
 * @author islam
 */
 public class AdminOperations implements StudentDatabase {

    private ArrayList<Student> students = new ArrayList<>();
    
    @Override
    public void addStudent(Student student) throws IOException {
        students.add(student);}
        
    @Override
    public boolean deleteStudent(int studentId) {
        return students.removeIf(s -> s.getStudentId() == studentId);}
    
    @Override
    public boolean updateStudent(int studentId, Student updatedStudent) throws IOException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == studentId) {
                students.set(i, updatedStudent);
                return true;}}
        return false;}
    
    @Override
    public Student searchStudentById(int studentId) {
        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                return s;}}
        return null;
    }
 }