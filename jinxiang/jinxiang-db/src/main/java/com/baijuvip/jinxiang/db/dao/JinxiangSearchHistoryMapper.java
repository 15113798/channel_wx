package com.baijuvip.jinxiang.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.domain.JinxiangSearchHistory;
import com.baijuvip.jinxiang.db.domain.JinxiangSearchHistoryExample;

public interface JinxiangSearchHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    long countByExample(JinxiangSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int deleteByExample(JinxiangSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int insert(JinxiangSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int insertSelective(JinxiangSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    JinxiangSearchHistory selectOneByExample(JinxiangSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    JinxiangSearchHistory selectOneByExampleSelective(@Param("example") JinxiangSearchHistoryExample example, @Param("selective") JinxiangSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    List<JinxiangSearchHistory> selectByExampleSelective(@Param("example") JinxiangSearchHistoryExample example, @Param("selective") JinxiangSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    List<JinxiangSearchHistory> selectByExample(JinxiangSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    JinxiangSearchHistory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") JinxiangSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    JinxiangSearchHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    JinxiangSearchHistory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") JinxiangSearchHistory record, @Param("example") JinxiangSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") JinxiangSearchHistory record, @Param("example") JinxiangSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JinxiangSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(JinxiangSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") JinxiangSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}