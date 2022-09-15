package com.myweb.www.repository;

import org.apache.ibatis.annotations.Param;

import com.myweb.www.domain.FileVO;

public interface ImageDAO {
	int insertImage(@Param("email") String email, @Param("fvo") FileVO fvo);
	FileVO selectImage(String email);
	int deleteFile(String uuid);
	int deleteAllFile(String email);
}
