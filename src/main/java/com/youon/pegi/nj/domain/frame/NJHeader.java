package com.youon.pegi.nj.domain.frame;

/**
 * @author Li dong
 */

public class NJHeader {
    private int frameType;

    private long posId;

    private long sessionId;

    private int frameId;

    private short lastFlag;

    private short frameCnt;

    private byte checkMac;

    public int getFrameType() {
        return frameType;
    }

    public void setFrameType(int frameType) {
        this.frameType = frameType;
    }

    public long getPosId() {
        return posId;
    }

    public void setPosId(long posId) {
        this.posId = posId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public int getFrameId() {
        return frameId;
    }

    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }

    public short getLastFlag() {
        return lastFlag;
    }

    public void setLastFlag(short lastFlag) {
        this.lastFlag = lastFlag;
    }

    public short getFrameCnt() {
        return frameCnt;
    }

    public void setFrameCnt(short frameCnt) {
        this.frameCnt = frameCnt;
    }

    public byte getCheckMac() {
        return checkMac;
    }

    public void setCheckMac(byte checkMac) {
        this.checkMac = checkMac;
    }
}
