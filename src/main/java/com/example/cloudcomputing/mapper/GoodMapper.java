package com.example.cloudcomputing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudcomputing.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface GoodMapper extends BaseMapper<Good> {
    // 查询所有Good记录
    @Select("SELECT * FROM good")
    List<Good> findAll();

    // 根据name查询Good记录
    @Select("SELECT * FROM good WHERE name = #{name}")
    Good findByName(@Param("name") String name);

    // 根据uid查询Good记录
    @Select("SELECT * FROM good WHERE uid = #{uid}")
    List<Good> findAllByUid(@Param("uid") Integer uid);

    // 根据main查询Good记录
    @Select("SELECT * FROM good WHERE main = #{main}")
    List<Good> findAllByMain(@Param("main") String main);

    // 根据main和detail查询Good记录
    @Select("SELECT * FROM good WHERE main = #{main} AND detail = #{detail}")
    List<Good> findAllByMainAndDetail(@Param("main") String main, @Param("detail") String detail);
}
