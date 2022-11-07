package repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;


public class FreeDAO {

	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	// singleton pattern
	private static FreeDAO dao = new FreeDAO();
	private FreeDAO() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static FreeDAO getInstance() {
		return dao;
	}
	
	// method
	
	String mapper = "mybatis.mapper.free.";
	
	// 1. 학생목록
	public List<Free> selectAllFrees() {
		SqlSession ss = factory.openSession();
		List<Free> frees = ss.selectList(mapper + "selectAllFrees");
		ss.close();
		return frees;
	}
	
	// 2. 전체학생수
	public int selectAllFreesCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectAllFreesCount");
		ss.close();
		return count;
	}
	
	// 4. 학생등록
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertFree", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 8. 학생삭제
	public int deleteFree(int freeNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteFree", freeNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 9. 학생상세보기
	public Free selectFreeByNo(int freeNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne(mapper + "selectFreeByNo", freeNo);
		ss.close();
		return free;
	}
	
	// 10. 학생수정
	public int updateFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(mapper + "updateFree", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 11. TOP3
	public List<Free> selectFreesTop3() {
		SqlSession ss = factory.openSession();
		List<Free> top3 = ss.selectList(mapper + "selectFreesTop3");
		ss.close();
		return top3;
	}
	
	
	
	
	
}