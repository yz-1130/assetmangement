package com.cn.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.domain.User;

@Service
public class RegisterDao {
	@Autowired
	public SqlSessionTemplate sqlSession;
	
	public boolean insertuser(User user){
		boolean ret=false;
		int re = sqlSession.insert("addUser",user);
		if(re>0){
			ret=true;
		}
		return ret;
	}
	
	//显示申请列表
	public List<User> showRegister(){
		
		List<User> q = sqlSession.selectList("selectuserP");
		return q;
	}
	
	public int deleteUserQ(User user){
		
		int Q= sqlSession.delete("deleteUserQ",user);
		return Q;
	}
	
	//根据用户ID查询
	public List<User> selectuserByID(User user){
		List<User> q = sqlSession.selectList("selectuserByID",user);
		return q;
	}
	
    //批准用户申请
	public int approveUserQ(User user){
		
		int Q= sqlSession.update("approveUserQ",user);
		//在info表也插入一条只存了userID的新数据
		return Q;
	}
	
	
	
	
	//显示党员列表
		public List<User> showAllUser(){
			List<User> q =sqlSession.selectList("selectuser");
			
			return q;
		}
		
		// 查找user,通过name和password
		
		public User selectuserByName(User user){
			User q =sqlSession.selectOne("selectuserByName",user);
			return q;
		}

		
		// 充值
		
				public void chongzhiForUser(User user){
					sqlSession.update("chongzhiForUser",user);
					
				}

				
				
		
	
		
	
		
		
}
