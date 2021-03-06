package com.baijuvip.jinxiang.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.domain.JinxiangGroupon;
import com.baijuvip.jinxiang.db.domain.JinxiangGrouponExample;

public interface JinxiangGrouponMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    long countByExample(JinxiangGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int deleteByExample(JinxiangGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int insert(JinxiangGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int insertSelective(JinxiangGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    JinxiangGroupon selectOneByExample(JinxiangGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    JinxiangGroupon selectOneByExampleSelective(@Param("example") JinxiangGrouponExample example, @Param("selective") JinxiangGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    List<JinxiangGroupon> selectByExampleSelective(@Param("example") JinxiangGrouponExample example, @Param("selective") JinxiangGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    List<JinxiangGroupon> selectByExample(JinxiangGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    JinxiangGroupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") JinxiangGroupon.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    JinxiangGroupon selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    JinxiangGroupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") JinxiangGroupon record, @Param("example") JinxiangGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") JinxiangGroupon record, @Param("example") JinxiangGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JinxiangGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(JinxiangGroupon record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") JinxiangGrouponExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_groupon
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}