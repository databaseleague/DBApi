package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dbapi.apple.verify.SpecManager;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.JdbcDataSource;
import com.gitee.freakchicken.dbapi.basic.service.C_DNpMVP6y;
import com.gitee.freakchicken.dbapi.basic.util.C_tz9SKzDQ;
import com.gitee.freakchicken.dbapi.basic.util.C_31nDdnvP;
import com.gitee.freakchicken.dbapi.basic.util.C_9CYMzywH;
import com.gitee.freakchicken.dbapi.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/datasource")
public class C_S0UIDRN5 {

    @Autowired
    C_DNpMVP6y gf_TvWZtROj;

    @RequestMapping("/add")
    public ResponseDto m_EGyiS6Xk(@RequestBody JSONObject jo) {
        DataSource lf_SoeOvQ7r = new DataSource();
        lf_SoeOvQ7r.setName(jo.getString("name"));
        lf_SoeOvQ7r.setNote(jo.getString("note"));
        lf_SoeOvQ7r.setType(jo.getString("type"));
        JSONObject lf_9qWUPMQL = jo.getJSONObject("detail");
        if (lf_SoeOvQ7r.isJdbcType()) {
            JdbcDataSource lf_GByldQzj = lf_9qWUPMQL.toJavaObject(JdbcDataSource.class);
            try {
                lf_GByldQzj.setPassword(C_tz9SKzDQ.m_xlpIsQKe(lf_GByldQzj.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            lf_SoeOvQ7r.setDetail(JSON.toJSONString(lf_GByldQzj));
        }
        lf_SoeOvQ7r.setCreateUserId(C_9CYMzywH.m_PvlTFGSh());
        return gf_TvWZtROj.m_2zkqo2K8(lf_SoeOvQ7r);
    }

    @RequestMapping("/getAll")
    public List<DataSource> m_yKWNcKhD() {
        return gf_TvWZtROj.m_et2h3rTx();
    }

    @RequestMapping("/getAllByType")
    public List<DataSource> m_IRIFC7gp(String type) {
        return gf_TvWZtROj.m_G0W76Fnz(type);
    }

    @RequestMapping("/detail/{id}")
    public DataSource m_UFVl3ey5(@PathVariable String id) {
        return gf_TvWZtROj.m_tck0gaQC(id);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_ZVxgZJio(@PathVariable String id) {
        return gf_TvWZtROj.m_zVSPG1mp(id);
    }

    @RequestMapping("/update")
    public void m_691Wi5EA(@RequestBody JSONObject jo) {
        DataSource lf_RHGaWqW0 = new DataSource();
        lf_RHGaWqW0.setId(jo.getString("id"));
        lf_RHGaWqW0.setName(jo.getString("name"));
        lf_RHGaWqW0.setNote(jo.getString("note"));
        lf_RHGaWqW0.setType(jo.getString("type"));
        JSONObject lf_1WnTU17z = jo.getJSONObject("detail");
        if (lf_RHGaWqW0.isJdbcType()) {
            JdbcDataSource lf_zvsUbyCD = lf_1WnTU17z.toJavaObject(JdbcDataSource.class);
            if (lf_1WnTU17z.getBoolean("edit_password")) {
                try {
                    lf_zvsUbyCD.setPassword(C_tz9SKzDQ.m_xlpIsQKe(lf_zvsUbyCD.getPassword()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lf_RHGaWqW0.setDetail(JSON.toJSONString(lf_zvsUbyCD));
        }
        lf_RHGaWqW0.setCreateUserId(C_9CYMzywH.m_PvlTFGSh());
        gf_TvWZtROj.m_Jcbhg86Z(lf_RHGaWqW0);
    }

    @RequestMapping("/connect")
    public ResponseDto m_ngYxPDc1(JdbcDataSource dataSource) {
        Connection lf_j09oroiN = null;
        try {
            lf_j09oroiN = C_31nDdnvP.m_DhzpizRg(dataSource);
            return ResponseDto.apiSuccess(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseDto.fail(e.getMessage());
        } finally {
            if (lf_j09oroiN != null) {
                try {
                    lf_j09oroiN.close();
                } catch (SQLException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    @RequestMapping("/export")
    public void m_CVE2Yf4c(String ids, HttpServletResponse response) {
        List<String> lf_1zdKyXF5 = Arrays.asList(ids.split(","));
        List<DataSource> lf_Amvsa6qO = gf_TvWZtROj.m_5XCxItTQ(lf_1zdKyXF5);
        String lf_IWA1BOn3 = JSON.toJSONString(lf_Amvsa6qO);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=datasource.json");
        OutputStream lf_9oxXJtDl = null;
        try {
            lf_9oxXJtDl = response.getOutputStream();
            lf_9oxXJtDl.write(lf_IWA1BOn3.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_9oxXJtDl != null)
                    lf_9oxXJtDl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_S9Xoy3iF(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_0nYytyoH = IOUtils.toString(file.getInputStream(), "utf-8");
        List<DataSource> lf_LTJgYXWq = JSON.parseArray(lf_0nYytyoH, DataSource.class);
        Integer lf_ftp6acxY = gf_TvWZtROj.m_hs9kYhik();
        if ((lf_ftp6acxY + lf_LTJgYXWq.size()) > SpecManager.getDatasourceNum()) {
            throw new RuntimeException("The number of datasources exceeds the limit");
        }
        lf_LTJgYXWq.stream().forEach(lambda_lf_OHHuQuD7 -> {
            lambda_lf_OHHuQuD7.setCreateUserId(C_9CYMzywH.m_PvlTFGSh());
            lambda_lf_OHHuQuD7.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_OHHuQuD7.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_TvWZtROj.m_HtMFuBOm(lf_LTJgYXWq);
    }
}
