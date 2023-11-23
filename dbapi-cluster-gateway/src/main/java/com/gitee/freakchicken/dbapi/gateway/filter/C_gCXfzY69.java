package com.gitee.freakchicken.dbapi.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.service.C_3FeAXavv;
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
public class C_gCXfzY69 implements GlobalFilter, Ordered {

    @Autowired
    C_3FeAXavv gf_5NitapX8;

    @Override
    public Mono<Void> filter(ServerWebExchange p_8CcJixvB, GatewayFilterChain p_ViR5H4dY) {
        ServerHttpRequest lf_gfaZMtFu = p_8CcJixvB.getRequest();
        ServerHttpResponse lf_XfIt1RB9 = p_8CcJixvB.getResponse();
        String lf_lQQ669j9 = lf_gfaZMtFu.getRemoteAddress().getHostString();
        if (!gf_5NitapX8.m_uzribJzi(lf_lQQ669j9)) {
            log.info("ip forbidden : {}", lf_lQQ669j9);
            String lf_J352QXQ6 = JSON.toJSONString(ResponseDto.fail("Illegal ip (" + lf_lQQ669j9 + "), access forbidden"));
            DataBuffer lf_cPXpKby8 = lf_XfIt1RB9.bufferFactory().wrap(lf_J352QXQ6.getBytes());
            return lf_XfIt1RB9.writeWith(Mono.just(lf_cPXpKby8));
        }
        return p_ViR5H4dY.filter(p_8CcJixvB);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
