package com.gitee.freakchicken.dbapi.basic.conf;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_Ei9EBY2s;
import com.gitee.freakchicken.dbapi.basic.util.C_tmJWNszs;
import com.gitee.freakchicken.dbapi.basic.util.C_vudUmpvO;
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
public class C_ZjARMek1 implements HandlerInterceptor {

    @Autowired
    C_Ei9EBY2s gf_m2IP0LVZ;

    @Override
    public boolean preHandle(HttpServletRequest p_V9cWD7Ab, HttpServletResponse p_0jAgjBPw, Object p_XiX3XSg8) throws Exception {
        log.debug(p_V9cWD7Ab.getServletPath());
        if (p_V9cWD7Ab.getMethod().equals(HttpMethod.OPTIONS)) {
            return true;
        }
        if (!(p_XiX3XSg8 instanceof HandlerMethod)) {
            return true;
        }
        PrintWriter lf_DneTBlUS = null;
        try {
            p_0jAgjBPw.setCharacterEncoding("UTF-8");
            p_0jAgjBPw.setContentType("application/json; charset=utf-8");
            String lf_YlL2GCRa = p_V9cWD7Ab.getHeader("Authorization");
            if (lf_YlL2GCRa == null) {
                p_0jAgjBPw.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_DneTBlUS = p_0jAgjBPw.getWriter();
                lf_DneTBlUS.append("No Token!");
                return false;
            }
            String lf_sK8JffOJ = C_tmJWNszs.m_qJp2x0Uk(lf_YlL2GCRa);
            User lf_YRVmQJAf = gf_m2IP0LVZ.m_oEgL2ByG(Integer.valueOf(lf_sK8JffOJ));
            if (lf_YRVmQJAf == null) {
                p_0jAgjBPw.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_DneTBlUS = p_0jAgjBPw.getWriter();
                lf_DneTBlUS.append("User not exists!");
                return false;
            }
            boolean lf_s4KDCBMF = C_tmJWNszs.m_OpOFNZ8q(lf_YlL2GCRa, lf_YRVmQJAf.getPassword());
            if (lf_s4KDCBMF) {
                p_V9cWD7Ab.setAttribute("id", lf_YRVmQJAf.getId());
                C_vudUmpvO.m_kttEiZn6(lf_YRVmQJAf);
                return true;
            } else {
                p_0jAgjBPw.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_DneTBlUS = p_0jAgjBPw.getWriter();
                lf_DneTBlUS.append("Token Invalid!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (lf_DneTBlUS != null) {
                lf_DneTBlUS.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest p_H8bGSy9X, HttpServletResponse p_7U4sXLHw, Object p_zWZZEWn2, ModelAndView p_OhHhkOD3) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest p_lffj9kGi, HttpServletResponse p_rMRxv58h, Object p_EgWmbhMU, Exception p_VslcOFxG) throws Exception {
        C_vudUmpvO.m_cRTrYAha();
    }
}
