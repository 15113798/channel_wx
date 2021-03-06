package com.baijuvip.jinxiang.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsAttribute;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsAttributeExample;

public interface JinxiangGoodsAttributeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    long countByExample(JinxiangGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int deleteByExample(JinxiangGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int insert(JinxiangGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int insertSelective(JinxiangGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    JinxiangGoodsAttribute selectOneByExample(JinxiangGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    JinxiangGoodsAttribute selectOneByExampleSelective(@Param("example") JinxiangGoodsAttributeExample example, @Param("selective") JinxiangGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    List<JinxiangGoodsAttribute> selectByExampleSelective(@Param("example") JinxiangGoodsAttributeExample example, @Param("selective") JinxiangGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    List<JinxiangGoodsAttribute> selectByExample(JinxiangGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    JinxiangGoodsAttribute selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") JinxiangGoodsAttribute.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    JinxiangGoodsAttribute selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    JinxiangGoodsAttribute selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") JinxiangGoodsAttribute record, @Param("example") JinxiangGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") JinxiangGoodsAttribute record, @Param("example") JinxiangGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JinxiangGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(JinxiangGoodsAttribute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") JinxiangGoodsAttributeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_attribute
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}