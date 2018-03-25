package com.youon.pegi.nj.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.youon.pegi.nj.domain.frame.NJBody;

import java.util.List;

public class NJSeBody extends NJBody {

    @JsonProperty("网点编号")
    private String siteId;

    @JsonProperty("网点状态")
    private String siteStatus;

    @JsonProperty("交易日期时间")
    private String txTime;

    @JsonProperty("语音版本")
    private String voiceVer;

    @JsonProperty("费率版本")
    private String feeVer;

    @JsonProperty("车互通白名单版本")
    private String bikeExWhitelistVer;

    @JsonProperty("卡互通白名单版本")
    private String cardExWhitelistVer;

    @JsonProperty("卡种白名单版本")
    private String cardClassWhitelistVer;

    @JsonProperty("互通城市白名单版本")
    private String exCityWhitelistVer;

    @JsonProperty("静态黑名单版本")
    private String staticBlacklistVer;

    @JsonProperty("动态名单版本")
    private String dynamicBlacklistVer;

    @JsonProperty("灰名单版本")
    private String greylistVer;

    @JsonProperty("温度")
    private int temp;

    @JsonProperty("电压")
    private int volt;

    @JsonProperty("经度")
    private int lng;

    @JsonProperty("纬度")
    private int lat;

    @JsonProperty("备车数量")
    private int resvCount;

    @JsonProperty("锁桩数量")
    private int lockCount;

    @JsonProperty("锁桩信息")
    private List<Lock> locksInfo;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(String siteStatus) {
        this.siteStatus = siteStatus;
    }

    public String getTxTime() {
        return txTime;
    }

    public void setTxTime(String txTime) {
        this.txTime = txTime;
    }

    public String getVoiceVer() {
        return voiceVer;
    }

    public void setVoiceVer(String voiceVer) {
        this.voiceVer = voiceVer;
    }

    public String getFeeVer() {
        return feeVer;
    }

    public void setFeeVer(String feeVer) {
        this.feeVer = feeVer;
    }

    public String getBikeExWhitelistVer() {
        return bikeExWhitelistVer;
    }

    public void setBikeExWhitelistVer(String bikeExWhitelistVer) {
        this.bikeExWhitelistVer = bikeExWhitelistVer;
    }

    public String getCardExWhitelistVer() {
        return cardExWhitelistVer;
    }

    public void setCardExWhitelistVer(String cardExWhitelistVer) {
        this.cardExWhitelistVer = cardExWhitelistVer;
    }

    public String getCardClassWhitelistVer() {
        return cardClassWhitelistVer;
    }

    public void setCardClassWhitelistVer(String cardClassWhitelistVer) {
        this.cardClassWhitelistVer = cardClassWhitelistVer;
    }

    public String getExCityWhitelistVer() {
        return exCityWhitelistVer;
    }

    public void setExCityWhitelistVer(String exCityWhitelistVer) {
        this.exCityWhitelistVer = exCityWhitelistVer;
    }

    public String getStaticBlacklistVer() {
        return staticBlacklistVer;
    }

    public void setStaticBlacklistVer(String staticBlacklistVer) {
        this.staticBlacklistVer = staticBlacklistVer;
    }

    public String getDynamicBlacklistVer() {
        return dynamicBlacklistVer;
    }

    public void setDynamicBlacklistVer(String dynamicBlacklistVer) {
        this.dynamicBlacklistVer = dynamicBlacklistVer;
    }

    public String getGreylistVer() {
        return greylistVer;
    }

    public void setGreylistVer(String greylistVer) {
        this.greylistVer = greylistVer;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getVolt() {
        return volt;
    }

    public void setVolt(int volt) {
        this.volt = volt;
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

    public int getResvCount() {
        return resvCount;
    }

    public void setResvCount(int resvCount) {
        this.resvCount = resvCount;
    }

    public int getLockCount() {
        return lockCount;
    }

    public void setLockCount(int lockCount) {
        this.lockCount = lockCount;
    }

    public List<Lock> getLocksInfo() {
        return locksInfo;
    }

    public void setLocksInfo(List<Lock> locksInfo) {
        this.locksInfo = locksInfo;
    }

    @Override
    public String getTxFlag() {
        return "S3";
    }

    private class Lock {
        @JsonProperty("锁桩编号")
        private String lockId;

        /**
         * 锁桩状态
         * 01：有车
         * 02：无车
         * 04：断线
         */
        @JsonProperty("锁桩状态")
        private String lockStatus;

        @JsonProperty("锁桩程序版本")
        private String programVer;

        @JsonProperty("自行车卡号")
        private String bikeCardId;

        public String getLockId() {
            return lockId;
        }

        public void setLockId(String lockId) {
            this.lockId = lockId;
        }

        public String getLockStatus() {
            return lockStatus;
        }

        public void setLockStatus(String lockStatus) {
            this.lockStatus = lockStatus;
        }

        public String getProgramVer() {
            return programVer;
        }

        public void setProgramVer(String programVer) {
            this.programVer = programVer;
        }

        public String getBikeCardId() {
            return bikeCardId;
        }

        public void setBikeCardId(String bikeCardId) {
            this.bikeCardId = bikeCardId;
        }
    }
}
