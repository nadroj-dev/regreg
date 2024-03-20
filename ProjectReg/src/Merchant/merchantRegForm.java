package Merchant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class merchantRegForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField userNameTxt;
    private JTextField firstNameTxt;
    private JTextField middleNameTxt;
    private JTextField lastNameTxt;
    private JTextField emailTxt;
    private JTextField phoneNumberTxt;
    private JTextField mNameTxt;
    private JTextField categoryTxt;
    private JTextField streetTxt;
    private JTextField brgyTxt;
    private JTextField cityTxt;
    private JTextField regionTxt;
    private JPasswordField passTxt;

    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/java_registration";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public merchantRegForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 438, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Merchant Registration Form");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(97, 30, 207, 18);
		contentPane.add(lblNewLabel);
		
		JLabel userNameLbl = new JLabel("Username:");
		userNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		userNameLbl.setBounds(63, 78, 61, 13);
		contentPane.add(userNameLbl);
		
		userNameTxt = new JTextField();
		userNameTxt.setToolTipText("Enter you username");
		userNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		userNameTxt.setBounds(132, 76, 140, 19);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel firstNameLbl = new JLabel("First Name:");
		firstNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		firstNameLbl.setBounds(61, 103, 63, 13);
		contentPane.add(firstNameLbl);
		
		firstNameTxt = new JTextField();
		firstNameTxt.setToolTipText("Enter your first name");
		firstNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		firstNameTxt.setColumns(10);
		firstNameTxt.setBounds(132, 99, 140, 19);
		contentPane.add(firstNameTxt);
		
		JLabel middleNameLbl = new JLabel("Middle Name:");
		middleNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		middleNameLbl.setBounds(48, 126, 76, 13);
		contentPane.add(middleNameLbl);
		
		middleNameTxt = new JTextField();
		middleNameTxt.setToolTipText("Enter your middle name");
		middleNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		middleNameTxt.setColumns(10);
		middleNameTxt.setBounds(132, 122, 140, 19);
		contentPane.add(middleNameTxt);
		
		JLabel lastNameLbl = new JLabel("Last Name:");
		lastNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		lastNameLbl.setBounds(61, 149, 63, 13);
		contentPane.add(lastNameLbl);
		
		lastNameTxt = new JTextField();
		lastNameTxt.setToolTipText("Enter your last name");
		lastNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		lastNameTxt.setColumns(10);
		lastNameTxt.setBounds(132, 145, 140, 19);
		contentPane.add(lastNameTxt);
		
		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		emailLbl.setBounds(89, 172, 35, 13);
		contentPane.add(emailLbl);
		
		emailTxt = new JTextField();
		emailTxt.setToolTipText("Enter your email");
		emailTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		emailTxt.setColumns(10);
		emailTxt.setBounds(132, 168, 140, 19);
		contentPane.add(emailTxt);
		
		JLabel phoneNumberLbl = new JLabel("Phone Number:");
		phoneNumberLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		phoneNumberLbl.setBounds(36, 195, 88, 13);
		contentPane.add(phoneNumberLbl);
		
		phoneNumberTxt = new JTextField();
		phoneNumberTxt.setToolTipText("Enter your phone number");
		phoneNumberTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		phoneNumberTxt.setColumns(10);
		phoneNumberTxt.setBounds(132, 193, 140, 19);
		contentPane.add(phoneNumberTxt);
		
		JLabel mNameLbl = new JLabel("Merchant Name:");
		mNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		mNameLbl.setBounds(34, 232, 90, 13);
		contentPane.add(mNameLbl);
		
		mNameTxt = new JTextField();
		mNameTxt.setToolTipText("Enter your merchant name");
		mNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		mNameTxt.setColumns(10);
		mNameTxt.setBounds(132, 228, 140, 19);
		contentPane.add(mNameTxt);
		
		JLabel categoryLbl = new JLabel("Category:");
		categoryLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		categoryLbl.setBounds(70, 255, 54, 13);
		contentPane.add(categoryLbl);
		
		categoryTxt = new JTextField();
		categoryTxt.setToolTipText("Entery business category");
		categoryTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		categoryTxt.setColumns(10);
		categoryTxt.setBounds(132, 253, 140, 19);
		contentPane.add(categoryTxt);
		
		JLabel streetLbl = new JLabel("Street:");
		streetLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		streetLbl.setBounds(89, 341, 35, 13);
		contentPane.add(streetLbl);
		
		streetTxt = new JTextField();
		streetTxt.setToolTipText("Enter your street");
		streetTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		streetTxt.setColumns(10);
		streetTxt.setBounds(132, 339, 140, 19);
		contentPane.add(streetTxt);
		
		JLabel brgtLbl = new JLabel("Barangay:");
		brgtLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		brgtLbl.setBounds(70, 364, 54, 13);
		contentPane.add(brgtLbl);
		
		brgyTxt = new JTextField();
		brgyTxt.setToolTipText("Enter your barangay");
		brgyTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		brgyTxt.setColumns(10);
		brgyTxt.setBounds(132, 362, 140, 19);
		contentPane.add(brgyTxt);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(174, 324, 48, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCity.setBounds(97, 387, 27, 13);
		contentPane.add(lblCity);
		
		cityTxt = new JTextField();
		cityTxt.setToolTipText("Enter your city");
		cityTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		cityTxt.setColumns(10);
		cityTxt.setBounds(132, 385, 140, 19);
		contentPane.add(cityTxt);
		
		JLabel lblRegion = new JLabel("Region:");
		lblRegion.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblRegion.setBounds(80, 410, 44, 13);
		contentPane.add(lblRegion);
		
		regionTxt = new JTextField();
		regionTxt.setToolTipText("Enter you region");
		regionTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		regionTxt.setColumns(10);
		regionTxt.setBounds(132, 408, 140, 19);
		contentPane.add(regionTxt);
		
		JLabel regDateLbl = new JLabel("Registration Date:");
		regDateLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		regDateLbl.setBounds(24, 278, 100, 13);
		contentPane.add(regDateLbl);
		
		JComboBox dayCbox = new JComboBox();
		dayCbox.setToolTipText("Day");
		dayCbox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayCbox.setFont(new Font("Dialog", Font.PLAIN, 12));
		dayCbox.setBounds(132, 275, 39, 21);
		contentPane.add(dayCbox);
		
		JComboBox monthCbox = new JComboBox();
		monthCbox.setToolTipText("Month");
		monthCbox.setModel(new DefaultComboBoxModel(new String[] {"Jan ", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"}));
		monthCbox.setBounds(174, 275, 51, 21);
		contentPane.add(monthCbox);
		
		JComboBox yearCbox = new JComboBox();
		yearCbox.setToolTipText("Year");
		yearCbox.setModel(new DefaultComboBoxModel(new String[] {"2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
		yearCbox.setBounds(228, 275, 53, 21);
		contentPane.add(yearCbox);
		
		JLabel passLbl = new JLabel("Password:");
		passLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		passLbl.setBounds(63, 450, 61, 13);
		contentPane.add(passLbl);
		
		passTxt = new JPasswordField();
		passTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		passTxt.setColumns(10);
		passTxt.setBounds(132, 448, 140, 19);
		contentPane.add(passTxt);

        JButton regBtn = new JButton("REGISTER");
        regBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
        regBtn.setBounds(143, 488, 110, 31);
        contentPane.add(regBtn);

        // ActionListener for registration button
        regBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform validation
                if (validateInput()) {
                    // If validation succeeds, proceed with registration
                    if (registerMerchant()) {
                        JOptionPane.showMessageDialog(contentPane, "Merchant registered successfully.");
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Failed to register. Please try again later.");
                    }
                } 
            }
        });
    }

    // Method to validate input fields
    private boolean validateInput() {
    	if (!isValidUsername(userNameTxt.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a valid username.");
            return false;
        }
        if (!isValidName(firstNameTxt.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a valid first name.");
            return false;
        }
        if (!isValidName(middleNameTxt.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a valid middle name.");
            return false;
        }
        if (!isValidName(lastNameTxt.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a valid last name.");
            return false;
        }
        if (!isValidEmail(emailTxt.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a valid email address.");
            return false;
        }
        if (!isValidPhoneNumber(phoneNumberTxt.getText())) {
            JOptionPane.showMessageDialog(contentPane, "Please enter a valid phone number.");
            return false;
        }
        if (mNameTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Please enter the merchant name.");
            return false;
        }
        if (categoryTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Please enter the category.");
            return false;
        }
        if (streetTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Please enter the street.");
            return false;
        }
        if (brgyTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Please enter the barangay.");
            return false;
        }
        if (cityTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Please enter the city.");
            return false;
        }
        if (regionTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Please enter the region.");
            return false;
        }
        if (new String(passTxt.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Please enter the password.");
            return false;
        }
        return true; // All fields are valid
    }

    // Validate username
    private boolean isValidUsername(String username) {
        return !username.isEmpty(); // For now, check if not empty
    }

    // Validate first, middle, and last names
    private boolean isValidName(String name) {
        return !name.isEmpty(); // For now, check if not empty
    }

    // Validate email address using a regular expression
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Validate phone number in Philippine format
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Accepts either 09xxxxxxxxx or +639xxxxxxxxx formats
        return phoneNumber.matches("(09|\\+639)\\d{9}");
    }


    public static void main1(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    merchantRegForm frame = new merchantRegForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Method to register merchant in the database
    private boolean registerMerchant() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO merchant (username, first_name, middle_name, last_name, email, phone_number, merchant_name, category, street, barangay, city, region, registration_date, password) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE(), ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, userNameTxt.getText());
                stmt.setString(2, firstNameTxt.getText());
                stmt.setString(3, middleNameTxt.getText());
                stmt.setString(4, lastNameTxt.getText());
                stmt.setString(5, emailTxt.getText());
                stmt.setString(6, phoneNumberTxt.getText());
                stmt.setString(7, mNameTxt.getText());
                stmt.setString(8, categoryTxt.getText());
                stmt.setString(9, streetTxt.getText());
                stmt.setString(10, brgyTxt.getText());
                stmt.setString(11, cityTxt.getText());
                stmt.setString(12, regionTxt.getText());
                stmt.setString(13, new String(passTxt.getPassword()));

                int rowsInserted = stmt.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Load MySQL JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    merchantRegForm frame = new merchantRegForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}