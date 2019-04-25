package com.cn.service;
import java.util.List;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.Huangjin;
@Service
public class  HuangjinDao{
	@Autowired
	public SqlSessionTemplate sqlSession;

	public List<Huangjin>  selectHuangjin(Huangjin  huangjin){
	List<Huangjin>  Q= sqlSession.selectList("selectHuangjin",huangjin);
		return Q;
	}

	public int deleteHuangjin(Huangjin  huangjin){
	int Q= sqlSession.delete("deleteHuangjin",huangjin);
		return Q;
	}

	public int updateHuangjin(Huangjin  huangjin){
	int Q= sqlSession.update("updateHuangjin",huangjin);
		return Q;
	}

	public int  insertHuangjin(Huangjin  huangjin){
	int Q= sqlSession.insert("insertHuangjin",huangjin);
		return Q;
	}

}