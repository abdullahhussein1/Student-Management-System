import java.util.ArrayList;

public class Courses {

    static ArrayList<String> stage1List = new ArrayList<>();
    static ArrayList<String> stage2List = new ArrayList<>();
    static ArrayList<String> stage3List = new ArrayList<>();
    static ArrayList<String> stage4List = new ArrayList<>();


    public static void addStage(int stage, String course1, String course2, String course3){
        switch (stage){
            case 1->{
                stage1List.add(course1);
                stage1List.add(course2);
                stage1List.add(course3);
            }
            case 2->{
                stage2List.add(course1);
                stage2List.add(course2);
                stage2List.add(course3);
            }
            case 3->{
                stage3List.add(course1);
                stage3List.add(course2);
                stage3List.add(course3);
            }
            case 4->{
                stage4List.add(course1);
                stage4List.add(course2);
                stage4List.add(course3);
            }
        }

    }
    public static void updateStage(int stage, String course1, String course2, String course3){
        switch (stage){
            case 1->{
                stage1List.set(0,course1);
                stage1List.set(1,course2);
                stage1List.set(2,course3);
            }
            case 2->{
                stage2List.set(0,course1);
                stage2List.set(1,course2);
                stage2List.set(2,course3);
            }
            case 3->{
                stage3List.set(0,course1);
                stage3List.set(1,course2);
                stage3List.set(2,course3);
            }
            case 4->{
                stage4List.set(0,course1);
                stage4List.set(1,course2);
                stage4List.set(2,course3);
            }
        }

    }

    public static void updateSingleStage(int stage, int index, String course){
        switch (stage){
            case 1-> stage1List.set(index,course);
            case 2-> stage2List.set(index,course);
            case 3-> stage3List.set(index,course);
            case 4-> stage4List.set(index,course);
        }
    }


}
