package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

public class Database {

	// mothod to open connection with the database
	public static Connection getConnection() {

		String driver = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/HMS"; // connecting to the
														// Database users
		String user = "root";
		String pass = "admin";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(URL, user, pass);
			return con;
		} catch (Exception e) {
			System.out.println(e);

		}
		return null;
	}

	public static boolean checkInvManager(String name) {
		// connection establishment to the database
		String rt = null;
		Connection con = Database.getConnection();
		int empId = 0;

		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con
					.prepareStatement("select employee_id from Employee where user_name='" + name + "'");
			ResultSet rs = check.executeQuery();

			while (rs.next()) {
				empId = rs.getInt("employee_id");

			}

			PreparedStatement check2 = con
					.prepareStatement("select * from InventoryManager where invmanager_id='" + empId + "'");

			ResultSet rs2 = check2.executeQuery();

			while (rs2.next()) {

				return true;
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return false;
	}

	public static void callDeleteProcudure(String username) {

		Connection con = Database.getConnection();
		int empId = 0;

		CallableStatement cs = null;
		try {
			cs = (CallableStatement) con.prepareCall("{call deleteEmployeeDetail(?)}");
			cs.setString(1, username);
			cs.execute();

		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException e) {
					System.err.println("SQLException: " + e.getMessage());
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.err.println("SQLException: " + e.getMessage());
				}
			}
		}

	}

	public static boolean checkLabIncharge(String name) {
		// connection establishment to the database
		String rt = null;
		Connection con = Database.getConnection();
		int empId = 0;

		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con
					.prepareStatement("select employee_id from Employee where user_name='" + name + "'");
			ResultSet rs = check.executeQuery();

			while (rs.next()) {
				empId = rs.getInt("employee_id");

			}

			PreparedStatement check2 = con
					.prepareStatement("select * from LabInCharge where labincharge_id='" + empId + "'");

			ResultSet rs2 = check2.executeQuery();

			while (rs2.next()) {

				return true;
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return false;
	}

	public static boolean checkEmergencyManager(String name) {
		// connection establishment to the database
		String rt = null;
		Connection con = Database.getConnection();
		int empId = 0;

		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con
					.prepareStatement("select employee_id from Employee where user_name='" + name + "'");
			ResultSet rs = check.executeQuery();

			while (rs.next()) {
				empId = rs.getInt("employee_id");

			}

			PreparedStatement check2 = con
					.prepareStatement("select * from EmergencyManager where emergencymanager_id='" + empId + "'");

			ResultSet rs2 = check2.executeQuery();

			while (rs2.next()) {

				return true;
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return false;
	}

	// method to check whether the user already exists or not
	public static String check(String name, String pass) {
		// connection establishment to the database
		String rt = null;
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con
					.prepareStatement("select user_name from Employee where user_name='" + name + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) { // if resultset holds any data then rt = exists
								// else rt = null
				rt = "Exists";

				return rt;
			} else {
				return rt;

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return rt;
	}

	public static void updateLabInCharge(String username, String lab) {

		Connection con = Database.getConnection();

		try {
			/*
			 * preparing SQL statement Inserting
			 */

			System.out.println("$$$$ select employee_id from Employee where user_name='" + username + "'");

			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee where user_name='" + username + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int empId = rs.getInt("employee_id");

				System.out.println(
						"$$$$ update LabInCharge set laboratory = '" + lab + "' where labincharge_id =" + empId + "");

				PreparedStatement prep = con.prepareStatement(
						"update LabInCharge set laboratory = '" + lab + "' where labincharge_id =" + empId + "");
				prep.executeUpdate();

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void updateEmployeeRecord(String username, String lastName, String firstName, String addLine1,
			String addLine2, String city, String zipcode, String emailAdd1, String emailAdd2, String mobileNo) {

		Connection con = Database.getConnection();

		try {
			/*
			 * preparing SQL statement Inserting
			 */

			System.out.println("$$$$ select employee_id from Employee where user_name='" + username + "'");

			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee where user_name='" + username + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int empId = rs.getInt("employee_id");

				System.out.println("$$$$ update Employee set last_name = '" + lastName + "', first_name = '" + firstName
						+ "', addr_line1 = '" + addLine1 + "', addr_line2 = '" + addLine2 + "', city = '" + city
						+ "', zip_code = '" + zipcode + "', email_id_1 = '" + emailAdd1 + "', email_id_2 = '"
						+ emailAdd2 + "', mobile_number = '" + mobileNo + "' where employee_id =" + empId + "");

				PreparedStatement prep = con.prepareStatement(
						"update Employee set last_name = '" + lastName + "', first_name = '" + firstName
								+ "', addr_line1 = '" + addLine1 + "', addr_line2 = '" + addLine2 + "', city = '" + city
								+ "', zip_code = '" + zipcode + "', email_id_1 = '" + emailAdd1 + "', email_id_2 = '"
								+ emailAdd2 + "', mobile_number = '" + mobileNo + "' where employee_id =" + empId + "");
				prep.executeUpdate();

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void updateDocPerRecord(String docUsername, String docLastName, String docFirstName, String addLine1,
			String addLine2, String city, String zipcode, String emailAdd1, String emailAdd2, String mobileNo) {

		Connection con = Database.getConnection();

		try {
			/*
			 * preparing SQL statement Inserting
			 */

			System.out.println("$$$$ select employee_id from Employee where user_name='" + docUsername + "'");

			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee where user_name='" + docUsername + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int empId = rs.getInt("employee_id");

				System.out.println("$$$$ update Employee set last_name = '" + docLastName + "', first_name = '"
						+ docFirstName + "', addr_line1 = '" + addLine1 + "', addr_line2 = '" + addLine2 + "', city = '"
						+ city + "', zip_code = '" + zipcode + "', email_id_1 = '" + emailAdd1 + "', email_id_2 = '"
						+ emailAdd2 + "', mobile_number = '" + mobileNo + "' where employee_id =" + empId + "");

				PreparedStatement prep = con.prepareStatement(
						"update Employee set last_name = '" + docLastName + "', first_name = '" + docFirstName
								+ "', addr_line1 = '" + addLine1 + "', addr_line2 = '" + addLine2 + "', city = '" + city
								+ "', zip_code = '" + zipcode + "', email_id_1 = '" + emailAdd1 + "', email_id_2 = '"
								+ emailAdd2 + "', mobile_number = '" + mobileNo + "' where employee_id =" + empId + "");
				prep.executeUpdate();

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void updateOprRecord(String oprUsername, String oprLastName, String oprFirstName, String addLine1,
			String addLine2, String city, String zipcode, String emailAdd1, String emailAdd2, String mobileNo) {

		Connection con = Database.getConnection();

		try {
			/*
			 * preparing SQL statement Inserting
			 */

			System.out.println("$$$$ select employee_id from Employee where user_name='" + oprUsername + "'");

			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee where user_name='" + oprUsername + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int empId = rs.getInt("employee_id");

				System.out.println("$$$$ update Employee set last_name = '" + oprLastName + "', first_name = '"
						+ oprFirstName + "', addr_line1 = '" + addLine1 + "', addr_line2 = '" + addLine2
						+ "', city = ' " + city + " ', zip_code = ' " + zipcode + "', email_id_1 = ' " + emailAdd1
						+ " ', email_id_2 = ' " + emailAdd2 + "', mobile_number = '" + mobileNo
						+ "' where employee_id =" + empId + "");

				PreparedStatement prep = con.prepareStatement("update Employee set last_name = '" + oprLastName
						+ "', first_name = '" + oprFirstName + " ', addr_line1 = '" + addLine1 + "', addr_line2 = '"
						+ addLine2 + " ', city = ' " + city + " ', zip_code = ' " + zipcode + " ', email_id_1 = '"
						+ emailAdd1 + " ', email_id_2 = '" + emailAdd2 + "', mobile_number = '" + mobileNo
						+ "' where employee_id ='" + empId + "'");
				prep.executeUpdate();

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void deleteLabInchargeRecord(String username) {

		Connection con = Database.getConnection();

		System.out.println("$$$$ select employee_id from Employee where user_name='" + username + "'");

		PreparedStatement p;
		try {
			p = con.prepareStatement("select employee_id from Employee where user_name='" + username + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int empId = rs.getInt("employee_id");

				System.out.println("$$$$ oprId " + empId);
				System.out.println("$$$$ delete from LabInCharge where labincharge_id  =" + empId + "");

				PreparedStatement prep = con
						.prepareStatement("delete from LabInCharge where labincharge_id =" + empId + "");
				prep.executeUpdate();

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void deleteInvManagerRecord(String username) {

		Connection con = Database.getConnection();

		System.out.println("$$$$ select employee_id from Employee where user_name='" + username + "'");

		PreparedStatement p;
		try {
			p = con.prepareStatement("select employee_id from Employee where user_name='" + username + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int empId = rs.getInt("employee_id");

				System.out.println("$$$$ oprId " + empId);
				System.out.println("$$$$ delete from InventoryManager where invmanager_id =" + empId + "");

				PreparedStatement prep = con
						.prepareStatement("delete from InventoryManager where invmanager_id =" + empId + "");
				prep.executeUpdate();

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	/*
	 * public static void deleteOprRecord(String oprUsername) throws Exception {
	 * 
	 * Connection con = Database.getConnection();
	 * 
	 * // try {
	 * 
	 * preparing SQL statement Inserting
	 * 
	 * 
	 * System.out. println(
	 * "$$$$ select employee_id from Employee where user_name='" + oprUsername +
	 * "'");
	 * 
	 * PreparedStatement p = con .prepareStatement(
	 * "select employee_id from Employee where user_name='" + oprUsername +
	 * "'");
	 * 
	 * ResultSet rs = p.executeQuery(); while (rs.next()) { int oprId =
	 * rs.getInt("employee_id");
	 * 
	 * System.out.println("$$$$ oprId " + oprId); System.out.println(
	 * "$$$$ delete from Operator where operator_id=" + oprId + "");
	 * 
	 * PreparedStatement prep = con.prepareStatement(
	 * "delete from Operator where operator_id=" + oprId + "");
	 * prep.executeUpdate();
	 * 
	 * }
	 * 
	 * } catch (Exception e) { System.out.println(e); }
	 * 
	 * 
	 * if (con != null) { try { con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 * 
	 * }
	 */

	public static void deleteEmerManagerRecord(String username) throws Exception {

		Connection con = Database.getConnection();

		System.out.println("$$$$ select employee_id from Employee where user_name='" + username + "'");

		PreparedStatement p = con
				.prepareStatement("select employee_id from Employee where user_name='" + username + "'");

		ResultSet rs = p.executeQuery();
		while (rs.next()) {
			int empId = rs.getInt("employee_id");

			System.out.println("$$$$ oprId " + empId);
			System.out.println("$$$$ delete from EmergencyManager where emergencymanager_id =" + empId + "");

			PreparedStatement prep = con
					.prepareStatement("delete from EmergencyManager where emergencymanager_id =" + empId + "");
			prep.executeUpdate();

		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void deleteOprRecord(String oprUsername) throws Exception {

		Connection con = Database.getConnection();

		// try {
		/*
		 * preparing SQL statement Inserting
		 */

		System.out.println("$$$$ select employee_id from Employee where user_name='" + oprUsername + "'");

		PreparedStatement p = con
				.prepareStatement("select employee_id from Employee where user_name='" + oprUsername + "'");

		ResultSet rs = p.executeQuery();
		while (rs.next()) {
			int oprId = rs.getInt("employee_id");

			System.out.println("$$$$ oprId " + oprId);
			System.out.println("$$$$ delete from Operator where operator_id=" + oprId + "");

			PreparedStatement prep = con.prepareStatement("delete from Operator where operator_id=" + oprId + "");
			prep.executeUpdate();

		}
		/*
		 * } catch (Exception e) { System.out.println(e); }
		 */

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void add(String uname, String uPassword, String e_last_name, String e_first_name, String addr1,
			String addr2, String city, int zip_code, String email1, String email2, long mobile_no) {
		String name = uname;
		String pass = uPassword;
		String first_name = e_first_name;
		String last_name = e_last_name;
		String addrLine1 = addr1;
		String addrLine2 = addr2;
		String City = city;
		int zc = zip_code;
		String Email1 = email1;
		String Email2 = email2;
		long m_no = mobile_no;

		// connection established to the database

		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting data into table user with
			 * attributes username and password
			 */
			PreparedStatement prep = con.prepareStatement(
					"insert into Employee (user_name,pass,last_name,first_name,addr_line1,addr_line2,city,zip_code,email_id_1,email_id_2,mobile_number)"
							+ "values ('" + name + "','" + pass + "','" + last_name + "','" + first_name + "','"
							+ addrLine1 + "','" + addrLine2 + "','" + City + "','" + zc + "','" + Email1 + "','"
							+ Email2 + "','" + m_no + "')");
			prep.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static Boolean add(String e_last_name, String e_first_name, int age, String gender, String addr1,
			String addr2, String city, int zip_code, String email1, String email2, long mobile_no, long e_mobile_no) {
		Boolean execution = false;
		String sex = gender;
		int ag = age;
		String first_name = e_first_name;
		String last_name = e_last_name;
		String addrLine1 = addr1;
		String addrLine2 = addr2;
		String City = city;
		int zc = zip_code;
		String Email1 = email1;
		String Email2 = email2;
		long m_no = mobile_no;
		long e_m_no = e_mobile_no;

		// connection established to the database

		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting data into table Patient
			 */
			PreparedStatement prep = con.prepareStatement(
					"insert into Patient (last_name,first_name,age,sex,addr_line1,addr_line2,city,zip_code,email_id_1,email_id_2,mobile_number,e_mobile_number)"
							+ "values ('" + last_name + "','" + first_name + "','" + ag + "','" + sex + "','"
							+ addrLine1 + "','" + addrLine2 + "','" + City + "','" + zc + "','" + Email1 + "','"
							+ Email2 + "','" + m_no + "','" + e_m_no + "')");
			prep.executeUpdate();
			execution = true;

		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return execution;
	}

	public static void addDocSpec(String uname, String degree, String spec) {
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting
			 */

			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee where user_name='" + uname + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int un = rs.getInt("employee_id");
				System.out.println(un);

				PreparedStatement prep = con.prepareStatement("insert into Doctor (doctor_id,degree,specialization)"
						+ "values ('" + un + "','" + degree + "','" + spec + "')");
				prep.executeUpdate();

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void deleteDocRecord(String docUsername) throws Exception {

		Connection con = Database.getConnection();

		// try {
		/*
		 * preparing SQL statement Inserting
		 */

		/*
		 * System.out. println(
		 * "$$$$ select employee_id from Employee where user_name='" +
		 * docUsername + "'");
		 */

		PreparedStatement p = con
				.prepareStatement("select employee_id from Employee where user_name='" + docUsername + "'");

		ResultSet rs = p.executeQuery();
		while (rs.next()) {
			int docId = rs.getInt("employee_id");

			/*
			 * System.out.println("$$$$ update Doctor set doctor_id = " + docId
			 * + ", degree = ' " + degree + " ', specialization = ' " + special
			 * + " ' , in_time='" + inTimeHrsInt + ":" + inTimeMinInt +
			 * "', out_time='" + outTimeHrInt + ":" + outTimeMinInt +
			 * "' where doctor_id=" + docId + "");
			 */

			PreparedStatement prep = con.prepareStatement("delete from Doctor where doctor_id=" + docId + "");
			prep.executeUpdate();

		}
		/*
		 * } catch (Exception e) { System.out.println(e); }
		 */

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void updateDocRecord(String docUsername, String degree, String special) throws Exception {
		Connection con = Database.getConnection();

		// try {
		/*
		 * preparing SQL statement Inserting
		 */

		/*
		 * System.out. println(
		 * "$$$$ select employee_id from Employee where user_name='" +
		 * docUsername + "'");
		 */

		PreparedStatement p = con
				.prepareStatement("select employee_id from Employee where user_name='" + docUsername + "'");

		ResultSet rs = p.executeQuery();
		while (rs.next()) {
			int docId = rs.getInt("employee_id");

			/*
			 * System.out.println("$$$$ update Doctor set doctor_id = " + docId
			 * + ", degree = ' " + degree + " ', specialization = ' " + special
			 * + " ' , in_time='" + inTimeHrsInt + ":" + inTimeMinInt +
			 * "', out_time='" + outTimeHrInt + ":" + outTimeMinInt +
			 * "' where doctor_id=" + docId + "");
			 */

			/*
			 * PreparedStatement prep = con.prepareStatement(
			 * "update Doctor set doctor_id = " + docId + ", degree = ' " +
			 * degree + " ', specialization = ' " + special + " ' , in_time='" +
			 * inTimeHrsInt + ":" + inTimeMinInt + "', out_time='" +
			 * outTimeHrInt + ":" + outTimeMinInt + "' where doctor_id=" + docId
			 * + "");
			 */

			PreparedStatement prep = con.prepareStatement("update Doctor set  degree = '" + degree
					+ "', specialization = '" + special + "' where doctor_id = '" + docId + "'");

			prep.executeUpdate();

		}
		/*
		 * } catch (Exception e) { System.out.println(e); }
		 */

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void addOperator(String uname) {
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting
			 */

			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee where user_name='" + uname + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int uno = rs.getInt("employee_id");

				PreparedStatement prep = con
						.prepareStatement("insert into Operator(operator_id)" + "values ('" + uno + "')");
				prep.executeUpdate();

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void upWrkHrs(String duName, int inHrs, int inMin, int oHrs, int oMin) {
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting
			 */

			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee where user_name='" + duName + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int uno = rs.getInt("employee_id");

				PreparedStatement prep = con.prepareStatement("update Doctor set in_time='" + inHrs + ":" + inMin
						+ "', out_time='" + oHrs + ":" + oMin + "' where doctor_id=" + uno + "");
				prep.executeUpdate();

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static int scheduleApt(int pid, String doc, int aptHR, int aptMin, String o_user, String date) {
		Connection con = Database.getConnection();
		int aptNum = 0;
		int o_id = 0;
		int d_id = 0;

		try {

			PreparedStatement check = con.prepareStatement(
					"select o.operator_id from employee e inner join operator o on e.employee_id=o.operator_id where user_name='"
							+ o_user + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) {
				o_id = rs.getInt("operator_id");

			}

			PreparedStatement p = con.prepareStatement(
					"select d.doctor_id from employee e inner join doctor d on e.employee_id=d.doctor_id where user_name='"
							+ doc + "'");

			ResultSet rss = p.executeQuery();
			while (rss.next()) {
				d_id = rss.getInt("doctor_id");

			}

			String aptsch = date + " " + aptHR + ":" + aptMin;

			PreparedStatement c = con.prepareStatement("SELECT doctor_id FROM appointment where doctor_id='" + d_id
					+ "' and apt_time='" + aptsch + "' and patient_id='" + pid + "'");

			ResultSet cc = c.executeQuery();

			if (!cc.next()) { // enters the loop if it's gng to be a new
								// appointment.
				// System.out.println(cc.getInt("doctor_id"));
				// System.out.println("Entering the new appointment schedule");
				// scheduling the apt

				if (aptMin == 30 || aptMin == 00) {
					PreparedStatement apt = con.prepareStatement(
							"insert into appointment (operator_id, patient_id,doctor_id, apt_time) values (" + o_id
									+ "," + pid + "," + d_id + ",'" + aptsch + "') ");

					apt.executeUpdate();

					PreparedStatement n = con.prepareStatement(
							"select apt_no from appointment where operator_id =" + o_id + " and patient_id =" + pid
									+ " and doctor_id=" + d_id + " and apt_time ='" + aptsch + "' ");

					ResultSet rsn = n.executeQuery();
					while (rsn.next()) {
						aptNum = rsn.getInt("apt_no");
					}

				} else {
					return aptNum = 0;
				}
			} else {
				return aptNum = 0;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return aptNum;
	}

	public static String admincheck(String uname, String uPassword) {

		// connection establishment to the database
		String rt = null;
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con.prepareStatement(
					"select user_name from employee e inner join administrator a on e.employee_id=a.admin_id where user_name='"
							+ uname + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) { // if resultset holds any data then rt = exists
								// else rt = null
				rt = "Exists";

				return rt;
			} else {
				return rt;

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return rt;

	}

	public static String operatorCheck(String uname, String uPassword) {

		String rt = null;
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con.prepareStatement(
					"select user_name from employee e inner join operator o on e.employee_id=o.operator_id where user_name='"
							+ uname + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) { // if resultset holds any data then rt = exists
								// else rt = null
				rt = "Exists";

				return rt;
			} else {
				return rt;

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return rt;
	}

	public static void updatePatientRecords(String pid, String doc, String disease, String comments, String viston,
			String op_user, String time) {

		Connection con = Database.getConnection();
		int d_id = 0;
		int o_id = 0;
		try {

			PreparedStatement p = con.prepareStatement(
					"select d.doctor_id from employee e inner join doctor d on e.employee_id=d.doctor_id where user_name='"
							+ doc + "'");

			ResultSet rss = p.executeQuery();
			while (rss.next()) {
				d_id = rss.getInt("doctor_id");

			}

			PreparedStatement check = con.prepareStatement(
					"select o.operator_id from employee e inner join operator o on e.employee_id=o.operator_id where user_name='"
							+ op_user + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) {
				o_id = rs.getInt("operator_id");

			}

			String VT = viston + " " + time;

			PreparedStatement i = con.prepareStatement(
					"insert into Patient_Records (patient_id,doctor_id,operator_id,disease,comments ,Visited_On) "
							+ "       values (" + pid + "," + d_id + "," + o_id + ",'" + disease + "','" + comments
							+ "','" + VT + "')");

			i.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static String wardBooking(String pat_id, String op_user, String wardType, String bed_num) {
		// TODO Auto-generated method stub
		Connection con = Database.getConnection();
		String event = "failure";
		int p_id = Integer.parseInt(pat_id);
		int b_no = Integer.parseInt(bed_num);
		int o_id = 0;
		int w_id = 0;
		int capty = 0;
		int bno;
		int wcount;
		try {
			PreparedStatement check = con.prepareStatement(
					"select o.operator_id from employee e inner join operator o on e.employee_id=o.operator_id where user_name='"
							+ op_user + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) {
				o_id = rs.getInt("operator_id");
				System.out.println(o_id);

				PreparedStatement wid = con
						.prepareStatement("SELECT ward_id, capacity FROM Wards where ward_type= '" + wardType + "'");
				ResultSet wrs = wid.executeQuery();

				while (wrs.next()) {
					w_id = wrs.getInt("ward_id");
					capty = wrs.getInt("capacity");
					System.out.println(w_id);
					System.out.println(capty);
				}
				PreparedStatement count = con.prepareStatement(
						"SELECT COUNT(patient_id) as total, bed_number FROM AdmittedPatients WHERE ward_id = '" + w_id
								+ "'");

				ResultSet c = count.executeQuery();

				while (c.next()) {
					wcount = c.getInt("total");
					bno = c.getInt("bed_number");
					System.out.println(wcount);
					if (wcount < capty && bno != b_no) {
						PreparedStatement in = con.prepareStatement(
								"INSERT INTO AdmittedPatients (patient_id,ward_id,operator_id,bed_number) VALUES ('"
										+ p_id + "','" + w_id + "','" + o_id + "','" + b_no + "')");
						in.executeUpdate();
						event = "success";
					} else {
						event = "failure";
						return event;
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return event;

	}

	public static String wardBooking(String pat_id) {
		// TODO Auto-generated method stub
		String del = "faliure";
		int p_id = Integer.parseInt(pat_id);
		Connection con = Database.getConnection();
		try {
			PreparedStatement d = con.prepareStatement("DELETE FROM AdmittedPatients WHERE patient_id= '" + p_id + "'");
			d.executeUpdate();
			del = "success";
		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return del;
	}

	// Dhenuka
	public static void addIManager(String uname) {
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting
			 */

			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee where user_name='" + uname + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int uno = rs.getInt("employee_id");

				PreparedStatement prep = con
						.prepareStatement("insert into Inventory_Manager(inv_manager_id)" + "values ('" + uno + "')");
				prep.executeUpdate();

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static String imCheck(String uname, String uPassword) {

		String rt = null;
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con.prepareStatement(
					"select user_name from employee e inner join inventory_manager i on e.employee_id=i.inv_manager_id where user_name='"
							+ uname + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) { // if resultset holds any data then rt = exists
								// else rt = null
				rt = "Exists";

				return rt;
			} else {
				return rt;

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return rt;
	}

	public static boolean addInventory(String i_name, String i_description, int i_quantity) {
		String iname = i_name;
		String description = i_description;
		int quantity = i_quantity;
		Boolean execution = false;

		// connection established to the database

		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting data into table inventory with
			 * attributes item_name,description,quantity
			 */
			PreparedStatement prep = con.prepareStatement("insert into inventory (item_name,description,quantity)"
					+ "values ('" + iname + "','" + description + "','" + quantity + "')");
			prep.executeUpdate();
			execution = true;

		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return execution;
	}

	public static boolean updateInventory(String i_name, String i_description, int i_quantity) {
		String iname = i_name;
		String description = i_description;
		int quantity = i_quantity;
		boolean execution = false;

		// connection established to the database

		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting data into table user with
			 * attributes username and password
			 */
			PreparedStatement prep1 = con
					.prepareStatement("select count(*) from inventory where item_name='" + iname + "'");
			ResultSet rs = prep1.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}

			if (count == 1) {
				PreparedStatement prep = con
						.prepareStatement("update inventory set " + "item_name='" + iname + "',description='"
								+ description + "',quantity='" + quantity + "' where item_name='" + iname + "'");
				System.out.println("query: " + "update inventory set " + "item_name='" + iname + "',description='"
						+ description + "',quantity='" + quantity + "' where item_name='" + iname + "'");
				System.out.println("execution before : " + execution);

				prep.executeUpdate();
				execution = true;
				System.out.println("execution after : " + execution);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return execution;
	}

	public static boolean deleteInventory(String i_name) {
		String iname = i_name;
		boolean execution = false;
		// connection established to the database

		Connection con = Database.getConnection();
		try {

			/*
			 * preparing SQL statement Inserting data into table user with
			 * attributes username and password
			 */
			PreparedStatement prep1 = con
					.prepareStatement("select count(*) from inventory where item_name='" + iname + "'");
			ResultSet rs = prep1.executeQuery();
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}

			if (count == 1) {
				PreparedStatement prep = con.prepareStatement("delete from inventory where item_name='" + iname + "'");

				prep.executeUpdate();
				execution = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return execution;
	}

	public static int addRequestForInventory(String doctorname,String itemName, int quantity) {
	Connection con = Database.getConnection();
	int j=0;
	try {
		/* preparing SQL statement 
		 * Inserting   */
		PreparedStatement prep1 = con.prepareStatement("select d.doctor_id from doctor d inner join employee e on d.doctor_id=e.employee_id where e.user_name='"+doctorname+"'");
		ResultSet rs = prep1.executeQuery();
		int doctor_id = 0;
		while(rs.next())
		{
			doctor_id = rs.getInt(1);
		}
		
		
		
		PreparedStatement p = con
				.prepareStatement("Insert into request(doctor_id,item_name,quantity) values('"+doctor_id+"','"+itemName+"','"+quantity+"')");
		
	
			p.executeUpdate();
			j=1;
			
		}
	
	catch (Exception e) {
		System.out.println(e);
		return j;
	}

if (con != null) {
try {
	
con.close();

} catch (Exception e) {
System.out.println(e);
return j;
}

}
return j;
}

public static void addEManager(String uname) {
	// TODO Auto-generated method stub
	Connection con = Database.getConnection();
	try {
		/* preparing SQL statement 
		 * Inserting   */
		
		PreparedStatement p = con
				.prepareStatement("select employee_id from Employee where user_name='"+uname+"'");
		
	
		ResultSet rs = p.executeQuery();
		while(rs.next()){
		int uno= rs.getInt("employee_id");
		
		
		PreparedStatement prep = con
				.prepareStatement("insert into emergencymanager(emergencymanager_id)"
						+ "values ('"+uno+"')");
		prep.executeUpdate();
		
		}
	}
	catch (Exception e) {
		System.out.println(e);
	}

if (con != null) {
try {
con.close();
} catch (Exception e) {
System.out.println(e);
}
}
	
	
	
}

public static Boolean updateBloodQuantity(String bloodgroup, int bgQuantity) {
	String blood_group = bloodgroup;
	
	int bg_quantity = bgQuantity;
	boolean execution = false;
	
	// connection established to the database
			
			Connection con = Database.getConnection();
			try {
				PreparedStatement prep1 = con.prepareStatement("select count(*) from bloodgroup where blood_group_name='"+blood_group+"'");
				ResultSet rs = prep1.executeQuery();
				int count = 0;
				while(rs.next())
				{
					count = rs.getInt(1);
				}
				
				if(count==1){
				PreparedStatement prep = con
						.prepareStatement("update bloodgroup set "
								+ "quantity="+bg_quantity+" where blood_group_name='"+blood_group+"'");
				System.out.println("update bloodgroup set "
						+ "quantity="+bg_quantity+" where blood_group_name='"+blood_group+"'");
				System.out.println("execution before : "+execution);
			 
			prep.executeUpdate();
			 execution = true;
			  System.out.println("execution after : " +execution);
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}

if (con != null) {
	try {
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}
return execution;
}

public static String emerManagercheck(String uname, String uPassword) {
	// connection establishment to the database
	String rt = null;
	Connection con = Database.getConnection();
	try {
		/* preparing SQL statement 
		 * checking user details from the table Employee with attributes username and password */
		
		PreparedStatement check = con.prepareStatement("select user_name from employee e inner join emergencymanager em on e.employee_id=em.emergencymanager_id where user_name='"+uname+"'");
		ResultSet rs = check.executeQuery();
		
		
		if (rs.first()){ //if resultset holds any data then rt = exists else rt = null
			rt = "Exists";
			
			return rt;
		}
		else {
			return rt;
		

	}
	}

	
	catch (Exception e) {
		System.out.println(e);
	}
	if (con != null) {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	return rt;

	
}

	public static String doctorCheck(String uname, String uPassword) {

		String rt = null;
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con.prepareStatement(
					"select user_name from employee e inner join doctor d on e.employee_id=d.doctor_id where user_name='"
							+ uname + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) { // if resultset holds any data then rt = exists
								// else rt = null
				rt = "Exists";

				return rt;
			} else {
				return rt;

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return rt;
	}

	public static void AcceptInventoryRequest(String request_id, String doctor_id, String item_name,
			int requiredQuantity1, int availableQuantity1) {
		// TODO Auto-generated method stub
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting
			 */
			int newQuantity = availableQuantity1 - requiredQuantity1;
			PreparedStatement p = con.prepareStatement(
					"update inventory set quantity='" + newQuantity + "'where item_name='" + item_name + "'");
			p.executeUpdate();

			p = con.prepareStatement("update request set status='COMPLETED' where request_id='" + request_id + "'");
			p.executeUpdate();

		}

		catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void RejectInventoryRequest(String request_id, String doctor_id, String item_name,
			int requiredQuantity1, int availableQuantity1) {
		// TODO Auto-generated method stub
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting
			 */

			PreparedStatement p = con
					.prepareStatement("update request set status='FAILED' where request_id='" + request_id + "'");

			p.executeUpdate();

		}

		catch (Exception e) {
			System.out.println(e);
		}

		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	// Venkat
	public static String patientIDCheck(String p_id) {

		String rt = null;
		Connection con = Database.getConnection();
		System.out.println("patientIDCheckExists");
		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con
					.prepareStatement("select patient_id from patient where patient_id ='" + p_id + "'");
			ResultSet rs = check.executeQuery();

			System.out.println("patientIDCheckExists2");
			if (rs.next()) { // if resultset holds any data then rt = exists
								// else rt = null
				rt = "Exists";
				System.out.println("patientIDCheckExists3");
				return rt;
			} else {
				return rt;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return rt;
	}

	public static Boolean upadd(String pid, String e_last_name, String e_first_name, int age, String addr1,
			String addr2, String city, int zip_code, String email1, String email2, long mobile_no, long e_mobile_no) {
		Boolean execution = false;
		String patid = pid;
		int ag = age;
		String first_name = e_first_name;
		String last_name = e_last_name;
		String addrLine1 = addr1;
		String addrLine2 = addr2;
		String City = city;
		int zc = zip_code;
		String Email1 = email1;
		String Email2 = email2;
		long m_no = mobile_no;
		long e_m_no = e_mobile_no;

		// connection established to the database

		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting data into table Patient
			 */
			PreparedStatement prep = con.prepareStatement("update Patient SET last_name = '" + last_name
					+ "', first_name = '" + first_name + "', age = '" + ag + "', addr_line1 = '" + addrLine1
					+ "', addr_line2 = '" + addrLine2 + "', city = '" + City + "', zip_code = '" + zc
					+ "' ,email_id_1 = '" + Email1 + "' ,email_id_2 = '" + Email2 + "' ,mobile_number = '" + m_no
					+ "', e_mobile_number = '" + e_m_no + "' where patient_id = '" + patid + "'");
			prep.executeUpdate();
			execution = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return execution;
	}

	public static String appNoCheck(String app_no) {

		String rt = null;
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con
					.prepareStatement("select apt_no from appointment where apt_no ='" + app_no + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) { // if resultset holds any data then rt = exists
								// else rt = null
				rt = "Exists";

				return rt;
			} else {
				return rt;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return rt;
	}

	public static Boolean upapp(String appno, int pat_id, String dname, String app_date) {
		Boolean execution = false;
		int d_id = 0;
		String app_no = appno;
		int appoint_no = Integer.parseInt(app_no);
		int patid = pat_id;
		String d_name = dname;
		String appdate = app_date;
		// connection established to the database

		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting data into table Patient
			 */
			PreparedStatement p = con.prepareStatement(
					"select d.doctor_id from employee e inner join doctor d on e.employee_id=d.doctor_id where user_name='"
							+ d_name + "'");

			ResultSet rss = p.executeQuery();
			while (rss.next()) {
				d_id = rss.getInt("doctor_id");
			}
			PreparedStatement prep = con
					.prepareStatement("update appointment SET patient_id = '" + patid + "', doctor_id = '" + d_id
							+ "', apt_time = '" + appdate + "' where apt_no = '" + appoint_no + "'");
			prep.executeUpdate();
			execution = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return execution;
	}

	public static Boolean canapp(String appno, int pat_id, String dname, String app_date) {
		Boolean execution = false;
		int d_id = 0;
		String app_no = appno;
		int appoint_no = Integer.parseInt(app_no);
		int patid = pat_id;
		String d_name = dname;
		String appdate = app_date;
		// connection established to the database

		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement Inserting data into table Patient
			 */
			PreparedStatement p = con.prepareStatement(
					"select d.doctor_id from employee e inner join doctor d on e.employee_id=d.doctor_id where user_name='"
							+ d_name + "'");

			ResultSet rss = p.executeQuery();
			while (rss.next()) {
				d_id = rss.getInt("doctor_id");
			}
			PreparedStatement prep = con
					.prepareStatement("delete from appointment where apt_no = '" + appoint_no + "'");
			prep.executeUpdate();
			execution = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return execution;
	}

	public static void addLab(String uname, String lab) {
		Connection con = Database.getConnection();
		try {
			
			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee where user_name='" + uname + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				int uno = rs.getInt("employee_id");

				PreparedStatement prep = con
						.prepareStatement("insert into LabInCharge(labincharge_id,laboratory)" + "values ('" + uno + "','"+lab+"')");
				prep.executeUpdate();
		}
		}
		
		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		
		
	}

}

	public static String labincCheck(String lname, String lPassword) {
		String rt = null;
		Connection con = Database.getConnection();
		try {
			/*
			 * preparing SQL statement checking user details from the table
			 * Employee with attributes username and password
			 */

			PreparedStatement check = con.prepareStatement(
					"select user_name from employee e inner join LabInCharge l on e.employee_id=l.labincharge_id where user_name='"
							+ lname + "'");
			ResultSet rs = check.executeQuery();

			if (rs.first()) { // if resultset holds any data then rt = exists
								// else rt = null
				rt = "Exists";

				return rt;
			} else {
				return rt;

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return rt;
		
		
	}

	public static void addPatTestRecord(String pid, String tname, String tresult, String lname) {
		
		Connection con = Database.getConnection();
		int lno =0;
		try {
			
			PreparedStatement p = con
					.prepareStatement("select employee_id from Employee e inner join LabInCharge l on e.employee_id = l.labincharge_id where user_name='" + lname + "'");

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				 lno = rs.getInt("employee_id");
				
				
			}
			
			PreparedStatement I = con
					.prepareStatement("INSERT INTO PatientTestResults (patient_id,labincharge_id,test_name,test_result,test_taken_on) VALUES ('"+pid+"','"+lno+"','"+tname+"','"+tresult+"',CURDATE())");
		
			I.executeUpdate();
		
		}
			catch (Exception e) {
				System.out.println(e);
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	
			
		
	}
