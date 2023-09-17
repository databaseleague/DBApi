package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.dao.C_YZzTwKze;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.util.C_VTgGlxrg;
import com.gitee.freakchicken.dbapi.basic.util.C_0pwc7Ovh;
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
public class C_UdKghQYv {

    @Autowired
    C_YZzTwKze gf_Twz9q9n4;

    @RequestMapping("/getAllTables")
    public List<JSONObject> m_pRDdhHCt(String sourceId) throws SQLException {
        DataSource lf_RMiLYyN9 = gf_Twz9q9n4.selectById(sourceId);
        DruidPooledConnection lf_gLEhWU2D = C_0pwc7Ovh.m_Smt0D1dZ(lf_RMiLYyN9);
        List<String> lf_fuJtcueo = C_VTgGlxrg.m_xJMCXMnw(lf_gLEhWU2D, lf_RMiLYyN9.getJdbcDataSource().getTableSql());
        List<JSONObject> lf_UQhuloWu = lf_fuJtcueo.stream().map(lambda_lf_WRjv6Rhs -> {
            JSONObject lf_ZjcqIGx1 = new JSONObject();
            lf_ZjcqIGx1.put("label", lambda_lf_WRjv6Rhs);
            try {
                DruidPooledConnection lf_wP4hPr6C = C_0pwc7Ovh.m_Smt0D1dZ(lf_RMiLYyN9);
                lf_ZjcqIGx1.put("columns", C_VTgGlxrg.m_y2kMWsJc(lf_wP4hPr6C, lf_RMiLYyN9.getType(), lambda_lf_WRjv6Rhs));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            lf_ZjcqIGx1.put("showColumns", false);
            return lf_ZjcqIGx1;
        }).collect(Collectors.toList());
        return lf_UQhuloWu;
    }

    @RequestMapping("/getAllColumns")
    public List<JSONObject> m_pRDdhHCt(String sourceId, String table) throws SQLException {
        DataSource lf_IKYJZqwZ = gf_Twz9q9n4.selectById(sourceId);
        DruidPooledConnection lf_7FdAdhuw = C_0pwc7Ovh.m_Smt0D1dZ(lf_IKYJZqwZ);
        List<JSONObject> lf_nZtTE3Ah = C_VTgGlxrg.m_y2kMWsJc(lf_7FdAdhuw, lf_IKYJZqwZ.getType(), table);
        return lf_nZtTE3Ah;
    }
}
