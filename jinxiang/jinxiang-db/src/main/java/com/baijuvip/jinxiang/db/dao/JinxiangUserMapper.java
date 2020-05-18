package com.baijuvip.jinxiang.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.domain.JinxiangUser;
import com.baijuvip.jinxiang.db.domain.JinxiangUserExample;

public interface JinxiangUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    long countByExample(JinxiangUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int deleteByExample(JinxiangUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int insert(JinxiangUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int insertSelective(JinxiangUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    JinxiangUser selectOneByExample(JinxiangUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    JinxiangUser selectOneByExampleSelective(@Param("example") JinxiangUserExample example, @Param("selective") JinxiangUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    List<JinxiangUser> selectByExampleSelective(@Param("example") JinxiangUserExample example, @Param("selective") JinxiangUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    List<JinxiangUser> selectByExample(JinxiangUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    JinxiangUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") JinxiangUser.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    JinxiangUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    JinxiangUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") JinxiangUser record, @Param("example") JinxiangUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") JinxiangUser record, @Param("example") JinxiangUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JinxiangUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(JinxiangUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") JinxiangUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}