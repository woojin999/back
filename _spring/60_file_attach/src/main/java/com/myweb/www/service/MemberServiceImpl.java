package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.www.domain.MemberDTO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.repository.FileDAO;
import com.myweb.www.repository.ImageDAO;
import com.myweb.www.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO mdao;
	
	@Inject
	private ImageDAO idao;

	@Override
	public int register(MemberDTO mdto) {
		int isUp = mdao.insert(mdto.getMvo());
		if(isUp > 0) {
			isUp = idao.insertImage(mdto.getMvo().getEmail(), mdto.getFvo());
		}
		return isUp;
	}

	
	@Override
	public MemberVO login(MemberVO mvo) {
		
		return mdao.selectOne(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		return mdao.selectList();
	}

	@Override
	public MemberDTO getDetail(String email) {
		return new MemberDTO(mdao.selectDetail(email),
				idao.selectImage(email));
	}

	@Override
	public int modify(MemberDTO mdto) {
		int isUp = mdao.update(mdto.getMvo());
		if(isUp > 0) {
			isUp = idao.insertImage(mdto.getMvo().getEmail(), mdto.getFvo());
		}
		return isUp;
	}

	@Override
	public int remove(String email) {
		int isUp = idao.deleteAllFile(email);
		if (isUp > 0) {
			isUp = mdao.delete(email);	
		}
		return isUp; 
	}

	@Override
	public int dupleCheck(String email) {
		return mdao.selectEmail(email);
	}


	@Override
	public int removeFile(String uuid) {
		return idao.deleteFile(uuid);
	}
}
