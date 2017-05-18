package com.mbesutti.seminarweb.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mbesutti.seminarweb.seminar.Course;
import com.mbesutti.seminarweb.seminar.Seminar;

public class SeminarRepository {

	private List<Seminar> _seminars;
	private DataSource _ds;

	public SeminarRepository() {
		try {
			_ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/ds");
			_ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		_seminars = new ArrayList<Seminar>();
		try {
			_seminars = selectAllOnDb();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Seminar> getSeminars() {
		List<Seminar> seminars = new ArrayList<Seminar>();
		try {
			seminars.addAll(selectAllOnDb());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seminars;
	}

	public void add(Seminar seminar) {
		try {
			insertOnDb(seminar);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int count() {
		try {
			_seminars = selectAllOnDb();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return _seminars.size();
	}
	
	private List<Seminar> selectAllOnDb() throws SQLException {
		List<Seminar> seminars = new ArrayList<Seminar>(); 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT id, name, description, location, totalSeats, start FROM Course";

		try {
			dbConnection = _ds.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String location = rs.getString("location");
				int totalSeats = rs.getInt("totalSeats");
				String start = rs.getString("start");
				
				seminars.add(new Seminar(new Course(id, name, description, start), totalSeats, location));
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return seminars;
	}

	private void insertOnDb(Seminar seminar) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = _ds.getConnection();
			connection.setAutoCommit(true);
			String query = "insert into Course (name, description, location, totalSeats, start) values ("
					+ "'" + seminar.getCourse().getName() + "'"
					+ ", '" +  seminar.getCourse().getDescription() + "'"
					+ ", '" + seminar.getLocation() + "'"
					+ ", " + seminar.getTotalSeats() + ""
					+ ", '" + getFormattedDate(seminar) + "'"
			+ ");";
			preparedStatement = connection.prepareStatement(query);
			System.out.println("query: "+query);
			int executeQuery = preparedStatement.executeUpdate();
			System.out.println("result: "+executeQuery);
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	private String getFormattedDate(Seminar seminar) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String courseDate = "";
		try {
			courseDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(formatter.parse(seminar.getCourse().getDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return courseDate;
	}
	
}
