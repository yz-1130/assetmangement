package com.cn.service;
import java.util.List;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.Jingyin;
@Service
public class  JingyinDao{
	@Autowired
	public SqlSessionTemplate sqlSession;

	public List<Jingyin>  selectJingyin(Jingyin  jingyin){
	List<Jingyin>  Q= sqlSession.selectList("selectJingyin",jingyin);
		return Q;
	}

	public int deleteJingyin(Jingyin  jingyin){
	int Q= sqlSession.delete("deleteJingyin",jingyin);
		return Q;
	}

	public int updateJingyin(Jingyin  jingyin){
	int Q= sqlSession.update("updateJingyin",jingyin);
		return Q;
	}

	public int  insertJingyin(Jingyin  jingyin){
	int Q= sqlSession.insert("insertJingyin",jingyin);
		return Q;
	}

}