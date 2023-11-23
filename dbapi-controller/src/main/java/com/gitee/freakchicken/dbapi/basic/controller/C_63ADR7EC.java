package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dbapi.C_CtyAZ80Y;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.JdbcDataSource;
import com.gitee.freakchicken.dbapi.basic.service.C_PPKGzyLn;
import com.gitee.freakchicken.dbapi.basic.util.C_remwVx8I;
import com.gitee.freakchicken.dbapi.basic.util.C_TfP8QHJa;
import com.gitee.freakchicken.dbapi.basic.util.C_LCGXNEh5;
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
public class C_63ADR7EC {

    @Autowired
    C_PPKGzyLn gf_S8o2aANw;

    @RequestMapping("/add")
    public ResponseDto m_TAsM9T4D(@RequestBody JSONObject jo) {
        DataSource lf_QflzQbj3 = new DataSource();
        lf_QflzQbj3.setName(jo.getString("name"));
        lf_QflzQbj3.setNote(jo.getString("note"));
        lf_QflzQbj3.setType(jo.getString("type"));
        JSONObject lf_PfuUqYSx = jo.getJSONObject("detail");
        if (lf_QflzQbj3.isJdbcType()) {
            JdbcDataSource lf_BQTvHx80 = lf_PfuUqYSx.toJavaObject(JdbcDataSource.class);
            try {
                lf_BQTvHx80.setPassword(C_remwVx8I.m_HhDnG628(lf_BQTvHx80.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            lf_QflzQbj3.setDetail(JSON.toJSONString(lf_BQTvHx80));
        }
        lf_QflzQbj3.setCreateUserId(C_LCGXNEh5.m_4r4IiO0Z());
        return gf_S8o2aANw.m_QVL746zo(lf_QflzQbj3);
    }

    @RequestMapping("/getAll")
    public List<DataSource> m_AgoJFTKb() {
        return gf_S8o2aANw.m_q9gY0qn0();
    }

    @RequestMapping("/getAllByType")
    public List<DataSource> m_BisZF5VP(String type) {
        return gf_S8o2aANw.m_aOcJpVCM(type);
    }

    @RequestMapping("/detail/{id}")
    public DataSource m_ZQ6LX4ty(@PathVariable String id) {
        return gf_S8o2aANw.m_ggRKn4xy(id);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_uYb2d60v(@PathVariable String id) {
        return gf_S8o2aANw.m_jJHgNzYS(id);
    }

    @RequestMapping("/update")
    public void m_90d9QFaY(@RequestBody JSONObject jo) {
        DataSource lf_9h8SBftf = new DataSource();
        lf_9h8SBftf.setId(jo.getString("id"));
        lf_9h8SBftf.setName(jo.getString("name"));
        lf_9h8SBftf.setNote(jo.getString("note"));
        lf_9h8SBftf.setType(jo.getString("type"));
        JSONObject lf_WjV6t9d0 = jo.getJSONObject("detail");
        if (lf_9h8SBftf.isJdbcType()) {
            JdbcDataSource lf_64ot4r9t = lf_WjV6t9d0.toJavaObject(JdbcDataSource.class);
            if (lf_WjV6t9d0.getBoolean("edit_password")) {
                try {
                    lf_64ot4r9t.setPassword(C_remwVx8I.m_HhDnG628(lf_64ot4r9t.getPassword()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lf_9h8SBftf.setDetail(JSON.toJSONString(lf_64ot4r9t));
        }
        lf_9h8SBftf.setCreateUserId(C_LCGXNEh5.m_4r4IiO0Z());
        gf_S8o2aANw.m_Vff0hr2a(lf_9h8SBftf);
    }

    @RequestMapping("/connect")
    public ResponseDto m_9PCruo5b(JdbcDataSource dataSource) {
        Connection lf_ud1NuwJp = null;
        try {
            lf_ud1NuwJp = C_TfP8QHJa.m_Y5MYniFj(dataSource);
            return ResponseDto.apiSuccess(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseDto.fail(e.getMessage());
        } finally {
            if (lf_ud1NuwJp != null) {
                try {
                    lf_ud1NuwJp.close();
                } catch (SQLException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    @RequestMapping("/export")
    public void m_nvZ6QP6B(String ids, HttpServletResponse response) {
        List<String> lf_AM0gtRvG = Arrays.asList(ids.split(","));
        List<DataSource> lf_33uru00y = gf_S8o2aANw.m_ryeIemAd(lf_AM0gtRvG);
        String lf_Sz9cTxBa = JSON.toJSONString(lf_33uru00y);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=datasource.json");
        OutputStream lf_iYDzbpe5 = null;
        try {
            lf_iYDzbpe5 = response.getOutputStream();
            lf_iYDzbpe5.write(lf_Sz9cTxBa.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_iYDzbpe5 != null)
                    lf_iYDzbpe5.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_ZsJ0mGkt(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_rtN8awEI = IOUtils.toString(file.getInputStream(), "utf-8");
        List<DataSource> lf_mD4nntFm = JSON.parseArray(lf_rtN8awEI, DataSource.class);
        Integer lf_mgKoAznn = gf_S8o2aANw.m_39uBLdbm();
        if ((lf_mgKoAznn + lf_mD4nntFm.size()) > C_CtyAZ80Y.m_pD9uPoml()) {
            throw new RuntimeException("The number of datasources exceeds the limit");
        }
        lf_mD4nntFm.stream().forEach(lambda_lf_Kbnpgsan -> {
            lambda_lf_Kbnpgsan.setCreateUserId(C_LCGXNEh5.m_4r4IiO0Z());
            lambda_lf_Kbnpgsan.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_Kbnpgsan.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_S8o2aANw.m_1Sk40boM(lf_mD4nntFm);
    }
}
