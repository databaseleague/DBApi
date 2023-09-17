<template>
  <div>
    <el-form label-width="160px">
      <el-form-item :label="$t('m.database')">
        <div slot="label">
          <label-tip :label="$t('m.database')" :tip="$t('m.ds_driver_tip')"></label-tip>
        </div>
        <el-select v-model="detail.type" @change="selectDB">
          <el-option v-for="item in options" :key="item.label" :label="item.label" :value="item.value">
            <db-icon :type="item.value"></db-icon>
            <span>{{ item.label }}</span>
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item :label="$t('m.jdbc_driver_class')">
        <el-input v-model="detail.driver"></el-input>
      </el-form-item>
      <el-form-item label="Jdbc Url">
        <el-input v-model="detail.url" type="textarea" class="my"></el-input>
      </el-form-item>
      <el-form-item :label="$t('m.username')">
        <el-input v-model="detail.username"></el-input>
      </el-form-item>

      <el-form-item :label="$t('m.password')" prop="password" style="display: inline-block">
        <el-input prefix-icon="el-icon-lock" style="min-width: 400px;" :type="flag?'text':'password'" v-model="detail.password" :disabled="!detail.edit_password">
          <i slot="suffix" :class="[flag?'el-icon-minus':'el-icon-view']" style="margin-top:8px;font-size:18px;" autocomplete="auto" @click="flag=!flag"/>
        </el-input>
      </el-form-item>
      <el-form-item :label="$t('m.edit_password')" label-width="100%" style="margin-left:20px; display: inline-block">
        <el-checkbox v-model="detail.edit_password" ></el-checkbox>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="connect" plain style="margin: 10px 0;">{{$t('m.test_connection')}}</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "jdbc",
  data() {
    return {
      flag: false,
      options: [{label: 'mysql', value: 'mysql'}, {label: 'postgresql', value: 'postgresql'}, {label: 'hive', value: 'hive'},
        {label: 'sqlserver', value: 'sqlserver'}, {label: 'clickhouse', value: 'clickhouse'}, {label: 'kylin', value: 'kylin'},
        {label: 'oracle', value: 'oracle'}, {label: 'TDengine', value: 'TDengine'},
        {label: 'doris', value: 'doris'}, {label: 'others', value: 'others'}],
      detail: {
        type: null,
        url: null,
        username: null,
        password: null,
        edit_password: false,
        driver: null
      },
      ds: {
        mysql: {
          url: 'jdbc:mysql://localhost:3306/<db>?useSSL=false&characterEncoding=UTF-8&serverTimezone=GMT%2B8',
          driver: 'com.mysql.cj.jdbc.Driver',
          sql: 'show tables'
        },
        postgresql: {
          url: 'jdbc:postgresql://localhost:5432/<db>',
          driver: 'org.postgresql.Driver',
          sql: 'SELECT table_name FROM information_schema.tables WHERE table_schema = \'public\' ORDER BY table_name'
        },
        hive: {
          url: 'jdbc:hive2://localhost:10000/<db>',
          driver: 'org.apache.hive.jdbc.HiveDriver',
          sql: 'show tables'
        },
        sqlserver: {
          url: 'jdbc:sqlserver://localhost:1433;databaseName=<db>',
          driver: 'com.microsoft.sqlserver.jdbc.SQLServerDriver',
          sql: 'select * from sys.tables'
        },
        clickhouse: {
          url: 'jdbc:clickhouse://localhost:8123/<db>',
          driver: 'ru.yandex.clickhouse.ClickHouseDriver'
        },
        kylin: {
          url: 'jdbc:kylin://localhost:7070/<db>',
          driver: 'org.apache.kylin.jdbc.Driver'
        },
        oracle: {
          url: 'jdbc:oracle:thin:@localhost:1521:<db>',
          driver: 'oracle.jdbc.OracleDriver',
          sql: "SELECT OWNER || '.' || TABLE_NAME FROM ALL_TABLES"
        },
        TDengine: {
          url: 'jdbc:TAOS://localhost:6030/<db>?timezone=Asia/Beijing&charset=UTF-8',
          driver: 'com.taosdata.jdbc.rs.RestfulDriver',
          sql: ""
        },
        doris: {
          url: 'jdbc:mysql://localhost:9030/<db>',
          driver: 'com.mysql.cj.jdbc.Driver',
          sql: ""
        }
      }
    }
  },
  props: {
    jdbcdata: {
      type: Object,
      default: {
        url: null,
        type: null,
        username: null,
        password: null,
        edit_password: false,
        driver: null,
        tableSql: null
      }
    }
  },
  watch: {
    jdbcdata: {
      immediate: true,
      handler: function (val) {
        this.detail.type = val.type
        this.detail.url = val.url
        this.detail.username = val.username
        this.detail.password = val.password
        this.detail.driver = val.driver
        this.detail.edit_password = false
      }
    }
  },
  methods: {
    selectDB() {
      this.detail.url = (this.ds[this.detail.type]).url
      this.detail.driver = (this.ds[this.detail.type]).driver
      this.detail.tableSql = (this.ds[this.detail.type]).sql
    },
    connect() {
      this.axios.post("/datasource/connect", {
        "url": this.detail.url,
        "username": this.detail.username,
        "password": this.detail.password,
        "edit_password": this.detail.edit_password,
        "driver": this.detail.driver
      }).then((response) => {
        if (response.data.success)
          this.$message.success("Success")
        else
          this.$message.error(response.data.msg)
      }).catch((error) => {
        this.$message.error("Failed")
      })
    },
    isNull(item) {
      if (typeof item == 'undefined' || item == null || item == '') {
        return true
      } else {
        return false
      }
    },
    checkValue(){
      if (this.isNull(this.detail.type)) {
        this.$message.warning("DB type empty!")
        return false
      }
      if (this.isNull(this.detail.url)) {
        this.$message.warning("Url empty!")
        return false
      }
      if (this.isNull(this.detail.driver)) {
        this.$message.warning("Driver empty!")
        return false
      }
      if (this.isNull(this.detail.username)) {
        this.$message.warning("username empty!")
        return false
      }
      if (this.isNull(this.detail.password)) {
        this.$message.warning("password empty!")
        return false
      }
      return true;
    }
  }
}
</script>

<style scoped>

</style>