package com.gitee.freakchicken.dbapi.basic.conf;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_b47wiYIN;
import com.gitee.freakchicken.dbapi.basic.util.C_bzOuiv2k;
import com.gitee.freakchicken.dbapi.basic.util.C_idPcCdpc;
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
public class C_PFeTZYuk implements HandlerInterceptor {

    @Autowired
    C_b47wiYIN gf_fw18GuOi;

    @Override
    public boolean preHandle(HttpServletRequest p_WS35LsxV, HttpServletResponse p_NSAYQWrw, Object p_4uETXj2P) throws Exception {
        log.debug(p_WS35LsxV.getServletPath());
        if (p_WS35LsxV.getMethod().equals(HttpMethod.OPTIONS)) {
            return true;
        }
        if (!(p_4uETXj2P instanceof HandlerMethod)) {
            return true;
        }
        PrintWriter lf_YNM7u4qC = null;
        try {
            p_NSAYQWrw.setCharacterEncoding("UTF-8");
            p_NSAYQWrw.setContentType("application/json; charset=utf-8");
            String lf_mdzVfqV4 = p_WS35LsxV.getHeader("Authorization");
            if (lf_mdzVfqV4 == null) {
                p_NSAYQWrw.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_YNM7u4qC = p_NSAYQWrw.getWriter();
                lf_YNM7u4qC.append("No Token!");
                return false;
            }
            String lf_7wHNfpzy = C_bzOuiv2k.m_gv0CVaBG(lf_mdzVfqV4);
            User lf_pmYXVjGV = gf_fw18GuOi.m_BwFeAQJz(Integer.valueOf(lf_7wHNfpzy));
            if (lf_pmYXVjGV == null) {
                p_NSAYQWrw.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_YNM7u4qC = p_NSAYQWrw.getWriter();
                lf_YNM7u4qC.append("User not exists!");
                return false;
            }
            boolean lf_PCjvGpeA = C_bzOuiv2k.m_DVsEimqb(lf_mdzVfqV4, lf_pmYXVjGV.getPassword());
            if (lf_PCjvGpeA) {
                p_WS35LsxV.setAttribute("id", lf_pmYXVjGV.getId());
                C_idPcCdpc.m_pjz8qc2I(lf_pmYXVjGV);
                return true;
            } else {
                p_NSAYQWrw.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_YNM7u4qC = p_NSAYQWrw.getWriter();
                lf_YNM7u4qC.append("Token Invalid!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (lf_YNM7u4qC != null) {
                lf_YNM7u4qC.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest p_uz8B5bFJ, HttpServletResponse p_DwoPPma2, Object p_EiukNOGF, ModelAndView p_N0wlASQI) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest p_mmLOnA1V, HttpServletResponse p_dymYPwHJ, Object p_1D1TN4EM, Exception p_XH4kyzbz) throws Exception {
        C_idPcCdpc.m_VRFB3YVw();
    }
}
