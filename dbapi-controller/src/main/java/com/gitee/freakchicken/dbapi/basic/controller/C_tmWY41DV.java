package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.dao.C_O9xJYrxF;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.util.C_QQPsbS0G;
import com.gitee.freakchicken.dbapi.basic.util.C_KvmbqieE;
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
public class C_tmWY41DV {

    @Autowired
    C_O9xJYrxF gf_flmeMynC;

    @RequestMapping("/getAllTables")
    public List<JSONObject> m_8bs8HwkX(String sourceId) throws SQLException {
        DataSource lf_pzt1KE0r = gf_flmeMynC.selectById(sourceId);
        DruidPooledConnection lf_uiZ7RvvO = C_KvmbqieE.m_u5RCTUtN(lf_pzt1KE0r);
        List<String> lf_hiJELQFN = C_QQPsbS0G.m_fDyDiz1C(lf_uiZ7RvvO, lf_pzt1KE0r.getJdbcDataSource().getTableSql());
        List<JSONObject> lf_0NzQN56x = lf_hiJELQFN.stream().map(lambda_lf_65rwUg1p -> {
            JSONObject lf_dG56QZSH = new JSONObject();
            lf_dG56QZSH.put("label", lambda_lf_65rwUg1p);
            try {
                DruidPooledConnection lf_WC9hl1LG = C_KvmbqieE.m_u5RCTUtN(lf_pzt1KE0r);
                lf_dG56QZSH.put("columns", C_QQPsbS0G.m_ElhWlCm0(lf_WC9hl1LG, lf_pzt1KE0r.getType(), lambda_lf_65rwUg1p));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            lf_dG56QZSH.put("showColumns", false);
            return lf_dG56QZSH;
        }).collect(Collectors.toList());
        return lf_0NzQN56x;
    }

    @RequestMapping("/getAllColumns")
    public List<JSONObject> m_8bs8HwkX(String sourceId, String table) throws SQLException {
        DataSource lf_CFquK2j1 = gf_flmeMynC.selectById(sourceId);
        DruidPooledConnection lf_zH0MMmij = C_KvmbqieE.m_u5RCTUtN(lf_CFquK2j1);
        List<JSONObject> lf_ZoMbXp3E = C_QQPsbS0G.m_ElhWlCm0(lf_zH0MMmij, lf_CFquK2j1.getType(), table);
        return lf_ZoMbXp3E;
    }
}
