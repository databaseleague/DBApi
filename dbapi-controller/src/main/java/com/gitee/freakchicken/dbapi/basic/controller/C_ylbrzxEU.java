package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.dao.C_JzHXjrTp;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.util.C_7LZZiEH7;
import com.gitee.freakchicken.dbapi.basic.util.C_qv6gCIrW;
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
public class C_ylbrzxEU {

    @Autowired
    C_JzHXjrTp gf_CcPSKZfm;

    @RequestMapping("/getAllTables")
    public List<JSONObject> m_BhOQS2YU(String sourceId) throws SQLException {
        DataSource lf_FGiPeTQv = gf_CcPSKZfm.selectById(sourceId);
        DruidPooledConnection lf_J1iPJ6tJ = C_qv6gCIrW.m_6BCTSwlB(lf_FGiPeTQv);
        List<String> lf_lTxWy1fg = C_7LZZiEH7.m_zJGxhVZU(lf_J1iPJ6tJ, lf_FGiPeTQv.getJdbcDataSource().getTableSql());
        List<JSONObject> lf_32b10Aa3 = lf_lTxWy1fg.stream().map(lambda_lf_qngADkIT -> {
            JSONObject lf_rRhMJTYz = new JSONObject();
            lf_rRhMJTYz.put("label", lambda_lf_qngADkIT);
            try {
                DruidPooledConnection lf_Rxxwz2NV = C_qv6gCIrW.m_6BCTSwlB(lf_FGiPeTQv);
                lf_rRhMJTYz.put("columns", C_7LZZiEH7.m_03frhHgr(lf_Rxxwz2NV, lf_FGiPeTQv.getType(), lambda_lf_qngADkIT));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            lf_rRhMJTYz.put("showColumns", false);
            return lf_rRhMJTYz;
        }).collect(Collectors.toList());
        return lf_32b10Aa3;
    }

    @RequestMapping("/getAllColumns")
    public List<JSONObject> m_BhOQS2YU(String sourceId, String table) throws SQLException {
        DataSource lf_TVzkWL8E = gf_CcPSKZfm.selectById(sourceId);
        DruidPooledConnection lf_dbH97zjA = C_qv6gCIrW.m_6BCTSwlB(lf_TVzkWL8E);
        List<JSONObject> lf_3EAXTuKk = C_7LZZiEH7.m_03frhHgr(lf_dbH97zjA, lf_TVzkWL8E.getType(), table);
        return lf_3EAXTuKk;
    }
}
