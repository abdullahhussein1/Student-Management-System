import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CoursesIO {

    private static final String COMMA = ",";
    private static final String NEW_LINE ="\n";
    private static final int FULLNAME_IDX = 1;
    private static final int STAGE_IDX = 6;


    public static void courseWriter(int stage, String fileName) throws IOException {
        FileWriter writer = null;

        try{
            switch (stage){
                case 1->{
                    writer = new FileWriter(fileName+".csv");
                    writer.append("(stage one)");
                    writer.append(NEW_LINE);
                    
                    writer.append(Courses.stage1List.get(0));
                    writer.append(NEW_LINE);
                    writer.append(Courses.stage1List.get(1));
                    writer.append(NEW_LINE);
                    writer.append(Courses.stage1List.get(2));

                    
                }
                case 2->{
                    writer = new FileWriter(fileName);
                    writer.append("(stage two)");
                    writer.append(NEW_LINE);

                    writer.append(Courses.stage2List.get(0));
                    writer.append(NEW_LINE);
                    writer.append(Courses.stage2List.get(1));
                    writer.append(NEW_LINE);
                    writer.append(Courses.stage2List.get(2));

                }
                case 3->{
                    writer = new FileWriter(fileName);
                    writer.append("(stage three)");
                    writer.append(NEW_LINE);

                    writer.append(Courses.stage3List.get(0));
                    writer.append(NEW_LINE);
                    writer.append(Courses.stage3List.get(1));
                    writer.append(NEW_LINE);
                    writer.append(Courses.stage3List.get(2));
                }
                case 4->{
                    writer = new FileWriter(fileName);
                    writer.append("(stage four)");
                    writer.append(NEW_LINE);

                    writer.append(Courses.stage4List.get(0));
                    writer.append(COMMA);
                    writer.append(Courses.stage4List.get(1));
                    writer.append(COMMA);
                    writer.append(Courses.stage4List.get(2));
                    writer.append(NEW_LINE);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            assert writer != null;
            writer.flush();
            writer.close();
        }
    }
    public static void courseReader(int stage,String fileName) {

        BufferedReader fileReader = null;

        try {

            switch (stage){
                case 1 ->{
                    fileReader = new BufferedReader(new FileReader(fileName+".csv"));
                    fileReader.readLine();
                    String line = null;
                    while ((line = fileReader.readLine()) != null) {
                        String[] cell = line.split(COMMA);
                        Courses.stage1List.add(line);
                        StagesGUI.model1.addRow(new Object[]{
                                cell[0],cell[1],cell[2]
                        });
                    }
                }
                case 2 ->{
                    fileReader = new BufferedReader(new FileReader(fileName+".csv"));
                    fileReader.readLine();
                    String line = null;
                    while ((line = fileReader.readLine()) != null) {
                        String[] cell = line.split(COMMA);
                        Courses.stage2List.add(line);
                        StagesGUI.model1.addRow(new Object[]{
                                cell[0],cell[1],cell[2]
                        });
                    }
                }
                case 3 ->{
                    fileReader = new BufferedReader(new FileReader(fileName+".csv"));
                    fileReader.readLine();
                    String line = null;
                    while ((line = fileReader.readLine()) != null) {
                        String[] cell = line.split(COMMA);
                        Courses.stage3List.add(line);
                        StagesGUI.model1.addRow(new Object[]{
                                cell[0],cell[1],cell[2]
                        });
                    }

                }
                case 4 ->{
                    fileReader = new BufferedReader(new FileReader(fileName+".csv"));
                    fileReader.readLine();
                    String line = null;
                    while ((line = fileReader.readLine()) != null) {
                        String[] cell = line.split(COMMA);
                        Courses.stage4List.add(line);
                        StagesGUI.model1.addRow(new Object[]{
                                cell[0],cell[1],cell[2]
                        });
                    }

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
