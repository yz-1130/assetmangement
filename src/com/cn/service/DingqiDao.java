package com.cn.service;
import java.util.List;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.Dingqi;
@Service
public class  DingqiDao{
	@Autowired
	public SqlSessionTemplate sqlSession;

	public List<Dingqi>  selectDingqi(Dingqi  dingqi){
	List<Dingqi>  Q= sqlSession.selectList("selectDingqi",dingqi);
		return Q;
	}

	public int deleteDingqi(Dingqi  dingqi){
	int Q= sqlSession.delete("deleteDingqi",dingqi);
		return Q;
	}

	public int updateDingqi(Dingqi  dingqi){
	int Q= sqlSession.update("updateDingqi",dingqi);
		return Q;
	}

	public int  insertDingqi(Dingqi  dingqi){
	int Q= sqlSession.insert("insertDingqi",dingqi);
		return Q;
	}

}