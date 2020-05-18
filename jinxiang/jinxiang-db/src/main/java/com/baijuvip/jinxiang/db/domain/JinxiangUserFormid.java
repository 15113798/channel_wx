package com.baijuvip.jinxiang.db.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class JinxiangUserFormid {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jinxiang_user_formid
     *
     * @mbg.generated
     */
    public static final Boolean IS_DELETED = Deleted.IS_DELETED.value();

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jinxiang_user_formid
     *
     * @mbg.generated
     */
    public static final Boolean NOT_DELETED = Deleted.NOT_DELETED.value();

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jinxiang_user_formid.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jinxiang_user_formid.formId
     *
     * @mbg.generated
     */
    private String formid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jinxiang_user_formid.isprepay
     *
     * @mbg.generated
     */
    private Boolean isprepay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jinxiang_user_formid.useAmount
     *
     * @mbg.generated
     */
    private Integer useamount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jinxiang_user_formid.expire_time
     *
     * @mbg.generated
     */
    private LocalDateTime expireTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jinxiang_user_formid.openId
     *
     * @mbg.generated
     */
    private String openid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jinxiang_user_formid.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jinxiang_user_formid.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jinxiang_user_formid.deleted
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jinxiang_user_formid.id
     *
     * @return the value of jinxiang_user_formid.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jinxiang_user_formid.id
     *
     * @param id the value for jinxiang_user_formid.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jinxiang_user_formid.formId
     *
     * @return the value of jinxiang_user_formid.formId
     *
     * @mbg.generated
     */
    public String getFormid() {
        return formid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jinxiang_user_formid.formId
     *
     * @param formid the value for jinxiang_user_formid.formId
     *
     * @mbg.generated
     */
    public void setFormid(String formid) {
        this.formid = formid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jinxiang_user_formid.isprepay
     *
     * @return the value of jinxiang_user_formid.isprepay
     *
     * @mbg.generated
     */
    public Boolean getIsprepay() {
        return isprepay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jinxiang_user_formid.isprepay
     *
     * @param isprepay the value for jinxiang_user_formid.isprepay
     *
     * @mbg.generated
     */
    public void setIsprepay(Boolean isprepay) {
        this.isprepay = isprepay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jinxiang_user_formid.useAmount
     *
     * @return the value of jinxiang_user_formid.useAmount
     *
     * @mbg.generated
     */
    public Integer getUseamount() {
        return useamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jinxiang_user_formid.useAmount
     *
     * @param useamount the value for jinxiang_user_formid.useAmount
     *
     * @mbg.generated
     */
    public void setUseamount(Integer useamount) {
        this.useamount = useamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jinxiang_user_formid.expire_time
     *
     * @return the value of jinxiang_user_formid.expire_time
     *
     * @mbg.generated
     */
    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jinxiang_user_formid.expire_time
     *
     * @param expireTime the value for jinxiang_user_formid.expire_time
     *
     * @mbg.generated
     */
    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jinxiang_user_formid.openId
     *
     * @return the value of jinxiang_user_formid.openId
     *
     * @mbg.generated
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jinxiang_user_formid.openId
     *
     * @param openid the value for jinxiang_user_formid.openId
     *
     * @mbg.generated
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jinxiang_user_formid.add_time
     *
     * @return the value of jinxiang_user_formid.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jinxiang_user_formid.add_time
     *
     * @param addTime the value for jinxiang_user_formid.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jinxiang_user_formid.update_time
     *
     * @return the value of jinxiang_user_formid.update_time
     *
     * @mbg.generated
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jinxiang_user_formid.update_time
     *
     * @param updateTime the value for jinxiang_user_formid.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user_formid
     *
     * @mbg.generated
     */
    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? Deleted.IS_DELETED.value() : Deleted.NOT_DELETED.value());
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jinxiang_user_formid.deleted
     *
     * @return the value of jinxiang_user_formid.deleted
     *
     * @mbg.generated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jinxiang_user_formid.deleted
     *
     * @param deleted the value for jinxiang_user_formid.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user_formid
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", IS_DELETED=").append(IS_DELETED);
        sb.append(", NOT_DELETED=").append(NOT_DELETED);
        sb.append(", id=").append(id);
        sb.append(", formid=").append(formid);
        sb.append(", isprepay=").append(isprepay);
        sb.append(", useamount=").append(useamount);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", openid=").append(openid);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user_formid
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        JinxiangUserFormid other = (JinxiangUserFormid) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFormid() == null ? other.getFormid() == null : this.getFormid().equals(other.getFormid()))
            && (this.getIsprepay() == null ? other.getIsprepay() == null : this.getIsprepay().equals(other.getIsprepay()))
            && (this.getUseamount() == null ? other.getUseamount() == null : this.getUseamount().equals(other.getUseamount()))
            && (this.getExpireTime() == null ? other.getExpireTime() == null : this.getExpireTime().equals(other.getExpireTime()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jinxiang_user_formid
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFormid() == null) ? 0 : getFormid().hashCode());
        result = prime * result + ((getIsprepay() == null) ? 0 : getIsprepay().hashCode());
        result = prime * result + ((getUseamount() == null) ? 0 : getUseamount().hashCode());
        result = prime * result + ((getExpireTime() == null) ? 0 : getExpireTime().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table jinxiang_user_formid
     *
     * @mbg.generated
     */
    public enum Deleted {
        NOT_DELETED(new Boolean("0"), "未删除"),
        IS_DELETED(new Boolean("1"), "已删除");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        private final Boolean value;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        private final String name;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        Deleted(Boolean value, String name) {
            this.value = value;
            this.name = name;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public Boolean getValue() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public Boolean value() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public String getName() {
            return this.name;
        }
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table jinxiang_user_formid
     *
     * @mbg.generated
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        formid("formId", "formid", "VARCHAR", false),
        isprepay("isprepay", "isprepay", "BIT", false),
        useamount("useAmount", "useamount", "INTEGER", false),
        expireTime("expire_time", "expireTime", "TIMESTAMP", false),
        openid("openId", "openid", "VARCHAR", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table jinxiang_user_formid
         *
         * @mbg.generated
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}