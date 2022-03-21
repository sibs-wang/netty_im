package com.wang.util;


import lombok.Data;

import java.io.Serializable;

@Data
public class MsgModel<T> implements Serializable {
    private Integer action;

    private T data;
}
