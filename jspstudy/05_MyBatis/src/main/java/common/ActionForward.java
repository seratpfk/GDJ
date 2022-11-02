package common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionForward { // ActionForward: 모든 작업을 끝내고서 이동하는 위치을 가상적으로 지정한 것
	private String view; // 응답할 Jsp의 이름
	private boolean isRedirect; // 이동 방식(true이면 리다이렉트, false이면 포워드)
	
	/*
	
     * forward : request를 비롯한 컨텍스트가 보존된다.
                     동일 웹 어플리케이션에서만 사용가능하다.
                     웹 브라우저는 포워드 된 사실을 모른다.
     * redirect : 웹 브라우저가 새로운 HTTP요청을 생성하도록 한다.
                     request 컨텍스트가 보존되지 않는다.
                     동일 웹 어플리케이션이 아니어도 된다.
	 */
}
