package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

    public static void main(String[] args) throws Exception{
    	
    	Scanner sc = new Scanner(System.in);
		int num;
		
		List<Person> pList = new ArrayList<Person>();
		BufferedReader br = new BufferedReader(new FileReader("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt"));
		
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			
			String[] data = str.split(",");
			String name = data[0];
			String hp = data[1];
			String company = data[2];
			
			pList.add(new Person(name, hp, company));
		}
		
		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램               *");
		System.out.println("***********************************");
		
		do{
			System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호:");
			num = sc.nextInt();
			
			switch(num) {
				case 1:
					for(int i = 0 ; i < pList.size(); i++) {
						System.out.println((i+1) + ". " +pList.get(i).getName() + "    " + pList.get(i).getHp() + "    " + pList.get(i).getCompany());
					}
					System.out.println();
					break;
					
				case 2:
					
			    	BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt",true));
			    	
					System.out.println("<2.등록>");
					
					System.out.println(">이름:");
					String name = sc.next();
					
					System.out.println(">휴대전화: ");
					String hp = sc.next();
					
					System.out.println(">회사전화: ");
					String company = sc.next();
					
					pList.add(new Person(name,hp,company));
					bw.write(name + "," + hp + "," + company);
					System.out.println("[등록되었습니다.]");
					
					bw.close();
					break;
					
				case 3:
			    	BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt"));
					
					System.out.println("<3.삭제>");
					System.out.println(">번호: ");
					int deleteNum = sc.nextInt();
					
					pList.remove(deleteNum - 1);
					for(Person p: pList) {
						bw1.write(p.getName() + "," + p.getHp() + "," + p.getCompany());
						bw1.newLine();
					}
					System.out.println("삭제되었습니다.");
					bw1.close();
					break;
				case 4:
					System.out.println("<4.검색>");
					System.out.print("이름:");
					String part = sc.next();
					
					for(int i = 0; i < pList.size(); i++) {
						if((pList.get(i).getName()).contains(part) ) {
							System.out.println((i+1) + ". " + pList.get(i).getName() + "    " + pList.get(i).getHp() + "   " + pList.get(i).getCompany());
						}
					}
					break;
				case 5:
					System.out.println("***********************************");
					System.out.println("		  감사합니다.   			");
					System.out.println("***********************************");
					break;
					
				default:
					System.out.println("[다시 입력해 주세요.]");
					break;
				}
		}while(!(num == 5));
		
		br.close();
    	
    }

}