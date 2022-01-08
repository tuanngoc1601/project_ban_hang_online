/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package csdlproject;
import java.sql.*;

/**
 *
 * @author VIP
 */
public class database_connect {
    public static Connection connection() throws SQLException {
		
		String host="localhost";
		String port="5432";
		String dbname="csdl_ban_hang_online";
		String user="postgres";
		String pass="123456";
		String dburl = "jdbc:postgresql://"+host+":"+port+"/"+dbname+"?loggerLevel=OFF";
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet ret = null;
		
		try{
			conn = DriverManager.getConnection(dburl, user, pass);
			
			// prepare query to get oid from relation name
			pstmt = conn.prepareStatement("select oid,relname from pg_class where relname = ?;");
			
			stmt = conn.createStatement();
			stmt.executeUpdate("drop table if exists testpg_db;");
			stmt.executeUpdate("create temp table testpg_db as select generate_series(1,5) as id;");
			
			// test prepareStatement
			pstmt.setString(1,"testpg_db");
			ret = pstmt.executeQuery();
			while(ret.next()){
				System.out.println("relation name: "+ret.getString("relname") + ", oid: "+ret.getInt("oid"));
			}
//			ret.close();
			
			// test Statement
			ret = stmt.executeQuery("select id from testpg_db");
			while(ret.next()) {
				System.out.println("value: "+ret.getInt("id"));
			}
			
			System.out.println("done.");
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			if (ret != null) {
//				ret.close();
			}
			if (stmt != null) {
//				stmt.close();
			}
			if (pstmt != null) {
//				pstmt.close();
			}
			if (conn != null) {
//				conn.close();
			}
		}
                return conn;
	}
        

}
