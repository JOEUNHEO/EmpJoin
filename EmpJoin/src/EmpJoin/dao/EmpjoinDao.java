package EmpJoin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import EmpJoin.dto.EmpjoinDto;
import EmpJoin.util.DBConnect;

public class EmpjoinDao {
	private static EmpjoinDao empjoinDao;
	
	private EmpjoinDao() {
		
	}
	
	public static EmpjoinDao getInstance() {
		if(empjoinDao == null) {
			empjoinDao = new EmpjoinDao();
		}
		
		return empjoinDao;
	}
	
	public List<EmpjoinDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmpjoinDto> joins = new ArrayList<>();
		
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT empno, ename, dname, loc FROM emp, dept WHERE emp.deptno = dept.deptno ORDER BY empno ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("empno");
				String ename = rs.getString("ename");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				EmpjoinDto empjoinDto = new EmpjoinDto(num, ename, dname, loc);
				joins.add(empjoinDto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(pstmt != null)pstmt.close();
				if(rs != null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return joins;
		
	}
}
