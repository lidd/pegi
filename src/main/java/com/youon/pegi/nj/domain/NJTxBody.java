package com.youon.pegi.nj.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.youon.pegi.nj.domain.frame.NJBody;

public class NJTxBody extends NJBody {
    /**
     * 交易类型
     * 01: 借车交易
     * 02: 还车刷卡交易
     * 03: 无卡还车
     * 99：黑名单交易
     * 05: 异常还车处理交易
     */
    @JsonProperty("交易类型")
    private String txType;

    @JsonProperty("城市代码")
    private String cityCode;

    @JsonProperty("卡号")
    private String cardId;

    @JsonProperty("卡公司编码")
    private String cardCorpId;

    @JsonProperty("卡类型")
    private int cardType;

    @JsonProperty("子卡类型")
    private int subCardType = 0;

    @JsonProperty("终端交易流水号")
    private int termTxId;

    @JsonProperty("交易前余额")
    private int balanceBeforeTx;

    @JsonProperty("交易金额")
    private int txMoney;

    @JsonProperty("交易日期时间")
    private String txTime;

    @JsonProperty("卡上交易次数")
    private int txCountsInCard = 0;

    @JsonProperty("卡版本")
    private int cardVer = 0;

    /**
     * 钱包编号，
     * 电子钱包：0，月票：1，在线账户：10
     */
    @JsonProperty("钱包编号")
    private int purseId = 0;

    @JsonProperty("TAC")
    private String tac;

    @JsonProperty("自行车卡号")
    private String bikeCardId;

    @JsonProperty("自行车卡公司编码")
    private String bikeCorpId;

    @JsonProperty("借车时间")
    private String rentTime;

    @JsonProperty("还车时间")
    private String returnTime;

    @JsonProperty("应收金额")
    private int amountReceivable = 0;

    @JsonProperty("操作员编号")
    private String operatorId;

    @JsonProperty("网点编号")
    private String branchId;

    @JsonProperty("借车锁桩编号")
    private String rentLockId;

    @JsonProperty("交易锁桩编号")
    private String txLockId;

    @JsonProperty("交易终端类型")
    private String txTermType;

    @JsonProperty("卡支付类型")
    private String cardPaymentType;

    @JsonProperty("卡种")
    private int cardClass;

    public String getTxType() {
        return txType;
    }

    public void setTxType(String txType) {
        this.txType = txType;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardCorpId() {
        return cardCorpId;
    }

    public void setCardCorpId(String cardCorpId) {
        this.cardCorpId = cardCorpId;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public int getSubCardType() {
        return subCardType;
    }

    public void setSubCardType(int subCardType) {
        this.subCardType = subCardType;
    }

    public int getTermTxId() {
        return termTxId;
    }

    public void setTermTxId(int termTxId) {
        this.termTxId = termTxId;
    }

    public int getBalanceBeforeTx() {
        return balanceBeforeTx;
    }

    public void setBalanceBeforeTx(int balanceBeforeTx) {
        this.balanceBeforeTx = balanceBeforeTx;
    }

    public int getTxMoney() {
        return txMoney;
    }

    public void setTxMoney(int txMoney) {
        this.txMoney = txMoney;
    }

    public String getTxTime() {
        return txTime;
    }

    public void setTxTime(String txTime) {
        this.txTime = txTime;
    }

    public int getTxCountsInCard() {
        return txCountsInCard;
    }

    public void setTxCountsInCard(int txCountsInCard) {
        this.txCountsInCard = txCountsInCard;
    }

    public int getCardVer() {
        return cardVer;
    }

    public void setCardVer(int cardVer) {
        this.cardVer = cardVer;
    }

    public int getPurseId() {
        return purseId;
    }

    public void setPurseId(int purseId) {
        this.purseId = purseId;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public String getBikeCardId() {
        return bikeCardId;
    }

    public void setBikeCardId(String bikeCardId) {
        this.bikeCardId = bikeCardId;
    }

    public String getBikeCorpId() {
        return bikeCorpId;
    }

    public void setBikeCorpId(String bikeCorpId) {
        this.bikeCorpId = bikeCorpId;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public int getAmountReceivable() {
        return amountReceivable;
    }

    public void setAmountReceivable(int amountReceivable) {
        this.amountReceivable = amountReceivable;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getRentLockId() {
        return rentLockId;
    }

    public void setRentLockId(String rentLockId) {
        this.rentLockId = rentLockId;
    }

    public String getTxLockId() {
        return txLockId;
    }

    public void setTxLockId(String txLockId) {
        this.txLockId = txLockId;
    }

    public String getTxTermType() {
        return txTermType;
    }

    public void setTxTermType(String txTermType) {
        this.txTermType = txTermType;
    }

    public String getCardPaymentType() {
        return cardPaymentType;
    }

    public void setCardPaymentType(String cardPaymentType) {
        this.cardPaymentType = cardPaymentType;
    }

    public int getCardClass() {
        return cardClass;
    }

    public void setCardClass(int cardClass) {
        this.cardClass = cardClass;
    }

    @Override
    public String getTxFlag() {
        return "S2";
    }
}
