package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import analysis.Document;
import analysis.WordCount;

/**
 * Clase que gestiona la conexión a la base de datos
 * @author Unai Aguilera <unai.aguilera@deusto.es>
 *
 */
public class DBManager {

	private Connection conn;
	
	/**
	 * Método que conecta a un fichero de base de datos SQLIte concreta ("/data/database.db")
	 * @throws DBManagerException se produce si existe algún problema al conectar a la BD.
	 */
	public void connect() throws DBManagerException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data/database.db");
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBManagerException("Error connecting to database", e);
		}
	}
	
	public void createDocumentTable() throws DBManagerException {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS document (name TEXT, chars INTEGER, words INTEGER, lines INTEGER)";
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(createTableSQL);
		} catch (SQLException e) {
			throw new DBManagerException("Error insert documents into database.", e);
		}
	}
	
	public void insertDocuments(List<Document> documents) throws DBManagerException {
		String insertSQL = "INSERT INTO document VALUES(?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
			for (Document document : documents) {
				stmt.setString(1, document.getName());
				stmt.setInt(2, document.getChars()); 
				stmt.setInt(3, document.getWords());
				stmt.setInt(4, document.getLines());
				
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DBManagerException("Error insert documents into database.", e);
		}
	}
	
	public void createStatisticsTable() throws DBManagerException {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS statistics (avgWords REAL, topWord TEXT, topCount INTEGER, timestamp NUMERIC)";
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(createTableSQL);
		} catch (SQLException e) {
			throw new DBManagerException("Error insert documents into database.", e);
		}
	} 
	
	public void insertStatistics(float avgWords, WordCount wordCount) throws DBManagerException {
		String insertSQL = "INSERT INTO statistics VALUES(?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
			stmt.setFloat(1, avgWords);
			stmt.setString(2, wordCount.getWord()); 
			stmt.setInt(3, wordCount.getCount());
			stmt.setLong(4, System.currentTimeMillis());
				
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBManagerException("Error insert statistics into database.", e);
		}
	}
	
	/**
	 * Este método permite llevar a cabo la desconexión de la base de datos
	 * @throws DBManagerException se produce si existe algún problema al desconectar con la BD.
	 */
	public void disconnect() throws DBManagerException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new DBManagerException("Error disconnecting from database", e);
		}
	}
}
