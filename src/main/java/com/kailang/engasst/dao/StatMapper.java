package com.kailang.engasst.dao;

import com.kailang.engasst.pojo.Stat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table STAT
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer userno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table STAT
     *
     * @mbg.generated
     */
    int insert(Stat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table STAT
     *
     * @mbg.generated
     */
    Stat selectByPrimaryKey(@Param("userno") Integer userno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table STAT
     *
     * @mbg.generated
     */
    List<Stat> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table STAT
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Stat record);
}