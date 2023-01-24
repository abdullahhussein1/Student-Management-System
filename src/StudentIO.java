import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class StudentIO {
    private static final String COMMA = ",";
    private static final String NEW_LINE ="\n";
    private static final String studentHeader = "ID,Full Name,Age,Gender,Address,Mobile,Stage";

    private static final int ID_IDX = 0;
    private static final int FULLNAME_IDX = 1;
    private static final int AGE_IDX = 2;
    private static final int GENDER_IDX = 3;
    private static final int ADDRESS_IDX = 4;
    private static final int MOBILE_IDX = 5;
    private static final int STAGE_IDX = 6;



    public static void studentWriter(String fileName,ArrayList<Students> students) throws IOException {
    FileWriter writer = null;

        try{
            writer = new FileWriter(fileName);
            writer.append(studentHeader);
            writer.append(NEW_LINE);

            for(Students value : students){
                writer.append(String.valueOf(value.getID()));
                writer.append(COMMA);
                writer.append(value.getFullName());
                writer.append(COMMA);
                writer.append(String.valueOf(value.getAge()));
                writer.append(COMMA);
                writer.append(value.getGender());
                writer.append(COMMA);
                writer.append(value.getAddress());
                writer.append(COMMA);
                writer.append(value.getMobile());
                writer.append(COMMA);
                writer.append(String.valueOf(value.getStage()));
                writer.append(NEW_LINE);
            }


        }catch (IOException e){
            e.printStackTrace();
        }finally {
            assert writer != null;
            writer.flush();
            writer.close();
        }
    }

    public static void studentReader(String fileName) {

        BufferedReader fileReader = null;

        try {


            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();

            String line = null;

            while ((line = fileReader.readLine()) != null) {

                String[] cell = line.split(COMMA);
                if (cell.length > 0) {

                    Students stu = new Students(Integer.parseInt(cell[ID_IDX]),
                            cell[FULLNAME_IDX], Integer.parseInt(cell[AGE_IDX]),
                            cell[GENDER_IDX],cell[ADDRESS_IDX],cell[MOBILE_IDX],
                            Integer.parseInt(cell[STAGE_IDX]));

                    StudentsGUI.model.addRow(new Object[]{
                            cell[ID_IDX],cell[FULLNAME_IDX],
                            cell[GENDER_IDX],cell[AGE_IDX],
                            cell[MOBILE_IDX],cell[STAGE_IDX]
                            ,cell[ADDRESS_IDX]
                    });

                    StudentsGUI.studentsList.add(stu);
                }
            }

        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

    }


}


