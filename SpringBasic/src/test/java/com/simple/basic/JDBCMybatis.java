package com.simple.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.command.BoardVO;
import com.simple.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class JDBCMybatis {

	// 1.세션팩토리 빈 주입 확인
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;

	// 2. TestMapper인터페이스 주입
	@Autowired
	private TestMapper testMapper;

	// 마이바티스 객체 확인
//	@Test
//	public void test() {
//		System.out.println(sqlSessionFactory);
//	}
//
//	@Test
//	public void testGetTime() {
//		System.out.println(testMapper.getTime());
//	}

	// insert구문의 값을 전달하라 때는, 단일값 or VO를 통해서 전달 or Map으로 전달
	// vo를 통한 전달 구문
//	@Test
//	public void insertTest() {
//		for (int i = 1; i <= 10; i++) {
//			BoardVO vo = new BoardVO();
//			vo.setName("홍길동" + i);
//			vo.setTitle("테스트" + i);
//			vo.setContent("테스트" + i);
//			testMapper.insert(vo);
//		}
//	}

	// Map을 통한 전달구문
//	@Test
//	public void insertTest() {
//		Map<String, String> map = new HashMap<>();
//		map.put("name", "홍길자");
//		map.put("title", "Map을 통한 insert");
//		map.put("content", "Map을 통한 insert");
//		
//		testMapper.insert(map);
//	}

	// select VO로 받아오기
//	@Test
	public void selectTest() {
		ArrayList<BoardVO> list = testMapper.getList();
		System.out.println("반환결과: " + list.toString());

	}

	// 10번 게시글의 단일 조회
//	@Test
	public void selectTest2() {
		BoardVO vo = testMapper.getListOne(10);
		System.out.println("단일조회 결과: " + vo);

	}

	// 2개의 파라미터를 전달할 경우...
//	@Test
	public void getListTwo() {
		ArrayList<BoardVO> list = testMapper.getListTwo("홍길동", "테스트");
		System.out.println("두개파라미터 전달 결과: " + list.toString());
	}

	// 게시글 수정 테스트
	// update태그를 이용합니다.
	// VO객체를 이용해서 수정내용(글 제목, 글 내용)을 입력하고
	// 10번 게시글을 수정해보세요
	@Test
	public void updateTest() {

		BoardVO vo = new BoardVO();
		vo.setNum(10);
		vo.setTitle("update테스트");
		vo.setContent("update테스트");

		int result = testMapper.update(vo);// 반환결과 받기
		System.out.println("update성공 여부:" + result);

	}

	// 게시글 삭제 리스트
	// delete태그를 이요ㅕㅇ한다
	// 3번게시글을 삭제하는 구문을 작성(삭제 결과여부도 확인)
//	@Test
	public void delete() {
		boolean result = testMapper.delete(3);
		System.out.println("삭제여부 + " + result);
	}

}
