package com.gitee.freakchicken.dbapi.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.service.C_8CjE0s2l;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class C_8toaeM21 implements GlobalFilter, Ordered {

    @Autowired
    C_8CjE0s2l gf_4YoFwHrq;

    @Override
    public Mono<Void> filter(ServerWebExchange p_A93QHKEI, GatewayFilterChain p_0v0bcvDy) {
        ServerHttpRequest lf_5NtJ0GJA = p_A93QHKEI.getRequest();
        ServerHttpResponse lf_ASUa9pkv = p_A93QHKEI.getResponse();
        String lf_dob7c9QM = lf_5NtJ0GJA.getRemoteAddress().getHostString();
        if (!gf_4YoFwHrq.m_jLuD0Bt9(lf_dob7c9QM)) {
            log.info("ip forbidden : {}", lf_dob7c9QM);
            String lf_Tb3Up7vZ = JSON.toJSONString(ResponseDto.fail("Illegal ip (" + lf_dob7c9QM + "), access forbidden"));
            DataBuffer lf_MSbt3eZ8 = lf_ASUa9pkv.bufferFactory().wrap(lf_Tb3Up7vZ.getBytes());
            return lf_ASUa9pkv.writeWith(Mono.just(lf_MSbt3eZ8));
        }
        return p_0v0bcvDy.filter(p_A93QHKEI);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
