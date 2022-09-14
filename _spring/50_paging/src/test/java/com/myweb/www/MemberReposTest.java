package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.repository.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberReposTest {
	private static Logger log = LoggerFactory.getLogger(MemberReposTest.class);
	
	@Inject
	private MemberDAO mdao;
	
	@Test
	public void deleteMemberTest() throws Exception {
		int isUp = mdao.delete("tester@tester.com");
		log.info(">>> Test of delete Member : {} ", isUp > 0 ? "OK":"FAIL");
	}
	
	@Test
	public void updateMemberTest() throws Exception {
		int isUp = mdao.update(
					new MemberVO(
							"tester@tester.com", "1234", "TESTERUP", 20));
		log.info(">>> Test of update Member : {} ", isUp > 0 ? "OK":"FAIL");
	}
	
	@Test
	public void getDetailMemberTest() throws Exception {
		MemberVO mvo = mdao.selectDetail("tester@tester.com");
		log.info(">>> {},{},{},{},{}",
				mvo.getEmail(), mvo.getNickName(), mvo.getRegAt(),
				mvo.getLastLogin(), mvo.getGrade());
	}
	
	
	@Test
	public void LoginMemberTest() throws Exception {
		MemberVO mvo = mdao.selectOne(new MemberVO("tester@tester.com", "1111"));
		log.info(">>> {},{},{},{}",
				mvo.getEmail(), mvo.getNickName(), mvo.getLastLogin(), mvo.getGrade());
	}
	
	@Test
	public void getListMemberListTest() throws Exception {
		List<MemberVO> list  = mdao.selectList();
		for (MemberVO mvo : list) {
			log.info(">>> {},{},{},{},{}",
					mvo.getEmail(), mvo.getNickName(), mvo.getRegAt(),
					mvo.getLastLogin(), mvo.getGrade());
		}
	}
	
	@Test
	public void insertMemberDummies100() throws Exception {
		// guest1@guest.com , 1111, GUEST1 부터 100까지 데이터베이스에 입력하기
		for (int i = 1; i < 101; i++) {
			mdao.insert(new MemberVO("guest"+i+"@guest.com",
					"1111", "GUEST"+i));			
		}
	}
		
	@Test
	public void insertMemberDummy() throws Exception {
//		MemberVO mvo = new MemberVO();
//		mvo.setEmail("tester@tester.com");
//		mvo.setPwd("1111");
//		mvo.setNickName("TESTER");
//		mdao.insert(mvo);
		
		int isUp = mdao.insert(new MemberVO("tester2@tester.com", "1111", "TESTER2"));
		log.info(">>> Test of insert Member : {} ", isUp > 0 ? "OK":"FAIL");
	}
}
