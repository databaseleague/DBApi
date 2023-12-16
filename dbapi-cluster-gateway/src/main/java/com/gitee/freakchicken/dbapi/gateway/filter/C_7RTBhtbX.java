package com.gitee.freakchicken.dbapi.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.service.C_1evcT41m;
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
public class C_7RTBhtbX implements GlobalFilter, Ordered {

    @Autowired
    C_1evcT41m gf_2osORYJh;

    @Override
    public Mono<Void> filter(ServerWebExchange p_xb1ZfpzV, GatewayFilterChain p_NKTQCB2i) {
        ServerHttpRequest lf_jkQmUopa = p_xb1ZfpzV.getRequest();
        ServerHttpResponse lf_NGdh4rl6 = p_xb1ZfpzV.getResponse();
        String lf_0p40Gisw = lf_jkQmUopa.getRemoteAddress().getHostString();
        if (!gf_2osORYJh.m_htscuq3s(lf_0p40Gisw)) {
            log.info("ip forbidden : {}", lf_0p40Gisw);
            String lf_anKnvA56 = JSON.toJSONString(ResponseDto.fail("Illegal ip (" + lf_0p40Gisw + "), access forbidden"));
            DataBuffer lf_jiyLkn4n = lf_NGdh4rl6.bufferFactory().wrap(lf_anKnvA56.getBytes());
            return lf_NGdh4rl6.writeWith(Mono.just(lf_jiyLkn4n));
        }
        return p_NKTQCB2i.filter(p_xb1ZfpzV);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
