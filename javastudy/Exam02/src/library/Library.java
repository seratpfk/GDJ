package library;

import java.util.Scanner;

public class Library {
	
	private Scanner sc;
	private Book[] books;
	private int idx;
	
	public Library() {
		sc = new Scanner(System.in);
		books = new Book[100];
	}
	
	private void addBook() {
		if(idx == books.length) { // 인덱스와 배열의 길이가 같으면 꽉 찬 상태
			System.out.println("더 이상 등록할 수 없습니다.");
			return;
		}
		System.out.println("===책 등록===");
		System.out.print("제목 입력 >>> ");
		String title = sc.next();
		System.out.print("저자 입력 >>> ");
		String author = sc.next();
		Book book = new Book(idx + 1, title, author);
		books[idx++] = book;
	}
	
	private void removeBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("===책 삭제===");
		System.out.print("삭제할 책의 번호(1~" + idx + ") >>> ");
		int bookNo = sc.nextInt() - 1;
		if(bookNo < 0 || bookNo >= idx) {
			System.out.println("책 번호가 " + (bookNo + 1) + "인 책은 없습니다.");
			return;
		}
		System.arraycopy(books, bookNo + 1, books, bookNo, idx - bookNo -1);
		books[--idx] = null;
		System.out.println("책 번호가 " + (bookNo + 1) + "인 책을 삭제했습니다.");
	}
	
	private void findBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("===책 조회===");
		System.out.print("조회할 책 제목 입력 >>> ");
		String title = sc.next();
		for(int i = 0; i < idx; i++) {
			// 저장된 책 제목 : books[i].getTitle()
			// 조회할 책 제목 : title
			// String의 동등비교 : equals() 메소드
			if(title.equals(books[i].getTitle())) {
				System.out.println(books[i]);
				return;  // findBook() 메소드 종료
			}
		} // for문이 끝나고 출력
		System.out.println("제목이 " + title + "인 책은 없습니다.");
	}
	
	private void printAllBooks() {  // 비어있는지 체크
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("===전체 조회===");
		for(int i = 0; i < idx; i++) {
			System.out.println(books[i]);
		}
	}
	
	public void manage() {
		while(true) {
			System.out.print("1. 추가 2. 삭제 3. 조회. 4.전체목록 0.프로그램 종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1: addBook(); break;
			case 2: removeBook(); break;
			case 3: findBook(); break;
			case 4: printAllBooks(); break;
			case 0: System.out.println("Library 프로그램을 종료합니다. 감사합니다.");
					return;  // manage() 메소드 종료
			default: System.out.println("알 수 없는 명령입니다. 다시 시도하세요.");
			}
		}
	}

}
