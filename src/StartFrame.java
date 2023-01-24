import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class StartFrame {

    static ImageIcon logo = new ImageIcon("report.png");
    static ImageIcon student = new ImageIcon("student4.png");
    static ImageIcon student1 = new ImageIcon("student44.png");
    static ImageIcon studentLight = new ImageIcon("student09.png");
    static ImageIcon studentLight1 = new ImageIcon("student9.png");
    static ImageIcon stages = new ImageIcon("scientific.png");
    static ImageIcon stages1 = new ImageIcon("scientific2.png");
    static ImageIcon stagesLight = new ImageIcon("stagesLight3.png");
    static ImageIcon stagesLight1 = new ImageIcon("stagesLight4.png");
    static ImageIcon lightMode0 = new ImageIcon("lightMode0.png");
    static ImageIcon lightMode1 = new ImageIcon("lightMode1.png");
    static ImageIcon darkMode1 = new ImageIcon("darkMode2.png");
    static ImageIcon darkMode2 = new ImageIcon("darkMode1.png");
    static ImageIcon homeButton = new ImageIcon("home.png");
    static ImageIcon homeLight = new ImageIcon("home1.png");

    static JButton studentBtn, stagesBtn, modeBtn;
    static JPanel panel, studentBtnPanel, stagesBtnPanel, panel5;
    static JButton homeBtn = new JButton(homeButton);
    static JLabel title = new JLabel("ISE Student Management");
    static StagesGUI stagesGUI = new StagesGUI();
    static StudentsGUI studentsGUI = new StudentsGUI();

    static JFrame frame = new JFrame();


    public static void main(String[] args) {
          StudentIO.studentReader("Students.csv");
//        CoursesIO.courseReader(1,"stageONE");
//        CoursesIO.courseReader(2,"stageTWO");
//        CoursesIO.courseReader(3,"stageTHREE");
//        CoursesIO.courseReader(4,"stageFOUR");

        start();

    }

    public static void start() {

        modeBtn = new JButton(darkMode2);
        modeBtn.setBounds(1095,20,30,30);
        modeBtn.setBackground(null);
        modeBtn.setRolloverIcon(darkMode1);
        modeBtn.setContentAreaFilled(false);
        modeBtn.setBorder(null);
        modeBtn.addActionListener(e-> {

            if (modeBtn.getIcon()== darkMode2) {

                modeBtn.setIcon(lightMode0);
                modeBtn.setRolloverIcon(lightMode1);
                panel.setBackground(new Color(0xEEEEEE));
                studentBtnPanel.setBackground(new Color(0x232931));
                stagesBtnPanel.setBackground(new Color(0x232931));
                studentBtn.setIcon(studentLight);
                studentBtn.setRolloverIcon(studentLight1);
                stagesBtn.setIcon(stagesLight);
                stagesBtn.setRolloverIcon(stagesLight1);
                studentBtn.setForeground(Color.white);
                stagesBtn.setForeground(Color.white);

                studentsGUI.searchField.setBackground(new Color(0xE7E7E7));
                studentsGUI.searchField.setForeground(new Color(0x232931));
                studentsGUI.searchIcon.setIcon(studentsGUI.search);

                studentsGUI.idLabel.setForeground(new Color(0x232931));
                studentsGUI.nameLabel.setForeground(new Color(0x232931));
                studentsGUI.addressLabel.setForeground(new Color(0x232931));
                studentsGUI.ageLabel.setForeground(new Color(0x232931));
                studentsGUI.stageLabel.setForeground(new Color(0x232931));
                studentsGUI.mobileLabel.setForeground(new Color(0x232931));
                studentsGUI.genderLabel.setForeground(new Color(0x232931));

                studentsGUI.maleRadio.setIcon(studentsGUI.disableBlack);
                studentsGUI.maleRadio.setSelectedIcon(studentsGUI.enableBlack);
                studentsGUI.maleRadio.setBackground(new Color(0xEEEEEE));
                studentsGUI.maleRadio.setForeground(new Color(0x232931));

                studentsGUI.femaleRadio.setIcon(studentsGUI.disableBlack);
                studentsGUI.femaleRadio.setSelectedIcon(studentsGUI.enableBlack);
                studentsGUI.femaleRadio.setBackground(new Color(0xEEEEEE));
                studentsGUI.femaleRadio.setForeground(new Color(0x232931));

                studentsGUI.idField.setBackground(new Color(0xE7E7E7));
                studentsGUI.idField.setForeground(new Color(0x393E46));
                studentsGUI.idField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                studentsGUI.idField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.idField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                    }
                });

                studentsGUI.nameField.setBackground(new Color(0xE7E7E7));
                studentsGUI.nameField.setForeground(new Color(0x393E46));
                studentsGUI.nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                studentsGUI.nameField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                    }
                });

                studentsGUI.addressField.setBackground(new Color(0xDEDEDE));
                studentsGUI.addressField.setForeground(new Color(0x393E46));
                studentsGUI.addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                studentsGUI.addressField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                    }
                });

                studentsGUI.ageField.setBackground(new Color(0xDEDEDE));
                studentsGUI.ageField.setForeground(new Color(0x393E46));
                studentsGUI.ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                studentsGUI.ageField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                    }
                });


                studentsGUI.stageCombo.setBackground(new Color(0xDEDEDE));
                studentsGUI.stageCombo.setForeground(new Color(0x393E46));

                studentsGUI.mobileField.setBackground(new Color(0xDEDEDE));
                studentsGUI.mobileField.setForeground(new Color(0x393E46));
                studentsGUI.mobileField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                studentsGUI.mobileField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.mobileField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0xBEBEBE)));
                    }
                });

                studentsGUI.studentTable.setBackground(new Color(0xeeeeee));
                studentsGUI.studentTable.setForeground(new Color(0x232931));
                studentsGUI.studentTable.getTableHeader().setBackground(new Color(0xDEDEDE));
                studentsGUI.studentTable.getTableHeader().setForeground(new Color(0x393E46));
                studentsGUI.studentTable.setGridColor(new Color(0x393E46));

                stagesGUI.studentTable.setBackground(new Color(0xeeeeee));
                stagesGUI.studentTable.setForeground(new Color(0x232931));
                stagesGUI.studentTable.getTableHeader().setBackground(new Color(0xDEDEDE));
                stagesGUI.studentTable.getTableHeader().setForeground(new Color(0x393E46));
                stagesGUI.studentTable.setGridColor(new Color(0x393E46));

                studentsGUI.addBtn.setForeground(new Color(0x393E46));
                studentsGUI.updateBtn.setForeground(new Color(0x393E46));
                studentsGUI.deleteBtn.setForeground(new Color(0x393E46));




                frame.repaint();

            }
            else{

                modeBtn.setIcon(darkMode2);
                modeBtn.setRolloverIcon(darkMode1);
                panel.setBackground(new Color(0x232931));
                studentBtnPanel.setBackground(new Color(0xEEEEEE));
                stagesBtnPanel.setBackground(new Color(0xEEEEEE));
                studentBtn.setIcon(student);
                studentBtn.setRolloverIcon(student1);
                stagesBtn.setIcon(stages);
                stagesBtn.setRolloverIcon(stages1);
                studentBtn.setForeground(new Color(0x232931));
                stagesBtn.setForeground(new Color(0x232931));

                studentsGUI.searchField.setBackground(new Color(0x464C56));
                studentsGUI.searchField.setForeground(new Color(0xeeeeee));
                studentsGUI.searchIcon.setIcon(studentsGUI.searchLight);

                studentsGUI.idLabel.setForeground(new Color(0xeeeeee));
                studentsGUI.nameLabel.setForeground(new Color(0xeeeeee));
                studentsGUI.addressLabel.setForeground(new Color(0xeeeeee));
                studentsGUI.ageLabel.setForeground(new Color(0xeeeeee));
                studentsGUI.stageLabel.setForeground(new Color(0xeeeeee));
                studentsGUI.mobileLabel.setForeground(new Color(0xeeeeee));
                studentsGUI.genderLabel.setForeground(new Color(0xeeeeee));

                studentsGUI.maleRadio.setBackground(new Color(0x232931));
                studentsGUI.maleRadio.setForeground(new Color(0xeeeeee));
                studentsGUI.maleRadio.setIcon(StudentsGUI.disable);
                studentsGUI.maleRadio.setSelectedIcon(StudentsGUI.enable);

                studentsGUI.femaleRadio.setBackground(new Color(0x232931));
                studentsGUI.femaleRadio.setForeground(new Color(0xeeeeee));
                studentsGUI.femaleRadio.setIcon(StudentsGUI.disable);
                studentsGUI.femaleRadio.setSelectedIcon(StudentsGUI.enable);

                studentsGUI.idField.setBackground(new Color(0x393E46));
                studentsGUI.idField.setForeground(new Color(0xeeeeee));
                studentsGUI.idField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                studentsGUI.idField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.idField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                    }
                });

                studentsGUI.nameField.setBackground(new Color(0x393E46));
                studentsGUI.nameField.setForeground(new Color(0xeeeeee));
                studentsGUI.nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                studentsGUI.nameField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                    }
                });

                studentsGUI.addressField.setBackground(new Color(0x393E46));
                studentsGUI.addressField.setForeground(new Color(0xeeeeee));
                studentsGUI.addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                studentsGUI.addressField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                    }
                });


                studentsGUI.ageField.setBackground(new Color(0x393E46));
                studentsGUI.ageField.setForeground(new Color(0xeeeeee));
                studentsGUI.ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                studentsGUI.ageField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                    }
                });

                studentsGUI.mobileField.setBackground(new Color(0x393E46));
                studentsGUI.mobileField.setForeground(new Color(0xeeeeee));
                studentsGUI.mobileField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                studentsGUI.mobileField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        studentsGUI.mobileField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
                    }
                });

                studentsGUI.stageCombo.setBackground(new Color(0x393E46));
                studentsGUI.stageCombo.setForeground(new Color(0xeeeeee));

                studentsGUI.studentTable.setBackground(new Color(0x232931));
                studentsGUI.studentTable.setForeground(new Color(0xeeeeee));
                studentsGUI.studentTable.getTableHeader().setBackground(new Color(0x393E46));
                studentsGUI.studentTable.getTableHeader().setForeground(new Color(0xeeeeee));
                studentsGUI.studentTable.setGridColor(new Color(0xeeeeee));

                stagesGUI.studentTable.setBackground(new Color(0x232931));
                stagesGUI.studentTable.setForeground(new Color(0xeeeeee));
                stagesGUI.studentTable.getTableHeader().setBackground(new Color(0x393E46));
                stagesGUI.studentTable.getTableHeader().setForeground(new Color(0xeeeeee));
                stagesGUI.studentTable.setGridColor(new Color(0xeeeeee));

                studentsGUI.addBtn.setForeground(new Color(0xeeeeee));
                studentsGUI.updateBtn.setForeground(new Color(0xeeeeee));
                studentsGUI.deleteBtn.setForeground(new Color(0xeeeeee));


                frame.repaint();

            }

        });

        studentBtn = new JButton();
        studentBtn.setForeground(new Color(0x232931));
        studentBtn.setIcon(student);
        studentBtn.setText("STUDENTS");
        studentBtn.setIconTextGap(35);
        studentBtn.setFont(new Font("Verdana", Font.PLAIN, 24));
        studentBtn.setRolloverIcon(student1);
        studentBtn.setHorizontalTextPosition(JButton.CENTER);
        studentBtn.setVerticalTextPosition(JButton.BOTTOM);
        studentBtn.setSize(300,300);
        studentBtn.setFocusable(false);
        studentBtn.setBorder(new RoundedBorder(25));
        studentBtn.setContentAreaFilled(false);
        studentBtn.setOpaque(false);
        studentBtn.addActionListener(e -> {

            stagesBtnPanel.setVisible(false);
            studentBtnPanel.setVisible(false);
            studentsGUI.panel.setVisible(true);

            frame.repaint();

        });

        stagesBtn = new JButton("STAGES");
        stagesBtn.setForeground(new Color(0x232931));
        stagesBtn.setIcon(stages);
        stagesBtn.setIconTextGap(35);
        stagesBtn.setFont(new Font("Verdana", Font.PLAIN, 24));
        stagesBtn.setHorizontalTextPosition(JButton.CENTER);
        stagesBtn.setVerticalTextPosition(JButton.BOTTOM);
        stagesBtn.setRolloverIcon(stages1);
        stagesBtn.setSize(300,300);
        stagesBtn.setFocusable(false);
        stagesBtn.setBorder(new RoundedBorder(25));
        stagesBtn.setContentAreaFilled(false);
        stagesBtn.setOpaque(false);
        stagesBtn.addActionListener(e -> {

            stagesBtnPanel.setVisible(false);
            studentBtnPanel.setVisible(false);
            stagesGUI.panel.setVisible(true);

            frame.repaint();

        });

        studentBtnPanel = new RoundedPanel(25);
        studentBtnPanel.setBackground(new Color(0xeeeeee));
        studentBtnPanel.setLayout(null);
        studentBtnPanel.setBounds(220,180,300,300);
        studentBtnPanel.setOpaque(false);
        studentBtnPanel.add(studentBtn);

        stagesBtnPanel = new RoundedPanel(25);
        stagesBtnPanel.setBackground(new Color(0xeeeeee));
        stagesBtnPanel.setLayout(null);
        stagesBtnPanel.setBounds(650,180,300,300);
        stagesBtnPanel.setOpaque(false);
        stagesBtnPanel.add(stagesBtn);

        panel = new RoundedPanel(100);
        panel.setBackground(new Color(0x232931));
        panel.setLayout(null);
        panel.setBounds(0,80,1185,800);
        panel.setOpaque(false);
        panel.add(studentBtnPanel);
        panel.add(stagesBtnPanel);
        panel.add(studentsGUI.panel);
        panel.add(stagesGUI.panel);

        panel5 = new RoundedPanel(100);
        panel5.setBackground(new Color(0x4ECCA3));
        panel5.setLayout(null);
        panel5.setBounds(0,69,1185,700);
        panel5.setOpaque(false);

        homeBtn.setBounds(55,20,30,32);
        homeBtn.setBackground(null);
        homeBtn.setRolloverIcon(homeLight);
        homeBtn.setContentAreaFilled(false);
        homeBtn.setBorder(null);
        homeBtn.addActionListener(e->{

            stagesBtnPanel.setVisible(true);
            studentBtnPanel.setVisible(true);
            studentsGUI.panel.setVisible(false);
            stagesGUI.panel.setVisible(false);

            frame.repaint();

        });

        title.setFont(new Font("Verdana", Font.PLAIN, 24));
        title.setBounds(440,9,350,50);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setForeground(Color.white);

        frame.setTitle("ISE Student Management System");
        frame.setSize(1200,800);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x393E46));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setIconImage(logo.getImage());
        frame.add(panel);
        frame.add(panel5);
        frame.add(modeBtn);
        frame.add(homeBtn);
        frame.add(title);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
