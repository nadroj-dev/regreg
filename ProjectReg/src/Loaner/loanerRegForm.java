package Loaner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class loanerRegForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTxt;
	private JTextField firstNameTxt;
	private JTextField middleNameTxt;
	private JTextField lastNameTxt;
	private JTextField ageTxt;
	private JTextField emailTxt;
	private JTextField phoneTxt;
	private JTextField sourceTxt;
	private JTextField occupationTxt;
	private JTextField monthlyTxt;
	private JPasswordField passTxt;
	private JComboBox dayCBox;
    private JComboBox monthCbox;
    private JComboBox yearCbox;

	// Database connection parameters
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/java_registration";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loanerRegForm frame = new loanerRegForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loanerRegForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Loaner Registration Form");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(97, 31, 190, 13);
		contentPane.add(lblNewLabel);

		JLabel usernameLbl = new JLabel("Username:");
		usernameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		usernameLbl.setBounds(59, 79, 61, 13);
		contentPane.add(usernameLbl);

		usernameTxt = new JTextField();
		usernameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		usernameTxt.setBounds(130, 77, 140, 19);
		contentPane.add(usernameTxt);
		usernameTxt.setColumns(10);

		JLabel firstNameLbl = new JLabel("First Name:");
		firstNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		firstNameLbl.setBounds(57, 102, 63, 13);
		contentPane.add(firstNameLbl);

		firstNameTxt = new JTextField();
		firstNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		firstNameTxt.setColumns(10);
		firstNameTxt.setBounds(130, 100, 140, 19);
		contentPane.add(firstNameTxt);

		JLabel middleNameLbl = new JLabel("Middle Name:");
		middleNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		middleNameLbl.setBounds(44, 125, 76, 13);
		contentPane.add(middleNameLbl);

		middleNameTxt = new JTextField();
		middleNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		middleNameTxt.setColumns(10);
		middleNameTxt.setBounds(130, 123, 140, 19);
		contentPane.add(middleNameTxt);

		JLabel lastNameLbl = new JLabel("Last Name:");
		lastNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		lastNameLbl.setBounds(57, 148, 63, 13);
		contentPane.add(lastNameLbl);

		lastNameTxt = new JTextField();
		lastNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		lastNameTxt.setColumns(10);
		lastNameTxt.setBounds(130, 146, 140, 19);
		contentPane.add(lastNameTxt);

		JLabel birthdayLbl = new JLabel("Birthday:");
		birthdayLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		birthdayLbl.setBounds(73, 171, 47, 13);
		contentPane.add(birthdayLbl);

		yearCbox = new JComboBox();
	    yearCbox.setModel(new DefaultComboBoxModel(new String[] {"2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
	    yearCbox.setFont(new Font("Dialog", Font.PLAIN, 12));
	    yearCbox.setBounds(240, 168, 53, 21);
	    contentPane.add(yearCbox);
	    
	    monthCbox = new JComboBox();
	    monthCbox.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"}));
	    monthCbox.setFont(new Font("Dialog", Font.PLAIN, 12));
	    monthCbox.setBounds(179, 168, 51, 21);
	    contentPane.add(monthCbox);
	    
	    dayCBox = new JComboBox();
	    dayCBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
	    dayCBox.setBounds(130, 168, 39, 21);
	    contentPane.add(dayCBox);

		JLabel ageLbl = new JLabel("Age:");
		ageLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		ageLbl.setBounds(97, 194, 23, 13);
		contentPane.add(ageLbl);

		ageTxt = new JTextField();
		ageTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		ageTxt.setColumns(10);
		ageTxt.setBounds(130, 192, 70, 19);
		contentPane.add(ageTxt);

		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		emailLbl.setBounds(85, 217, 35, 13);
		contentPane.add(emailLbl);

		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		emailTxt.setColumns(10);
		emailTxt.setBounds(130, 215, 140, 19);
		contentPane.add(emailTxt);

		JLabel phoneLbl = new JLabel("Phone Number:");
		phoneLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		phoneLbl.setBounds(32, 242, 88, 13);
		contentPane.add(phoneLbl);

		phoneTxt = new JTextField();
		phoneTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(130, 238, 140, 19);
		contentPane.add(phoneTxt);

		JLabel sourceLbl = new JLabel("Source of Income:");
		sourceLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		sourceLbl.setBounds(22, 279, 98, 13);
		contentPane.add(sourceLbl);

		sourceTxt = new JTextField();
		sourceTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		sourceTxt.setColumns(10);
		sourceTxt.setBounds(130, 277, 140, 19);
		contentPane.add(sourceTxt);

		JLabel occupationLbl = new JLabel("Occupation:");
		occupationLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		occupationLbl.setBounds(55, 302, 65, 13);
		contentPane.add(occupationLbl);

		occupationTxt = new JTextField();
		occupationTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		occupationTxt.setColumns(10);
		occupationTxt.setBounds(130, 300, 140, 19);
		contentPane.add(occupationTxt);

		JLabel monthlyLbl = new JLabel("Monthly Income:");
		monthlyLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		monthlyLbl.setBounds(32, 325, 88, 13);
		contentPane.add(monthlyLbl);

		monthlyTxt = new JTextField();
		monthlyTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		monthlyTxt.setColumns(10);
		monthlyTxt.setBounds(130, 323, 140, 19);
		contentPane.add(monthlyTxt);

		JLabel passLbl = new JLabel("Password:");
		passLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		passLbl.setBounds(59, 348, 61, 13);
		contentPane.add(passLbl);

		passTxt = new JPasswordField();
		passTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		passTxt.setBounds(130, 346, 140, 19);
		contentPane.add(passTxt);

		JButton registerButton = new JButton("REGISTER");
		registerButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		registerButton.setBounds(140, 383, 110, 31);
		contentPane.add(registerButton);


		// Action listener for the register button
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    if (registerLoaner()) {
                        JOptionPane.showMessageDialog(contentPane, "Loaner registered successfully.");
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Failed to register loaner. Please try again later.");
                    }
                }
            }
        });
    }

	private boolean validateInput() {
		if (!isValidText(usernameTxt.getText())) {
			showMessage("Please enter a valid username.");
			return false;
		}
		if (!isValidText(firstNameTxt.getText())) {
			showMessage("Please enter a valid first name.");
			return false;
		}
		if (!isValidText(middleNameTxt.getText())) {
			showMessage("Please enter a valid middle name.");
			return false;
		}
		if (!isValidText(lastNameTxt.getText())) {
			showMessage("Please enter a valid last name.");
			return false;
		}
		if (!isValidAge(ageTxt.getText())) {
			showMessage("Please enter a valid age.");
			return false;
		}
		if (!isValidEmail(emailTxt.getText())) {
			showMessage("Please enter a valid email address.");
			return false;
		}
		if (!isValidPhoneNumber(phoneTxt.getText())) {
			showMessage("Please enter a valid phone number.");
			return false;
		}
		if (!isValidText(sourceTxt.getText())) {
			showMessage("Please enter a valid source of income.");
			return false;
		}
		if (!isValidText(occupationTxt.getText())) {
			showMessage("Please enter a valid occupation.");
			return false;
		}
		if (!isValidMonthlyIncome(monthlyTxt.getText())) {
			showMessage("Please enter a valid monthly income.");
			return false;
		}
		if (new String(passTxt.getPassword()).isEmpty()) {
			showMessage("Please enter a password.");
			return false;
		}
		return true; // All fields are valid
	}

	private boolean isValidText(String text) {
		return !text.isEmpty();
	}

	private boolean isValidAge(String age) {
		try {
			int ageValue = Integer.parseInt(age);
			return ageValue >= 18 && ageValue <= 120; // Assuming a valid age range
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		// Validate phone number 
		return phoneNumber.matches("(09|\\+639)\\d{9}");
	}

	private boolean isValidMonthlyIncome(String income) {
		try {
			double incomeValue = Double.parseDouble(income);
			return incomeValue > 0; // Assuming income cannot be negative
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(contentPane, message);

	}


	private boolean registerLoaner() {
        String birthday = yearCbox.getSelectedItem().toString() + "-" +
                String.format("%02d", monthCbox.getSelectedIndex() + 1) + "-" +
                dayCBox.getSelectedItem().toString();
	    
	    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
	        String sql = "INSERT INTO loaner (username, first_name, middle_name, last_name, birthday, age, email, phone, source_of_income, occupation, monthly_income, password) " +
	                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, usernameTxt.getText());
	            stmt.setString(2, firstNameTxt.getText());
	            stmt.setString(3, middleNameTxt.getText());
	            stmt.setString(4, lastNameTxt.getText());
	            stmt.setString(5, birthday); // Set the birthday value
	            stmt.setInt(6, Integer.parseInt(ageTxt.getText()));
	            stmt.setString(7, emailTxt.getText());
	            stmt.setString(8, phoneTxt.getText());
	            stmt.setString(9, sourceTxt.getText());
	            stmt.setString(10, occupationTxt.getText());
	            stmt.setDouble(11, Double.parseDouble(monthlyTxt.getText()));
	            stmt.setString(12, new String(passTxt.getPassword()));

	            int rowsInserted = stmt.executeUpdate();
	            return rowsInserted > 0;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return false;
	    }
	}
}