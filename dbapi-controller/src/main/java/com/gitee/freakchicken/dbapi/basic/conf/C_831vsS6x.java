package com.gitee.freakchicken.dbapi.basic.conf;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_x5KREvdK;
import com.gitee.freakchicken.dbapi.basic.util.C_rBywQc3Z;
import com.gitee.freakchicken.dbapi.basic.util.C_oagmA7fO;
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
public class C_831vsS6x implements HandlerInterceptor {

    @Autowired
    C_x5KREvdK gf_UtCOrSmm;

    @Override
    public boolean preHandle(HttpServletRequest p_tPqD31te, HttpServletResponse p_aiVJNBk7, Object p_61ACrq3j) throws Exception {
        log.debug(p_tPqD31te.getServletPath());
        if (p_tPqD31te.getMethod().equals(HttpMethod.OPTIONS)) {
            return true;
        }
        if (!(p_61ACrq3j instanceof HandlerMethod)) {
            return true;
        }
        PrintWriter lf_VIx6pKjm = null;
        try {
            p_aiVJNBk7.setCharacterEncoding("UTF-8");
            p_aiVJNBk7.setContentType("application/json; charset=utf-8");
            String lf_SroKEbjA = p_tPqD31te.getHeader("Authorization");
            if (lf_SroKEbjA == null) {
                p_aiVJNBk7.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_VIx6pKjm = p_aiVJNBk7.getWriter();
                lf_VIx6pKjm.append("No Token!");
                return false;
            }
            String lf_eb3NHhwd = C_rBywQc3Z.m_F6irqvr3(lf_SroKEbjA);
            User lf_hwZkEgYt = gf_UtCOrSmm.m_Bnzaj83M(Integer.valueOf(lf_eb3NHhwd));
            if (lf_hwZkEgYt == null) {
                p_aiVJNBk7.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_VIx6pKjm = p_aiVJNBk7.getWriter();
                lf_VIx6pKjm.append("User not exists!");
                return false;
            }
            boolean lf_Pvl8TFpp = C_rBywQc3Z.m_WvYAeOR5(lf_SroKEbjA, lf_hwZkEgYt.getPassword());
            if (lf_Pvl8TFpp) {
                p_tPqD31te.setAttribute("id", lf_hwZkEgYt.getId());
                C_oagmA7fO.m_PZJ8ith2(lf_hwZkEgYt);
                return true;
            } else {
                p_aiVJNBk7.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_VIx6pKjm = p_aiVJNBk7.getWriter();
                lf_VIx6pKjm.append("Token Invalid!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (lf_VIx6pKjm != null) {
                lf_VIx6pKjm.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest p_7DUxXncE, HttpServletResponse p_oQ4tASDM, Object p_hjzEB4ws, ModelAndView p_31bR280r) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest p_jefevSNJ, HttpServletResponse p_NG8XNYrU, Object p_XEjat3Ns, Exception p_zdb62WMB) throws Exception {
        C_oagmA7fO.m_zutGU1MO();
    }
}
