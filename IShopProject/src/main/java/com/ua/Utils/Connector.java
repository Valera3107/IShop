package com.ua.Utils;

import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private static final String URL = "jdbc:mysql://localhost:3306/i_shop?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "zenbook3107";

	public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

		DOMConfigurator.configure("loggerConfiguration.tld");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
