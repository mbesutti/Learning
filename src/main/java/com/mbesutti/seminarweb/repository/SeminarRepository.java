package com.mbesutti.seminarweb.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mbesutti.seminarweb.seminar.Course;
import com.mbesutti.seminarweb.seminar.Seminar;

public class SeminarRepository {

	private List<Seminar> _seminars;
	private final Connection _connection;

	public SeminarRepository(Connection connection) {
		_connection = connection;
		_seminars = getSeminars();
	}
	
	public List<Seminar> getSeminars() {
		return selectAllOnDb();
	}

	public Seminar getSeminar(int id) {
		return selectOnDb(id);
	}

	public void add(Seminar seminar) {
		insertOnDb(seminar);
	}
	
	public int count() {
		_seminars = selectAllOnDb();
		return _seminars.size();
	}

	private Seminar selectOnDb(int id) {
		Seminar seminar = new Seminar(); 

		try {
			String selectSQL = "SELECT id, name, description, location, totalSeats, start FROM Course"
					+ " WHERE id = "+id;
			PreparedStatement preparedStatement = _connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			rs.next();
			String courseId = rs.getString("id");
			String name = rs.getString("name");
			String description = rs.getString("description");
			String location = rs.getString("location");
			int totalSeats = rs.getInt("totalSeats");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date startDate = null;
			try {
				startDate = dateFormat.parse(rs.getString("start"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			SimpleDateFormat stringDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			String start = stringDateFormat.format(startDate);
			seminar = new Seminar(new Course(courseId, name, description, start), totalSeats, location);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return seminar;
	}
	
	private List<Seminar> selectAllOnDb() {
		List<Seminar> seminars = new ArrayList<Seminar>(); 

		try {
			String selectSQL = "SELECT id, name, description, location, totalSeats, start FROM Course";
			PreparedStatement preparedStatement = _connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String location = rs.getString("location");
				int totalSeats = rs.getInt("totalSeats");
				String start = rs.getString("start");
				
				seminars.add(new Seminar(new Course(id, name, description, start), totalSeats, location));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return seminars;
	}

	private void insertOnDb(Seminar seminar) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String query = "insert into Course (name, description, location, totalSeats, start) values ("
					+ "'" + seminar.getCourse().getName() + "'"
					+ ", '" +  seminar.getCourse().getDescription() + "'"
					+ ", '" + seminar.getLocation() + "'"
					+ ", " + seminar.getTotalSeats() + ""
					+ ", '" + getFormattedDate(seminar) + "'"
			+ ");";
			preparedStatement = _connection.prepareStatement(query);
			int executeQuery = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(Seminar seminar) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String query = "update Course set"
									+ " name = '" + seminar.getCourse().getName() + "'"
									+ ", description = '" +  seminar.getCourse().getDescription() + "'"
									+ ", location = '" + seminar.getLocation() + "'"
									+ ", totalSeats = " + seminar.getTotalSeats() + ""
									+ ", start = '" + getFormattedDate(seminar) + "'"
						+ " WHERE id = "+seminar.getCourse().getId()
			+ ";";
			preparedStatement = _connection.prepareStatement(query);
			int executeQuery = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String query = "DELETE FROM Course"
					+ " WHERE id = "+id;
			preparedStatement = _connection.prepareStatement(query);
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
