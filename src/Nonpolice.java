import java.sql.*;
import javax.swing.*;

class Nonpolice extends User {

	public Nonpolice() {

	}

	public Nonpolice(String username, String password) {
		try {

			Connection conn = DriverManager.getConnection(super.DBURL);
			PreparedStatement pst1 = conn.prepareStatement("select*from NonPolice where UserName=? and Password=?");
			pst1.setString(1, username);
			pst1.setString(2, password);
			ResultSet rs1 = pst1.executeQuery();

			int count1 = 0;

			while (rs1.next()) {
				count1 = count1 + 1;
			}

			if (count1 == 1) {
				JOptionPane.showMessageDialog(null, String.format("Welcome " + username));
				ListUser user = new ListUser();
				user.setVisible(true);

			} else if (count1 == 0) {
				JOptionPane.showMessageDialog(null, String.format("Incorrect Username/Password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}