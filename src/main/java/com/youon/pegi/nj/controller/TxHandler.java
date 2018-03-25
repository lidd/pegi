package com.youon.pegi.nj.controller;

import com.youon.pegi.nj.domain.NJTxBody;
import com.youon.pegi.nj.domain.NJTxResp;
import com.youon.pegi.nj.infrastructure.BizHandler;
import org.springframework.stereotype.Controller;

/**
 * @author Li dong
 */

@Controller
public class TxHandler implements BizHandler<NJTxBody> {
    @Override
    public NJTxResp handle(NJTxBody njTxBody) {
        //todo 业务处理
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NJTxResp resp = new NJTxResp();
        resp.setOperatorCardId(njTxBody.getOperatorCardId());

        return resp;
    }
}
