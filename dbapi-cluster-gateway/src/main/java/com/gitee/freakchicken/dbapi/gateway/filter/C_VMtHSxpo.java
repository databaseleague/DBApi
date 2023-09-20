package com.gitee.freakchicken.dbapi.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.gitee.freakchicken.dbapi.basic.service.C_pt3rVIPu;
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
public class C_VMtHSxpo implements GlobalFilter, Ordered {

    @Autowired
    C_pt3rVIPu gf_xgpVVUBl;

    @Override
    public Mono<Void> filter(ServerWebExchange p_IYtkqSb7, GatewayFilterChain p_xRWGPlor) {
        ServerHttpRequest lf_nQXBHDsx = p_IYtkqSb7.getRequest();
        ServerHttpResponse lf_n5S0pZIv = p_IYtkqSb7.getResponse();
        String lf_0rXYQkrn = lf_nQXBHDsx.getRemoteAddress().getHostString();
        if (!gf_xgpVVUBl.m_737vLk2e(lf_0rXYQkrn)) {
            log.info("ip forbidden : {}", lf_0rXYQkrn);
            String lf_wexGVDlx = JSON.toJSONString(ResponseDto.fail("Illegal ip (" + lf_0rXYQkrn + "), access forbidden"));
            DataBuffer lf_GMtsfisA = lf_n5S0pZIv.bufferFactory().wrap(lf_wexGVDlx.getBytes());
            return lf_n5S0pZIv.writeWith(Mono.just(lf_GMtsfisA));
        }
        return p_xRWGPlor.filter(p_IYtkqSb7);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
