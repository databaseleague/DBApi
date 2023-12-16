package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dbapi.C_1muQm9UY;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.JdbcDataSource;
import com.gitee.freakchicken.dbapi.basic.service.C_ZkDf0MyS;
import com.gitee.freakchicken.dbapi.basic.util.C_ZLBvw2qY;
import com.gitee.freakchicken.dbapi.basic.util.C_QQPsbS0G;
import com.gitee.freakchicken.dbapi.basic.util.C_vudUmpvO;
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
public class C_6sRyXYzM {

    @Autowired
    C_ZkDf0MyS gf_L8nJROMM;

    @RequestMapping("/add")
    public ResponseDto m_6UEEHbYg(@RequestBody JSONObject jo) {
        DataSource lf_Hq5AKjQ2 = new DataSource();
        lf_Hq5AKjQ2.setName(jo.getString("name"));
        lf_Hq5AKjQ2.setNote(jo.getString("note"));
        lf_Hq5AKjQ2.setType(jo.getString("type"));
        JSONObject lf_BfntLw4c = jo.getJSONObject("detail");
        if (lf_Hq5AKjQ2.isJdbcType()) {
            JdbcDataSource lf_UNO6uSl1 = lf_BfntLw4c.toJavaObject(JdbcDataSource.class);
            try {
                lf_UNO6uSl1.setPassword(C_ZLBvw2qY.m_xIOhDcze(lf_UNO6uSl1.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            lf_Hq5AKjQ2.setDetail(JSON.toJSONString(lf_UNO6uSl1));
        }
        lf_Hq5AKjQ2.setCreateUserId(C_vudUmpvO.m_4zzh6Q4j());
        return gf_L8nJROMM.m_beLGXra1(lf_Hq5AKjQ2);
    }

    @RequestMapping("/getAll")
    public List<DataSource> m_R6gxG6tQ() {
        return gf_L8nJROMM.m_qs9bzu7a();
    }

    @RequestMapping("/getAllByType")
    public List<DataSource> m_eIUESblS(String type) {
        return gf_L8nJROMM.m_loUtbBGG(type);
    }

    @RequestMapping("/detail/{id}")
    public DataSource m_yJxdDcZe(@PathVariable String id) {
        return gf_L8nJROMM.m_GYWILPej(id);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_sRPVFqUf(@PathVariable String id) {
        return gf_L8nJROMM.m_DZ8iLY3c(id);
    }

    @RequestMapping("/update")
    public void m_V815zgAu(@RequestBody JSONObject jo) {
        DataSource lf_CzD6VUKm = new DataSource();
        lf_CzD6VUKm.setId(jo.getString("id"));
        lf_CzD6VUKm.setName(jo.getString("name"));
        lf_CzD6VUKm.setNote(jo.getString("note"));
        lf_CzD6VUKm.setType(jo.getString("type"));
        JSONObject lf_zo3JtkOm = jo.getJSONObject("detail");
        if (lf_CzD6VUKm.isJdbcType()) {
            JdbcDataSource lf_iN0Wq3NW = lf_zo3JtkOm.toJavaObject(JdbcDataSource.class);
            if (lf_zo3JtkOm.getBoolean("edit_password")) {
                try {
                    lf_iN0Wq3NW.setPassword(C_ZLBvw2qY.m_xIOhDcze(lf_iN0Wq3NW.getPassword()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lf_CzD6VUKm.setDetail(JSON.toJSONString(lf_iN0Wq3NW));
        }
        lf_CzD6VUKm.setCreateUserId(C_vudUmpvO.m_4zzh6Q4j());
        gf_L8nJROMM.m_k2BLodHR(lf_CzD6VUKm);
    }

    @RequestMapping("/connect")
    public ResponseDto m_I2JY8xPQ(JdbcDataSource dataSource) {
        Connection lf_BhvPWLRa = null;
        try {
            lf_BhvPWLRa = C_QQPsbS0G.m_iXjcATa1(dataSource);
            return ResponseDto.apiSuccess(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseDto.fail(e.getMessage());
        } finally {
            if (lf_BhvPWLRa != null) {
                try {
                    lf_BhvPWLRa.close();
                } catch (SQLException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    @RequestMapping("/export")
    public void m_xcX1qX1H(String ids, HttpServletResponse response) {
        List<String> lf_Q3LTXtWq = Arrays.asList(ids.split(","));
        List<DataSource> lf_HkqgaV3I = gf_L8nJROMM.m_ZOaOEYcg(lf_Q3LTXtWq);
        String lf_u7uUrb6N = JSON.toJSONString(lf_HkqgaV3I);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=datasource.json");
        OutputStream lf_raS7UXPx = null;
        try {
            lf_raS7UXPx = response.getOutputStream();
            lf_raS7UXPx.write(lf_u7uUrb6N.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_raS7UXPx != null)
                    lf_raS7UXPx.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_ABxL9CcP(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_9WKEIbP7 = IOUtils.toString(file.getInputStream(), "utf-8");
        List<DataSource> lf_7TiJqHKm = JSON.parseArray(lf_9WKEIbP7, DataSource.class);
        Integer lf_K3LTVuGm = gf_L8nJROMM.m_3clin3BX();
        if ((lf_K3LTVuGm + lf_7TiJqHKm.size()) > C_1muQm9UY.m_7ZPsKnx0()) {
            throw new RuntimeException("The number of datasources exceeds the limit");
        }
        lf_7TiJqHKm.stream().forEach(lambda_lf_7GlZxPvt -> {
            lambda_lf_7GlZxPvt.setCreateUserId(C_vudUmpvO.m_4zzh6Q4j());
            lambda_lf_7GlZxPvt.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_7GlZxPvt.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_L8nJROMM.m_SlhRJ7ic(lf_7TiJqHKm);
    }
}
