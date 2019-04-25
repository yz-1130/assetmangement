package com.cn.service;
import java.util.List;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.Baoxian;
@Service
public class  BaoxianDao{
	@Autowired
	public SqlSessionTemplate sqlSession;

	public List<Baoxian>  selectBaoxian(Baoxian  baoxian){
	List<Baoxian>  Q= sqlSession.selectList("selectBaoxian",baoxian);
		return Q;
	}

	public int deleteBaoxian(Baoxian  baoxian){
	int Q= sqlSession.delete("deleteBaoxian",baoxian);
		return Q;
	}

	public int updateBaoxian(Baoxian  baoxian){
	int Q= sqlSession.update("updateBaoxian",baoxian);
		return Q;
	}

	public int  insertBaoxian(Baoxian  baoxian){
	int Q= sqlSession.insert("insertBaoxian",baoxian);
		return Q;
	}

}