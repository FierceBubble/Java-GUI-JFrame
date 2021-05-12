import java.sql.*;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class Complaints_DB extends JFrame {
	JFrame f;
	DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();
	JTable table = new JTable(model);

	public Complaints_DB() {
		String DBURL = "jdbc:ucanaccess://lib/DB.accdb";

		cnt.setLayout(new FlowLayout(FlowLayout.CENTER));

		model.addColumn("Name");
		model.addColumn("Type");
		model.addColumn("Date");

		try (Connection conn = DriverManager.getConnection(DBURL)) {

			String sql = "SELECT*FROM Complaints";

			PreparedStatement pst = conn.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("Name"), rs.getString("Type"), rs.getString("Dates") });

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane jsp = new JScrollPane(table);
		cnt.add(jsp);
		this.pack();

	}

}