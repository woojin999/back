package service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.EmpVO;
import repository.EmpDAO;
import repository.EmpDAOImpl;
public class EmpServiceImpl implements EmpService {
	private static Logger log = LoggerFactory.getLogger(EmpServiceImpl.class);
	private EmpDAO edao;
	
	public EmpServiceImpl() {
		edao = new EmpDAOImpl();
	}

	@Override
	public int register(EmpVO evo) {		
		return edao.insert(evo);
	}

	@Override
	public List<EmpVO> getList() {
		return edao.selectList();
	}

	@Override
	public EmpVO getDetail(int empno) {		
		return edao.selectOne(empno);
	}

	@Override
	public int modify(EmpVO evo) {
		return edao.update(evo);
	}
	@Override
	public int remove(int empno) {
		return edao.delete(empno);
	}

	@Override
	public EmpVO login(int empno, String pwd) {
		return edao.selectOne(empno, pwd);
	}
}
