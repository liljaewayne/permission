package top.liujianwei.dao;

import org.apache.ibatis.annotations.Param;
import top.liujianwei.model.SysDept;

import java.util.List;

public interface SysDeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

    List<SysDept> getAllDept();

//    @Deprecated
//    List<SysDept> getChildDeptListByLevel(@Param("level") String level);
    
    List<SysDept> listChildDeptListById(@Param("id") Integer id);

    @Deprecated
    // FIXME batch sql error
    void batchUpdateLevel(@Param("sysDeptList") List<SysDept> sysDeptList);
    
    int countByNameAndParentId(@Param("parentId") Integer parentId, @Param("name") String name, @Param("id") Integer id);

    int countByParentId(@Param("deptId") int deptId);
}