<template>
  <div class="app-container">
    <el-form ref="dataForm" :rules="rules" :model="dataForm" status-icon label-width="300px">
      <el-form-item label="签到1天获得" prop="jinxiang_signin_one_day_integral">
        <el-input v-model="dataForm.jinxiang_signin_one_day_integral" class="input-width">
          <template slot="append">分</template>
        </el-input>
      </el-form-item>
      <el-form-item label="签到2天获得" prop="jinxiang_signin_two_day_integral">
        <el-input v-model="dataForm.jinxiang_signin_two_day_integral" class="input-width">
          <template slot="append">分</template>
        </el-input>
      </el-form-item>
      <el-form-item label="签到3天获得" prop="jinxiang_signin_three_day_integral">
        <el-input v-model="dataForm.jinxiang_signin_three_day_integral" class="input-width">
          <template slot="append">分</template>
        </el-input>
      </el-form-item>
      <el-form-item label="签到4天获得" prop="jinxiang_signin_four_day_integral">
        <el-input v-model="dataForm.jinxiang_signin_four_day_integral" class="input-width">
          <template slot="append">分</template>
        </el-input>
      </el-form-item>
      <el-form-item label="签到5天获得" prop="jinxiang_signin_five_day_integral">
        <el-input v-model="dataForm.jinxiang_signin_five_day_integral" class="input-width">
          <template slot="append">分</template>
        </el-input>
      </el-form-item>
      <el-form-item label="签到6天获得" prop="jinxiang_signin_six_day_integral">
        <el-input v-model="dataForm.jinxiang_signin_six_day_integral" class="input-width">
          <template slot="append">分</template>
        </el-input>
      </el-form-item>
      <el-form-item label="签到7天获得" prop="jinxiang_signin_seven_day_integral">
        <el-input v-model="dataForm.jinxiang_signin_seven_day_integral" class="input-width">
          <template slot="append">分</template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="cancel">取消</el-button>
        <el-button type="primary" @click="update">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { listSignin, updateSignin } from '@/api/config'

export default {
  name: 'ConfigOrder',
  data() {
    return {
      dataForm: {}
    }
  },
  created() {
    this.init()
  },
  methods: {
    init: function() {
      listSignin().then(response => {
        this.dataForm = response.data.data
      })
    },
    cancel() {
      this.init()
    },
    update() {
      updateSignin(this.dataForm)
        .then(response => {
          this.$notify.success({
            title: '成功',
            message: '签到参数配置成功'
          })
        })
        .catch(response => {
          this.$notify.error({
            title: '失败',
            message: response.data.errmsg
          })
        })
    }
  }
}
</script>
<style scoped>
  .input-width {
    width: 50%;
  }
  .info {
    margin-left: 15px;
  }
</style>
