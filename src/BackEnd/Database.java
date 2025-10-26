
package BackEnd;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author husse
 */
public abstract class Database {
    
    private ArrayList<Student> students;
    private String filename; 
    
     public Database(String filename) {
        this.filename = filename;
        students = new ArrayList<>();
    }

    
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
    
    
    public abstract Student createStudentFrom(String line);
    
    public boolean contains(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return true;
            }
        }
        return false;
    }
    
       public void insertStudent(Student student) {
        students.add(student);
    }

    
      public void deleteStudent(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (studentId == students.get(i).getStudentId()) {
                students.remove(i);
            }
        }
    }
    
    
    
    public void updateStudent(int studentId, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (studentId == students.get(i).getStudentId()) {
                students.remove(i);
                students.add(updatedStudent);
            }
        }
    }
    

    public ArrayList<Student> getStudentsArrayList() {
        return students;
    }
    
    
      public void saveToFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        for (Student student : students) {
            pw.println(student.lineRepresentation());
        }
        pw.close();
    }
    
}
