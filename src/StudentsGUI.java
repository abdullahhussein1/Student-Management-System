import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class StudentsGUI{

    ImageIcon search = new ImageIcon("assets/images/search0.png");
    ImageIcon searchLight = new ImageIcon("assets/images/search.png");
    static ImageIcon disable = new ImageIcon("assets/images/disableRadio.png");
    static ImageIcon enable = new ImageIcon("assets/images/enableRadio.png");
    ImageIcon disableBlack = new ImageIcon("assets/images/disableRadioLight.png");
    ImageIcon enableBlack = new ImageIcon("assets/images/enableRadioLight.png");

    static String[] columns = {"ID","Full name","Gender","Age","Mobile","Stage","Address"};

    static DefaultTableModel model = new DefaultTableModel(columns,0);
    JTable studentTable;
    JScrollPane studentTableScroll;
    JLabel addBtn,updateBtn,deleteBtn;
    JComboBox stageCombo;
    JRadioButton maleRadio,femaleRadio;
    JTextField searchField,idField,nameField,ageField,addressField,mobileField;
    JLabel searchIcon,idLabel,nameLabel,genderLabel,ageLabel,addressLabel,stageLabel,mobileLabel;
    ButtonGroup buttonGroup;

    String[] stages = {"1","2","3","4"};

    JPanel addPanel,updatePanel,deletePanel,tablePanel;

    JPanel panel = new JPanel();
    static ArrayList<Students> studentsList = new ArrayList<>();

    StudentsGUI() {

        studentTable = new JTable(model);
        studentTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        studentTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        studentTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        studentTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        studentTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        studentTable.getColumnModel().getColumn(5).setPreferredWidth(60);
        studentTable.getColumnModel().getColumn(6).setPreferredWidth(120);
        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
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
        studentTable.getSelectionModel().addListSelectionListener(e -> {
//                if (studentTable.getModel().getValueAt(studentTable.getSelectedRow(),
//                        studentTable.getSelectedColumn())  != null){
//                    nameField.setText(String.valueOf(studentTable.getModel().getValueAt(studentTable.getSelectedRow(), 1)));
//
//                }
            try {
                if (studentTable.getSelectedRow() != -1) {
                    idField.setText(String.valueOf(studentTable.getValueAt(studentTable.getSelectedRow(), 0)));
                    nameField.setText(String.valueOf(studentTable.getValueAt(studentTable.getSelectedRow(), 1)));
                    //stageCombo.setSelectedIndex(Integer.parseInt(String.valueOf(studentTable.getValueAt
                    // (studentTable.getSelectedRow(),2))));
                    ageField.setText(String.valueOf(studentTable.getValueAt(studentTable.getSelectedRow(), 3)));
                    mobileField.setText(String.valueOf(studentTable.getValueAt(studentTable.getSelectedRow(),
                            4)));
                    if (studentTable.getValueAt(studentTable.getSelectedRow(),
                            5) == "male"){
                        maleRadio.setEnabled(true);
                    }else {
                        femaleRadio.setEnabled(true);
                    }
                    addressField.setText(String.valueOf(studentTable.getValueAt(studentTable.getSelectedRow(),
                            6)));
                }
            }catch (Exception ez){
                System.out.println("listListener error");
            }

        });

        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(new Color(0x393E46));
        tablePanel.setBounds(440,120,747,568);
        tablePanel.setOpaque(false);
        tablePanel.add(studentTableScroll);

        deleteBtn = new JLabel("delete");
        deleteBtn.setSize(220,40);
        deleteBtn.setOpaque(false);
        deleteBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        deleteBtn.setForeground(new Color(0xeeeeee));

        updateBtn = new JLabel("update");
        updateBtn.setSize(220,40);
        updateBtn.setOpaque(false);
        updateBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        updateBtn.setForeground(new Color(0xeeeeee));

        addBtn = new JLabel("add");
        addBtn.setSize(220,40);
        addBtn.setOpaque(false);
        addBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        addBtn.setForeground(new Color(0xeeeeee));

        deletePanel = new RoundedPanel(25);
        deletePanel.setBounds(270,510,105,40);
        deletePanel.setBackground(new Color(0xCC4E4E));
        deletePanel.setOpaque(false);
        deletePanel.add(deleteBtn);
        deletePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(studentTable.getSelectedRow() != -1) {
                    studentsList.remove(studentTable.getSelectedRow());
                    model.removeRow(studentTable.getSelectedRow());
                }
                try {
                    StudentIO.studentWriter("Students.csv", studentsList);
                } catch (IOException en) {
                    en.printStackTrace();
                }
                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                mobileField.setText("");
                addressField.setText("");
                maleRadio.setSelected(true);
                stageCombo.setSelectedIndex(0);
                studentTable.clearSelection();


            }
        });

        updatePanel = new RoundedPanel(25);
        updatePanel.setBounds(156,510,105,40);
        updatePanel.setBackground(new Color(0x4ECCA3));
        updatePanel.setOpaque(false);
        updatePanel.add(updateBtn);
        updatePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                studentsList.set(studentTable.getSelectedRow(),new Students(Integer.parseInt(idField.getText()), nameField.getText().toLowerCase(),
                        Integer.parseInt(ageField.getText()),
                        buttonGroup.getSelection().getActionCommand(), addressField.getText(), mobileField.getText(),
                        Integer.parseInt(stageCombo.getSelectedItem().toString())));
                try {
                    StudentIO.studentWriter("Students.csv",studentsList);
                } catch (IOException en) {
                    en.printStackTrace();
                }
                model.setValueAt(idField.getText(),studentTable.getSelectedRow(),0);
                model.setValueAt(nameField.getText(),studentTable.getSelectedRow(),1);
                model.setValueAt(buttonGroup.getSelection().getActionCommand(),studentTable.getSelectedRow(),2);
                model.setValueAt(ageField.getText(),studentTable.getSelectedRow(),3);
                model.setValueAt(mobileField.getText(),studentTable.getSelectedRow(),4);
                model.setValueAt(stageCombo.getSelectedItem().toString(),studentTable.getSelectedRow(),5);
                model.setValueAt(addressField.getText(),studentTable.getSelectedRow(),6);
                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                mobileField.setText("");
                addressField.setText("");
                maleRadio.setSelected(true);
                stageCombo.setSelectedIndex(0);
                studentTable.clearSelection();
            }
        });

        addPanel = new RoundedPanel(25);
        addPanel.setBounds(156,460,220,40);
        addPanel.setBackground(new Color(0x4E8DCC));
        addPanel.setOpaque(false);
        addPanel.add(addBtn);
        addPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                int x;
                     x = Integer.parseInt(idField.getText());
                    model.addRow(new Object[]{
                            x,
                            nameField.getText().toLowerCase(),
                            buttonGroup.getSelection().getActionCommand() ,
                            ageField.getText(),
                            mobileField.getText(),
                            stageCombo.getSelectedItem().toString(),
                            addressField.getText()
                    });
                    studentsList.add(new Students(Integer.parseInt(idField.getText()), nameField.getText().toLowerCase(),
                            Integer.parseInt(ageField.getText()),
                            buttonGroup.getSelection().getActionCommand(), addressField.getText(), mobileField.getText(),
                            Integer.parseInt(stageCombo.getSelectedItem().toString())));
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"wrong input type");
                    idField.setText("");
                    nameField.setText("");
                    ageField.setText("");
                    mobileField.setText("");
                    addressField.setText("");
                    maleRadio.setSelected(true);
                    stageCombo.setSelectedIndex(0);
                    studentTable.clearSelection();
                }

                try {
                    StudentIO.studentWriter("Students.csv",studentsList);
                } catch (IOException en) {
                    en.printStackTrace();
                }
                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                mobileField.setText("");
                addressField.setText("");
                maleRadio.setSelected(true);
                stageCombo.setSelectedIndex(0);
                studentTable.clearSelection();
            }
        });

        stageCombo = new JComboBox(stages);
        stageCombo.setBounds(328,400,45,32);
        stageCombo.setFont(new Font("Verdana", Font.PLAIN, 16));
        stageCombo.setBackground(new Color(0x393E46));
        stageCombo.setFocusable(false);
        stageCombo.setForeground(new Color(0xeeeeee));

        ageField = new JTextField();
        ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
        ageField.setBounds(315,187,60,40);
        ageField.setBackground(new Color(0x393E46));
        ageField.setForeground(new Color(0xeeeeee));
        ageField.setSelectionColor(new Color(0x4ECCA3));
        ageField.setFont(new Font("Verdana", Font.PLAIN, 16));
        ageField.setCaretColor(new Color(0x4ECCA3));
        ageField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x4ECCA3)));
            }

            @Override
            public void focusLost(FocusEvent e) {
                ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
            }
        });

        addressField = new JTextField();
        addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
        addressField.setBounds(156,327,220,40);
        addressField.setBackground(new Color(0x393E46));
        addressField.setForeground(new Color(0xeeeeee));
        addressField.setSelectionColor(new Color(0x4ECCA3));
        addressField.setFont(new Font("Verdana", Font.PLAIN, 16));
        addressField.setCaretColor(new Color(0x4ECCA3));
        addressField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x4ECCA3)));
            }

            @Override
            public void focusLost(FocusEvent e) {
                addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
            }
        });

        idField = new JTextField();
        idField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
        idField.setBounds(156,187,60,40);
        idField.setBackground(new Color(0x393E46));
        idField.setForeground(new Color(0xeeeeee));
        idField.setSelectionColor(new Color(0x4ECCA3));
        idField.setFont(new Font("Verdana", Font.PLAIN, 16));
        idField.setCaretColor(new Color(0x4ECCA3));
        idField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                idField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x4ECCA3)));
            }

            @Override
            public void focusLost(FocusEvent e) {
                idField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
            }
        });

        nameField = new JTextField();
        nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
        nameField.setBounds(156,120,220,40);
        nameField.setBackground(new Color(0x393E46));
        nameField.setForeground(new Color(0xeeeeee));
        nameField.setSelectionColor(new Color(0x4ECCA3));
        nameField.setFont(new Font("Verdana", Font.PLAIN, 16));
        nameField.setCaretColor(new Color(0x4ECCA3));
        nameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x4ECCA3)));
            }

            @Override
            public void focusLost(FocusEvent e) {
                nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
            }
        });

        femaleRadio = new JRadioButton("female");
        femaleRadio.setBounds(153,416,80,30);
        femaleRadio.setFont(new Font("Verdana", Font.PLAIN, 15));
        femaleRadio.setBackground(new Color(0x232931));
        femaleRadio.setIcon(disable);
        femaleRadio.setSelectedIcon(enable);
        femaleRadio.setActionCommand("female");
        femaleRadio.setVerticalTextPosition(0);
        femaleRadio.setFocusable(false);
        femaleRadio.setForeground(new Color(0xeeeeee));

        maleRadio = new JRadioButton("male");
        maleRadio.setBounds(153,390,70,30);
        maleRadio.setFont(new Font("Verdana", Font.PLAIN, 15));
        maleRadio.setIcon(disable);
        maleRadio.setSelectedIcon(enable);
        maleRadio.setActionCommand("male");
        maleRadio.setSelected(true);
        maleRadio.setVerticalTextPosition(0);
        maleRadio.setFocusable(false);
        maleRadio.setBackground(new Color(0x232931));
        maleRadio.setForeground(new Color(0xeeeeee));

        buttonGroup = new ButtonGroup();
        buttonGroup.add(maleRadio);
        buttonGroup.add(femaleRadio);

        mobileLabel = new JLabel("Mobile:");
        mobileLabel.setBounds(80,260,100,30);
        mobileLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        mobileLabel.setForeground(new Color(0xeeeeee));

        mobileField = new JTextField();
        mobileField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
        mobileField.setBounds(156,260,220,40);
        mobileField.setBackground(new Color(0x393E46));
        mobileField.setForeground(new Color(0xeeeeee));
        mobileField.setSelectionColor(new Color(0x4ECCA3));
        mobileField.setFont(new Font("Verdana", Font.PLAIN, 16));
        mobileField.setCaretColor(new Color(0x4ECCA3));
        mobileField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                mobileField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x4ECCA3)));
            }

            @Override
            public void focusLost(FocusEvent e) {
                mobileField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x464C56)));
            }
        });

        stageLabel = new JLabel("Stage:");
        stageLabel.setBounds(260,400,100,25);
        stageLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        stageLabel.setForeground(new Color(0xeeeeee));

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(71,400,100,30);
        genderLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        genderLabel.setForeground(new Color(0xeeeeee));

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(68,330,100,30);
        addressLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        addressLabel.setForeground(new Color(0xeeeeee));

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(265,190,100,30);
        ageLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        ageLabel.setForeground(new Color(0xeeeeee));

        nameLabel = new JLabel("Full name:");
        nameLabel.setBounds(50,120,100,30);
        nameLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        nameLabel.setForeground(new Color(0xeeeeee));

        idLabel = new JLabel("ID:");
        idLabel.setBounds(115,190,100,30);
        idLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        idLabel.setForeground(new Color(0xeeeeee));

        searchIcon = new JLabel(searchLight);
        searchIcon.setBounds(756,20,32,32);

        searchField = new RoundJTextField(25);
        searchField.setBounds(390,10,400,45);
        searchField.setCaretColor(new Color(0x4ECCA3));
        searchField.setBackground(new Color(0x464C56));
        searchField.setForeground(new Color(0xeeeeee));
        searchField.setSelectionColor(new Color(0x4ECCA3));
        searchField.setFont(new Font("Verdana", Font.PLAIN, 20));

        panel.setBounds(0,0,1185,800);
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.add(searchIcon);
        panel.add(searchField);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(mobileLabel);
        panel.add(mobileField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(genderLabel);
        panel.add(maleRadio);
        panel.add(femaleRadio);
        panel.add(stageLabel);
        panel.add(stageCombo);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(addPanel);
        panel.add(updatePanel);
        panel.add(deletePanel);
        panel.add(tablePanel);


        panel.setVisible(false);

    }

}
