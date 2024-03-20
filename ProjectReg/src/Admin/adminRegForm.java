package Admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class adminRegForm extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxt;
	private JTextField firstNameTxt;
	private JTextField middleNameTxt;
	private JTextField lastNameTxt;
	private JTextField ageTxt;
	private JTextField emailTxt;
	private JTextField phoneTxt;
	private JPasswordField passwordField;
	private JComboBox<String> monthCbox;
	private JComboBox<String> dayCbox;
	private JComboBox<String> yearCbox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminRegForm frame = new adminRegForm();
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
	public adminRegForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titleLabel = new JLabel("ADMIN REGISTRATION FORM");
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		titleLabel.setBounds(95, 34, 218, 38);
		contentPane.add(titleLabel);

		JLabel usernameLbl = new JLabel("Username:");
		usernameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		usernameLbl.setBounds(86, 114, 62, 13);
		contentPane.add(usernameLbl);

		usernameTxt = new JTextField();
		usernameTxt.setToolTipText("Enter your user name");
		usernameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		usernameTxt.setBounds(158, 110, 140, 19);
		contentPane.add(usernameTxt);
		usernameTxt.setColumns(10);

		JLabel firstNameLbl = new JLabel("First Name:");
		firstNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		firstNameLbl.setBounds(83, 139, 65, 13);
		contentPane.add(firstNameLbl);

		firstNameTxt = new JTextField();
		firstNameTxt.setToolTipText("Enter your first name");
		firstNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		firstNameTxt.setColumns(10);
		firstNameTxt.setBounds(158, 135, 140, 19);
		contentPane.add(firstNameTxt);

		JLabel middleNameLbl = new JLabel("Middle Name:");
		middleNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		middleNameLbl.setBounds(73, 164, 75, 13);
		contentPane.add(middleNameLbl);

		middleNameTxt = new JTextField();
		middleNameTxt.setToolTipText("Enter your middle name");
		middleNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		middleNameTxt.setColumns(10);
		middleNameTxt.setBounds(158, 160, 140, 19);
		contentPane.add(middleNameTxt);

		JLabel lastNameLbl = new JLabel("Last Name:");
		lastNameLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		lastNameLbl.setBounds(84, 189, 64, 13);
		contentPane.add(lastNameLbl);

		lastNameTxt = new JTextField();
		lastNameTxt.setToolTipText("Enter your last name");
		lastNameTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		lastNameTxt.setColumns(10);
		lastNameTxt.setBounds(158, 185, 140, 19);
		contentPane.add(lastNameTxt);

		JLabel birthLbl = new JLabel("Birthday:");
		birthLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		birthLbl.setBounds(101, 217, 47, 13);
		contentPane.add(birthLbl);

		// Correcting JComboBox creation
		dayCbox = new JComboBox(); // Assign to class field instead of declaring a local variable
		dayCbox.setFont(new Font("Dialog", Font.PLAIN, 12));
		dayCbox.setToolTipText("DAY");
		dayCbox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayCbox.setBounds(158, 214, 39, 21);
		contentPane.add(dayCbox);

		monthCbox = new JComboBox(); // Assign to class field instead of declaring a local variable
		monthCbox.setFont(new Font("Dialog", Font.PLAIN, 12));
		monthCbox.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"}));
		monthCbox.setToolTipText("MONTH");
		monthCbox.setBounds(207, 214, 51, 21);
		contentPane.add(monthCbox);

		yearCbox = new JComboBox(); // Assign to class field instead of declaring a local variable
		yearCbox.setFont(new Font("Dialog", Font.PLAIN, 12));
		yearCbox.setModel(new DefaultComboBoxModel(new String[] {"2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
		yearCbox.setToolTipText("YEAR");
		yearCbox.setBounds(268, 214, 53, 21);
		contentPane.add(yearCbox);


		JLabel ageLbl = new JLabel("Age:");
		ageLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		ageLbl.setBounds(125, 249, 23, 13);
		contentPane.add(ageLbl);

		ageTxt = new JTextField();
		ageTxt.setToolTipText("Enter your age");
		ageTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		ageTxt.setColumns(10);
		ageTxt.setBounds(158, 245, 70, 19);
		contentPane.add(ageTxt);

		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		emailLbl.setBounds(113, 274, 35, 13);
		contentPane.add(emailLbl);

		emailTxt = new JTextField();
		emailTxt.setToolTipText("Enter your email");
		emailTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		emailTxt.setColumns(10);
		emailTxt.setBounds(158, 270, 140, 19);
		contentPane.add(emailTxt);

		JLabel phoneLbl = new JLabel("Phone Number:");
		phoneLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		phoneLbl.setBounds(61, 299, 87, 13);
		contentPane.add(phoneLbl);

		phoneTxt = new JTextField();
		phoneTxt.setToolTipText("Enter your phone number");
		phoneTxt.setFont(new Font("Dialog", Font.PLAIN, 12));
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(158, 295, 140, 19);
		contentPane.add(phoneTxt);

		JLabel passLbl = new JLabel("Password:");
		passLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
		passLbl.setBounds(86, 322, 62, 13);
		contentPane.add(passLbl);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 12));
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(158, 320, 140, 19);
		contentPane.add(passwordField);

		JButton regBtn = new JButton("Register");
        regBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (validateInput()) {
                    registerAdmin();
                }
            }
        });
        regBtn.setFont(new Font("Dialog", Font.PLAIN, 12));
        regBtn.setBounds(158, 366, 110, 31);
        contentPane.add(regBtn);
    }

	// Validate input fields
	private boolean validateInput() {
		if (!isValidUsername(usernameTxt.getText())) {
			JOptionPane.showMessageDialog(this, "Please enter a valid username.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!isValidName(firstNameTxt.getText())) {
			JOptionPane.showMessageDialog(this, "Please enter a valid first name.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!isValidName(middleNameTxt.getText())) {
			JOptionPane.showMessageDialog(this, "Please enter a valid middle name.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!isValidName(lastNameTxt.getText())) {
			JOptionPane.showMessageDialog(this, "Please enter a valid last name.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!isValidAge(ageTxt.getText())) {
			JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!isValidEmail(emailTxt.getText())) {
			JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!isValidPhoneNumber(phoneTxt.getText())) {
			JOptionPane.showMessageDialog(this, "Please enter a valid phone number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!isValidPassword(new String(passwordField.getPassword()))) {
			JOptionPane.showMessageDialog(this, "Please enter a password.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	// Validate username
	private boolean isValidUsername(String username) {
		return !username.isEmpty() && !username.contains(" ");
	}

	// Validate first, middle, and last names
	private boolean isValidName(String name) {
		return !name.isEmpty(); 
	}

	// Validate age
	private boolean isValidAge(String age) {
		if (age.isEmpty()) return false;
		try {
			int ageValue = Integer.parseInt(age);
			return ageValue > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// Validate email address using a regular expression
	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		return email.matches(emailRegex);
	}

	// Validate phone number
	private boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber.matches("(09|\\+639)\\d{9}");
	}

	// Validate password
	private boolean isValidPassword(String password) {
		return !password.isEmpty();
	}

	private void registerAdmin() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_registration", "root", "");
            String sql = "INSERT INTO admins (username, first_name, middle_name, last_name, birthday, age, email, phone, password) "
                    + "VALUES (?, ?, ?, ?, STR_TO_DATE(?, '%d-%b-%Y'), ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, usernameTxt.getText());
            statement.setString(2, firstNameTxt.getText());
            statement.setString(3, middleNameTxt.getText());
            statement.setString(4, lastNameTxt.getText());
            String birthday = dayCbox.getSelectedItem().toString() + "-" + monthCbox.getSelectedItem().toString() + "-"
                    + yearCbox.getSelectedItem().toString();
            statement.setString(5, birthday);
            
            int age;
            try {
                age = Integer.parseInt(ageTxt.getText());
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Please enter a valid number.");
                return; // Exit method if age is invalid
            }
            statement.setInt(6, age);
            statement.setString(7, emailTxt.getText());
            statement.setString(8, phoneTxt.getText());
            statement.setString(9, new String(passwordField.getPassword()));
            statement.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(this, "Admin registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error connecting to database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}