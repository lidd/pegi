package com.youon.pegi.nj.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.youon.pegi.nj.domain.frame.NJBody;

import java.util.List;

public class NJSeMtcBody extends NJBody{

    @JsonProperty("网点编号")
    private String siteId;

    @JsonProperty("网点名称")
    private String siteName;

    @JsonProperty("经度")
    private int lng;

    @JsonProperty("纬度")
    private int lat;

    /**
     * 维护标志
     * 0：新增
     * 1：更新
     * 2：拆除
     * 3：维修
     * 4：停运
     * 5：挪移
     */
    @JsonProperty("维护标志")
    private int mtcFlag;

    @JsonProperty("记录数")
    private int aroundSitesCount;

    @JsonProperty("周边网点")
    private List<Site> aroundSites;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getMtcFlag() {
        return mtcFlag;
    }

    public void setMtcFlag(int mtcFlag) {
        this.mtcFlag = mtcFlag;
    }

    public int getAroundSitesCount() {
        return aroundSitesCount;
    }

    public void setAroundSitesCount(int aroundSitesCount) {
        this.aroundSitesCount = aroundSitesCount;
    }

    public List<Site> getAroundSites() {
        return aroundSites;
    }

    public void setAroundSites(List<Site> aroundSites) {
        this.aroundSites = aroundSites;
    }

    @Override
    public String getTxFlag() {
        return "S4";
    }

    private class Site {
        @JsonProperty("网点编号")
        private String siteId;

        public String getSiteId() {
            return siteId;
        }

        public void setSiteId(String siteId) {
            this.siteId = siteId;
        }
    }
}
