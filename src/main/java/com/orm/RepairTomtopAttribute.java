package com.orm;

/**
 * 修复属性实体
 * Created by Administrator on 2016/7/20.
 */
public class RepairTomtopAttribute {

    /**
     * 属性键 en
     */
    private String key;

    /**
     * 属性键 id
     */
    private Integer keyId;

    /**
     * 语言
     */
    private Integer languangeId;

    /**
     * 显示方式
     */
    private Boolean showImg;

    /**
     * 关键属性 sku=true/ 非关键属性 sku=false
     */
    private Boolean sku;

    /**
     * 属性值 en
     */
    private String value;

    /**
     * 属性id
     */
    private Integer valueId;

    private Boolean visible;

    /**
     * 属性键中文
     */
    private String keyZh;

    /**
     * 属性值中文
     */
    private String valueZh;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public Integer getLanguangeId() {
        return languangeId;
    }

    public void setLanguangeId(Integer languangeId) {
        this.languangeId = languangeId;
    }

    public Boolean getShowImg() {
        return showImg;
    }

    public void setShowImg(Boolean showImg) {
        this.showImg = showImg;
    }

    public Boolean getSku() {
        return sku;
    }

    public void setSku(Boolean sku) {
        this.sku = sku;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getKeyZh() {
        return keyZh;
    }

    public void setKeyZh(String keyZh) {
        this.keyZh = keyZh;
    }

    public String getValueZh() {
        return valueZh;
    }

    public void setValueZh(String valueZh) {
        this.valueZh = valueZh;
    }
}
