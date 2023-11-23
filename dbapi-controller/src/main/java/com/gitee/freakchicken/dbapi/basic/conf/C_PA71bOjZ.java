package com.gitee.freakchicken.dbapi.basic.conf;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_K7Ac0fQF;
import com.gitee.freakchicken.dbapi.basic.util.C_IvNrvvGl;
import com.gitee.freakchicken.dbapi.basic.util.C_LCGXNEh5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
@Slf4j
public class C_PA71bOjZ implements HandlerInterceptor {

    @Autowired
    C_K7Ac0fQF gf_3tajP8lS;

    @Override
    public boolean preHandle(HttpServletRequest p_uquaKCYF, HttpServletResponse p_AYIdBe1x, Object p_EgzC4xOf) throws Exception {
        log.debug(p_uquaKCYF.getServletPath());
        if (p_uquaKCYF.getMethod().equals(HttpMethod.OPTIONS)) {
            return true;
        }
        if (!(p_EgzC4xOf instanceof HandlerMethod)) {
            return true;
        }
        PrintWriter lf_moWINMkv = null;
        try {
            p_AYIdBe1x.setCharacterEncoding("UTF-8");
            p_AYIdBe1x.setContentType("application/json; charset=utf-8");
            String lf_gEgZ9FuV = p_uquaKCYF.getHeader("Authorization");
            if (lf_gEgZ9FuV == null) {
                p_AYIdBe1x.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_moWINMkv = p_AYIdBe1x.getWriter();
                lf_moWINMkv.append("No Token!");
                return false;
            }
            String lf_SF554Rgx = C_IvNrvvGl.m_s16vRQtu(lf_gEgZ9FuV);
            User lf_rjHiv4vA = gf_3tajP8lS.m_hJjtIII6(Integer.valueOf(lf_SF554Rgx));
            if (lf_rjHiv4vA == null) {
                p_AYIdBe1x.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_moWINMkv = p_AYIdBe1x.getWriter();
                lf_moWINMkv.append("User not exists!");
                return false;
            }
            boolean lf_HQmgAicx = C_IvNrvvGl.m_9dsDIXxD(lf_gEgZ9FuV, lf_rjHiv4vA.getPassword());
            if (lf_HQmgAicx) {
                p_uquaKCYF.setAttribute("id", lf_rjHiv4vA.getId());
                C_LCGXNEh5.m_5Y7ZjtMP(lf_rjHiv4vA);
                return true;
            } else {
                p_AYIdBe1x.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_moWINMkv = p_AYIdBe1x.getWriter();
                lf_moWINMkv.append("Token Invalid!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (lf_moWINMkv != null) {
                lf_moWINMkv.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest p_lp61LhOX, HttpServletResponse p_48nePJmX, Object p_1kBTZzrt, ModelAndView p_5o8LGgmp) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest p_PHM7g3jP, HttpServletResponse p_zjLJEaJ5, Object p_CRojkrOU, Exception p_e8eGjP5u) throws Exception {
        C_LCGXNEh5.m_R2RuOATz();
    }
}
