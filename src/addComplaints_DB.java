import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addComplaints_DB extends JFrame implements ActionListener {

	JTextField Complaints_ID;
	JTextField Complaints_name;
	JTextField Complaints_type;
	JTextField Complaints_date;

	public addComplaints_DB() {
		super("Add Complaints");
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
		panelsignup.add(new JLabel("Name: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Type: "), c);
		c.gridy++;
		panelsignup.add(new JLabel("Dates(dd/mm/yyyy): "), c);

		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);
		c.anchor = GridBagConstraints.LINE_START;
		Complaints_ID = new JTextField(10);
		Complaints_name = new JTextField(10);
		Complaints_type = new JTextField(10);
		Complaints_date = new JTextField(10);

		panelsignup.add(Complaints_name, c);
		c.gridy++;
		panelsignup.add(Complaints_type, c);
		c.gridy++;
		panelsignup.add(Complaints_date, c);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.insets = new Insets(15, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		JButton Complaints_submit = new JButton("Submit");
		panelsignup.add(Complaints_submit, c);

		Complaints_date.addActionListener(this);
		Complaints_submit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {

		String Names = Complaints_name.getText();
		String Type = Complaints_type.getText();
		String Dates = Complaints_date.getText();

		String DBURL = "jdbc:ucanaccess://lib/DB.accdb";

		try {
			Connection conn2 = DriverManager.getConnection(DBURL);

			PreparedStatement pst2 = conn2.prepareStatement("select * from Complaints where Name=?");

			pst2.setString(1, Names);

			ResultSet rs2 = pst2.executeQuery();

			int count = 0;
			while (rs2.next()) {
				count = count + 1;
			}

			if (count >= 1) {
				JOptionPane.showMessageDialog(null, "Complaints is exist in DataBase");
			} else if (count == 0) {
				Connection conn = DriverManager.getConnection(DBURL);
				PreparedStatement pst = conn.prepareStatement("INSERT INTO Complaints(Name, Type, Dates)VALUES(?,?,?)");

				pst.setString(1, Names);
				pst.setString(2, Type);
				pst.setString(3, Dates);

				JOptionPane.showMessageDialog(null, "Complaints has been added to DataBase");
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