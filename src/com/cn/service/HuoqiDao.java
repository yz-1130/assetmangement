package com.cn.service;
import java.util.List;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.Huoqi;
@Service
public class  HuoqiDao{
	@Autowired
	public SqlSessionTemplate sqlSession;

	public List<Huoqi>  selectHuoqi(Huoqi  Huoqi){
	List<Huoqi>  Q= sqlSession.selectList("selectHuoqi",Huoqi);
		return Q;
	}

	public int deleteHuoqi(Huoqi  Huoqi){
	int Q= sqlSession.delete("deleteHuoqi",Huoqi);
		return Q;
	}

	public int updateHuoqi(Huoqi  Huoqi){
	int Q= sqlSession.update("updateHuoqi",Huoqi);
		return Q;
	}

	public int  insertHuoqi(Huoqi  Huoqi){
	int Q= sqlSession.insert("insertHuoqi",Huoqi);
		return Q;
	}

}