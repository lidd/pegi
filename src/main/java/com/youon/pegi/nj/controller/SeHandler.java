package com.youon.pegi.nj.controller;

import com.youon.pegi.nj.domain.NJSeBody;
import com.youon.pegi.nj.domain.NJSeResp;
import com.youon.pegi.nj.infrastructure.BizHandler;
import org.springframework.stereotype.Controller;

/**
 * @author Li dong
 */
@Controller
public class SeHandler implements BizHandler<NJSeBody> {
    @Override
    public NJSeResp handle(NJSeBody njSeBody) {
        NJSeResp resp = new NJSeResp();
        resp.setOperatorCardId(njSeBody.getOperatorCardId());
        return resp;
    }
}
