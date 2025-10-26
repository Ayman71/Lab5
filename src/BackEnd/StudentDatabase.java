/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;



/**
 *
 * @se7ss
 */
public class StudentDatabase extends Database {

    

    public StudentDatabase(String filename ) {
       
          super(filename);

    }

    /**
     *
     * @param line
     * @return
     */
    @Override
    public Student createRecordFrom(String line) {
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

   
    

  

  




  
}
