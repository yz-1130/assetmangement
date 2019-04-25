package com.cn.service;
import java.util.List;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.Jijin;
@Service
public class  JijinDao{
	@Autowired
	public SqlSessionTemplate sqlSession;

	public List<Jijin>  selectJijin(Jijin  jijin){
	List<Jijin>  Q= sqlSession.selectList("selectJijin",jijin);
		return Q;
	}

	public int deleteJijin(Jijin  jijin){
	int Q= sqlSession.delete("deleteJijin",jijin);
		return Q;
	}

	public int updateJijin(Jijin  jijin){
	int Q= sqlSession.update("updateJijin",jijin);
		return Q;
	}

	public int  insertJijin(Jijin  jijin){
	int Q= sqlSession.insert("insertJijin",jijin);
		return Q;
	}

}