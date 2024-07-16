package projcet1_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class project1 {

	public static void main(String[] args) {
		Member[] list = null;
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		
		try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (Member[]) ois.readObject();
			System.out.println("파일에서 객체를 가져왔습니다");
			
		}catch (IOException | ClassNotFoundException e) { //input output 예외상황
			e.printStackTrace();
		}
		for (Member member : list) {
			System.out.println(member);
		}
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum) {
			case 1:
				// 로그인 처리
				System.out.println("로그인 처리");
				
				System.out.print("아이디:");  //출력문
				String name = scanner.nextLine(); // name 변수의 값 입력
				System.out.print("패스워드:");
				String strPassword = scanner.nextLine();//패스워드입력
				
				// 찾기 전 또는 못 찾았을 때
				
				for (int i = 0; i < list.length; i++) {
					if (name.equals(list[i].name) && strPassword.equals(list[i].ssn)) {
						System.out.println("로그인 성공");
						break;
					}else {
						System.out.println("로그인 실패");
						break;
					}
				}
				break;
			case 2:
				// 회원 가입
				System.out.println("회원 가입");
				
				System.out.println("[필수 정보 입력]"); 
				System.out.print("1. 이름: ");
				String name2 = scanner.nextLine(); 
				System.out.print("2. 주민번호 앞 6자리: ");
				String ssn = scanner.nextLine(); 
				System.out.print("3. 전화번호: "); 
				String tel = scanner.nextLine();
				System.out.println();
				System.out.println("[입력된 내용]");
				System.out.println("1. 이름: " + name2);
				System.out.println("2. 주민번호 앞 6자리: " + ssn); 
				System.out.println("3. 전화번호: " + tel);
				// 객체 생성 
				break;
			case 3:
				// 예금 출금
				System.out.println("예금 출금");
				boolean run2 = true;
				int balance = 0;
				
				while (run2) {
					System.out.println("-------------------------------------");
					System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
					System.out.println("-------------------------------------");
					System.out.print("선택> ");
					int menuNum2 = Integer.parseInt(scanner.nextLine());
					switch (menuNum2) {
					case 1:
						System.out.print("예금액> ");
						balance += Integer.parseInt(scanner.nextLine());
						break;
					case 2:
						System.out.print("출금액> ");
						balance -= Integer.parseInt(scanner.nextLine());
						break;
					case 3:
						System.out.print("잔고> ");
						System.out.println(balance);
						break;
					case 4:
						run2 = false;
						break;
					}
					System.out.println();
				}
				System.out.println("예금/출금 프로그램 종료");
				break;
			case 4:
				try(FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos)){ //직렬화
					oos.writeObject(list);
					System.out.println("객체를 파일에 저장했습니다.");
					
				}catch (IOException e) {
					e.printStackTrace();
				}
				
				run = false;
				break;
			}
		}
		System.out.println("프로그램 전체 종료");
	}

}
	