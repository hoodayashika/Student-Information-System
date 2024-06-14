import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentController {
    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;
    private JList<Student> studentList;
    private DefaultListModel<Student> listModel;

    public StudentController() {
        JFrame frame = new JFrame("Student Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));

        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        panel.add(formPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleAddStudent();
            }
        });
        buttonPanel.add(addButton);

        JButton updateButton = new JButton("Update Student");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleUpdateStudent();
            }
        });
        buttonPanel.add(updateButton);

        JButton deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleDeleteStudent();
            }
        });
        buttonPanel.add(deleteButton);

        JButton clearButton = new JButton("Clear Fields");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        buttonPanel.add(clearButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        // List panel
        listModel = new DefaultListModel<>();
        studentList = new JList<>(listModel);
        studentList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Student selectedStudent = studentList.getSelectedValue();
                if (selectedStudent != null) {
                    idField.setText(selectedStudent.getId());
                    nameField.setText(selectedStudent.getName());
                    emailField.setText(selectedStudent.getEmail());
                }
            }
        });
        panel.add(new JScrollPane(studentList), BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void handleAddStudent() {
        String id = idField.getText();
        String name = nameField.getText();
        String email = emailField.getText();

        if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student student = new Student(id, name, email);
        listModel.addElement(student);
        clearFields();
    }

    private void handleUpdateStudent() {
        int selectedIndex = studentList.getSelectedIndex();
        if (selectedIndex != -1) {
            Student selectedStudent = studentList.getSelectedValue();
            selectedStudent.setId(idField.getText());
            selectedStudent.setName(nameField.getText());
            selectedStudent.setEmail(emailField.getText());
            studentList.repaint();
            clearFields();
        }
    }

    private void handleDeleteStudent() {
        int selectedIndex = studentList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
            clearFields();
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        studentList.clearSelection();
    }

    public JPanel getMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));

        formPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        panel.add(formPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleAddStudent();
            }
        });
        buttonPanel.add(addButton);

        JButton updateButton = new JButton("Update Student");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleUpdateStudent();
            }
        });
        buttonPanel.add(updateButton);

        JButton deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleDeleteStudent();
            }
        });
        buttonPanel.add(deleteButton);

        JButton clearButton = new JButton("Clear Fields");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        buttonPanel.add(clearButton);

        panel.add(buttonPanel, BorderLayout.CENTER);

        // List panel
        listModel = new DefaultListModel<>();
        studentList = new JList<>(listModel);
        studentList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Student selectedStudent = studentList.getSelectedValue();
                if (selectedStudent != null) {
                    idField.setText(selectedStudent.getId());
                    nameField.setText(selectedStudent.getName());
                    emailField.setText(selectedStudent.getEmail());
                }
            }
        });
        panel.add(new JScrollPane(studentList), BorderLayout.SOUTH);

        return panel;
    }
}
