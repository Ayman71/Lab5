/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author islam
 */
public abstract class AdminOperations implements StudentDatabase {

    private ArrayList<Student> students = new ArrayList<>();
    private String filename;

    // Constructor to set the filename
    public AdminOperations(String filename) throws IOException, ClassNotFoundException {
        this.filename = filename;
        loadStudentDataIfExists();
    }
    @Override
    public boolean addStudent(Student student) throws IOException, ClassNotFoundException {
        loadStudentDataIfExists();
        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                System.out.println("Error: Student with ID " + student.getStudentId() + " already exists.");
                return false; } }
        students.add(student);
        saveStudentData();
        return true; }
    @Override
    public boolean deleteStudent(int studentId) throws IOException {
        boolean removed = students.removeIf(s -> s.getStudentId() == studentId);
        if (removed) {
            saveStudentData(); }
        return removed; }
    @Override
    public boolean updateStudent(int studentId, Student updatedStudent) throws IOException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == studentId) {
                students.set(i, updatedStudent);
                saveStudentData();
                return true; } }
        return false; }
    @Override
    public Student searchStudentById(int studentId) {
        for (Student s : students) {
            if (s.getStudentId() == studentId) {
                return s; } }
        return null; }
    @Override
    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> results = new ArrayList<>();
        for (Student s : students) {
            if (s.getFullName().equalsIgnoreCase(name)) {
                results.add(s); } }
        return results; }
    @Override
    public ArrayList<Student> getAllStudents() {
        return students; }
    public void saveStudentData() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
        os.writeObject(students);
        os.close(); }
    public void loadStudentData() throws IOException, ClassNotFoundException {
        File file = new File(filename);
        if (!file.exists()) return;
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
        Object data = is.readObject();
        is.close();
        if (data instanceof ArrayList) {
            students = (ArrayList<Student>) data; } }
    private void loadStudentDataIfExists() throws IOException, ClassNotFoundException {
        loadStudentData(); }
}