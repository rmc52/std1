package jhctpj.view;

import static jhctpj.common.jdbctemplate.close;
import static jhctpj.common.jdbctemplate.commit;
import static jhctpj.common.jdbctemplate.getConnection;
import static jhctpj.common.jdbctemplate.rollback;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

import jhctpj.dto.stdnt;
import jhctpj.service.stdservice;




public class stdntview {
	
	
	
	
	
	

	private Scanner sc = new Scanner(System.in);
	private stdservice service = new stdservice();
	
	
	
public void mainMenu() {
		
		int input = 0;
		
		do {
			try {
				
				
				System.out.println("1.학생 조회");
				System.out.println("2.학생 추가");
				System.out.println("3.학생 삭제");
				System.out.println("4.학생 수정");
				
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 선택 : ");
			
				input = sc.nextInt();
				sc.nextLine(); 
				
				switch(input) {
				
				case 1: selectstdnt(); break;
				
				case 2: insertstdnt(); break;
				case 3: deleteStdnt(); break;
				case 4: updateStdnt(); break;
				
				
				case 0 : System.out.println("\n 프로그램 종료 \n"); break;
				default: System.out.println("\n 번호만 입력 \n");
				}
				
				System.out.println("\n ---------------------- \n");
				
			} catch (InputMismatchException e) {
				
				System.out.println("\n 잘못 입력 \n");
				
				input = -1; 
				sc.nextLine(); 
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}while(input != 0);
		
	} 
	
	
	


// 등록

private void insertstdnt() throws Exception{
	
	System.out.println("\n=== 1. 학생 등록 ===\n");
	
	System.out.print("이름 : ");
	String stdName = sc.next();
	
	System.out.print("나이 : ");
	String stdAge = sc.next();
	
	System.out.print("성별 : ");
	String stdGender = sc.next();
	
	System.out.print("성적 : ");
	String score = sc.next();
	

	stdnt stdnt = new stdnt();
	
	
	stdnt.setStdName(stdName);
	stdnt.setStdAge(stdAge);
	stdnt.setStdGender(stdGender);
	stdnt.setScore(score);
	
	
	int result = service.insertstdnt(stdnt);
	
	
	if(result > 0) {
		System.out.println("\n" + stdName + " 학생이 등록되었습니다.\n");
	} else {
		System.out.println(" \n 등록 실패 \n ");}
		}





// 조회


private void selectstdnt() throws Exception{
	System.out.println("\n 검색 회원 조회 \n");
	
	
	
	System.out.print("입력 : ");
	String input = sc.nextLine();
	
	stdnt stdnt = service.selectstdnt(input);
	
	if(stdnt == null) {
		System.out.println("검색 결과 없음");
		return;
	}
	
	
		System.out.println(stdnt);
	
	

}

	
	

/// 삭제

private void deleteStdnt() throws Exception{
	System.out.println("\n 삭제 \n");
	
	System.out.print("삭제할 사용자 이름 : ");
	
	
	String input = sc.nextLine();
	

	int result = service.deleteStdnt(input);
	
	
	
	if(result >0 ) System.out.println("삭제 성공");
	else 		  System.out.println(" 존재하지 않음");

	
}


// 수정



private void updateStdnt() throws Exception {
	
	//
	
	String Name = null; 

	System.out.print("ID : ");
	Name = sc.next();
		
		
	int count = service.stdntCheck(Name);
		
		
	
	if(count == 1) { 
			
	System.out.print("수정할 이름 : ");
	String stdName = sc.next();
		
	System.out.print("수정할 나이 : ");
	String stdAge = sc.next();
	
	System.out.print("수정할 성적 : ");
	String score = sc.next();
	
	
	int result = service.updateStdnt(stdName, stdAge, score, Name);
	
	if(result >0 ) System.out.println("수정 성공");
	else 		  System.out.println("오류입니다");
	
	}
		
	
		
	
	
	
	}
	
	
	
	
	
	
	



	
	
	
	
	
}
