package com.baijuvip.jinxiang.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.domain.JinxiangIntegral;
import com.baijuvip.jinxiang.db.domain.JinxiangIntegralExample;

public interface JinxiangIntegralMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    long countByExample(JinxiangIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int deleteByExample(JinxiangIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int insert(JinxiangIntegral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int insertSelective(JinxiangIntegral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    JinxiangIntegral selectOneByExample(JinxiangIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    JinxiangIntegral selectOneByExampleSelective(@Param("example") JinxiangIntegralExample example, @Param("selective") JinxiangIntegral.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    List<JinxiangIntegral> selectByExampleSelective(@Param("example") JinxiangIntegralExample example, @Param("selective") JinxiangIntegral.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    List<JinxiangIntegral> selectByExample(JinxiangIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    JinxiangIntegral selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") JinxiangIntegral.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    JinxiangIntegral selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    JinxiangIntegral selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") JinxiangIntegral record, @Param("example") JinxiangIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") JinxiangIntegral record, @Param("example") JinxiangIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JinxiangIntegral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(JinxiangIntegral record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") JinxiangIntegralExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_integral
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}