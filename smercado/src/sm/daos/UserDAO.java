package sm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection connection;

	public UserDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public int getT(String email) {
		int aux = 0;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select tipo from users where email=?;");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				aux = rs.getInt("tipo");
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return aux;
	}

	public int idByEmail(String email) {
		int aux = 0;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select id from users where email = ?;");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				aux = rs.getInt("id");
			}

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return aux;
	}

	public boolean login(String email, String senha) {

		int aux = 0;

		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select count(*) as tst from users where email=? and senha=?;");
			stmt.setString(1, email);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				aux = rs.getInt("tst");

				if (aux > 0 && aux < 5) {
					return true;
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

		return false;
	}
}
