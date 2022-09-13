package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.ProductVO;

public interface ProductDAO {
	int insert(ProductVO pvo);
	List<ProductVO> selectList();
	ProductVO selectOne(long pno);
	int update(ProductVO pvo);
	int delete(long pno);
}
