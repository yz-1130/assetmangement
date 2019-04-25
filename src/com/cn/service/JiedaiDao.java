package com.cn.service;
import java.util.List;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.Jiedai;
@Service
public class  JiedaiDao{
	@Autowired
	public SqlSessionTemplate sqlSession;

	public List<Jiedai>  selectJiedai(Jiedai  jiedai){
	List<Jiedai>  Q= sqlSession.selectList("selectJiedai",jiedai);
		return Q;
	}

	public int deleteJiedai(Jiedai  jiedai){
	int Q= sqlSession.delete("deleteJiedai",jiedai);
		return Q;
	}

	public int updateJiedai(Jiedai  jiedai){
	int Q= sqlSession.update("updateJiedai",jiedai);
		return Q;
	}

	public int  insertJiedai(Jiedai  jiedai){
	int Q= sqlSession.insert("insertJiedai",jiedai);
		return Q;
	}

}