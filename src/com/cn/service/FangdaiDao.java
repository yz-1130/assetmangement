package com.cn.service;
import java.util.List;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.Fangdai;
@Service
public class  FangdaiDao{
	@Autowired
	public SqlSessionTemplate sqlSession;

	public List<Fangdai>  selectFangdai(Fangdai  fangdai){
	List<Fangdai>  Q= sqlSession.selectList("selectFangdai",fangdai);
		return Q;
	}

	public int deleteFangdai(Fangdai  fangdai){
	int Q= sqlSession.delete("deleteFangdai",fangdai);
		return Q;
	}

	public int updateFangdai(Fangdai  fangdai){
	int Q= sqlSession.update("updateFangdai",fangdai);
		return Q;
	}

	public int  insertFangdai(Fangdai  fangdai){
	int Q= sqlSession.insert("insertFangdai",fangdai);
		return Q;
	}

}