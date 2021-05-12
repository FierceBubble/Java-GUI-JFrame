import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addCrime_DB extends JFrame implements ActionListener {

	JTextField crime_ID;
	JTextField crime_name;
	JTextField crime_type;
	JTextField crime_date;

	public addCrime_DB() {
		super("Add Crime");
		setSize(480, 480);
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
		panelsignup.add(new JLabel("Crime ID: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Name: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Type: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Dates(dd/mm/yyyy): "), c);

		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);
		c.anchor = GridBagConstraints.LINE_START;
		crime_ID = new JTextField(10);
		crime_name = new JTextField(10);
		crime_type = new JTextField(10);
		crime_date = new JTextField(10);

		panelsignup.add(crime_ID, c);
		c.gridy++;
		panelsignup.add(crime_name, c);
		c.gridy++;
		panelsignup.add(crime_type, c);
		c.gridy++;
		panelsignup.add(crime_date, c);

		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 2;
		c.insets = new Insets(15, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		JButton crime_submit = new JButton("Submit");
		panelsignup.add(crime_submit, c);

		crime_date.addActionListener(this);
		crime_submit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String Names = crime_name.getText();
		String CrimeID = crime_ID.getText();
		String Type = crime_type.getText();
		String Dates = crime_date.getText();

		String DBURL = "jdbc:ucanaccess://lib/DB.accdb";

		try {
			Connection conn2 = DriverManager.getConnection(DBURL);

			PreparedStatement pst2 = conn2.prepareStatement("select * from Case where Name=?");

			pst2.setString(1, Names);

			ResultSet rs2 = pst2.executeQuery();

			int count = 0;
			while (rs2.next()) {
				count = count + 1;
			}

			if (count >= 1) {
				JOptionPane.showMessageDialog(null, "Case is exist in DataBase");
			} else if (count == 0) {
				Connection conn = DriverManager.getConnection(DBURL);
				PreparedStatement pst = conn
						.prepareStatement("INSERT INTO Crime(CriminalID, Name, Type, Dates)VALUES(?,?,?,?)");
				pst.setString(1, CrimeID);
				pst.setString(2, Names);
				pst.setString(3, Type);
				pst.setString(4, Dates);

				JOptionPane.showMessageDialog(null, "Crime has been added to DataBase");
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