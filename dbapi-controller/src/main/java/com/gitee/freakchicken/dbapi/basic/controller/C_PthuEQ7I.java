package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.dao.C_mdDrNwqb;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.util.C_zAYV4Q2c;
import com.gitee.freakchicken.dbapi.basic.util.C_Brw65PMK;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/table")
public class C_PthuEQ7I {

    @Autowired
    C_mdDrNwqb gf_cZxDUJxx;

    @RequestMapping("/getAllTables")
    public List<JSONObject> m_UUq6lgL1(String sourceId) throws SQLException {
        DataSource lf_NQTdRUqk = gf_cZxDUJxx.selectById(sourceId);
        DruidPooledConnection lf_USukZu7K = C_Brw65PMK.m_KgAFIOMX(lf_NQTdRUqk);
        List<String> lf_P9Z4gsZe = C_zAYV4Q2c.m_dugemeXM(lf_USukZu7K, lf_NQTdRUqk.getJdbcDataSource().getTableSql());
        List<JSONObject> lf_FSDrTzfW = lf_P9Z4gsZe.stream().map(lambda_lf_3To3y7yf -> {
            JSONObject lf_KFUyfRAc = new JSONObject();
            lf_KFUyfRAc.put("label", lambda_lf_3To3y7yf);
            try {
                DruidPooledConnection lf_08CrWpMl = C_Brw65PMK.m_KgAFIOMX(lf_NQTdRUqk);
                lf_KFUyfRAc.put("columns", C_zAYV4Q2c.m_22il2W1t(lf_08CrWpMl, lf_NQTdRUqk.getType(), lambda_lf_3To3y7yf));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            lf_KFUyfRAc.put("showColumns", false);
            return lf_KFUyfRAc;
        }).collect(Collectors.toList());
        return lf_FSDrTzfW;
    }

    @RequestMapping("/getAllColumns")
    public List<JSONObject> m_UUq6lgL1(String sourceId, String table) throws SQLException {
        DataSource lf_4W3UocIX = gf_cZxDUJxx.selectById(sourceId);
        DruidPooledConnection lf_bEC5mYNX = C_Brw65PMK.m_KgAFIOMX(lf_4W3UocIX);
        List<JSONObject> lf_cnTm3aaN = C_zAYV4Q2c.m_22il2W1t(lf_bEC5mYNX, lf_4W3UocIX.getType(), table);
        return lf_cnTm3aaN;
    }
}
