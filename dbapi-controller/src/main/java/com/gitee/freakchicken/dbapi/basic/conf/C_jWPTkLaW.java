package com.gitee.freakchicken.dbapi.basic.conf;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_Z5TGnMNO;
import com.gitee.freakchicken.dbapi.basic.util.C_0cSzX84s;
import com.gitee.freakchicken.dbapi.basic.util.C_9CYMzywH;
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
public class C_jWPTkLaW implements HandlerInterceptor {

    @Autowired
    C_Z5TGnMNO gf_THEZMlJc;

    @Override
    public boolean preHandle(HttpServletRequest p_ENIEb81Q, HttpServletResponse p_8dE2dgaI, Object p_FcWqanHn) throws Exception {
        log.debug(p_ENIEb81Q.getServletPath());
        if (p_ENIEb81Q.getMethod().equals(HttpMethod.OPTIONS)) {
            return true;
        }
        if (!(p_FcWqanHn instanceof HandlerMethod)) {
            return true;
        }
        PrintWriter lf_BqYXRoJ3 = null;
        try {
            p_8dE2dgaI.setCharacterEncoding("UTF-8");
            p_8dE2dgaI.setContentType("application/json; charset=utf-8");
            String lf_94nWdTUR = p_ENIEb81Q.getHeader("Authorization");
            if (lf_94nWdTUR == null) {
                p_8dE2dgaI.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_BqYXRoJ3 = p_8dE2dgaI.getWriter();
                lf_BqYXRoJ3.append("No Token!");
                return false;
            }
            String lf_rx5mGUMw = C_0cSzX84s.m_Qr85zeKb(lf_94nWdTUR);
            User lf_kre9B8PQ = gf_THEZMlJc.m_A3w38Q8O(Integer.valueOf(lf_rx5mGUMw));
            if (lf_kre9B8PQ == null) {
                p_8dE2dgaI.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_BqYXRoJ3 = p_8dE2dgaI.getWriter();
                lf_BqYXRoJ3.append("User not exists!");
                return false;
            }
            boolean lf_H7zDc9i4 = C_0cSzX84s.m_UmHh8RsX(lf_94nWdTUR, lf_kre9B8PQ.getPassword());
            if (lf_H7zDc9i4) {
                p_ENIEb81Q.setAttribute("id", lf_kre9B8PQ.getId());
                C_9CYMzywH.m_BzHE9RUa(lf_kre9B8PQ);
                return true;
            } else {
                p_8dE2dgaI.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_BqYXRoJ3 = p_8dE2dgaI.getWriter();
                lf_BqYXRoJ3.append("Token Invalid!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (lf_BqYXRoJ3 != null) {
                lf_BqYXRoJ3.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest p_oKYBm018, HttpServletResponse p_nxOmoriN, Object p_cJQuQCuV, ModelAndView p_vpYE7wDo) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest p_7vOMIPXV, HttpServletResponse p_hILOj17I, Object p_oQO5ntpu, Exception p_6a8IIQaT) throws Exception {
        C_9CYMzywH.m_WljzFKUY();
    }
}
