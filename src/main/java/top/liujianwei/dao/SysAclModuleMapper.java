package top.liujianwei.dao;

import org.apache.ibatis.annotations.Param;
import top.liujianwei.model.SysAclModule;

import java.util.List;

public interface SysAclModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAclModule record);

    int insertSelective(SysAclModule record);

    SysAclModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAclModule record);

    int updateByPrimaryKey(SysAclModule record);


    int countByNameAndParentId(@Param("parentId") Integer parentId, @Param("name") String name, @Param("id") Integer id);

    List<SysAclModule> getAllAclModule();

    int countByParentId(@Param("aclModuleId") int aclModuleId);

//    @Deprecated
    // WTF
//    List<SysAclModule> getChildAclModuleListByLevel(@Param("level") String level);

    List<SysAclModule> listChildAclModuleListById(@Param("id") Integer id);

    @Deprecated
    // org.springframework.jdbc.UncategorizedSQLException
    void batchUpdateLevel(@Param("sysAclModuleList") List<SysAclModule> sysAclModuleList);
}