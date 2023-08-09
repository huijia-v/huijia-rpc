package com.huijia.impl;

import com.huijia.HelloRpc;

/**
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/8/9 22:44
 */
public class HelloRpcImpl implements HelloRpc {
    @Override
    public String sayHi(String msg) {
        return "provider get msg:" + msg;
    }

}
