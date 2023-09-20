package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dbapi.C_dQG4lXSP;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.JdbcDataSource;
import com.gitee.freakchicken.dbapi.basic.service.C_FHj5xs4w;
import com.gitee.freakchicken.dbapi.basic.util.C_FRQlSXNI;
import com.gitee.freakchicken.dbapi.basic.util.C_zAYV4Q2c;
import com.gitee.freakchicken.dbapi.basic.util.C_oagmA7fO;
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
public class C_2NnMrugp {

    @Autowired
    C_FHj5xs4w gf_E9HmYihx;

    @RequestMapping("/add")
    public ResponseDto m_tt0YXdzL(@RequestBody JSONObject jo) {
        DataSource lf_nMkrAtis = new DataSource();
        lf_nMkrAtis.setName(jo.getString("name"));
        lf_nMkrAtis.setNote(jo.getString("note"));
        lf_nMkrAtis.setType(jo.getString("type"));
        JSONObject lf_d8Q2xaPK = jo.getJSONObject("detail");
        if (lf_nMkrAtis.isJdbcType()) {
            JdbcDataSource lf_A7sSd7Vk = lf_d8Q2xaPK.toJavaObject(JdbcDataSource.class);
            try {
                lf_A7sSd7Vk.setPassword(C_FRQlSXNI.m_ueqpnc1S(lf_A7sSd7Vk.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            lf_nMkrAtis.setDetail(JSON.toJSONString(lf_A7sSd7Vk));
        }
        lf_nMkrAtis.setCreateUserId(C_oagmA7fO.m_RXdK6OuW());
        return gf_E9HmYihx.m_KcDSVy3R(lf_nMkrAtis);
    }

    @RequestMapping("/getAll")
    public List<DataSource> m_KWcIwfTr() {
        return gf_E9HmYihx.m_ALtVLd9T();
    }

    @RequestMapping("/getAllByType")
    public List<DataSource> m_KcTCWz0c(String type) {
        return gf_E9HmYihx.m_o91oQ5XT(type);
    }

    @RequestMapping("/detail/{id}")
    public DataSource m_UqG2ntOJ(@PathVariable String id) {
        return gf_E9HmYihx.m_4QfMOutT(id);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_q9I1JHRL(@PathVariable String id) {
        return gf_E9HmYihx.m_4FB6Skzs(id);
    }

    @RequestMapping("/update")
    public void m_dROm1fIF(@RequestBody JSONObject jo) {
        DataSource lf_yZudLh10 = new DataSource();
        lf_yZudLh10.setId(jo.getString("id"));
        lf_yZudLh10.setName(jo.getString("name"));
        lf_yZudLh10.setNote(jo.getString("note"));
        lf_yZudLh10.setType(jo.getString("type"));
        JSONObject lf_I2eAcvF2 = jo.getJSONObject("detail");
        if (lf_yZudLh10.isJdbcType()) {
            JdbcDataSource lf_R4vghkHh = lf_I2eAcvF2.toJavaObject(JdbcDataSource.class);
            if (lf_I2eAcvF2.getBoolean("edit_password")) {
                try {
                    lf_R4vghkHh.setPassword(C_FRQlSXNI.m_ueqpnc1S(lf_R4vghkHh.getPassword()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lf_yZudLh10.setDetail(JSON.toJSONString(lf_R4vghkHh));
        }
        lf_yZudLh10.setCreateUserId(C_oagmA7fO.m_RXdK6OuW());
        gf_E9HmYihx.m_N0pLyH9i(lf_yZudLh10);
    }

    @RequestMapping("/connect")
    public ResponseDto m_fXqrcuKq(JdbcDataSource dataSource) {
        Connection lf_RZrPbmh9 = null;
        try {
            lf_RZrPbmh9 = C_zAYV4Q2c.m_o9klDnOP(dataSource);
            return ResponseDto.apiSuccess(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseDto.fail(e.getMessage());
        } finally {
            if (lf_RZrPbmh9 != null) {
                try {
                    lf_RZrPbmh9.close();
                } catch (SQLException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    @RequestMapping("/export")
    public void m_u3mnXpYJ(String ids, HttpServletResponse response) {
        List<String> lf_ectbDvOQ = Arrays.asList(ids.split(","));
        List<DataSource> lf_8rwSR4sO = gf_E9HmYihx.m_oWQGpy6e(lf_ectbDvOQ);
        String lf_aRpxKqjG = JSON.toJSONString(lf_8rwSR4sO);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=datasource.json");
        OutputStream lf_32TRhAyp = null;
        try {
            lf_32TRhAyp = response.getOutputStream();
            lf_32TRhAyp.write(lf_aRpxKqjG.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_32TRhAyp != null)
                    lf_32TRhAyp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_9YUM6DKK(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_LtPvVX0d = IOUtils.toString(file.getInputStream(), "utf-8");
        List<DataSource> lf_VZ7nmjqy = JSON.parseArray(lf_LtPvVX0d, DataSource.class);
        Integer lf_lgN5lty9 = gf_E9HmYihx.m_r5TODeKy();
        if ((lf_lgN5lty9 + lf_VZ7nmjqy.size()) > C_dQG4lXSP.m_CwLLk21t()) {
            throw new RuntimeException("The number of datasources exceeds the limit");
        }
        lf_VZ7nmjqy.stream().forEach(lambda_lf_ona9eSn8 -> {
            lambda_lf_ona9eSn8.setCreateUserId(C_oagmA7fO.m_RXdK6OuW());
            lambda_lf_ona9eSn8.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_ona9eSn8.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_E9HmYihx.m_ekFYVhqn(lf_VZ7nmjqy);
    }
}
