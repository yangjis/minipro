package com.javaex.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//화면과 관련된 기능을 담당합니다.

public class PhoneView {

	private Scanner sc;
	private List<Person> strL = new ArrayList<Person>();

	// 생성자: 입력을 위하여 스캐너를 생성합니다.
	public PhoneView() {
		this.sc = new Scanner(System.in);
	}

	// 프로그램 시작시 안내 문구를 출력하는 메소드
	public void showStart() {
		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램               *");
		System.out.println("***********************************");
	}

	// 메뉴를 출력하고 메뉴번호 입력을 받아 입력된 메뉴번호를 전달하는 메소드
	public int showMenu() {
		System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
		System.out.println("------------------------------------");
		System.out.print(">메뉴번호:");
		int num = sc.nextInt();
		
		return num;
	}

	// 1.리스트 : 데이터를 받아 리스트를 출력하는 메소드
	public void showList(List<Person> phoneList) {
		
		for(int i = 0; i < phoneList.size(); i++) {
			System.out.println((i+1) + ". " + phoneList.get(i).getName() + "    " + phoneList.get(i).getHp() + "   " + phoneList.get(i).getCompany());
		}
		System.out.println();
	}

	// 2.등록 : 등록을 위한 화면을 출력하고 사용자가 입력한 데이트를 받아 Person의 인스턴스에 담아 전달하는 메소드
	public Person showAdd() {
		System.out.println("<2.등록>");
		
		System.out.println(">이름:");
		String name = sc.next();
		
		System.out.println(">휴대전화: ");
		String hp = sc.next();
		
		System.out.println(">회사전화: ");
		String company = sc.next();
		
		Person p = new Person(name,hp,company);
		
		return p;
		
	}

	// 등록 완료시 결과 출력 메소드
	public void showAddResult() {
		System.out.println("[등록되었습니다.]");

	}

	// 3.삭제 : 삭제를 위한 화면을 출력하고 사용자가 선택한 번호를 입력받아 전달하는 메소드
	public int showDel() {
		System.out.println("<3.삭제>");
		System.out.println(">번호: ");
		return sc.nextInt();
	}

	// 삭제완료시 결과 출력 메소드
	public void showDelResult() {
		System.out.println("삭제되었습니다.");
	}

	// 4.검색 : 검색을 위한 화면을 출력하고 사용자가 입력한 검색키워드를 입력받아 전달하는 메소드
	public String showSearch() {
		System.out.println("<4.검색>");
		System.out.print("이름:");
		return sc.next();
	}

	// 검색결과를 가져와 화면에 출력하는 메소드
	public void showSearchResult(List<Person> phoneList, String keyword) {
		for(int i = 0; i < phoneList.size(); i++) {
			if((phoneList.get(i).getName()).contains(keyword) ) {
				System.out.println((i+1) + ". " + phoneList.get(i).getName() + "    " + phoneList.get(i).getHp() + "   " + phoneList.get(i).getCompany());
			}
		}
	}

	// 메뉴번호를 잘못 입력시 안내문구를 출력하는 메소드
	public void showEtc() {
		System.out.println("[다시 입력해 주세요.]");
	}
	
	
	// 종료시 안내 문구를 출력하는 메소드
	public void showEnd() {
		System.out.println("***********************************");
		System.out.println("		  감사합니다.   			");
		System.out.println("***********************************");
	}
}
