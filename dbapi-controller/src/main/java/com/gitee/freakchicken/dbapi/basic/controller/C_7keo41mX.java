package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dbapi.apple.verify.SpecManager;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.JdbcDataSource;
import com.gitee.freakchicken.dbapi.basic.service.C_QZ7SgGKu;
import com.gitee.freakchicken.dbapi.basic.util.C_6y7jEQqq;
import com.gitee.freakchicken.dbapi.basic.util.C_VTgGlxrg;
import com.gitee.freakchicken.dbapi.basic.util.C_EBTXy8Ml;
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
public class C_7keo41mX {

    @Autowired
    C_QZ7SgGKu gf_NCMgAGuq;

    @RequestMapping("/add")
    public ResponseDto m_3VXKGDiZ(@RequestBody JSONObject jo) {
        DataSource lf_AsDc6tmE = new DataSource();
        lf_AsDc6tmE.setName(jo.getString("name"));
        lf_AsDc6tmE.setNote(jo.getString("note"));
        lf_AsDc6tmE.setType(jo.getString("type"));
        JSONObject lf_G4aICLkg = jo.getJSONObject("detail");
        if (lf_AsDc6tmE.isJdbcType()) {
            JdbcDataSource lf_L30kOPTg = lf_G4aICLkg.toJavaObject(JdbcDataSource.class);
            try {
                lf_L30kOPTg.setPassword(C_6y7jEQqq.m_3e9d6ATu(lf_L30kOPTg.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            lf_AsDc6tmE.setDetail(JSON.toJSONString(lf_L30kOPTg));
        }
        lf_AsDc6tmE.setCreateUserId(C_EBTXy8Ml.m_3gCYT3A1());
        return gf_NCMgAGuq.m_V6a25kgr(lf_AsDc6tmE);
    }

    @RequestMapping("/getAll")
    public List<DataSource> m_Alt8jRD3() {
        return gf_NCMgAGuq.m_iEZVEu9Q();
    }

    @RequestMapping("/getAllByType")
    public List<DataSource> m_dAGDOsOQ(String type) {
        return gf_NCMgAGuq.m_r5Rjcw88(type);
    }

    @RequestMapping("/detail/{id}")
    public DataSource m_AClQ5a39(@PathVariable String id) {
        return gf_NCMgAGuq.m_sUgJb8Zu(id);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_aebikW6x(@PathVariable String id) {
        return gf_NCMgAGuq.m_rB9eRxTd(id);
    }

    @RequestMapping("/update")
    public void m_w2VuFKhx(@RequestBody JSONObject jo) {
        DataSource lf_o4SIxMwY = new DataSource();
        lf_o4SIxMwY.setId(jo.getString("id"));
        lf_o4SIxMwY.setName(jo.getString("name"));
        lf_o4SIxMwY.setNote(jo.getString("note"));
        lf_o4SIxMwY.setType(jo.getString("type"));
        JSONObject lf_wHxik3pR = jo.getJSONObject("detail");
        if (lf_o4SIxMwY.isJdbcType()) {
            JdbcDataSource lf_qv1cXjnO = lf_wHxik3pR.toJavaObject(JdbcDataSource.class);
            if (lf_wHxik3pR.getBoolean("edit_password")) {
                try {
                    lf_qv1cXjnO.setPassword(C_6y7jEQqq.m_3e9d6ATu(lf_qv1cXjnO.getPassword()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lf_o4SIxMwY.setDetail(JSON.toJSONString(lf_qv1cXjnO));
        }
        lf_o4SIxMwY.setCreateUserId(C_EBTXy8Ml.m_3gCYT3A1());
        gf_NCMgAGuq.m_maZGJBfw(lf_o4SIxMwY);
    }

    @RequestMapping("/connect")
    public ResponseDto m_Du0FzTG9(JdbcDataSource dataSource) {
        Connection lf_2DlrGJ86 = null;
        try {
            lf_2DlrGJ86 = C_VTgGlxrg.m_rIJBlaiB(dataSource);
            return ResponseDto.apiSuccess(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseDto.fail(e.getMessage());
        } finally {
            if (lf_2DlrGJ86 != null) {
                try {
                    lf_2DlrGJ86.close();
                } catch (SQLException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    @RequestMapping("/export")
    public void m_04b1ZP9R(String ids, HttpServletResponse response) {
        List<String> lf_mLjc2IbF = Arrays.asList(ids.split(","));
        List<DataSource> lf_wmRbrXcO = gf_NCMgAGuq.m_FNffuUtH(lf_mLjc2IbF);
        String lf_FzTQJC0t = JSON.toJSONString(lf_wmRbrXcO);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=datasource.json");
        OutputStream lf_LU1XUaAG = null;
        try {
            lf_LU1XUaAG = response.getOutputStream();
            lf_LU1XUaAG.write(lf_FzTQJC0t.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_LU1XUaAG != null)
                    lf_LU1XUaAG.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_XfewunHu(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_tXexsSgC = IOUtils.toString(file.getInputStream(), "utf-8");
        List<DataSource> lf_iV9Ol1l0 = JSON.parseArray(lf_tXexsSgC, DataSource.class);
        Integer lf_mYT12hOv = gf_NCMgAGuq.m_AL9PmTko();
        if ((lf_mYT12hOv + lf_iV9Ol1l0.size()) > SpecManager.getDatasourceNum()) {
            throw new RuntimeException("The number of datasources exceeds the limit");
        }
        lf_iV9Ol1l0.stream().forEach(lambda_lf_YQRSm9Nt -> {
            lambda_lf_YQRSm9Nt.setCreateUserId(C_EBTXy8Ml.m_3gCYT3A1());
            lambda_lf_YQRSm9Nt.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_YQRSm9Nt.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_NCMgAGuq.m_IW2VJ7Ub(lf_iV9Ol1l0);
    }
}
