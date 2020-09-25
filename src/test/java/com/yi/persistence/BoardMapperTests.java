package com.yi.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.BoardVO;
import com.yi.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

//	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

//	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setName("새로 작성하는 이름");
		board.setAge(20);
		board.setAddress("주소");
		board.setCphone("전화번호");

		mapper.insert(board);
	}

	@Test
	public void testRead() {
		BoardVO board = mapper.read("김석진");

		log.info(board);
		System.out.println(board.getAddress());
		System.out.println(board.getAge());
		System.out.println(board.getName());
	}

	@Test
	public void testDelete() {
		log.info("지워졌네요" + mapper.delete(2));
	}
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setMid(12);
		board.setName("김아미");
		board.setAddress("대구");
		board.setAge(20);
		board.setCphone("010-7777-1212");
		
		int count = mapper.update(board);
		log.info("잘 수정했어요" + count);
	}

}