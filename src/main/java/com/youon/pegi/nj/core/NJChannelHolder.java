package com.youon.pegi.nj.core;

import com.youon.pegi.nj.domain.frame.NJResp;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Li dong
 */

@Component
public class NJChannelHolder {

    private final Map<String, Channel> channelMap = new ConcurrentHashMap<>();

    public void register(String termId, Channel channel) {
        if (termId != null)
            channelMap.put(termId, channel);
    }

    public void broadcast(NJResp resp) {
    }

    public Channel getChannel(String termId) {
        return channelMap.get(termId);
    }

    public void unregister(Channel channel) {
        for (Map.Entry<String, Channel> entry : channelMap.entrySet()) {
            if (Objects.equals(channel.id().asLongText(), entry.getValue().id().asLongText())) {
                channelMap.remove(entry.getKey());
            }
        }
    }
}
