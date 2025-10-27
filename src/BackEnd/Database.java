
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
    
    private ArrayList<Record> records;
    private String filename; 
    
     public Database(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();
    }

    
    public void readFromFile() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        records = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Record record = createRecordFrom(line);
            records.add(record);
        }
    }
    
    
    public abstract Record createRecordFrom(String line);
    
    public boolean contains(String id) {
        for (Record record : records) {
            if (record.getSearchKey().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
       public void insertRecord(Record record) {
        records.add(record);
    }

    
      public void deleteRecord(String studentId) {
        for (int i = 0; i < records.size(); i++) {
            if (String.valueOf(studentId).equals(records.get(i).getSearchKey())) {
                records.remove(i);
            }
        }
    }
    
    
    
    public void updateRecord(String studentId, Record updatedStudent) {
        for (int i = 0; i < records.size(); i++) {
            if (String.valueOf(studentId).equals(records.get(i).getSearchKey())) {
                records.remove(i);
                records.add(updatedStudent);
            }
        }
    }
    

    public ArrayList<Record> getStudentsArrayList() {
        return records;
    }
    
    
      public void saveToFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        for (Record record : records) {
            pw.println(record.lineRepresentation());
        }
        pw.close();
    }
    
}
