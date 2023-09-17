<template>
  <div style="padding: 20px">
    <div>
      <ul>
        <li>
          <!--          <router-link to="/datasource/add">-->
          <el-button icon="el-icon-plus" size="mini" type="primary" plain @click="handleAdd()">{{ $t('m.create_ds') }}</el-button>
          <!--          </router-link>-->
        </li>
        <li>
          <el-button @click="show=true" icon="el-icon-download" round size="mini" plain>{{ $t('m.export_ds') }}</el-button>
        </li>
        <li>
          <el-upload action="/datasource/import" accept=".json" :on-success="importSuccess" :headers="headers" :on-error="importFail" :file-list="fileList">
            <el-button type="warning" icon="el-icon-upload2" round size="mini" plain>{{ $t('m.import_ds') }}</el-button>
          </el-upload>
        </li>
      </ul>
    </div>
    <div style="height: calc(100vh - 150px);overflow: auto;">
      <el-table :data="tableData" border stripe>
        <el-table-column prop="id" label="id" width="270px"></el-table-column>
        <el-table-column :label="$t('m.name')">
          <template slot-scope="scope">
            <db-icon :type="scope.row.type"></db-icon>
            <span>{{ scope.row.name }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="note" :label="$t('m.note')"></el-table-column>
        <el-table-column prop="updateTime" :label="$t('m.update_time')" width="170px"></el-table-column>
        <el-table-column :label="$t('m.operation')" width="220px">
          <template slot-scope="scope">

            <!-- <el-button plain size="mini" type="info" @click="detail(scope.row.id)" circle>
              <i class="iconfont icon-detail"></i>
            </el-button> -->
            <el-tooltip placement="top" effect="dark" :content="$t('m.edit')">
              <el-button plain size="mini" type="warning" @click="handleEdit(scope.row.id)" circle>
                <i class="el-icon-edit"></i>
              </el-button>
            </el-tooltip>
            <el-tooltip placement="top" effect="dark" :content="$t('m.delete')">
              <el-button plain size="mini" type="danger" @click="handleDelete(scope.row.id)" circle>
                <i class="el-icon-delete"></i>
              </el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <el-dialog :title="$t('m.export_ds')" :visible.sync="show">
      <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">{{ $t('m.select_all') }}</el-checkbox>
      <div style="margin: 15px 0;"></div>
      <el-checkbox-group v-model="checkedDatasources" @change="handleCheckedItemChange">
        <el-checkbox v-for="item in tableData" :label="item.id" :key="item.id">{{ item.name }}</el-checkbox>
      </el-checkbox-group>

      <span slot="footer" class="dialog-footer">
        <el-button @click="show = false">{{ $t('m.cancel') }}</el-button>
        <el-button type="primary" @click="show = false;exportConfig()">{{ $t('m.export') }}</el-button>
      </span>
    </el-dialog>

    <el-dialog :title="datasource_title" :visible.sync="dialog1">
      <common ref="dscommon" :id="id" @saveSuccess="saveSuccess"></common>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialog1 = false">{{ $t('m.cancel') }}</el-button>
        <el-button type="primary" @click="save()">{{ $t('m.save') }}</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import common from '@/components/datasource/common'

export default {
  name: "datasource",
  components: {common},
  data() {
    return {
      tableData: [],
      show: false,
      headers: {
        Authorization: localStorage.getItem("token"),
      },
      fileList: [],
      dialog1: false,
      id: null,
      datasource_title: null,
      checkAll: false,
      checkedDatasources: [],
      isIndeterminate: false
    };
  },
  methods: {
    handleCheckAllChange(val) {
      this.checkedDatasources = val ? this.tableData.map((t) => t.id) : [];
      this.isIndeterminate = false;
    },
    handleCheckedItemChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.tableData.length;
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.tableData.length;
    },
    saveSuccess() {
      this.dialog1 = false;
      this.getAllSource();
      this.id = null;// id 必须变化子组件才能检测到并重新加载数据，所以id置空。编辑保存后，下次再点编辑是重新加载数据，主要是jdbc数据源密码框要重新获取加密后的密码
    },
    handleAdd() {
      this.id = null
      this.dialog1 = true
      this.datasource_title = window.vm.$t('m.create_ds')
    },
    save() {
      this.$refs.dscommon.save()
    },
    exportConfig() {
      const ids = this.checkedDatasources
      console.log(ids);
      this.axios({
        method: "post",
        params: {ids: ids.join(",")},
        url: "/datasource/export",
        responseType: "blob", //这个很重要
      })
          .then((res) => {
            const link = document.createElement("a");
            let blob = new Blob([res.data], {type: "application/x-msdownload"});
            link.style.display = "none";
            link.href = URL.createObjectURL(blob);
            link.setAttribute("download", "datasource.json");
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
          })
          .catch((error) => {
            this.$message.error("Export Failed");
            console.error(error);
          });
    },
    importSuccess(response, file, fileList) {
      this.fileList = [];
      this.$message.success("Import success");
      this.getAllSource();
    },
    importFail(error, file, fileList) {
      this.$message.error("Import failed!  " + error.message);
    },
    detail(id) {
      this.$router.push({path: "/datasource/detail", query: {id: id}});
    },
    handleEdit(data) {
      this.id = data
      this.dialog1 = true;
      this.datasource_title = window.vm.$t('m.update_ds')
    },
    getAllSource() {
      this.axios
          .post("/datasource/getAll")
          .then((response) => {
            this.tableData = response.data;
          })
          .catch((error) => {
            // this.$message.error("Query all ")
          });
    },
    handleDelete(id) {
      this.axios
          .post("/datasource/delete/" + id)
          .then((response) => {
            if (response.data.success) {
              this.$message.success("Delete Success");
            } else {
              this.$message.error(response.data.msg);
            }
            this.getAllSource();
          })
          .catch((error) => {
            this.$message.error("Delete Failed");
          });
    },
  },
  created() {
    this.getAllSource();
  },
};
</script>

<style scoped lang="less">
.my /deep/ .el-textarea__inner {
  font-family: "Consolas", Helvetica, Arial, sans-serif;
  /*font-size: 18px;*/
}

ul {
  margin-bottom: 10px;

  li {
    display: inline-block;
    margin-right: 10px;
  }
}
</style>
