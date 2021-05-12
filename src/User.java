import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class User extends JFrame {
	private JTextField username;
	private JPasswordField password;

	String DBURL = "jdbc:ucanaccess://lib/DB.accdb";

	public User() {
		JFrame frame = new JFrame("Login");

		JPanel panelMain = new JPanel();
		frame.getContentPane().add(panelMain);
		JPanel panellogin = new JPanel(new GridBagLayout());
		panelMain.add(panellogin);

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);
		c.anchor = GridBagConstraints.LINE_START;
		panellogin.add(new JLabel("Enter ID: "), c);
		c.gridy++;
		panellogin.add(new JLabel("Enter Password: "), c);

		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);
		c.anchor = GridBagConstraints.LINE_START;
		username = new JTextField(10);
		panellogin.add(username, c);
		c.gridy++;
		password = new JPasswordField(10);
		panellogin.add(password, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.insets = new Insets(15, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		JButton reg = new JButton("Enter");
		panellogin.add(reg, c);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(300, 145);
		frame.setVisible(true);
		frame.setResizable(false);

		Thehandler function = new Thehandler();
		password.addActionListener(function);
		reg.addActionListener(function);

	}

	public String getUsername() {
		String Username = username.getText();
		return Username;
	}

	public String getPassword() {

		String Password = String.valueOf(password.getPassword());
		return Password;
	}

	public void Display() {

		System.out.println("Officer has logged in");

	}

	private class Thehandler implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			if (getUsername().equals("") || getPassword().equals("")) {
				JOptionPane.showMessageDialog(rootPane, "No ID/Password Input");
			} else if (getUsername().equals("admin") && getPassword().equals("admin")) {
				JOptionPane.showMessageDialog(null, String.format("Welcome Admin"));
				List second = new List();
				second.setVisible(true);
			} else {
				new Police(getUsername(), getPassword());
			}

		}

	}

}
