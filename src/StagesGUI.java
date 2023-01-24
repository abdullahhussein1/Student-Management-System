import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StagesGUI {

    JPanel tablePanel,tablePanel1;
    JComboBox stageCombo;
    JPanel panel = new JPanel();
    static String[] columns = {"Full name"};
    static String[] columns1 = {"Courses"};
    JTable studentTable,courseTable;
    JScrollPane studentTableScroll,courseScroll;
    String[] stages = {"Stage 1","Stage 2","Stage 3","Stage 4"};

    static DefaultTableModel model = new DefaultTableModel(columns,0);
    static DefaultTableModel model1 = new DefaultTableModel(columns1,0);


    StagesGUI() {



        studentTable = new JTable(model);
        studentTable.setFillsViewportHeight(true);
        studentTableScroll = new JScrollPane(studentTable);
        studentTable.setBackground(new Color(0x232931));
        studentTable.setForeground(new Color(0xeeeeee));
        studentTable.getTableHeader().setBackground(new Color(0x393E46));
        studentTable.getTableHeader().setForeground(new Color(0xeeeeee));
        studentTable.setGridColor(new Color(0xeeeeee));
        studentTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    cell.setBackground(new Color(0x4ECCA3));
                    cell.setForeground(new Color(0x393E46));
                }
                else{
                    if (StartFrame.modeBtn.getIcon()== StartFrame.lightMode0){
                        cell.setBackground(new Color(0xeeeeee));
                        cell.setForeground(new Color(0x232931));
                    }else{
                        cell.setBackground(new Color(0x232931));
                        cell.setForeground(new Color(0xeeeeee));
                    }

                }

                return cell;
            }
        });
        studentTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 16));
        studentTable.setFont(new Font("Verdana", Font.PLAIN, 14));

        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(new Color(0x393E46));
        tablePanel.setBounds(18,120,575,568);
        tablePanel.setOpaque(false);
        tablePanel.add(studentTableScroll);

        courseTable = new JTable(model1);
        courseTable.setFillsViewportHeight(true);
        courseScroll = new JScrollPane(courseTable);
        courseTable.setBackground(new Color(0x232931));
        courseTable.setForeground(new Color(0xeeeeee));
        courseTable.getTableHeader().setBackground(new Color(0x393E46));
        courseTable.getTableHeader().setForeground(new Color(0xeeeeee));
        courseTable.setGridColor(new Color(0xeeeeee));
        courseTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    cell.setBackground(new Color(0x4ECCA3));
                    cell.setForeground(new Color(0x393E46));
                }
                else{
                    if (StartFrame.modeBtn.getIcon()== StartFrame.lightMode0){
                        cell.setBackground(new Color(0xeeeeee));
                        cell.setForeground(new Color(0x232931));
                    }else{
                        cell.setBackground(new Color(0x232931));
                        cell.setForeground(new Color(0xeeeeee));
                    }

                }

                return cell;
            }
        });
        courseTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 16));
        courseTable.setFont(new Font("Verdana", Font.PLAIN, 14));

        tablePanel1 = new JPanel();
        tablePanel1.setLayout(new BorderLayout());
        tablePanel1.setBackground(new Color(0x393E46));
        tablePanel1.setBounds(593,120,575,568);
        tablePanel1.setOpaque(false);
        tablePanel1.add(courseScroll);


        stageCombo = new JComboBox(stages);
        stageCombo.setBounds(100,60,100,40);
        stageCombo.setFont(new Font("Verdana", Font.PLAIN, 16));
        stageCombo.setBackground(new Color(0x393E46));
        stageCombo.setFocusable(false);
        stageCombo.setSelectedIndex(0);
        stageCombo.setForeground(new Color(0xeeeeee));

        switch (stageCombo.getSelectedIndex()){
            case 0 ->{
                CoursesIO.courseReader(1,"stageOne");
            }
            case 1 ->{
                CoursesIO.courseReader(2,"stageOne");
            }
            case 2 ->{
                CoursesIO.courseReader(3,"stageOne");
            }
            case 3 ->{
                CoursesIO.courseReader(4,"stageOne");
            }

        }


        panel.setBounds(0,0,1185,800);
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setVisible(false);
        panel.add(stageCombo);
        panel.add(tablePanel1);
        panel.add(tablePanel);


    }

}
