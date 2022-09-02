package product_my;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO implements DAO {
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	
	 public ProductDAO() {
		 DatabaseConnector dbc = DatabaseConnector.getInstance();
		 conn = dbc.getConnection();
	}
	 
	@Override
	public int insert(ProductVO pvo) {
		query = "insert into product (pname, price, madeby)"
				+ " values (?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ProductVO selectOne(int pno) {
		// TODO Auto-generated method stub
		return null;
	}

}
