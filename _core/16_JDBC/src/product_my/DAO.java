package product_my;

public interface DAO {

	int insert(ProductVO pvo);

	ProductVO selectOne(int pno); 

}
