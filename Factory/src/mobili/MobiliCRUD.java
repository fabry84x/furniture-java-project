package mobili;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MobiliCRUD {
	static void aggiungiMobile(String nome, double prezzo) {

//          Insert data
		String insertQuery = "INSERT INTO mobili (nome, prezzo) VALUES (?, ?)";
		try (Connection connection = Database.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
			// Set parameter values
			preparedStatement.setString(1, nome);
			preparedStatement.setDouble(2, prezzo);
			// Execute the prepared statement
			int rowsInserted = preparedStatement.executeUpdate();
			System.out.println(rowsInserted + " row(s) inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void visualizzaMobili() {

		try (Connection connection = Database.createConnection();
				// Create a statement
				Statement statement = connection.createStatement();
				// Execute a query
				ResultSet resultSet = statement.executeQuery("SELECT * FROM mobili")) {
			// Process the results
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String prezzo = resultSet.getString("prezzo");
				System.out.println("ID: " + id + "\nNome: " + nome + "\nPrezzo: " + prezzo + "\n----------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void modificaMobile(String nome, double prezzo, int id) {

		// Update data
		String updateQuery = "UPDATE mobili SET nome=?, prezzo=? WHERE id=?";
		try (Connection connection = Database.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			// Set parameter values
			preparedStatement.setString(1, nome);
			preparedStatement.setDouble(2, prezzo);
			preparedStatement.setInt(3, id);
			int rowsUpdated = preparedStatement.executeUpdate();
			System.out.println(rowsUpdated + " row(s) updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void eliminaMobile(int id) {

		// Delete data
		String deleteQuery = "DELETE FROM mobili WHERE id=?";
		try (Connection connection = Database.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
			preparedStatement.setInt(1, id);
			int rowsDeleted = preparedStatement.executeUpdate();
			System.out.println(rowsDeleted + " row(s) deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
