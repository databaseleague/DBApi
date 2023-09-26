package com.gitee.freakchicken.dbapi.basic.conf;

import com.gitee.freakchicken.dbapi.basic.domain.User;
import com.gitee.freakchicken.dbapi.basic.service.C_FCdl5BaH;
import com.gitee.freakchicken.dbapi.basic.util.C_ykKSYJrZ;
import com.gitee.freakchicken.dbapi.basic.util.C_pW4Y7Qx2;
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
public class C_mVqlya6Y implements HandlerInterceptor {

    @Autowired
    C_FCdl5BaH gf_LCuMRX2r;

    @Override
    public boolean preHandle(HttpServletRequest p_W2efQfhe, HttpServletResponse p_fhd5FVrB, Object p_B4n17mjZ) throws Exception {
        log.debug(p_W2efQfhe.getServletPath());
        if (p_W2efQfhe.getMethod().equals(HttpMethod.OPTIONS)) {
            return true;
        }
        if (!(p_B4n17mjZ instanceof HandlerMethod)) {
            return true;
        }
        PrintWriter lf_rqfoVyC3 = null;
        try {
            p_fhd5FVrB.setCharacterEncoding("UTF-8");
            p_fhd5FVrB.setContentType("application/json; charset=utf-8");
            String lf_GnVVNOHX = p_W2efQfhe.getHeader("Authorization");
            if (lf_GnVVNOHX == null) {
                p_fhd5FVrB.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_rqfoVyC3 = p_fhd5FVrB.getWriter();
                lf_rqfoVyC3.append("No Token!");
                return false;
            }
            String lf_BzfPDP6i = C_ykKSYJrZ.m_Kim7MLJe(lf_GnVVNOHX);
            User lf_dJNco5r6 = gf_LCuMRX2r.m_QB6y10yr(Integer.valueOf(lf_BzfPDP6i));
            if (lf_dJNco5r6 == null) {
                p_fhd5FVrB.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_rqfoVyC3 = p_fhd5FVrB.getWriter();
                lf_rqfoVyC3.append("User not exists!");
                return false;
            }
            boolean lf_xCxeJp8G = C_ykKSYJrZ.m_vN7rAw5o(lf_GnVVNOHX, lf_dJNco5r6.getPassword());
            if (lf_xCxeJp8G) {
                p_W2efQfhe.setAttribute("id", lf_dJNco5r6.getId());
                C_pW4Y7Qx2.m_utCY5Dgl(lf_dJNco5r6);
                return true;
            } else {
                p_fhd5FVrB.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                lf_rqfoVyC3 = p_fhd5FVrB.getWriter();
                lf_rqfoVyC3.append("Token Invalid!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (lf_rqfoVyC3 != null) {
                lf_rqfoVyC3.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest p_F4vhJS4M, HttpServletResponse p_LARMDMho, Object p_kAkUAplQ, ModelAndView p_mkzPd7nR) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest p_DnxBGYjn, HttpServletResponse p_HoFq6APQ, Object p_wRiJ3fzA, Exception p_R8BRa05C) throws Exception {
        C_pW4Y7Qx2.m_e7NOzlDg();
    }
}
