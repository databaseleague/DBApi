package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.dao.C_zJAaMzsd;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.util.C_31nDdnvP;
import com.gitee.freakchicken.dbapi.basic.util.C_iYar35dl;
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
public class C_gOby0zin {

    @Autowired
    C_zJAaMzsd gf_AS5zcYyy;

    @RequestMapping("/getAllTables")
    public List<JSONObject> m_9djhDPLh(String sourceId) throws SQLException {
        DataSource lf_OZoPFW0q = gf_AS5zcYyy.selectById(sourceId);
        DruidPooledConnection lf_FKY0UZRQ = C_iYar35dl.m_p8mwaR3T(lf_OZoPFW0q);
        List<String> lf_xdvA0JYB = C_31nDdnvP.m_1gUISjDJ(lf_FKY0UZRQ, lf_OZoPFW0q.getJdbcDataSource().getTableSql());
        List<JSONObject> lf_wmRhNhcY = lf_xdvA0JYB.stream().map(lambda_lf_WYKr4DQz -> {
            JSONObject lf_TU8Pkiiu = new JSONObject();
            lf_TU8Pkiiu.put("label", lambda_lf_WYKr4DQz);
            try {
                DruidPooledConnection lf_6nZzzlSh = C_iYar35dl.m_p8mwaR3T(lf_OZoPFW0q);
                lf_TU8Pkiiu.put("columns", C_31nDdnvP.m_LxEED5FS(lf_6nZzzlSh, lf_OZoPFW0q.getType(), lambda_lf_WYKr4DQz));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            lf_TU8Pkiiu.put("showColumns", false);
            return lf_TU8Pkiiu;
        }).collect(Collectors.toList());
        return lf_wmRhNhcY;
    }

    @RequestMapping("/getAllColumns")
    public List<JSONObject> m_9djhDPLh(String sourceId, String table) throws SQLException {
        DataSource lf_8FYIsGVv = gf_AS5zcYyy.selectById(sourceId);
        DruidPooledConnection lf_UENJrBW9 = C_iYar35dl.m_p8mwaR3T(lf_8FYIsGVv);
        List<JSONObject> lf_QNyse0FQ = C_31nDdnvP.m_LxEED5FS(lf_UENJrBW9, lf_8FYIsGVv.getType(), table);
        return lf_QNyse0FQ;
    }
}
