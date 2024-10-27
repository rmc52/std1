package jhctpj.dao;


import static jhctpj.common.jdbctemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jhctpj.common.jdbctemplate;
import jhctpj.dto.stdnt;



public class stddao {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	public stdnt selectstdnt(Connection conn, String input) {
		//학생조회
		
		stdnt stdnt = null; 
		
		try {
			
		
			String sql = "SELECT * FROM TB_STUDENT WHERE STD_NAME = ?";
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, input);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
			
				int stdNo = rs.getInt("STD_NO");
				String stdName = rs.getString("STD_NAME");
				String stdAge = rs.getString("STD_AGE");
				String stdGender = rs.getString("STD_GENDER");
				String score = rs.getString("STD_SCORE");
			
				stdnt = new stdnt(stdNo, 
						stdName,
						stdAge,
						stdGender,
						score);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
		
			jdbctemplate.close(rs);
			jdbctemplate.close(pstmt);
			
			
		}
		
		return stdnt; 
	}

	// 추가
	public int insertstdnt(Connection conn, stdnt stdnt) throws Exception{
		
		int result = 0;
		
		try {
			
			
			String sql = """
					INSERT INTO TB_STUDENT
					VALUES(SEQ_USER_NO.NEXTVAL, ?, ?, ?, ?)""";
			
			
			pstmt = conn.prepareStatement(sql);
			
		
			pstmt.setString(1, stdnt.getStdName());
			pstmt.setString(2, stdnt.getStdAge());
			pstmt.setString(3, stdnt.getStdGender());
			pstmt.setString(4, stdnt.getScore());
			
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}

	
// 전체조회

	public List<stdnt> selectAll(Connection conn) throws Exception {
		
	
		List<stdnt> stdList = new ArrayList<stdnt>();
		
		try {
			
			String sql = "SELECT * FROM TB_STUDENT ORDER BY USER_NO ASC";
			
			pstmt = conn.prepareStatement(sql);
			
		
			rs = pstmt.executeQuery();
			
	
			
			
			while(rs.next()) {
				
				int stdNo = rs.getInt("STD_NO");
				String stdName = rs.getString("STD_NAME");
				String stdAge = rs.getString("STD_AGE");
				String stdGender = rs.getString("STD_GENDER");
				String score = rs.getString("STD_SCORE");
		
				stdnt stdnt = new stdnt(stdNo, 
						stdName,
						stdAge,
						stdGender,
						score);
				stdList.add(stdnt);
				
			}
			
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return stdList;
	}

	
	// 삭제
	
	
	public int deleteStdnt(Connection conn, String input) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = """
					DELETE FROM TB_STUDENT
					WHERE STD_NAME = ?
					""";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, input);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	// 수정
	
	public int updateStdnt(Connection conn, String stdName, String stdAge, String score, String Name) throws Exception{
		
		int result = 0;
		
		try {
			String sql = """
					UPDATE TB_STUDENT
					SET STD_NAME = ?, STD_AGE = ?, STD_SCORE = ?
					WHERE STD_NAME = ?
					""";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stdName);
			pstmt.setString(2, stdAge);
			pstmt.setString(3, score);
			pstmt.setString(4, Name);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	
	
	
	
	public int stdntCheck(Connection conn, String Name) throws Exception {
		
		int count = 0;
		
		try {
			String sql = """
					SELECT COUNT(*)
					FROM TB_STUDENT
					WHERE STD_NAME = ?
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1); 
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	
	
	
	
	
	
	

}
