package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import repository.ProductDAO;
import repository.ProductDAOImpl;

public class ProductServiceImpl implements ProductService {
	private static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	private ProductDAO pdao;
	
	public ProductServiceImpl() {
		pdao = new ProductDAOImpl();
	}
	
	@Override
	public int register(ProductVO pvo) {
		
		return pdao.insert(pvo);
	}

	@Override
	public List<ProductVO> getList() {
		
		return pdao.selectList();
	}

	@Override
	public ProductVO getDetail(int pno) {
		
		return pdao.selectOne(pno);
	}

	@Override
	public int modify(ProductVO pvo) {
		
		return pdao.update(pvo);
	}

	@Override
	public int remove(int pno) {
		
		return pdao.delete(pno);
	}

}
