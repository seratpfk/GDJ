package com.gdu.app02.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app02.domain.BlogDTO;
import com.gdu.app02.mapper.BlogMapper;
import com.gdu.app02.util.MyFileUtil;
import com.gdu.app02.util.PageUtil;

@Service
public class BlogServiceImpl implements BlogService {

   // @컴포넌트~ 스프링이 뉴 페이지유틸 해서 갖고 있단 의미. 스프링이 페이지유틸 객체를 가지고 있따는 의미
   // 가져다 쓰는게 @오토와이어드  
   private BlogMapper blogMapper;
   private PageUtil pageUtil;
   private MyFileUtil myFileUtil;
   
   @Autowired    // autowired가 적용되는 곳은 아래 매개변수. 매개변수로 주입된다   -> @Autowired를 하나만 쓸 때 이런식으로 작성한다.  
   public void set(BlogMapper blogMapper, PageUtil pageUtil, MyFileUtil myFileUtil) {
      this.blogMapper = blogMapper;
      this.pageUtil = pageUtil;
      this.myFileUtil = myFileUtil;
   }
   
   @Override
   public void getBlogList(Model model) {
      
      // Model에 저장된 request 꺼내기
      Map<String, Object> modelMap = model.asMap();   // model을 map으로 변신
      HttpServletRequest request = (HttpServletRequest)modelMap.get("request");  //
      
      // 페이징처리하면 꼭 들어와야하는게 page!!! 
      // 파라미터
      Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
      int page = Integer.parseInt(opt.orElse("1"));
      
      // 전체 블로그 개수
      int totalRecord = blogMapper.selectBlogListCount();   // 전체 블로그 갯수는 db에서 구해온다.
      
      // 페이징 처리에 필요한 변수 계산
      pageUtil.setPageUtil(page, totalRecord);
      
      // 조회 조건으로 사용할 Map 만들기
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("begin", pageUtil.getBegin()); // 페이지유틸에 계산 끝났으니까 begin값은 페유틸에 들어있음당
      map.put("end", pageUtil.getEnd());
      
      // 뷰로 전달할 데이터를 model에 저장하기
      model.addAttribute("totalRecord", totalRecord);
      model.addAttribute("blogList", blogMapper.selectBlogListByMap(map));
      model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage()); // 순번만들때 필요한거 모델에 실어드릴게
      model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/blog/list"));    // 완성된 번호 텍스트로 받아서 넘기깅(getPaging()에 경로path만 넘겨주면 다 작성되게 String으로 넘겨줌)
   
            // 뭘 누르든 어차피 blogList. 
   		}
   
   		@Override
		public void saveBlog(HttpServletRequest request, HttpServletResponse response) {
			
   			// 파라미터 title, content
   			String title = request.getParameter("title");
   			String content = request.getParameter("content");
   			
   			// 작성자의 ip
   	       // 작성된 내용이 어딘가를 경유해서 도착하면 원래 ip가 X-Forwarded-For라는 요청헤더에 저장
   	       // 출발       경유      도착
   	       // 1.1.1.1   2.2.2.2    2.2.2.2  : request.getRemoteAddr()
   	       //                      1.1.1.1  : request.getHeader("X-Forwarded-For")
		 	Optional<String> opt = Optional.ofNullable("X-Forwarded-For");
			String ip = opt.orElse(request.getRemoteAddr());
			
			// DB로 보낼 BlogDTO
			BlogDTO blog = BlogDTO.builder()
					.title(title)
					.content(content)
					.ip(ip)
					.build();
			
			// DB에 저장
			int result = blogMapper.insertBlog(blog);
			
			// 응답
			try {
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				if(result > 0) {
					
					out.println("<script>");
					out.println("alert('삽입 성공');");
					out.println("location.href='"+ request.getContextPath() +"/blog/list';");
					out.println("</script>");
				} else {
					out.println("<script>");
					out.println("alert('삽입 실패');");
					out.println("history.back();");
				}
				out.println("</script>");
				out.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
   		
   		@Override
		public Map<String, Object> saveSummernoteImage(MultipartHttpServletRequest multipartRequest) {
			
   			// 파라미터 file
   			MultipartFile multipartFile = multipartRequest.getFile("file");
   			
   			// 저장할 파일명
   			String filesystem = myFileUtil.getFilename(multipartFile.getOriginalFilename());
   			
   			// 저장 경로
   			String path = "C:\\upload";
   			
   			// 저장 경로가 없으면 만들기
   			File dir = new File(path);
   			if(dir.exists() == false) {
   				dir.mkdirs();
   			}
   			
   			// 저장할 File 객체
   			File file = new File(path, filesystem);  // new File(dir, filesystem)도 가능
   			
   			// HDD에 File 객체 저장하기
   			try {
   				
   				multipartFile.transferTo(file);
   				
   			} catch (Exception e) {
   				e.printStackTrace();
   			}
   			
   			// 저장된 파일을 확인할 수 있는 매핑을 반환
   			Map<String, Object> map = new HashMap<String, Object>();
   			map.put("src", multipartRequest.getContextPath() + "/load/image/" + filesystem);
   			
			return map;
			
			// 저장된 파일이 aaa.jpg라고 가정하면
			//	${contextPath}
		}
   		
   		
   		@Override
   		public int increseBlogHit(int blogNo) {
   			return blogMapper.updateHit(blogNo);
   			
   		}
   		
   		@Override
   		public BlogDTO getBlogByNo(int blogNo) {
   	      return blogMapper.selectBlogByNo(blogNo);
   	      
   	   }
   		
   		
   		@Override
   		public void modifyBlog(HttpServletRequest request, HttpServletResponse response) {
   			
   			// 파라미터 title, content, blogNo
   			String title = request.getParameter("title");
   			String content = request.getParameter("content");
   			int blogNo = Integer.parseInt(request.getParameter("blogNo"));
   			
   			// DB로 보낼 BlogDTO
   			BlogDTO blog = BlogDTO.builder()
   					.title(title)
   					.content(content)
   					.blogNo(blogNo)
   					.build();
   			
   			// DB 수정
   			int result = blogMapper.updateBlog(blog);
   			
   			// 응답
   			try {
   				
   				response.setContentType("text/html; charset=UTF-8");
   				PrintWriter out = response.getWriter();
   				
   				out.println("<script>");
   				if(result > 0) {			
   					out.println("alert('수정 성공');");
   					out.println("location.href='" + request.getContextPath() + "/blog/detail?blogNo=" + blogNo + "';");
   				} else {
   					out.println("alert('수정 실패');");
   					out.println("history.back();");
   				}
   				out.println("</script>");			
   				out.close();
   				
   			} catch (Exception e) {
   				e.printStackTrace();
   			}
   			
   		}
   		
   		@Override
   		public void removeBlog(HttpServletRequest request, HttpServletResponse response) {
   			
   			// 파라미터 blogNo
   			int blogNo = Integer.parseInt(request.getParameter("blogNo"));
   			
   			// DB 삭제
   			int result = blogMapper.deleteBlog(blogNo);
   			
   			// 응답
   			try {
   				
   				response.setContentType("text/html; charset=UTF-8");
   				PrintWriter out = response.getWriter();
   				
   				out.println("<script>");
   				if(result > 0) {			
   					out.println("alert('삭제 성공');");
   					out.println("location.href='" + request.getContextPath() + "/blog/list';");
   				} else {
   					out.println("alert('삭제 실패');");
   					out.println("history.back();");
   				}
   				out.println("</script>");			
   				out.close();
   				
   			} catch (Exception e) {
   				e.printStackTrace();
   			}
   			
   		}
	
   		
   		
   }
   