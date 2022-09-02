package product_my;

import java.util.List;

public interface Service {

	int register(ProductVO pvo);

	List<ProductVO> list();

	int edit(ProductVO pvo);

	ProductVO detail(int pno);

	int remove(int pno);

}
