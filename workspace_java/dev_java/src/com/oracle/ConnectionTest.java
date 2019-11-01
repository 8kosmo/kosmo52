package com.oracle;

import java.sql.Connection;

import com.util.DBConnectionMgr;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection con = null;
		//insert here
		//DBConnectionMgr dbMgr2 = new DBConnectionMgr();
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		DBConnectionMgr dbMgr2 = DBConnectionMgr.getInstance();
		System.out.println(dbMgr);
		System.out.println(dbMgr2);
		con = dbMgr.getConnection();
		System.out.println(con);
	}

}
