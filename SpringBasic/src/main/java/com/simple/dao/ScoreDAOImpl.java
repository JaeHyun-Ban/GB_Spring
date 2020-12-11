package com.simple.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;

@Repository("scoreDAO") //scoreDAO이름으로 bean생성(@Repository = @Service)
public class ScoreDAOImpl implements ScoreDAO {
	
//	//DB라고 가정
//	private ArrayList<ScoreVO> list = new ArrayList<>();
//	
//	//DB관련된 작업
//	@Override
//	public void scoreRegits(ScoreVO vo) {
//		// 복잡한 과정을 처리할 때 처리과정을 진행하는 곳
//		// or 복잡하지 않다면 다음 영역으로 보내주는 역할
//		System.out.println(vo.toString());
//		list.add(vo);
//	}
//	
//	@Override
//	public ArrayList<ScoreVO> getList() {
//		
//		return list;
//	}
//	
//	@Override
//	public void scoreDelete(int index) {
//		list.remove(index);
//	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;//jdbc템플릿 주입
	
	@Override
	public void scoreRegits(ScoreVO vo) {
		String sql = "INSERT INTO score VALUES(score_seq.nextval, ?, ?, ?, ?)";
		
		//jdbcTemplate.update(sql문, 넘어온 vo값들)
		//insert, update, delete는 jdbc템플릿 update(sql문, 바인딩값)이 대신한다
		jdbcTemplate.update(sql, new Object[] {vo.getName(), vo.getKor(), vo.getEng(), vo.getMath()});
		
	}

	@Override
	public ArrayList<ScoreVO> getList() {

		String sql = "SELECT * FROM score";

		//RowMapper<반환타입>
		List<ScoreVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<ScoreVO>() {
			@Override
			public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				//제네릭에는 select구문을 처리해줄 vo객체를 적어준다
				//mapRow메서드에는 select구문의 처리결과를 넣어주는데, 
				//개발자는 resultSet을 어떻게 처리할지 구문만 작성하면 된다.
				
				//rowNum수만큼 알아서 반복(회원)해준다
				ScoreVO vo = new ScoreVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));
				vo.setMath(rs.getString("math"));
						
				return vo;
			}
		});
		
		
		return (ArrayList<ScoreVO>) list;
	}

	@Override
	public void scoreDelete(int index) {
		
		String sql = "DELETE FROM score WHERE num = ?";
		
		jdbcTemplate.update(sql, new Object[] {index});
		
		
		
	}

	
	
}




























