package com.newlecture.web.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;


@AutoConfigureTestDatabase(replace = Replace.NONE)
//@MybatisTest
@SpringBootTest
class MyBatisNoticeDaoTest {

	
	@Autowired
	private NoticeDao noticeDao;
	
	@Test
	void test() {
		
		List<Notice> list = noticeDao.getListIn(new int[] {23,40,45});
		
		
		assertTrue(list.size() ==3);
		//fail("Not yet implemented");
	}

}
