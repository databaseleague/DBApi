package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dbapi.C_HnBXSCdF;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.JdbcDataSource;
import com.gitee.freakchicken.dbapi.basic.service.C_6NZfqGQo;
import com.gitee.freakchicken.dbapi.basic.util.C_EkBZd3iC;
import com.gitee.freakchicken.dbapi.basic.util.C_7LZZiEH7;
import com.gitee.freakchicken.dbapi.basic.util.C_pW4Y7Qx2;
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
public class C_jZp372G2 {

    @Autowired
    C_6NZfqGQo gf_BL4D8O9f;

    @RequestMapping("/add")
    public ResponseDto m_xHOCZBe1(@RequestBody JSONObject jo) {
        DataSource lf_uSRKsiss = new DataSource();
        lf_uSRKsiss.setName(jo.getString("name"));
        lf_uSRKsiss.setNote(jo.getString("note"));
        lf_uSRKsiss.setType(jo.getString("type"));
        JSONObject lf_AuhcSksG = jo.getJSONObject("detail");
        if (lf_uSRKsiss.isJdbcType()) {
            JdbcDataSource lf_ogeaDF1y = lf_AuhcSksG.toJavaObject(JdbcDataSource.class);
            try {
                lf_ogeaDF1y.setPassword(C_EkBZd3iC.m_NKx9vQxQ(lf_ogeaDF1y.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            lf_uSRKsiss.setDetail(JSON.toJSONString(lf_ogeaDF1y));
        }
        lf_uSRKsiss.setCreateUserId(C_pW4Y7Qx2.m_0JUEwP8t());
        return gf_BL4D8O9f.m_OGGTntt2(lf_uSRKsiss);
    }

    @RequestMapping("/getAll")
    public List<DataSource> m_d1TGEabP() {
        return gf_BL4D8O9f.m_3IQ42fIv();
    }

    @RequestMapping("/getAllByType")
    public List<DataSource> m_DkYbiG58(String type) {
        return gf_BL4D8O9f.m_K69G9dN8(type);
    }

    @RequestMapping("/detail/{id}")
    public DataSource m_Kwj4yV58(@PathVariable String id) {
        return gf_BL4D8O9f.m_0NVp7hEz(id);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_pEN3yYxJ(@PathVariable String id) {
        return gf_BL4D8O9f.m_wy8WmMpe(id);
    }

    @RequestMapping("/update")
    public void m_6Fvpzml5(@RequestBody JSONObject jo) {
        DataSource lf_ChXxocS9 = new DataSource();
        lf_ChXxocS9.setId(jo.getString("id"));
        lf_ChXxocS9.setName(jo.getString("name"));
        lf_ChXxocS9.setNote(jo.getString("note"));
        lf_ChXxocS9.setType(jo.getString("type"));
        JSONObject lf_hOVRiXk3 = jo.getJSONObject("detail");
        if (lf_ChXxocS9.isJdbcType()) {
            JdbcDataSource lf_pkDj5V5j = lf_hOVRiXk3.toJavaObject(JdbcDataSource.class);
            if (lf_hOVRiXk3.getBoolean("edit_password")) {
                try {
                    lf_pkDj5V5j.setPassword(C_EkBZd3iC.m_NKx9vQxQ(lf_pkDj5V5j.getPassword()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lf_ChXxocS9.setDetail(JSON.toJSONString(lf_pkDj5V5j));
        }
        lf_ChXxocS9.setCreateUserId(C_pW4Y7Qx2.m_0JUEwP8t());
        gf_BL4D8O9f.m_Eq1eU9UI(lf_ChXxocS9);
    }

    @RequestMapping("/connect")
    public ResponseDto m_WMpYg2GL(JdbcDataSource dataSource) {
        Connection lf_gmn5bKar = null;
        try {
            lf_gmn5bKar = C_7LZZiEH7.m_sn2vqydV(dataSource);
            return ResponseDto.apiSuccess(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseDto.fail(e.getMessage());
        } finally {
            if (lf_gmn5bKar != null) {
                try {
                    lf_gmn5bKar.close();
                } catch (SQLException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    @RequestMapping("/export")
    public void m_GAVXv4A5(String ids, HttpServletResponse response) {
        List<String> lf_JPVrGPeK = Arrays.asList(ids.split(","));
        List<DataSource> lf_YHSw5g3I = gf_BL4D8O9f.m_KHj7X8c6(lf_JPVrGPeK);
        String lf_XFsTrg0X = JSON.toJSONString(lf_YHSw5g3I);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=datasource.json");
        OutputStream lf_riViAJxf = null;
        try {
            lf_riViAJxf = response.getOutputStream();
            lf_riViAJxf.write(lf_XFsTrg0X.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_riViAJxf != null)
                    lf_riViAJxf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_Qt9QJxgT(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_EJdLABzb = IOUtils.toString(file.getInputStream(), "utf-8");
        List<DataSource> lf_ALanAzyk = JSON.parseArray(lf_EJdLABzb, DataSource.class);
        Integer lf_pMOtjsEp = gf_BL4D8O9f.m_rLXKosKZ();
        if ((lf_pMOtjsEp + lf_ALanAzyk.size()) > C_HnBXSCdF.m_IVA4pm9o()) {
            throw new RuntimeException("The number of datasources exceeds the limit");
        }
        lf_ALanAzyk.stream().forEach(lambda_lf_PZvxpJuH -> {
            lambda_lf_PZvxpJuH.setCreateUserId(C_pW4Y7Qx2.m_0JUEwP8t());
            lambda_lf_PZvxpJuH.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_PZvxpJuH.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_BL4D8O9f.m_KomDbLdY(lf_ALanAzyk);
    }
}
