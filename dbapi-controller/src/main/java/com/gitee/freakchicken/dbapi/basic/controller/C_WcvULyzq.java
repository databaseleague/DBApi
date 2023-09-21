package com.gitee.freakchicken.dbapi.basic.controller;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.dbapi.basic.dao.C_y6ZkXxTF;
import com.gitee.freakchicken.dbapi.basic.domain.DataSource;
import com.gitee.freakchicken.dbapi.basic.util.C_8uPcuzJY;
import com.gitee.freakchicken.dbapi.basic.util.C_JJ03WwEB;
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
public class C_WcvULyzq {

    @Autowired
    C_y6ZkXxTF gf_ISepmaer;

    @RequestMapping("/getAllTables")
    public List<JSONObject> m_2BhYlOKp(String sourceId) throws SQLException {
        DataSource lf_dyPfYEVg = gf_ISepmaer.selectById(sourceId);
        DruidPooledConnection lf_568fpvVB = C_JJ03WwEB.m_ezk725ad(lf_dyPfYEVg);
        List<String> lf_rirZcdk1 = C_8uPcuzJY.m_IJ4SV7AC(lf_568fpvVB, lf_dyPfYEVg.getJdbcDataSource().getTableSql());
        List<JSONObject> lf_PRBF25g8 = lf_rirZcdk1.stream().map(lambda_lf_hQPNZtko -> {
            JSONObject lf_XHQW8KT0 = new JSONObject();
            lf_XHQW8KT0.put("label", lambda_lf_hQPNZtko);
            try {
                DruidPooledConnection lf_HVX1tvHo = C_JJ03WwEB.m_ezk725ad(lf_dyPfYEVg);
                lf_XHQW8KT0.put("columns", C_8uPcuzJY.m_r6CGvIRG(lf_HVX1tvHo, lf_dyPfYEVg.getType(), lambda_lf_hQPNZtko));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            lf_XHQW8KT0.put("showColumns", false);
            return lf_XHQW8KT0;
        }).collect(Collectors.toList());
        return lf_PRBF25g8;
    }

    @RequestMapping("/getAllColumns")
    public List<JSONObject> m_2BhYlOKp(String sourceId, String table) throws SQLException {
        DataSource lf_qlIeqrhU = gf_ISepmaer.selectById(sourceId);
        DruidPooledConnection lf_dnDR92xT = C_JJ03WwEB.m_ezk725ad(lf_qlIeqrhU);
        List<JSONObject> lf_DjUIhTVo = C_8uPcuzJY.m_r6CGvIRG(lf_dnDR92xT, lf_qlIeqrhU.getType(), table);
        return lf_DjUIhTVo;
    }
}
