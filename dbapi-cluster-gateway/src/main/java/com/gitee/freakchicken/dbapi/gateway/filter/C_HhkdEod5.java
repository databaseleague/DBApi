package com.gitee.freakchicken.dbapi.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.service.C_meAhBQ4r;
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
public class C_HhkdEod5 implements GlobalFilter, Ordered {

    @Autowired
    C_meAhBQ4r gf_nYsEeF08;

    @Override
    public Mono<Void> filter(ServerWebExchange p_yXN3AGFw, GatewayFilterChain p_VyBNW5fA) {
        ServerHttpRequest lf_0dgTmrMV = p_yXN3AGFw.getRequest();
        ServerHttpResponse lf_obVXvQC0 = p_yXN3AGFw.getResponse();
        String lf_kghHLDW2 = lf_0dgTmrMV.getRemoteAddress().getHostString();
        if (!gf_nYsEeF08.m_qONQy2N9(lf_kghHLDW2)) {
            log.info("ip forbidden : {}", lf_kghHLDW2);
            String lf_nmcXszj9 = JSON.toJSONString(ResponseDto.fail("Illegal ip (" + lf_kghHLDW2 + "), access forbidden"));
            DataBuffer lf_J1imlJ4W = lf_obVXvQC0.bufferFactory().wrap(lf_nmcXszj9.getBytes());
            return lf_obVXvQC0.writeWith(Mono.just(lf_J1imlJ4W));
        }
        return p_VyBNW5fA.filter(p_yXN3AGFw);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
