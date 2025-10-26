/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;



public class Student extends Record {

    private int studentId;
    private String fullName;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    public Student(int studentId, String fullName, int age, String gender, String department, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.gpa = gpa;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", fullName=" + fullName + ", age=" + age + ", gender=" + gender + ", department=" + department + ", gpa=" + gpa + '}';
    }
    
 @Override
    public String lineRepresentation() {
        return studentId + "," + fullName + "," + age + "," + gender + "," + department + "," + gpa;
    }

    @Override
    public String getSearchKey() {
        return String.valueOf(getStudentId()); 
    }
    
    
    
    
    
}
