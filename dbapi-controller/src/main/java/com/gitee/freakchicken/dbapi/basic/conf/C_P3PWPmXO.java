package com.gitee.freakchicken.dbapi.basic.conf;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_y5ZsO7HK;
import com.gitee.freakchicken.dbapi.basic.util.C_NRYCuMqs;
import com.gitee.freakchicken.dbapi.basic.util.C_EBTXy8Ml;
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
public class C_P3PWPmXO implements HandlerInterceptor {

    @Autowired
    C_y5ZsO7HK gf_72LBGlkT;

    @Override
    public boolean preHandle(HttpServletRequest p_V9dk4nFX, HttpServletResponse p_oGvvkpnN, Object p_S0Vc51Dm) throws Exception {
        log.debug(p_V9dk4nFX.getServletPath());
        if (p_V9dk4nFX.getMethod().equals(HttpMethod.OPTIONS)) {
            return true;
        }
        if (!(p_S0Vc51Dm instanceof HandlerMethod)) {
            return true;
        }
        PrintWriter lf_DyUj0gWH = null;
        try {
            p_oGvvkpnN.setCharacterEncoding("UTF-8");
            p_oGvvkpnN.setContentType("application/json; charset=utf-8");
            String lf_0FYpMLzc = p_V9dk4nFX.getHeader("Authorization");
            if (lf_0FYpMLzc == null) {
                p_oGvvkpnN.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_DyUj0gWH = p_oGvvkpnN.getWriter();
                lf_DyUj0gWH.append("No Token!");
                return false;
            }
            String lf_WDSSYc2x = C_NRYCuMqs.m_5sCL8tA0(lf_0FYpMLzc);
            User lf_zRKrHd8c = gf_72LBGlkT.m_5I3wVyfY(Integer.valueOf(lf_WDSSYc2x));
            if (lf_zRKrHd8c == null) {
                p_oGvvkpnN.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_DyUj0gWH = p_oGvvkpnN.getWriter();
                lf_DyUj0gWH.append("User not exists!");
                return false;
            }
            boolean lf_gQ7Za0Uh = C_NRYCuMqs.m_npRRCNjn(lf_0FYpMLzc, lf_zRKrHd8c.getPassword());
            if (lf_gQ7Za0Uh) {
                p_V9dk4nFX.setAttribute("id", lf_zRKrHd8c.getId());
                C_EBTXy8Ml.m_5h29pE3h(lf_zRKrHd8c);
                return true;
            } else {
                p_oGvvkpnN.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_DyUj0gWH = p_oGvvkpnN.getWriter();
                lf_DyUj0gWH.append("Token Invalid!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (lf_DyUj0gWH != null) {
                lf_DyUj0gWH.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest p_jbL9VnGE, HttpServletResponse p_an8N9aeR, Object p_IAcSSIbO, ModelAndView p_h3NroXu0) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest p_kROmCAd0, HttpServletResponse p_bNNuTPZE, Object p_L8iRozUj, Exception p_cI5aM1ld) throws Exception {
        C_EBTXy8Ml.m_NXYVnWhu();
    }
}
