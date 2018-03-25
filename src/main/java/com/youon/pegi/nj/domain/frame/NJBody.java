package com.youon.pegi.nj.domain.frame;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Li dong
 */

public abstract class NJBody {

    @JsonProperty("操作员卡号")
    private String operatorCardId;

    @JsonProperty("终端机号")
    private String termId;

    @JsonProperty("SAM卡号")
    private String SAMCardId;

    @JsonProperty("会话流水号")
    private int sessionId;

    @JsonProperty("发送日期时间")
    private String sendTime;

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

    public String getSAMCardId() {
        return SAMCardId;
    }

    public void setSAMCardId(String SAMCardId) {
        this.SAMCardId = SAMCardId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public abstract String getTxFlag();

    public void setTxFlag(String txFlag) {
        this.txFlag = txFlag;
    }

}
