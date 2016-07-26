package com.orm;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class RepairTomtopProduct {
    private Integer id;
    private Integer fheight;
    private Integer flength;
    private Integer freight;
    private Integer fvolumeweight;
    private Integer fwidth;
    private Boolean isMain;
    private String listingId;
    private Boolean mainSku;
    private Long newFromDate;
    private Long newToDate;
    private String parentSku;
    private Double price;
    private Integer qty;
    private String sku;
    private String spu;
    private Integer status;
    private Boolean visible;
    private Integer websiteId;
    private Integer weight;
    private List<RepairTomtopAttribute> attributes;
    private List<RepairTomtopAttribute> multiAttributes;
    private List<Integer> categoryIds;
    private List<String> labelTypes;
    private List<Integer> storages;
    private List<RepairShippingTemplateMaps> shippingTemplateMaps;
    private List<ReairItems> items;
    private List<RepairVideos> videos;

    public RepairTomtopProduct() {
    }

    public Integer getFheight() {
        return this.fheight;
    }

    public void setFheight(Integer fheight) {
        this.fheight = fheight;
    }

    public Integer getFlength() {
        return this.flength;
    }

    public void setFlength(Integer flength) {
        this.flength = flength;
    }

    public Integer getFreight() {
        return this.freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getFvolumeweight() {
        return this.fvolumeweight;
    }

    public void setFvolumeweight(Integer fvolumeweight) {
        this.fvolumeweight = fvolumeweight;
    }

    public Integer getFwidth() {
        return this.fwidth;
    }

    public void setFwidth(Integer fwidth) {
        this.fwidth = fwidth;
    }

    public Boolean getIsMain() {
        return this.isMain;
    }

    public void setIsMain(Boolean isMain) {
        this.isMain = isMain;
    }

    public String getListingId() {
        return this.listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public Boolean getMainSku() {
        return this.mainSku;
    }

    public void setMainSku(Boolean mainSku) {
        this.mainSku = mainSku;
    }

    public Long getNewFromDate() {
        return this.newFromDate;
    }

    public void setNewFromDate(Long newFromDate) {
        this.newFromDate = newFromDate;
    }

    public Long getNewToDate() {
        return this.newToDate;
    }

    public void setNewToDate(Long newToDate) {
        this.newToDate = newToDate;
    }

    public String getParentSku() {
        return this.parentSku;
    }

    public void setParentSku(String parentSku) {
        this.parentSku = parentSku;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSpu() {
        return this.spu;
    }

    public void setSpu(String spu) {
        this.spu = spu;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getVisible() {
        return this.visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Integer getWebsiteId() {
        return this.websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<RepairTomtopAttribute> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(List<RepairTomtopAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<RepairTomtopAttribute> getMultiAttributes() {
        return this.multiAttributes;
    }

    public void setMultiAttributes(List<RepairTomtopAttribute> multiAttributes) {
        this.multiAttributes = multiAttributes;
    }

    public List<Integer> getCategoryIds() {
        return this.categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<String> getLabelTypes() {
        return this.labelTypes;
    }

    public void setLabelTypes(List<String> labelTypes) {
        this.labelTypes = labelTypes;
    }

    public List<Integer> getStorages() {
        return this.storages;
    }

    public void setStorages(List<Integer> storages) {
        this.storages = storages;
    }

    public List<RepairShippingTemplateMaps> getShippingTemplateMaps() {
        return this.shippingTemplateMaps;
    }

    public void setShippingTemplateMaps(List<RepairShippingTemplateMaps> shippingTemplateMaps) {
        this.shippingTemplateMaps = shippingTemplateMaps;
    }

    public List<ReairItems> getItems() {
        return this.items;
    }

    public void setItems(List<ReairItems> items) {
        this.items = items;
    }

    public List<RepairVideos> getVideos() {
        return this.videos;
    }

    public void setVideos(List<RepairVideos> videos) {
        this.videos = videos;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
