import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addFIR_DB extends JFrame implements ActionListener {

	JTextField FIR_ID;
	JTextField FIR_name;
	JTextField FIR_type;
	JTextField FIR_date;

	public addFIR_DB() {
		super("Add FIR");
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
		FIR_ID = new JTextField(10);
		FIR_name = new JTextField(10);
		FIR_type = new JTextField(10);
		FIR_date = new JTextField(10);

		panelsignup.add(FIR_name, c);
		c.gridy++;
		panelsignup.add(FIR_type, c);
		c.gridy++;
		panelsignup.add(FIR_date, c);

		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.insets = new Insets(15, 0, 0, 0);
		c.anchor = GridBagConstraints.CENTER;
		JButton FIR_submit = new JButton("Submit");
		panelsignup.add(FIR_submit, c);

		FIR_date.addActionListener(this);
		FIR_submit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {

		String Names = FIR_name.getText();
		String Type = FIR_type.getText();
		String Dates = FIR_date.getText();

		String DBURL = "jdbc:ucanaccess://lib/DB.accdb";

		try {
			Connection conn2 = DriverManager.getConnection(DBURL);

			PreparedStatement pst2 = conn2.prepareStatement("select * from FIR where Name=?");

			pst2.setString(1, Names);

			ResultSet rs2 = pst2.executeQuery();

			int count = 0;
			while (rs2.next()) {
				count = count + 1;
			}

			if (count >= 1) {
				JOptionPane.showMessageDialog(null, "FIR is exist in DataBase");
			} else if (count == 0) {
				Connection conn = DriverManager.getConnection(DBURL);
				PreparedStatement pst = conn.prepareStatement("INSERT INTO FIR(Name, Type, Dates)VALUES(?,?,?)");

				pst.setString(1, Names);
				pst.setString(2, Type);
				pst.setString(3, Dates);

				JOptionPane.showMessageDialog(null, "FIR has been added to DataBase");
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