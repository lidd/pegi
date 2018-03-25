package com.youon.pegi.nj.constants;

import com.youon.pegi.nj.domain.NJSeBody;
import com.youon.pegi.nj.domain.NJTxBody;
import com.youon.pegi.nj.domain.frame.NJBody;
import com.youon.pegi.nj.infrastructure.BizHandler;
import com.youon.pegi.nj.controller.SeHandler;
import com.youon.pegi.nj.controller.TxHandler;

/**
 * @author Li dong
 */
public enum NJTypeBodyHandlerBinder {

    TX($(0x01, 0x02), NJTxBody.class, TxHandler.class),

    SE($(0x01, 0x03), NJSeBody.class, SeHandler.class);

    /**
     * Use enum to bind frame type,body and handler.No need to modify the follow code,
     * just write the type you want to add as <code>TX(convert(0x01, 0x02), NJTxBody.class, TxHandler.class)</code>
     */
    private static int $(int b1, int b2) {
        return (b1 << 8) | b2;
    }

    public static NJTypeBodyHandlerBinder findBinder(int type) {
        for (NJTypeBodyHandlerBinder frameType : values()) {
            if (frameType.getType() == type) {
                return frameType;
            }
        }
        return null;
    }

    private int type;

    private Class<NJBody> bodyClass;

    private Class<BizHandler> handlerClass;

    <B extends NJBody,H extends BizHandler> NJTypeBodyHandlerBinder(int type, Class<B> bodyClass, Class<H> handlerClass) {
        this.type = type;
        this.bodyClass = (Class<NJBody>) bodyClass;
        this.handlerClass = (Class<BizHandler>) handlerClass;
    }

    public Class<BizHandler> getHandlerClass() {
        return handlerClass;
    }

    public void setHandlerClass(Class<BizHandler> handlerClass) {
        this.handlerClass = handlerClass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Class<NJBody> getBodyClass() {
        return bodyClass;
    }

    public void setBodyClass(Class<NJBody> bodyClass) {
        this.bodyClass = bodyClass;
    }
}
