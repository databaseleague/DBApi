<template>
  <div>
    <el-form label-width="160px">
      <el-form-item :label="$t('m.name')">
        <el-input v-model="detail.name"></el-input>
      </el-form-item>
      <el-form-item :label="$t('m.note')">
        <el-input v-model="detail.note"></el-input>
      </el-form-item>
      <el-form-item :label="$t('m.type')">
        <el-radio-group v-model="detail.type" disabled>
          <el-radio label="jdbc">jdbc</el-radio>
          <!-- <el-radio :label="2">{{$t('m.executor_es')}}</el-radio>
          <el-radio :label="3">{{$t('m.executor_http')}}</el-radio> -->
        </el-radio-group>
      </el-form-item>
      <jdbc v-if="detail.type == 'jdbc'" ref="ds" :jdbcdata="detail.detail"></jdbc>
    </el-form>
  </div>
</template>

<script>

import jdbc from './jdbc.vue'

export default {
  name: "common",
  data() {
    return {
      detail: {
        id: null,
        name: null,
        note: null,
        type: 'jdbc',
        detail: {
          type: null,
          url: null,
          username: null,
          password: null,
          edit_password: false,
          driver: null
        }
      }
    }
  },
  components: {jdbc},
  props: {
    id: {
      type: String,
      default: null
    }
  },
  methods: {
    isNull(item) {
      if (typeof item == 'undefined' || item == null || item == '') {
        return true
      } else {
        return false
      }
    },
    checkValue() {
      if (this.isNull(this.detail.name)) {
        this.$message.warning("Datasource name empty!")
        return false
      }
      if (this.isNull(this.detail.note)) {
        this.$message.warning("Datasource note empty!")
        return false
      }
      return true;
    },

    save() {
      if (!this.checkValue()) {
        return;
      }
      if (!this.$refs.ds.checkValue()) {
        return;
      }
      let p = this.detail
      p.detail = this.$refs.ds.detail


      // let url = p.id == null ? "/datasource/add/" : "/datasource/update/"
      // this.axios.post(url, p, {headers: {'Content-Type': 'application/json'}}).then((response) => {
      //   this.$message.success("Save Success")
      //   this.$emit('saveSuccess')
      // }).catch((error) => {
      //   this.$message.error("failed")
      // })


      if (p.id == null) {
        this.axios.post("/datasource/add/", p, {headers: {'Content-Type': 'application/json'}}).then((response) => {
          if (response.data.success) {
            this.$message.success(response.data.msg)
            this.$emit('saveSuccess')
          } else {
            this.$message.error(response.data.msg)
          }

        }).catch((error) => {
          this.$message.error("failed")
        })
      } else {
        this.axios.post("/datasource/update/", p, {headers: {'Content-Type': 'application/json'}}).then((response) => {
          this.$message.success("Save Success")
          this.$emit('saveSuccess')
        }).catch((error) => {
          this.$message.error("failed")
        })
      }
    },

    getDetail(id) {
      this.axios.post("/datasource/detail/" + id).then((response) => {
        this.detail.id = response.data.id
        this.detail.name = response.data.name
        this.detail.note = response.data.note
        this.detail.type = response.data.type
        // debugger
        this.detail.detail = JSON.parse(response.data.detail)

        // if (this.detail.type == 'jdbc'){
        this.detail.detail.edit_password = false
        // }
        console.log(this.detail)
      }).catch((error) => {
        this.$message.error("failed")
      })
    },

  },
  watch: {
    id: {
      immediate: true,
      handler: function (val) {
        if (val != null) {
          this.getDetail(val)
        } else {
          this.detail = {
            id: null,
            name: null,
            note: null,
            type: 'jdbc',
            detail: {
              type: null,
              url: null,
              username: null,
              password: null,
              edit_password: false,
              driver: null
            }
          }
        }
      }
    }
  },

  created() {

  },
}
</script>

<style scoped>

.my >>> .el-textarea__inner {
    font-family: 'Consolas', Helvetica, Arial, sans-serif;
}
</style>
