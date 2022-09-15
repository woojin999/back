/*
 * package com.myweb.www;
 * 
 * import javax.inject.Inject;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 * 
 * import com.myweb.www.domain.MemberVO; import
 * com.myweb.www.service.MemberService;
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @ContextConfiguration(classes = {com.myweb.www.config.RootConfig.class})
 * public class MemberSvcTest { private static Logger log =
 * LoggerFactory.getLogger(MemberSvcTest.class);
 * 
 * @Inject private MemberService msv;
 * 
 * @Test public void insertMemberDummy() throws Exception { // MemberVO mvo =
 * new MemberVO(); // mvo.setEmail("tester@tester.com"); // mvo.setPwd("1111");
 * // mvo.setNickName("TESTER"); // mdao.insert(mvo);
 * 
 * int isUp = msv.register(new MemberVO("tester3@tester.com", "1111",
 * "TESTER3")); log.info(">>> Test of register Member : {} ", isUp > 0 ?
 * "OK":"FAIL"); } }
 */