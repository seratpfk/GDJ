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
	public List<Free> selectAllStudents() {
		SqlSession ss = factory.openSession();
		List<Free> students = ss.selectList(mapper + "selectAllStudents");
		ss.close();
		return students;
	}
	
	// 2. 전체학생수
	public int selectAllStudentsCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectAllStudentsCount");
		ss.close();
		return count;
	}
	
	// 3. 전체평균
	public double selectAllStudentsAverage() {
		SqlSession ss = factory.openSession();
		double average = ss.selectOne(mapper + "selectAllStudentsAverage");
		ss.close();
		return average;
	}
	
	// 4. 학생등록
	public int insertStudent(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertStudent", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 5. 평균범위조회
	public List<Free> selectStudentsByAve(Map<String, Double> map) {
		SqlSession ss = factory.openSession();
		List<Free> frees = ss.selectList(mapper + "selectStudentsByAve", map);
		ss.close();
		return frees;
	}
	
	// 6. 평균범위조회 : 개수
	public int selectStudentsByAveCount(Map<String, Double> map) {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectStudentsByAveCount", map);
		ss.close();
		return count;
	}
	
	// 7. 평균범위조회 : 평균
	public double selectStudentsByAveAverage(Map<String, Double> map) {
		SqlSession ss = factory.openSession();
		double average = ss.selectOne(mapper + "selectStudentsByAveAverage", map);
		ss.close();
		return average;
	}
	
	// 8. 학생삭제
	public int deleteStudent(int stuNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteStudent", stuNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 9. 학생상세보기
	public Free selectStudentByNo(int stuNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne(mapper + "selectStudentByNo", stuNo);
		ss.close();
		return free;
	}
	
	// 10. 학생수정
	public int updateStudent(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(mapper + "updateStudent", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 11. TOP3
	public List<Free> selectStudentsTop3() {
		SqlSession ss = factory.openSession();
		List<Free> top3 = ss.selectList(mapper + "selectStudentsTop3");
		ss.close();
		return top3;
	}
	
	
	
	
	
}