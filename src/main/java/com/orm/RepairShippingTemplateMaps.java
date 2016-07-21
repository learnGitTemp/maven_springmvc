package com.orm;

import java.util.List;

/**
 * 修复仓库和物流模板问题
 * Created by Administrator on 2016/7/20.
 */
public class RepairShippingTemplateMaps {

    /**
     * 价格
     */
    private Double fprice;

    /**
     * 库存
     */
    private Integer iqty;

    /**
     * 销售状态
     */
    private Integer istatus;

    /**
     * 仓库id
     */
    private Integer storageid;

    /**
     * 模板id
     */
    private Integer templateid;

    /**
     * 预售
     */
    private List<ReairPreSellList> preSellList;

    public Double getFprice() {
        return fprice;
    }

    public void setFprice(Double fprice) {
        this.fprice = fprice;
    }

    public Integer getIqty() {
        return iqty;
    }

    public void setIqty(Integer iqty) {
        this.iqty = iqty;
    }

    public Integer getIstatus() {
        return istatus;
    }

    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
    }

    public Integer getStorageid() {
        return storageid;
    }

    public void setStorageid(Integer storageid) {
        this.storageid = storageid;
    }

    public Integer getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Integer templateid) {
        this.templateid = templateid;
    }

    public List<ReairPreSellList> getPreSellList() {
        return preSellList;
    }

    public void setPreSellList(List<ReairPreSellList> preSellList) {
        this.preSellList = preSellList;
    }
}
