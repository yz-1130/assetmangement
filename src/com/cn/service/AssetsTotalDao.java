package com.cn.service;
        import java.util.List;
        import com.cn.domain.AssetsTotal;
        import com.cn.domain.Baoxian;
        import org.mybatis.spring.SqlSessionTemplate;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
@Service
public class  AssetsTotalDao{
    @Autowired
    public SqlSessionTemplate sqlSession;

    public List<AssetsTotal> selectAssetsTotal(AssetsTotal  assetsTotal){
        List<AssetsTotal>  Q= sqlSession.selectList("selectAssetsTotal",assetsTotal);
        return Q;
    }

    public int deleteAssetsTotal(AssetsTotal assetsTotal){
        int Q= sqlSession.delete("deleteAssetsTotal",assetsTotal);
        return Q;
    }

    public int updateAssetsTotal(AssetsTotal  assetsTotal){
        int Q= sqlSession.update("updateAssetsTotal",assetsTotal);
        return Q;
    }

    public int  insertAssetsTotal(AssetsTotal  assetsTotal){
        int Q= sqlSession.insert("insertAssetsTotal",assetsTotal);
        return Q;
    }

}