package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.dao.C_zWByMEBh;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.util.C_TfP8QHJa;
import com.gitee.freakchicken.dbapi.basic.util.C_khZIipIa;
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
public class C_slUyi3T8 {

    @Autowired
    C_zWByMEBh gf_SCUSXJof;

    @RequestMapping("/getAllTables")
    public List<JSONObject> m_1KfA7fNS(String sourceId) throws SQLException {
        DataSource lf_A5cBKp5B = gf_SCUSXJof.selectById(sourceId);
        DruidPooledConnection lf_P8SvSHPD = C_khZIipIa.m_vb8mHVEp(lf_A5cBKp5B);
        List<String> lf_ausljMVc = C_TfP8QHJa.m_HgOZQqxt(lf_P8SvSHPD, lf_A5cBKp5B.getJdbcDataSource().getTableSql());
        List<JSONObject> lf_kcPGWS1H = lf_ausljMVc.stream().map(lambda_lf_kyEtaDjc -> {
            JSONObject lf_eYXJFY9f = new JSONObject();
            lf_eYXJFY9f.put("label", lambda_lf_kyEtaDjc);
            try {
                DruidPooledConnection lf_flwNBfXS = C_khZIipIa.m_vb8mHVEp(lf_A5cBKp5B);
                lf_eYXJFY9f.put("columns", C_TfP8QHJa.m_d7uKhh1Z(lf_flwNBfXS, lf_A5cBKp5B.getType(), lambda_lf_kyEtaDjc));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            lf_eYXJFY9f.put("showColumns", false);
            return lf_eYXJFY9f;
        }).collect(Collectors.toList());
        return lf_kcPGWS1H;
    }

    @RequestMapping("/getAllColumns")
    public List<JSONObject> m_1KfA7fNS(String sourceId, String table) throws SQLException {
        DataSource lf_eCrTWlQN = gf_SCUSXJof.selectById(sourceId);
        DruidPooledConnection lf_WNUdBBMx = C_khZIipIa.m_vb8mHVEp(lf_eCrTWlQN);
        List<JSONObject> lf_dYi0gcmr = C_TfP8QHJa.m_d7uKhh1Z(lf_WNUdBBMx, lf_eCrTWlQN.getType(), table);
        return lf_dYi0gcmr;
    }
}
