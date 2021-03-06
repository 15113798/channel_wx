package com.baijuvip.jinxiang.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsSpecification;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsSpecificationExample;

public interface JinxiangGoodsSpecificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    long countByExample(JinxiangGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int deleteByExample(JinxiangGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int insert(JinxiangGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int insertSelective(JinxiangGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    JinxiangGoodsSpecification selectOneByExample(JinxiangGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    JinxiangGoodsSpecification selectOneByExampleSelective(@Param("example") JinxiangGoodsSpecificationExample example, @Param("selective") JinxiangGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    List<JinxiangGoodsSpecification> selectByExampleSelective(@Param("example") JinxiangGoodsSpecificationExample example, @Param("selective") JinxiangGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    List<JinxiangGoodsSpecification> selectByExample(JinxiangGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    JinxiangGoodsSpecification selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") JinxiangGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    JinxiangGoodsSpecification selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    JinxiangGoodsSpecification selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") JinxiangGoodsSpecification record, @Param("example") JinxiangGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") JinxiangGoodsSpecification record, @Param("example") JinxiangGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JinxiangGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(JinxiangGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") JinxiangGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_specification
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}