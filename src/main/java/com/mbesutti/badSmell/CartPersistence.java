package com.mbesutti.badSmell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartPersistence {
	private final Connection _connection;

	public CartPersistence() {
		_connection = null;
	}
	
	public void insert(Cart cart) throws SQLException {
		String sql = new StringBuffer().append("INSERT INTO T_ORDER ")
				.append("(AUTHORIZATION_CODE, SHIPMETHOD_ID, USER_ID, ADDRESS_ID) ")
				.append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
				.toString();
		PreparedStatement insertStatement = _connection.prepareStatement(sql);
		// todo set parameters
		insertStatement.executeUpdate();
	}

	private void select() {
		PreparedStatement getStatement = null;
	}
}
