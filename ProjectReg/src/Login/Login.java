package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

    private JComboBox<String> userTypeComboBox;
    private JTextField usernameField;
    private JPasswordField passwordField;

    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/java_registration";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public Login() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(494, 385);
        setLocationRelativeTo(null); // Center the window
        getContentPane().setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        JLabel userTypeLabel = new JLabel("User Type:");
        userTypeLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        userTypeLabel.setBounds(73, 204, 74, 27);
        loginPanel.add(userTypeLabel);

        userTypeComboBox = new JComboBox<>(new String[]{"Admin", "Loaner", "Merchant"});
        userTypeComboBox.setFont(new Font("Dialog", Font.PLAIN, 15));
        userTypeComboBox.setBounds(153, 199, 95, 37);
        loginPanel.add(userTypeComboBox);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        usernameLabel.setBounds(73, 85, 74, 37);
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 15));
        usernameField.setBounds(153, 86, 194, 39);
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        passwordLabel.setBounds(73, 152, 74, 27);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 15));
        passwordField.setBounds(153, 148, 194, 39);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 15));
        loginButton.setBounds(167, 262, 164, 37);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userType = (String) userTypeComboBox.getSelectedItem();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (verifyLogin(userType, username, password)) {
                    JOptionPane.showMessageDialog(Login.this, "Login Successful");
                    // You can perform actions after successful login here
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid username or password");
                }
            }
        });
        loginPanel.add(loginButton);

        getContentPane().add(loginPanel, BorderLayout.CENTER);
        
        JLabel lblNewLabel = new JLabel("LOGIN");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        lblNewLabel.setBounds(207, 26, 67, 37);
        loginPanel.add(lblNewLabel);
    }

    private boolean verifyLogin(String userType, String username, String password) {
        String tableName = "";
        switch (userType) {
            case "Admin":
                tableName = "admins";
                break;
            case "Loaner":
                tableName = "loaner";
                break;
            case "Merchant":
                tableName = "merchant";
                break;
        }
        String query = "SELECT * FROM " + tableName + " WHERE username=? AND password=?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If result set has next, credentials are correct
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
