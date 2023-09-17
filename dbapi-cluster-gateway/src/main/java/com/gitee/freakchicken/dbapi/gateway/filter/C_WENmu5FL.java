package com.gitee.freakchicken.dbapi.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.service.C_E46GzSxW;
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
public class C_WENmu5FL implements GlobalFilter, Ordered {

    @Autowired
    C_E46GzSxW gf_aB2rHY1J;

    @Override
    public Mono<Void> filter(ServerWebExchange p_Bo1KJAIt, GatewayFilterChain p_aeETPIlv) {
        ServerHttpRequest lf_TzvkQOab = p_Bo1KJAIt.getRequest();
        ServerHttpResponse lf_Et47mO2f = p_Bo1KJAIt.getResponse();
        String lf_mX2GgFvI = lf_TzvkQOab.getRemoteAddress().getHostString();
        if (!gf_aB2rHY1J.m_XdXs6oW0(lf_mX2GgFvI)) {
            log.info("ip forbidden : {}", lf_mX2GgFvI);
            String lf_1vp9p65p = JSON.toJSONString(ResponseDto.fail("Illegal ip (" + lf_mX2GgFvI + "), access forbidden"));
            DataBuffer lf_12qaz4BU = lf_Et47mO2f.bufferFactory().wrap(lf_1vp9p65p.getBytes());
            return lf_Et47mO2f.writeWith(Mono.just(lf_12qaz4BU));
        }
        return p_aeETPIlv.filter(p_Bo1KJAIt);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
