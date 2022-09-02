package hoteldb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQL implements DataBase {
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	
	public MySQL() {
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public boolean insert(Hotel info) {
		query = "insert into hotel values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, info.getName());
			pst.setString(2, info.getTel());
			pst.setInt(3, info.getAge());
			return pst.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Hotel> selectList() {
		query = "select * from hotel";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			List<Hotel> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Hotel(rs.getString("name"),
									rs.getString("tel"),
									rs.getInt("age")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Hotel selectOne(String name) {
		query = "select * from hotel where name = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				 return new Hotel(rs.getString("name"),
						 			rs.getString("tel"),
						 			rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Hotel info) {
		query = "update hotel set tel=?, age=? where name=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, info.getTel());
			pst.setInt(2, info.getAge());
			pst.setString(3, info.getName());
			return pst.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String name) {
		query = "delete from hotel where name = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, name);
			return pst.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
