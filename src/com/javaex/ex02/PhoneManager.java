package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javaex.ex01.Person;

public class PhoneManager {

	private List<Person> pList;
	private Scanner sc = new Scanner(System.in);
	
	public PhoneManager() {
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

		try {
			pList = getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 시작준비 (시작화면 출려과 리스트 가져온다)
	public void showTitle() throws Exception {
		Reader fr;
			System.out.println("***********************************");
			System.out.println("*         전화번호 관리 프로그램               *");
			System.out.println("***********************************");
	}

	// 메뉴 출력과 입력을 받는다.
	public int showMenu() {
		System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
		System.out.println("------------------------------------");
		System.out.print(">메뉴번호:");
		
		return sc.nextInt();
	}

	// 1.리스트선택시
	public void showList() {
		for(int i = 0 ; i < pList.size(); i++) {
			System.out.println((i+1) + ". " +pList.get(i).getName() + "    " + pList.get(i).getHp() + "    " + pList.get(i).getCompany());
		}
		System.out.println();
	}

	// 2.등록선택시
	public void showAdd() throws IOException {
		System.out.println("<2.등록>");
		
		System.out.println(">이름:");
		String name = sc.next();
		
		System.out.println(">휴대전화: ");
		String hp = sc.next();
		
		System.out.println(">회사전화: ");
		String company = sc.next();
		
		pList.add(new Person(name,hp,company));
		saveList();
		
		System.out.println("[등록되었습니다.]");
	}

	// 3.삭제선택시
	public void showRemove() throws IOException {
		System.out.println("<3.삭제>");
		System.out.println(">번호: ");
		int deleteNum = sc.nextInt();
		
		pList.remove(deleteNum - 1);
		saveList();
		System.out.println("삭제되었습니다.");
	}

	// 4.검색선택시
	public void showSearch() {
		System.out.println("<4.검색>");
		System.out.print("이름:");
		
		printList(sc.next());
		
	}

	// 5.종료시
	public void showEnd() {
		System.out.println("***********************************");
		System.out.println("		  감사합니다.   			");
		System.out.println("***********************************");
	}
	
	
	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {
		System.out.println("[다시 입력해 주세요.]");
	}
	
	
	// 파일을 읽어 리스트에 담아 전달한다.
	private List<Person> getList() throws Exception{
		Reader fr = new FileReader("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		List<Person> pList = new ArrayList<Person>();
		
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			
			String[] data = str.split(",");
			String name = data[0];
			String hp = data[1];
			String company = data[2];
			
			pList.add(new Person(name, hp,company));
			
		}
		fr.close();
		return pList;
	}

	// 리스트를 파일에 저장한다.
	private void saveList() throws IOException {
		Writer fw = new FileWriter("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(Person p : pList) {
			bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany());
			bw.newLine();
		}
		bw.close();
	}

	// 전체 리스트를 출력한다
	private void printList() {
		showList();
	}

	// 키워드로 검색한 리스트를 출력한다
	private void printList(String keyword) {
		
		for(int i = 0; i < pList.size(); i++) {
			if((pList.get(i).getName()).contains(keyword) ) {
				System.out.println((i+1) + ". " + pList.get(i).getName() + "    " + pList.get(i).getHp() + "   " + pList.get(i).getCompany());
			}
		}
	}
	
}
