package com.javaex.ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.javaex.ex03.Person;

public class PhoneRepository {
	
	Reader fr;
	BufferedReader br ;
	
	private List<Person> pList;
    //phoneDB.txt 파일을 읽어 모든 전화번호(리스트)를 전달하는 메소드
	public List<Person> getList() throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt"));
		pList = new ArrayList<Person>();
		
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

	//phoneDB.txt 에 모든 전화번호 리스트를 저장하는 메소드
	private void saveInfo(List<Person> list) throws Exception{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\javaStudy\\workspace\\minipro\\PhoneDB.txt"));
		
		for(Person p : list) {
			bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany());
			bw.newLine();
		}
		bw.close();
	}
	
	//기존데이터에 새로입력받은 데이터를 추가하여 모두저장하는 메소드 
	public void addInfo(Person phoneVO) throws Exception {
		pList.add(phoneVO);
		saveInfo(pList);
	}

	//선택한 번호의 데이터를 삭제하고 저장하는 메소드(모두 다시저장)
	public void delInfo(int num) throws Exception {
		pList.remove(num - 1);
		saveInfo(pList);
	}
	

}
