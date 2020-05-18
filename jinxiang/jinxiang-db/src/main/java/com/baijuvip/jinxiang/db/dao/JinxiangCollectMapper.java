package com.baijuvip.jinxiang.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.domain.JinxiangCollect;
import com.baijuvip.jinxiang.db.domain.JinxiangCollectExample;

public interface JinxiangCollectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    long countByExample(JinxiangCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int deleteByExample(JinxiangCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int insert(JinxiangCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int insertSelective(JinxiangCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    JinxiangCollect selectOneByExample(JinxiangCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    JinxiangCollect selectOneByExampleSelective(@Param("example") JinxiangCollectExample example, @Param("selective") JinxiangCollect.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    List<JinxiangCollect> selectByExampleSelective(@Param("example") JinxiangCollectExample example, @Param("selective") JinxiangCollect.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    List<JinxiangCollect> selectByExample(JinxiangCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    JinxiangCollect selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") JinxiangCollect.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    JinxiangCollect selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    JinxiangCollect selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") JinxiangCollect record, @Param("example") JinxiangCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") JinxiangCollect record, @Param("example") JinxiangCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JinxiangCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(JinxiangCollect record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") JinxiangCollectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_collect
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}