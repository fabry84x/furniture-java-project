package mobili;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class Ordini {
	static void aggiungiOrdine(String usernameCliente, int idMobile, int quantita) {

//          Insert data
		String insertQuery = "INSERT INTO orders (usernameCliente, idMobile, quantita) VALUES (?, ?, ?)";
		try (Connection connection = Database.createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
			// Set parameter values
			preparedStatement.setString(1, usernameCliente);
			preparedStatement.setInt(2, idMobile);
			preparedStatement.setInt(3, quantita);
			// Execute the prepared statement
			int rowsInserted = preparedStatement.executeUpdate();
			System.out.println(rowsInserted + " row(s) inserted.");
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("L'id inserito non esiste. Riprova..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void visualizzaOrdini() {

		try (Connection connection = Database.createConnection();
				// Create a statement
				Statement statement = connection.createStatement();
				// Execute a query
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders")) {
			// Process the results
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String usernameCliente = resultSet.getString("usernameCliente");
				int idMobile = resultSet.getInt("idMobile");
				int quantita = resultSet.getInt("quantita");
				String dataOrdine = resultSet.getString("dataOrdine");
				System.out.println("ID: " + id + "\nusernameCliente: " + usernameCliente + "\nidMobile: " + idMobile
						+ "\nquantita: " + quantita + "\ndataOrdine: " + dataOrdine + "\n----------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
