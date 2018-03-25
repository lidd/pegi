package com.youon.pegi.nj.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.youon.pegi.nj.domain.frame.NJResp;

public class NJSeResp extends NJResp {

    @JsonProperty("应答码")
    private String respCode;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    @Override
    public String getTxFlag() {
        return null;
    }
}
