package com.cn.service;
import java.util.List;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.Licai;
@Service
public class  LicaiDao{
	@Autowired
	public SqlSessionTemplate sqlSession;

	public List<Licai>  selectLicai(Licai  licai){
	List<Licai>  Q= sqlSession.selectList("selectLicai",licai);
		return Q;
	}

	public int deleteLicai(Licai  licai){
	int Q= sqlSession.delete("deleteLicai",licai);
		return Q;
	}

	public int updateLicai(Licai  licai){
	int Q= sqlSession.update("updateLicai",licai);
		return Q;
	}

	public int  insertLicai(Licai  licai){
	int Q= sqlSession.insert("insertLicai",licai);
		return Q;
	}

}