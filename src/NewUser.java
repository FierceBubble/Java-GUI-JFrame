import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class NewUser extends JFrame implements ActionListener {
	private JTextField name;
	private JTextField mobile;
	private JTextField email;
	private JTextField address;
	private JTextField username;
	private JPasswordField password;
	private JTextField role;
	private JButton submit;

	public NewUser() {
		super("Add New Police");
		setSize(500, 500);
		setVisible(false);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);

		JPanel panelMain = new JPanel();
		getContentPane().add(panelMain);
		JPanel panelsignup = new JPanel(new GridBagLayout());
		panelMain.add(panelsignup);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);
		c.anchor = GridBagConstraints.LINE_START;
		panelsignup.add(new JLabel("Name: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Mobile Phone Number: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Email Address: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Current Address: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Role: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Username: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Password: "), c);

		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);
		c.anchor = GridBagConstraints.LINE_START;
		name = new JTextField(10);
		mobile = new JTextField(10);
		email = new JTextField(10);
		address = new JTextField(10);
		username = new JTextField(10);
		password = new JPasswordField(10);
		role = new JTextField(10);
		panelsignup.add(name, c);
		c.gridy++;
		panelsignup.add(mobile, c);
		c.gridy++;
		panelsignup.add(email, c);
		c.gridy++;
		panelsignup.add(address, c);
		c.gridy++;
		panelsignup.add(role, c);
		c.gridy++;
		panelsignup.add(username, c);
		c.gridy++;
		panelsignup.add(password, c);

		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 2;
		c.insets = new Insets(15, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		submit = new JButton("Submit");
		panelsignup.add(submit, c);

		password.addActionListener(this);
		submit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String Names = name.getText();
		String Mobile = mobile.getText();
		String Email = email.getText();
		String Address = address.getText();
		String Username = username.getText();
		String Password = password.getPassword().toString();
		String Role = role.getText();

		String DBURL = "jdbc:ucanaccess://lib/DB.accdb";

		if (Username.equals("") || Password.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter username and password");
		} else {
			try {
				Connection conn2 = DriverManager.getConnection(DBURL);

				PreparedStatement pst2 = conn2.prepareStatement("select * from Police where Name=?");

				pst2.setString(1, Names);

				ResultSet rs2 = pst2.executeQuery();

				int count = 0;
				while (rs2.next()) {
					count = count + 1;
				}

				if (count >= 1) {
					JOptionPane.showMessageDialog(null, "User is exist in DataBase, Please Login");
				} else if (count == 0) {
					Connection conn = DriverManager.getConnection(DBURL);
					PreparedStatement pst = conn.prepareStatement(
							"INSERT INTO Police(Name, Mobile, Email, Address, UserName, Password, Role)VALUES(?,?,?,?,?,?,?)");
					pst.setString(1, Names);
					pst.setString(2, Mobile);
					pst.setString(3, Email);
					pst.setString(4, Address);
					pst.setString(5, Username);
					pst.setString(6, Password);
					pst.setString(7, Role);

					JOptionPane.showMessageDialog(null, "User has been added to DataBase");
					int row = pst.executeUpdate();
					if (row > 0) {
						System.out.println("A row has been inserted successfully.");
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}