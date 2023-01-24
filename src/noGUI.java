import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class noGUI {

    static Scanner scanner;
    static ArrayList<Students> studentsList = new ArrayList<>();

    public static void main(String[] args) {
        StudentIO.studentReader("Students.csv");
        CoursesIO.courseReader(1,"stageONE");
        CoursesIO.courseReader(2,"stageTWO");
        CoursesIO.courseReader(3,"stageTHREE");
        CoursesIO.courseReader(4,"stageFOUR");
        naa();
    }

    public static void naa(){
        System.out.println("__________________MENU__________________");
        System.out.println("1)Add, 2)Update, 3)Search, 4)Show, 5)Delete");
        System.out.println("_____________________________________________");
        System.out.print("Enter a number: ");
        scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        switch (x) {

            case 1 -> {
                System.out.println("_____ADD_____");
                System.out.println("1)add student\n2)add courses");
                System.out.println("_____________________________________________");
                System.out.print("Enter the number: ");
                int id = scanner.nextInt();
                switch (id) {
                    case 1 -> {
                        System.out.println("_____ADD STUDENT_____");
                        System.out.print("ID: ");
                        id = scanner.nextInt();
                        System.out.print("fullName: ");
                        String fullName = scanner.next().toLowerCase();
                        System.out.print("gender: ");
                        scanner.nextLine();
                        String gender = scanner.next();
                        System.out.print("address: ");
                        String address = scanner.next();
                        System.out.print("mobile: ");
                        String mobile = scanner.next();
                        System.out.print("stage: ");
                        int stage = scanner.nextInt();
                        System.out.print("age: ");
                        int age = scanner.nextInt();
                        System.out.println("Student added!");
                        studentsList.add(new Students(id, fullName,age, gender, address, mobile, stage));
                        try {
                            StudentIO.studentWriter("Students.csv", studentsList);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    case 2 -> {
                        System.out.println("_____ADD COURSES_____");
                        System.out.println("""
                                Add courses for stage:
                                1)stageONE, 2)stageTWO
                                3)stageTHREE, 4)stageFOUR""");
                        System.out.println("_____________________________________________");
                        System.out.print("Enter the number: ");
                        int idd = scanner.nextInt();
                        String course1;
                        String course2;
                        String course3;
                        switch (idd) {
                            case 1 -> {
                                System.out.println("_____STAGE 1_____");
                                System.out.print("add course 1:");
                                course1 = scanner.next();
                                System.out.print("add course 2:");
                                course2 = scanner.next();
                                System.out.print("add course 3:");
                                course3 = scanner.next();
                                Courses.addStage(1, course1, course2, course3);
                                System.out.println("Courses added!");
                                try {
                                    CoursesIO.courseWriter(1,"stageONE");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                            case 2 -> {
                                System.out.println("_____STAGE 2_____");
                                System.out.print("add course 1:");
                                course1 = scanner.next();
                                System.out.print("add course 2:");
                                course2 = scanner.next();
                                System.out.print("add course 3:");
                                course3 = scanner.next();
                                Courses.addStage(2, course1, course2, course3);
                                System.out.println("Courses added!");
                                try {
                                    CoursesIO.courseWriter(2,"stageTWO");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case 3 -> {
                                System.out.println("_____STAGE 3_____");
                                System.out.print("add course 1:");
                                course1 = scanner.next();
                                System.out.print("add course 2:");
                                course2 = scanner.next();
                                System.out.print("add course 3:");
                                course3 = scanner.next();
                                Courses.addStage(3, course1, course2, course3);
                                System.out.println("Courses added!");
                                try {
                                    CoursesIO.courseWriter(3,"stageTHREE");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case 4 -> {
                                System.out.println("_____STAGE 4_____");
                                System.out.print("add course 1:");
                                course1 = scanner.next();
                                System.out.print("add course 2:");
                                course2 = scanner.next();
                                System.out.print("add course 3:");
                                course3 = scanner.next();
                                Courses.addStage(4, course1, course2, course3);
                                System.out.println("Courses added!");
                                try {
                                    CoursesIO.courseWriter(4,"stageFOUR");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            default -> System.out.println("Wrong number!");
                        }
                        naa();
                    }
                    default -> System.out.println("Wrong number!");
                }

                naa();

            }

            case 2 -> {
                int idd;
                System.out.println("_____UPDATE_____");
                System.out.println("1)Update student, 2)Update courses");
                System.out.println("_____________________________________________");
                System.out.print("Enter the number: ");
                idd = scanner.nextInt();
                switch (idd) {
                    case 1 -> {
                        System.out.println("_____UPDATE STUDENT_____");
                        System.out.print("Enter student ID to update: ");
                        idd = scanner.nextInt();
                        for (Students value : studentsList)
                            if (value.getID() == idd) {

                                System.out.println("""
                                        1)update fullName, 2)update gender
                                        3)update age, 4)update address
                                        5)update stage, 6)update mobile
                                        7)update all""");
                                System.out.println("_____________________________________________");
                                System.out.print("Enter the number: ");
                                idd = scanner.nextInt();
                                switch (idd) {
                                    case 1 -> {
                                        System.out.print("Enter new fullName: ");
                                        value.setFullName(scanner.next());

                                    }
                                    case 2 -> {
                                        System.out.print("Enter new gender: ");
                                        value.setGender(scanner.next());

                                    }
                                    case 3 -> {
                                        System.out.print("Enter new age: ");
                                        value.setAge(scanner.nextInt());

                                    }
                                    case 4 -> {
                                        System.out.print("Enter new address: ");
                                        value.setAddress(scanner.next());

                                    }
                                    case 5 -> {
                                        System.out.print("Enter new stage: ");
                                        value.setStage(scanner.nextInt());

                                    }
                                    case 6 -> {
                                        System.out.print("Enter new mobile: ");
                                        value.setMobile(scanner.next());

                                    }
                                    case 7 -> {
                                        System.out.print("Enter new fullName: ");
                                        value.setFullName(scanner.next());
                                        scanner.nextLine();
                                        System.out.print("Enter new gender: ");
                                        value.setGender(scanner.next());
                                        System.out.print("Enter new age: ");
                                        value.setAge(scanner.nextInt());
                                        System.out.print("Enter new address: ");
                                        value.setAddress(scanner.next());
                                        System.out.print("Enter new stage: ");
                                        value.setStage(scanner.nextInt());
                                        System.out.print("Enter new mobile: ");
                                        value.setMobile(scanner.next());
                                    }
                                    default -> System.out.println("Wrong input!");
                                }
                                try {
                                    StudentIO.studentWriter("Students.csv", studentsList);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                naa();
                            }
                        System.out.println("Invalid ID.");
                        naa();
                    }
                    case 2 -> {
                        System.out.println("_____UPDATE COURSES_____");
                        System.out.println("""
                                Update courses for stage:
                                1)stage one, 2)stage two
                                3)stage three, 4)stage four""");
                        System.out.println("_____________________________________________");
                        System.out.print("Enter the number: ");
                        idd = scanner.nextInt();
                        String course1;
                        String course2;
                        String course3;
                        switch (idd) {
                            case 1 -> {
                                System.out.println("_____STAGE 1_____");
                                System.out.println("""
                                        Enter course number to update:
                                        1)first course, 2)second course,\s
                                        3)third course, 4)update all""");
                                System.out.println("_____________________________________________");
                                System.out.print("Enter the number: ");
                                idd = scanner.nextInt();
                                switch (idd) {
                                    case 1 -> {
                                        System.out.print("update course 1:");
                                        course1 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(1, 0, course1);
                                    }
                                    case 2 -> {
                                        System.out.print("update course 2:");
                                        course1 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(1, 1, course1);
                                    }
                                    case 3 -> {
                                        System.out.print("update course 3:");
                                        course1 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(1, 2, course1);
                                    }
                                    case 4 -> {
                                        System.out.print("update course 1:");
                                        course1 = scanner.next();
                                        System.out.print("update course 2:");
                                        course2 = scanner.next();
                                        System.out.print("update course 3:");
                                        course3 = scanner.next();
                                        System.out.println("Courses updated!");
                                        Courses.updateStage(1, course1, course2, course3);
                                    }
                                    default -> System.out.println("Wrong number!");
                                }
                                try {
                                    CoursesIO.courseWriter(1,"stageONE");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case 2 -> {
                                System.out.println("_____STAGE 2_____");
                                System.out.println("""
                                        Enter course number to update:
                                        1)first course, 2)second course,\s
                                        3)third course, 4)update all""");
                                System.out.println("_____________________________________________");
                                System.out.print("Enter the number: ");
                                idd = scanner.nextInt();
                                switch (idd) {
                                    case 1 -> {
                                        System.out.print("update course 1:");
                                        course1 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(2, 0, course1);
                                    }
                                    case 2 -> {
                                        System.out.print("update course 2:");
                                        course2 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(2, 1, course2);
                                    }
                                    case 3 -> {
                                        System.out.print("update course 3:");
                                        course3 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(2, 2, course3);
                                    }
                                    case 4 -> {
                                        System.out.print("update course 1:");
                                        course1 = scanner.next();
                                        System.out.print("update course 2:");
                                        course2 = scanner.next();
                                        System.out.print("update course 3:");
                                        course3 = scanner.next();
                                        System.out.println("Courses updated!");
                                        Courses.updateStage(2, course1, course2, course3);
                                    }
                                    default -> System.out.println("Wrong number!");
                                }
                                try {
                                    CoursesIO.courseWriter(2,"stageTWO");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case 3 -> {
                                System.out.println("_____STAGE 3_____");
                                System.out.println("""
                                        Enter course number to update:
                                        1)first course, 2)second course,\s
                                        3)third course, 4)update all""");
                                System.out.println("_____________________________________________");
                                System.out.print("Enter the number: ");
                                idd = scanner.nextInt();
                                switch (idd) {
                                    case 1 -> {
                                        System.out.print("update course 1:");
                                        course1 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(3, 0, course1);
                                    }
                                    case 2 -> {
                                        System.out.print("update course 2:");
                                        course2 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(3, 1, course2);
                                    }
                                    case 3 -> {
                                        System.out.print("update course 3:");
                                        course3 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(3, 2, course3);
                                    }
                                    case 4 -> {
                                        System.out.print("update course 1:");
                                        course1 = scanner.next();
                                        System.out.print("update course 2:");
                                        course2 = scanner.next();
                                        System.out.print("update course 3:");
                                        course3 = scanner.next();
                                        System.out.println("Courses updated!");
                                        Courses.updateStage(3, course1, course2, course3);
                                    }
                                    default -> System.out.println("Wrong number!");
                                }
                                try {
                                    CoursesIO.courseWriter(3,"stageTHREE");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case 4 -> {
                                System.out.println("_____STAGE 4_____");
                                System.out.println("""
                                        Enter course number to update:
                                        1)first course, 2)second course,\s
                                        3)third course, 4)update all""");
                                System.out.println("_____________________________________________");
                                System.out.print("Enter the number: ");
                                idd = scanner.nextInt();
                                switch (idd) {
                                    case 1 -> {
                                        System.out.print("update course 1:");
                                        course1 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(4, 0, course1);
                                    }
                                    case 2 -> {
                                        System.out.print("update course 2:");
                                        course2 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(4, 1, course2);
                                    }
                                    case 3 -> {
                                        System.out.print("update course 3:");
                                        course3 = scanner.next();
                                        System.out.println("Course updated!");
                                        Courses.updateSingleStage(4, 2, course3);
                                    }
                                    case 4 -> {
                                        System.out.print("update course 1:");
                                        course1 = scanner.next();
                                        System.out.print("update course 2:");
                                        course2 = scanner.next();
                                        System.out.print("update course 3:");
                                        course3 = scanner.next();
                                        System.out.println("Courses updated!");
                                        Courses.updateStage(4, course1, course2, course3);
                                    }
                                    default -> System.out.println("Wrong number!");
                                }
                                try {
                                    CoursesIO.courseWriter(4,"stageFOUR");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            default -> System.out.println("Wrong number!");
                        }

                        naa();
                    }
                }

            }
            case 3 -> {
                String idd;
                System.out.println("_____SEARCH_____");
                System.out.println("1)Search by full name\n2)Search by Mobile Number");
                System.out.println("_____________________________________________");
                System.out.print("Enter the number: ");
                idd = scanner.next();
                switch (idd) {
                    case "1" -> {
                        System.out.println("_____________________________________________");
                        System.out.print("Enter full name: ");
                        idd = scanner.next().toLowerCase();
                        for (Students value : studentsList)
                            if (value.getFullName().equals(idd)) {
                                System.out.println(value);
                            }
                    }
                    case "2" -> {
                        System.out.println("_____________________________________________");
                        System.out.print("Enter mobile number: ");
                        idd = scanner.next();
                        for (Students value : studentsList)
                            if (value.getMobile().equals(idd)) {
                                System.out.println(value);
                            }
                    }
                    default -> System.out.println("Wrong number!");
                }
                naa();
            }
            case 4 -> {
                System.out.println("_____SHOW_____");
                System.out.println("1)show students\n2)show courses");
                System.out.println("_____________________________________________");
                System.out.print("Enter the number: ");
                int id = scanner.nextInt();
                switch (id) {
                    case 1 -> {
                        System.out.println("_____SHOW STUDENTS_____");
                        System.out.println("_____________________________________________");
                        System.out.println("1)stageONE, 2)stageTWO\n3)stageTHREE, 4)stage " +
                                "four, 5)Show all students");
                        System.out.println("_____________________________________________");
                        System.out.print("Enter the number: ");
                        id = scanner.nextInt();
                        if (id == 1 || id == 2 || id == 3 || id == 4) {
                            for (Students value : studentsList)
                                if (value.getStage() == id) {
                                    System.out.println(value);
                                }
                        } else if (id == 5) {
                            for (Students value : studentsList)
                                System.out.println(value);
                        } else {
                            System.out.println("Wrong number!");
                        }
                    }
                    case 2 -> {
                        System.out.println("_____SHOW COURSES_____");
                        System.out.println("""
                                Show courses for stage:
                                1)stage one, 2)stage two
                                3)stage three, 4)stage four
                                5)all courses""");
                        System.out.println("_____________________________________________");
                        System.out.print("Enter the number: ");
                        int idd = scanner.nextInt();
                        switch (idd) {
                            case 1 -> {
                                System.out.println("_____STAGE 1_____");
                                System.out.println(Courses.stage1List);

                            }
                            case 2 -> {
                                System.out.println("_____STAGE 2_____");
                                System.out.println(Courses.stage2List);
                            }
                            case 3 -> {
                                System.out.println("_____STAGE 3_____");
                                System.out.println(Courses.stage3List);
                            }
                            case 4 -> {
                                System.out.println("_____STAGE 4_____");
                                System.out.println(Courses.stage4List);
                            }
                            case 5 -> {
                                System.out.println("_____STAGE 1_____");
                                System.out.println(Courses.stage1List);
                                System.out.println("_____STAGE 2_____");
                                System.out.println(Courses.stage2List);
                                System.out.println("_____STAGE 3_____");
                                System.out.println(Courses.stage3List);
                                System.out.println("_____STAGE 4_____");
                                System.out.println(Courses.stage4List);
                            }
                            default -> System.out.println("Wrong number!");
                        }
                        naa();
                    }
                    default -> System.out.println("Wrong number!");
                }

                naa();

            }
            case 5 -> {
                System.out.println("_____DELETE_____");
                int idd;
                System.out.print("Enter student ID to delete: ");
                idd = scanner.nextInt();
                for (Students value : studentsList) {
                    if (value.getID() == idd) {
                        studentsList.remove(value);
                        System.out.println("Student deleted!");
                        try {
                            StudentIO.studentWriter("Students.csv", studentsList);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        naa();
                    }
                }
                System.out.println("Invalid ID.");
                naa();
            }
            default -> {
                System.out.println("Wrong number!");
                naa();
            }


        }

    }
}
