package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dbapi.C_yQrjZepH;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.domain.JdbcDataSource;
import com.gitee.freakchicken.dbapi.basic.service.C_2SJy2rJ0;
import com.gitee.freakchicken.dbapi.basic.util.C_IQRU7iFT;
import com.gitee.freakchicken.dbapi.basic.util.C_8uPcuzJY;
import com.gitee.freakchicken.dbapi.basic.util.C_idPcCdpc;
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
public class C_2OdxSHYs {

    @Autowired
    C_2SJy2rJ0 gf_l0gHXF1N;

    @RequestMapping("/add")
    public ResponseDto m_Irr53GMs(@RequestBody JSONObject jo) {
        DataSource lf_l6dL3qHo = new DataSource();
        lf_l6dL3qHo.setName(jo.getString("name"));
        lf_l6dL3qHo.setNote(jo.getString("note"));
        lf_l6dL3qHo.setType(jo.getString("type"));
        JSONObject lf_XLxNLU80 = jo.getJSONObject("detail");
        if (lf_l6dL3qHo.isJdbcType()) {
            JdbcDataSource lf_B5HKzCiW = lf_XLxNLU80.toJavaObject(JdbcDataSource.class);
            try {
                lf_B5HKzCiW.setPassword(C_IQRU7iFT.m_xixrzzCy(lf_B5HKzCiW.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            lf_l6dL3qHo.setDetail(JSON.toJSONString(lf_B5HKzCiW));
        }
        lf_l6dL3qHo.setCreateUserId(C_idPcCdpc.m_CpasizWZ());
        return gf_l0gHXF1N.m_QeB2r58N(lf_l6dL3qHo);
    }

    @RequestMapping("/getAll")
    public List<DataSource> m_k9NTOST4() {
        return gf_l0gHXF1N.m_znQ1qzDQ();
    }

    @RequestMapping("/getAllByType")
    public List<DataSource> m_9VGSdlnZ(String type) {
        return gf_l0gHXF1N.m_vZnyGeeP(type);
    }

    @RequestMapping("/detail/{id}")
    public DataSource m_JcnUYXLx(@PathVariable String id) {
        return gf_l0gHXF1N.m_qMS1GA0c(id);
    }

    @RequestMapping("/delete/{id}")
    public ResponseDto m_sRy37GBS(@PathVariable String id) {
        return gf_l0gHXF1N.m_ENueeuWs(id);
    }

    @RequestMapping("/update")
    public void m_FbRm994G(@RequestBody JSONObject jo) {
        DataSource lf_EhDJ1zap = new DataSource();
        lf_EhDJ1zap.setId(jo.getString("id"));
        lf_EhDJ1zap.setName(jo.getString("name"));
        lf_EhDJ1zap.setNote(jo.getString("note"));
        lf_EhDJ1zap.setType(jo.getString("type"));
        JSONObject lf_iwKzRA8p = jo.getJSONObject("detail");
        if (lf_EhDJ1zap.isJdbcType()) {
            JdbcDataSource lf_MtXs6g7m = lf_iwKzRA8p.toJavaObject(JdbcDataSource.class);
            if (lf_iwKzRA8p.getBoolean("edit_password")) {
                try {
                    lf_MtXs6g7m.setPassword(C_IQRU7iFT.m_xixrzzCy(lf_MtXs6g7m.getPassword()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lf_EhDJ1zap.setDetail(JSON.toJSONString(lf_MtXs6g7m));
        }
        lf_EhDJ1zap.setCreateUserId(C_idPcCdpc.m_CpasizWZ());
        gf_l0gHXF1N.m_Rf175gun(lf_EhDJ1zap);
    }

    @RequestMapping("/connect")
    public ResponseDto m_DAoJU05i(JdbcDataSource dataSource) {
        Connection lf_Y22rrZoT = null;
        try {
            lf_Y22rrZoT = C_8uPcuzJY.m_qJAkCI8k(dataSource);
            return ResponseDto.apiSuccess(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseDto.fail(e.getMessage());
        } finally {
            if (lf_Y22rrZoT != null) {
                try {
                    lf_Y22rrZoT.close();
                } catch (SQLException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    @RequestMapping("/export")
    public void m_JHKVusJC(String ids, HttpServletResponse response) {
        List<String> lf_EpAk8lsl = Arrays.asList(ids.split(","));
        List<DataSource> lf_siDSCM7j = gf_l0gHXF1N.m_gujfaxTq(lf_EpAk8lsl);
        String lf_2IUw9HLA = JSON.toJSONString(lf_siDSCM7j);
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=datasource.json");
        OutputStream lf_lhJ5uUsl = null;
        try {
            lf_lhJ5uUsl = response.getOutputStream();
            lf_lhJ5uUsl.write(lf_2IUw9HLA.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (lf_lhJ5uUsl != null)
                    lf_lhJ5uUsl.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/import", produces = "application/json;charset=UTF-8")
    public void m_CGKQdPBF(@RequestParam("file") MultipartFile file) throws IOException {
        String lf_xiwtFx63 = IOUtils.toString(file.getInputStream(), "utf-8");
        List<DataSource> lf_NRIDY1HF = JSON.parseArray(lf_xiwtFx63, DataSource.class);
        Integer lf_W6SlvXDK = gf_l0gHXF1N.m_f4U2xcl6();
        if ((lf_W6SlvXDK + lf_NRIDY1HF.size()) > C_yQrjZepH.m_ds0rnxch()) {
            throw new RuntimeException("The number of datasources exceeds the limit");
        }
        lf_NRIDY1HF.stream().forEach(lambda_lf_G7LqNGQV -> {
            lambda_lf_G7LqNGQV.setCreateUserId(C_idPcCdpc.m_CpasizWZ());
            lambda_lf_G7LqNGQV.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
            lambda_lf_G7LqNGQV.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        });
        gf_l0gHXF1N.m_Bqczf9Ep(lf_NRIDY1HF);
    }
}
