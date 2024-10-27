package jhctpj.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;
import static jhctpj.common.jdbctemplate.close;
import static jhctpj.common.jdbctemplate.commit;
import static jhctpj.common.jdbctemplate.getConnection;
import static jhctpj.common.jdbctemplate.rollback;

import java.sql.Connection;

import jhctpj.common.jdbctemplate;
import jhctpj.dao.stddao;
import jhctpj.dto.stdnt;



public class stdservice {

	private stddao dao = new stddao();

	
	
	
	//조회
	
	public stdnt selectstdnt(String input) {
		
		Connection conn = getConnection();
		
		
		stdnt stdnt = dao.selectstdnt(conn, input);
		
		jdbctemplate.close(conn);
		
		
		return stdnt; 
	}
	
	
	
	
	
	//등록
	
public int insertstdnt(stdnt stdnt) throws Exception{
		
		Connection conn = getConnection();
		
		
		int result = dao.insertstdnt(conn, stdnt);
		
	
		if(result > 0) { 
			commit(conn);
			
		} else { 
			rollback(conn);
			
		}
		
		
		close(conn);
		
		
		return result;
	}



//삭제 

public int deleteStdnt(String input) throws Exception {
	
	Connection conn = getConnection();
	
	int result = dao.deleteStdnt(conn, input);
	
	if(result >0 ) {
		commit(conn);
	} else {
		rollback(conn);
	}
	
	close(conn);
	
	return result;
}


// 수정
	
public int stdntCheck(String Name) throws Exception {
	
	Connection conn = getConnection();
	
	int count = dao.stdntCheck(conn, Name);
	
	close(conn);
	
	return count;
}
	
public int updateStdnt(String stdName, String stdAge, String score, String Name) throws Exception{
	
	Connection conn = getConnection();
	
	int result = dao.updateStdnt(conn, stdName, stdAge, score, Name);
	
	
	if(result > 0) commit(conn);
	else		   rollback(conn);
	
	close(conn);
	
	return result;
}


	
	
	
	
	
}
