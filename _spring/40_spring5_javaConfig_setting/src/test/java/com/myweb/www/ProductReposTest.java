package com.myweb.www;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.ProductVO;
import com.myweb.www.repository.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.myweb.www.config.RootConfig.class})
public class ProductReposTest {
	private static Logger log = LoggerFactory.getLogger(ProductReposTest.class);
	
	@Inject
	private ProductDAO pdao;
	
	@Test
	public void insertProductDummyTest() throws Exception {
//		category, pname, price, writer, description, made_by
		int isUp = pdao.insert(new ProductVO("cate1", "P-A", 100, 
					"tester2@tester.com", "DESC-A", "TESTERS"));
		log.info(">>> insertProductDummy > {}", isUp > 0 ? "OK":"FAIL");
	}
	@Test
	public void insertProductDummiesTest() throws Exception {
//		category, pname, price, writer, description, made_by
		int isUp = 1;
		for (int i = 0; i < 100; i++) {
			isUp *= pdao.insert(new ProductVO("cate"+((int)i/10), "P-A"+(i), 100+i, 
					"tester"+(i)+"@tester.com", "DESC-A"+i, "TESTERS"));
		}
		log.info(">>> insertProductDummy > {}", isUp > 0 ? "OK":"FAIL");
	}
	@Test
	public void selectProductListTest() throws Exception {
		for (ProductVO pvo : pdao.selectList()) {
			log.info("{}", pvo);
		}
	}
	
	@Test
	public void selectProductTest() throws Exception {
		ProductVO pvo = pdao.selectOne(99L);
		log.info(">>> selectProductTest > {}", pvo);
	}
	@Test
	public void updateProductTest() throws Exception {
//		pno, category, pname, price, description, made_by
		int isUp = pdao.update(new ProductVO(88L, "cate11", "P-AB", 200, 
				 "DESC-ABA", "TESTERS_UP"));
	log.info(">>> updateProductTest > {}", isUp > 0 ? "OK":"FAIL");
	}
	@Test
	public void deleteProductTest() throws Exception {
		int isUp = pdao.delete(88L);
		log.info(">>> deleteProductTest > {}", isUp > 0 ? "OK":"FAIL");
	}
}
