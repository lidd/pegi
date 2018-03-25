package com.youon.pegi.nj.domain.frame;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Li dong
 */

public abstract class NJResp {

    @JsonProperty("操作员卡号")
    private String operatorCardId;

    @JsonProperty("终端编号")
    private String termId;

    @JsonProperty("SAM卡号")
    private String samId;

    @JsonProperty("会话流水号")
    private int sessionId;

    @JsonProperty("客户端发送日期时间")
    private String clientSendTime;

    @JsonProperty("中心流水号")
    private int centerBatchId;

    @JsonProperty("交易标志")
    private String txFlag;

    public String getOperatorCardId() {
        return operatorCardId;
    }

    public void setOperatorCardId(String operatorCardId) {
        this.operatorCardId = operatorCardId;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getSamId() {
        return samId;
    }

    public void setSamId(String samId) {
        this.samId = samId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getClientSendTime() {
        return clientSendTime;
    }

    public void setClientSendTime(String clientSendTime) {
        this.clientSendTime = clientSendTime;
    }

    public int getCenterBatchId() {
        return centerBatchId;
    }

    public void setCenterBatchId(int centerBatchId) {
        this.centerBatchId = centerBatchId;
    }

    public abstract String getTxFlag();

    public void setTxFlag(String txFlag) {
        this.txFlag = txFlag;
    }
}
