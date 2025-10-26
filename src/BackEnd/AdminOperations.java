
package BackEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author islam && se7ssss
 */
public class AdminOperations {

    private Database studentDatabase;

    // Constructor to set the filename
    public AdminOperations() throws IOException, ClassNotFoundException {
        studentDatabase = new StudentDatabase("Students.txt");
        studentDatabase.readFromFile();

    }

    public boolean addStudent(Student student) throws IOException, ClassNotFoundException {
        if (studentDatabase.contains(student.getSearchKey())) {
            return false;
        } else {
            studentDatabase.insertRecord(student);
            return true;
        }
    }

    public ArrayList<Record> getStudents() {
        return studentDatabase.getStudentsArrayList();
    }

    public void deleteStudent(int studentId) throws IOException {
        studentDatabase.deleteRecord(String.valueOf(studentId));
    }

    public void updateStudent(int studentId, Student updatedStudent) throws IOException {
        studentDatabase.updateRecord(String.valueOf(studentId), updatedStudent);
    }

    public void logout() throws FileNotFoundException {
        studentDatabase.saveToFile();
    }
}
