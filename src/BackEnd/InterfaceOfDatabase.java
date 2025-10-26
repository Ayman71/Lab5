package BackEnd;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author husse
 */
public interface InterfaceOfDatabase {

    public void readFromFile() throws FileNotFoundException;

    public Student createStudentFrom(String line);

    public boolean contains(int id);

    void insertStudent(Student student);

    void updateStudent(int studentId, Student updatedStudent);

    public ArrayList<Student> getStudentsArrayList();  

    void saveToFile() throws FileNotFoundException;

    void deleteStudent(int studentId);

}
