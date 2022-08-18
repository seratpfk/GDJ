package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class Main {
	
	public static void m1() {
		
		// 보건복지부_코로나 19 감염현황 조회 서비스
		
				// 인증키(Decoding)
				String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";

				// API 주소	(주소 + 요청 파라미터)
				StringBuilder urlBuilder = new StringBuilder();
				try {
					urlBuilder.append("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
					urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
					urlBuilder.append("&startCreateDt=20220808");
					urlBuilder.append("&endCreateDt=20220812");

				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				String apiURL = urlBuilder.toString();
				
				// API 주소 접속
				URL url = null;
				HttpURLConnection con = null;
				
				try {			
					url = new URL(apiURL);
					con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
				} catch(MalformedURLException e) {
					System.out.println("API 주소 오류");
				} catch(IOException e) {
					System.out.println("API 접속 실패");
				}
				
				// 입력 스트림 생성
				// 1. 서버가 보낸 데이터를 읽어야 하므로 입력 스트림이 필요
				// 2. 서버와 연결된 입력 스트림은 바이트 스트림이므로 문자 스트림으로 변환해야 함
				BufferedReader reader = null;
				StringBuilder sb = new StringBuilder();
				try {
					
					if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
						reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
					} else {
						reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
					}
					
					String line = null;
					while((line = reader.readLine()) != null) {
						sb.append(line + "\n");
					}
					
					// 스트림 종료
					reader.close();
					
				} catch(IOException e) {
					System.out.println("API 응답 실패");
				}
				
				// API로부터 전달받은 xml 데이터
				String response = sb.toString();
				
				// XML File 생성
				File file = new File("C:\\storage", "api2.xml");
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					bw.write(response);
					bw.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
	}
	
	public static void m2() {
		
		// xml 파싱
		
		File file = new File("C:\\storage", "api2.xml");
		
		try {
			
			// api2.xml 문서 -> doc 객체
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file); // doc = "api2.xml"
			
			// api2.xml 문서의 최상위 태그 -> root
			Element root = doc.getDocumentElement();
			
			// <item>...</item> 태그 하나 == 특정 날짜의 데이터
			StringBuilder sb = new StringBuilder();
			NodeList items = root.getElementsByTagName("item"); // 태그 이름으로 찾기
			
			// 잘 가져왔는지 확인
			for(int i = 0; i < items.getLength(); i++) {
				Node item = items.item(i);
				NodeList itemChildren = item.getChildNodes();
				for(int j = 0; j < itemChildren.getLength(); j++) {
					Node itemChild = itemChildren.item(j);
					if(itemChild.getNodeName().equals("stateDt")) {
						sb.append(" 날짜 : ").append(itemChild.getTextContent());
					}
					else if(itemChild.getNodeName().equals("decideCnt")) {
						sb.append(" 확진자수 : ").append(itemChild.getTextContent());
					}
					else if(itemChild.getNodeName().equals("deathCnt")) {
						sb.append("사망자수 : ").append(itemChild.getTextContent());
					}
				}
				sb.append("\n");
				
				// Node stateDt == <stateDt>20220812</stateDt>
				// stateDt.getNodeName() == stateDt (태그이름)
				// stateDt.getTextContent() == 20220812 (태그내부텍스트)
				
			}
			System.out.println(sb.toString());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void m3() {
		
	      StringBuilder sbApiURL = null;
	      
	      // API 요청변수
	      try {
	         sbApiURL = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
	         String serviceKey = "S/M+l5y2TRDSRrmRIEX8Xjcg7bl4rnZAL/iIEPmLOt9tBrpkFTdhk3DvFsLT3fZl/4JqEP82TVdHhAVnY5Q+uQ==";
	         
	         sbApiURL.append("?ServiceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
	         sbApiURL.append("&pageNo=1");
	         sbApiURL.append("&numOfRows=1000");
	         sbApiURL.append("&dataType=XML");
	         sbApiURL.append("&base_date=20220818");
	         sbApiURL.append("&base_time=0600");
	         sbApiURL.append("&nx=58");
	         sbApiURL.append("&ny=125");
	         
	      } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	      }
	      
	      // API 주소 접속
	      URL url = null;
	      HttpURLConnection con = null;
	   
	      try {
	         url = new URL(sbApiURL.toString());
	         con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("GET");
	         con.setRequestProperty("content-Type", "application/xml; charset=UTF-8");
	         
	      } catch (MalformedURLException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      // 입력 스트림(response) 생성
	      BufferedReader reader = null;
	      StringBuilder sb = new StringBuilder();
	      
	      try {
	         if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         } else {
	            reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	         }
	         
	         String line = null;
	         while((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	         }

	         reader.close();
	         
	      } catch (IOException e) {
	         System.out.println("API 응답실패");
	      }
	      
	      // API로부터 전달받은 데이터
	      String response = sb.toString();
	      
	      // File 생성
	      File file = new File("C:\\storage", "api3.xml");
	      try {
	         BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	         bw.write(response);
	         bw.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      System.out.println(sb.toString());

	}
	
	public static void m4() {
		
		 File file = new File("C:\\storage", "api3.xml");
	      StringBuilder sb = null;
	      
	      try {
	         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder builder = factory.newDocumentBuilder();
	         Document doc = builder.parse(file);
	         
	         sb = new StringBuilder();
	         
	         Element root = doc.getDocumentElement();
	         
	         NodeList items = root.getElementsByTagName("item");
	         
	         for(int i = 0; i < items.getLength(); i++) {
	            Node item = items.item(i);
	            NodeList itemChildren = item.getChildNodes();
	            
	            for(int j = 0; j < itemChildren.getLength(); j++) {
	               Node itemChild = itemChildren.item(j);
	              // if(itemChild.getNodeName().equals(""))
	            }
	         }
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	}
	
	public static void m5() {
		
		File file = new File("C:\\storage", "api3.xml");
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();
			
			NodeList items = root.getElementsByTagName("item");
			for(int i = 0; i < items.getLength(); i++) {
				Element item = (Element)items.item(i); // Node -> Element 타입으로 다운캐스팅
				Node category = item.getElementsByTagName("category").item(0);
				Node obsrValue =  item.getElementsByTagName("obsrValue").item(0);
				String strCategory = null;
				switch(category.getTextContent()) {
				case "PTY": strCategory = "강수형태"; break;
				case "REH": strCategory = "습도"; break;
				case "RN1": strCategory = "강수량(1시간)"; break;
				case "T1H": strCategory = "기온"; break;
				case "UUU": strCategory = "동서바람성분"; break;
				case "VEC": strCategory = "풍향"; break;
				case "VVV": strCategory = "남북바람성분"; break;
				case "WSD": strCategory = "풍속"; break;
				}
				System.out.println(strCategory + ":" + obsrValue.getTextContent());
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void m6() {
		
		// 기상청 RSS
		String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013061000";
		
		// 접속
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
		
		} catch(IOException e) {
			System.out.println("접속 실패");
		}
		
		// 응답 스트림 생성 및 응답 데이터 받기
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch(IOException e) {
			System.out.println("응답 실패");
		}
		
		// XML 파일 생성
		File file = new File("C:\\storage", "api.xml");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
		} catch(IOException e) {
			System.out.println("파일 생성 실패");
		}
		
		
	}
	
	
	public static void m7() {
		
	}
	
	public static void m8() {
		
	}


	public static void m9() {
		
		File file = new File("C:\\storage", "sfc_web_map.xml");
		
		try {
			StringBuilder sb = new StringBuilder();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement(); // <current xmlns="current">태그

			Element weather = (Element)root.getElementsByTagName("weather").item(0); // -<weather hour="15" day="18" month="08" year="2022">
			sb.append(weather.getAttribute("year") + "년 ");
			sb.append(weather.getAttribute("month") + "월 ");
			sb.append(weather.getAttribute("day") + "일 ");
			sb.append(weather.getAttribute("hour") + "시\n");
			
			NodeList locals = root.getElementsByTagName("local");
			for(int i = 0; i < locals.getLength(); i++) {
				Element local = (Element)locals.item(i);
				sb.append(local.getTextContent() + ":");
				sb.append(local.getAttribute("ta") + "℃");
				sb.append(local.getAttribute("desc") + "\n");
			}
			System.out.println(sb.toString());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		m9();
		
		
	}

}
