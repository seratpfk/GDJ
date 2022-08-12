package ex05_inputstream;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void m1() {
		
		File file = new File("C:\\storage", "b1.bin");
		FileInputStream fis = null;
		
		try {
			
			// 바이트 입력 스트림 생성
			fis = new FileInputStream(file);
			
			// 입력 데이터 단위
			// 1. 1개 : int
			// 2. 여러 개 : byte[]
			
			// 모든 정보를 StringBuilder에 저장한 뒤 확인
			StringBuilder sb = new StringBuilder();
			byte[] b = new byte[5];  // 5바이트씩 읽기 위해서 준비
			int readByte = 0;
			
			// int read(byte[] b)
			// 읽은 내용은 byte배열 b에 저장
			// 읽은 바이트 수는 반환
			// 읽은 내용이 없으면 -1을 반환
			
			while ((readByte = fis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte));
			}
			
			// 문자를 바이트 스트림으로 읽었기 때문에
			// 문제가 발생
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m2() {
		
		// 바이트 입력스트림을 문자 입력 스트림으로 변환 InputStreamReader
		
		File file = new File("C:\\storage", "b2.bin");
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
			
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[5];  // 5글자씩 읽기 위해서
			int readCnt = 0;
			
			while((readCnt = isr.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCnt);
			}
			
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(isr != null) isr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void m3() {
		
		// 변수를 그대로 입력 받는 DataInputStream
		
		File file = new File("C:\\storage", "b3.dat");
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			
			String name = dis.readUTF();
			int age = dis.readInt();
			double height = dis.readDouble();
			
			System.out.println(name + "," + age + "," + height);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dis != null) dis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void m4() {
		
	}

	public static void main(String[] args) {
		
		m3();

	}

}
