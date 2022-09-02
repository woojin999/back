package hoteldb;

import java.util.List;

public interface DataBase {
	boolean insert(Hotel info);
	List<Hotel> selectList();
	Hotel selectOne(String name);
	boolean update(Hotel info);
	boolean delete(String name);
}
