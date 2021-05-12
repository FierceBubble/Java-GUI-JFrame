import java.sql.*;
import javax.swing.*;

public class Police extends User {

	public Police() {

	}

	public void Display() {

		System.out.println("Officer has logged in");

	}

	public Police(String username, String password) {

		try {
			Connection con = DriverManager.getConnection(super.DBURL);
			PreparedStatement pst = con.prepareStatement("select * from Police where UserName=? and Password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = count + 1;
			}
			if (count == 1) {
				JOptionPane.showMessageDialog(null, String.format("Welcome officer " + username));
				List window = new List();
				window.setVisible(true);

			} else if (count == 0) {
				new Nonpolice(username, password);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}