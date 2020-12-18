package com.team404.myweb;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team404.command.FreeBoardVO;
import com.team404.common.util.Criteria;
import com.team404.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springconfig/DB-context.xml")
public class PagingTest {
	
	@Autowired
	private TestMapper testMapper;
	
//	@Test
	public void Test() {
		System.out.println(testMapper);
		for(int i = 1; i <= 100; i++) {
			FreeBoardVO vo = new FreeBoardVO();
			vo.setTitle("aa제목" + i);
			vo.setWriter("aa작성자" + i);
			vo.setContent("aa" + i);
			
			testMapper.insertTest(vo);
		}
	}
	/////////////////////////////////////////////////////
	
	@Test //데이터 조회 테스트(페이징처리)
	public void test2() {
		Criteria cri = new Criteria();
//		Criteria cri = new Criteria(3, 10);
		ArrayList<FreeBoardVO> list = testMapper.selectTest(cri);
		
		System.out.println(list.toString());
	}
	
	
	
	
	
}





























