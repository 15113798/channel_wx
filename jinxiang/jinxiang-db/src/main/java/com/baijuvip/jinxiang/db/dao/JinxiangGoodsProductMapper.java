package com.baijuvip.jinxiang.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsProduct;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsProductExample;

public interface JinxiangGoodsProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    long countByExample(JinxiangGoodsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int deleteByExample(JinxiangGoodsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int insert(JinxiangGoodsProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int insertSelective(JinxiangGoodsProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    JinxiangGoodsProduct selectOneByExample(JinxiangGoodsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    JinxiangGoodsProduct selectOneByExampleSelective(@Param("example") JinxiangGoodsProductExample example, @Param("selective") JinxiangGoodsProduct.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    List<JinxiangGoodsProduct> selectByExampleSelective(@Param("example") JinxiangGoodsProductExample example, @Param("selective") JinxiangGoodsProduct.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    List<JinxiangGoodsProduct> selectByExample(JinxiangGoodsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    JinxiangGoodsProduct selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") JinxiangGoodsProduct.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    JinxiangGoodsProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    JinxiangGoodsProduct selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") JinxiangGoodsProduct record, @Param("example") JinxiangGoodsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") JinxiangGoodsProduct record, @Param("example") JinxiangGoodsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(JinxiangGoodsProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(JinxiangGoodsProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") JinxiangGoodsProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_goods_product
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}