package com.gitee.freakchicken.dbapi.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.service.C_UoTIlJoS;
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
public class C_tDp17dkI implements GlobalFilter, Ordered {

    @Autowired
    C_UoTIlJoS gf_vNMf5U08;

    @Override
    public Mono<Void> filter(ServerWebExchange p_FWa8rQRv, GatewayFilterChain p_SLoxol4o) {
        ServerHttpRequest lf_giyC7Klx = p_FWa8rQRv.getRequest();
        ServerHttpResponse lf_vXsA2QV4 = p_FWa8rQRv.getResponse();
        String lf_Q9xrv9nb = lf_giyC7Klx.getRemoteAddress().getHostString();
        if (!gf_vNMf5U08.m_m0qm5tbI(lf_Q9xrv9nb)) {
            log.info("ip forbidden : {}", lf_Q9xrv9nb);
            String lf_x49GTnAg = JSON.toJSONString(ResponseDto.fail("Illegal ip (" + lf_Q9xrv9nb + "), access forbidden"));
            DataBuffer lf_9SX9Ryg8 = lf_vXsA2QV4.bufferFactory().wrap(lf_x49GTnAg.getBytes());
            return lf_vXsA2QV4.writeWith(Mono.just(lf_9SX9Ryg8));
        }
        return p_SLoxol4o.filter(p_FWa8rQRv);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
