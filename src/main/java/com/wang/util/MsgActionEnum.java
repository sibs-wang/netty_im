package com.wang.util;

public enum MsgActionEnum {
    BIND(1, "第一次(或重连)初始化连接"),
    CHAT(2, "聊天消息"),
    SIGNED(3, "消息签收"),
    KEEP_ALIVE(4, "心跳消息"),
    PULL_FRIEND(5, "拉取好友"),
    FRIEND_REQUEST(6, "请求添加为好友"),
    FORCE_OFFLINE(7, "账号在异地登录，您已被挤下线");

    public final Integer type;
    public final String content;

    MsgActionEnum(Integer type, String content){
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }
}
