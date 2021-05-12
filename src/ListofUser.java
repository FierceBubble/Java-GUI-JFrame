import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class ListofUser extends JFrame {

	DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();
	JTable table = new JTable(model);

	public ListofUser() {
		super("List of Police");
		String DBURL = "jdbc:ucanaccess://lib/DB.accdb";

		// Center
		cnt.setLayout(new FlowLayout(FlowLayout.CENTER));

		model.addColumn("Name");
		model.addColumn("Mobile Phone Number");
		model.addColumn("Email Address");
		model.addColumn("Current Address");
		model.addColumn("Username");
		model.addColumn("Password");
		model.addColumn("Role");
		try (Connection conn = DriverManager.getConnection(DBURL)) {

			String sql = "SELECT*FROM Police";

			PreparedStatement pst = conn.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("Name"), rs.getString("Mobile"), rs.getString("Email"),
						rs.getString("Address"), rs.getString("UserName"), rs.getString("Password"),
						rs.getString("Role") });

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane jsp = new JScrollPane(table);
		cnt.add(jsp);
		this.pack();
		//

	}

}