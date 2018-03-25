package com.youon.pegi.nj.domain.frame;

import com.youon.pegi.nj.infrastructure.Message;

/**
 * @author Li dong
 */

public class NJFrame implements Message {
    /**
     * 包长度	本消息报文的长度（不包括长度本身）
     */
    private int length;

    /**
     * <table>
     * <tr><td>字段</td><td>描述</td><td>类型</td><td>长度</td></tr>
     * <tr><td>消息类型码</td><td>标识报文类型的特征数据</td><td>b</td><td>2</td></tr>
     * <tr><td>终端编号</td><td>节点标识码，表明本消息的发送方。消息在节点间传递时，转发方应将自己的节点标识码放在此字段中，然后发送。在回应答时，应答方不改变该部分。</td><td>bcd</td><td>4</td></tr>
     * <tr><td>会话流水号</td><td>保留</td><td>b</td><td>4</td></tr>
     * <tr><td>包序列号</td><td>保留</td><td>b</td><td>2</td></tr>
     * <tr><td>最后包标志</td><td>保留</td><td>b</td><td>1</td></tr>
     * <tr><td>包记录数</td><td>定值1</td><td>b</td><td>2</td></tr>
     * <tr><td>MAC加密算法</td><td>0 – 不加密</br>1 –加密</td><td>b</td><td>1</td></tr>
     * </table>
     */
    private NJHeader head;

    /**
     * 使用Unicode编码（UTF-8方式），JSON格式数据
     */
    private String body;

    private byte[] mac;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public NJHeader getHead() {
        return head;
    }

    public void setHead(NJHeader head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public byte[] getMac() {
        return mac;
    }

    public void setMac(byte[] mac) {
        this.mac = mac;
    }
}
