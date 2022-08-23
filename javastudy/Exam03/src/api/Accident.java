package api;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Accident {

	private String occrrncDt; // 발생월일시 (2019011622)
	private String occrrncDayCd;  // 발생요일코드 (4)
	private int dthDnvCnt;  // 사망자수 (0)
	private int injpsnCnt;  // 부상자수 (1)
}
