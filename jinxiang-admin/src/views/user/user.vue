<template>
  <div class="app-container">

    <!-- 查询和其他操作 -->
    <div class="filter-container">
      <el-input v-model="listQuery.nickname" clearable class="filter-item" style="width: 200px;" placeholder="请输入昵称" />
      <el-input v-model="listQuery.mobile" clearable class="filter-item" style="width: 200px;" placeholder="请输入手机号" />
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查找</el-button>
      <el-button :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">导出</el-button>
    </div>

    <!-- 查询结果 -->
    <el-table v-loading="listLoading" :data="list" element-loading-text="正在查询中。。。" border fit highlight-current-row>
      <el-table-column align="center" width="100px" label="用户ID" prop="id" sortable />

      <el-table-column align="center" label="昵称" prop="nickname" />

      <el-table-column align="center" label="手机号码" prop="mobile" />

      <el-table-column align="center" label="积分余额" prop="integral" />

      <el-table-column align="center" label="性别" prop="gender">
        <template slot-scope="scope">
          <el-tag>{{ genderDic[scope.row.gender] }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" label="生日" prop="birthday" />

      <el-table-column align="center" label="用户等级" prop="userLevel">
        <template slot-scope="scope">
          <el-tag>{{ levelDic[scope.row.userLevel] }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" label="状态" prop="status">
        <template slot-scope="scope">
          <el-tag>{{ statusDic[scope.row.status] }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" label="管理员" prop="adminId">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.adminId != 0">{{ scope.row.adminName }}</el-tag>
          <el-tag v-if="scope.row.adminId == 0">无</el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" width="230" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button v-permission="['POST /admin/user/update']" type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <!-- <el-button v-permission="['POST /admin/user/update']" type="primary" size="mini" @click="handleIntegral(scope.row)">积分</el-button> -->
          <el-button v-permission="['POST /admin/user/update']" v-if="scope.row.publishGoodState == 0" type="primary" size="mini" @click="Empowerment(scope.row.id)">赋权</el-button>
          <el-button v-permission="['POST /admin/user/update']" v-else style="width:80px" type="primary" size="mini" @click="Empowermentdelet(scope.row.id)">取消赋权</el-button>
        </template>
      </el-table-column>

    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

    <!-- 修改对话框 -->
    <el-dialog :visible.sync="dialogFormVisible" title="会员信息编辑">
      <el-form ref="dataForm" :rules="rules" :model="dataForm" status-icon label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="会员昵称" prop="nickname">
          <el-input v-model="dataForm.nickname" />
        </el-form-item>
        <el-form-item label="手机号码" prop="mobile">
          <el-input v-model="dataForm.mobile" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-radio-group v-model="dataForm.gender" size="medium">
            <el-radio-button label="0">未知</el-radio-button>
            <el-radio-button label="1">男</el-radio-button>
            <el-radio-button label="2">女</el-radio-button>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker v-model="dataForm.birthday" type="date" placeholder="选择日期" value-format="yyyy-MM-dd"/>
        </el-form-item>
        <el-form-item label="用户等级" prop="userLevel">
          <el-select v-model="dataForm.userLevel" placeholder="请选择">
            <el-option v-for="(item, index) in levelDic" :key="index" :label="item" :value="index"/>
          </el-select>
        </el-form-item>
        <el-form-item label="关联管理员" prop="adminId">
          <el-select v-model="dataForm.adminId" placeholder="请选择">
            <el-option v-for="(item, index) in adminList" :key="index" :label="item.username" :value="item.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="dataForm.status" size="medium">
            <el-radio-button label="0">正常</el-radio-button>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="updateData">确定</el-button>
      </div>
    </el-dialog>

    <!-- 积分对话框 -->
    <el-dialog :visible.sync="integralFormVisible" title="会员积分">
      <el-form ref="integralFrom" :model="integralFrom" status-icon label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="会员昵称" prop="nickname">
          <el-input v-model="integralFrom.nickname" :disabled="true" />
        </el-form-item>
        <el-form-item label="积分" prop="integral">
          <el-input-number v-model="integralFrom.integral" label="请输入积分数值,正数为增加,负数为减少"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="integralFormVisible = false">取消</el-button>
        <el-button type="primary" @click="integralSave">确定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import {
  fetchList,
  updateUser,
  integralSave,
  userFuquanUser
} from '@/api/user'
import {
  listAdmin
} from '@/api/admin'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

export default {
  name: 'User',
  components: {
    Pagination
  },
  data() {
    return {
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        nickname: undefined,
        mobile: undefined,
        sort: 'add_time',
        order: 'desc'
      },
      dialogFormVisible: false,
      integralFormVisible: false,
      downloadLoading: false,
      genderDic: ['未知', '男', '女'],
      levelDic: ['普通用户', 'VIP用户', '高级VIP用户'],
      statusDic: ['可用', '禁用', '注销'],
      dataForm: {
        id: undefined,
        nickname: undefined,
        mobile: undefined,
        gender: 0,
        birthday: undefined,
        userLevel: 0,
        status: 0,
        adminId: 0
      },
      integralFrom: {
        userId: undefined,
        nickname: undefined,
        integral: 0
      },
      rules: {
        nickname: [{
          required: true,
          message: '昵称不能为空',
          trigger: 'blur'
        }],
        mobile: [{
          required: true,
          message: '手机号码不能为空',
          trigger: 'blur'
        }]
      },
      adminList: []
    }
  },
  created() {
    this.getList()
    this.getAdminList()
  },
  methods: {
    getList() {
      this.listLoading = true
      fetchList(this.listQuery).then(response => {
        this.list = response.data.data.list
        this.total = response.data.data.total
        this.listLoading = false
      }).catch(() => {
        this.list = []
        this.total = 0
        this.listLoading = false
      })
    },
    getAdminList() {
      var listAdminQuery = {
        page: 1,
        limit: 999999,
        username: '',
        sort: 'add_time',
        order: 'desc'
      }
      listAdmin(this.listAdminQuery)
        .then(response => {
          this.adminList = response.data.data.list
          this.adminList.reverse().push({
            id: 0,
            username: '请选择'
          })
          this.adminList.reverse()
        })
        .catch(() => {
          this.adminList = []
        })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['昵称', '手机号码', '积分余额', '性别', '生日', '状态']
        const filterVal = ['nickname', 'mobile', 'integral', 'gender', 'birthday', 'status']
        excel.export_json_to_excel2(tHeader, this.list, filterVal, '用户信息')
        this.downloadLoading = false
      })
    },
    handleUpdate(row) {
      console.log(row)
      this.dataForm = Object.assign({}, row)
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    handleIntegral(row) {
      console.log(row)
      this.integralFrom = Object.assign({}, {
        userId: row.id,
        nickname: row.nickname,
        integral: 0
      })
      this.integralFormVisible = true
      this.$nextTick(() => {
        this.$refs['integralFrom'].clearValidate()
      })
    },
    // 赋权
    Empowerment: function(userId) {
      var listAdminQuery = {
        userId: userId,
        publishState: 1
      }
      var _this = this
      userFuquanUser(listAdminQuery).then(response => {
        console.log(response)
        _this.getList()
        this.$notify.success({
          title: '成功',
          message: '赋权成功'
        })
      }).catch(() => {
        this.$notify.error({
          title: '失败',
          message: response.data.errmsg
        })
      })
    },
    // 取消赋权
    Empowermentdelet: function(userId) {
      var listAdminQuery = {
        userId: userId,
        publishState: 0
      }
      var _this = this
      userFuquanUser(listAdminQuery).then(response => {
        console.log(response)
        _this.getList()
        this.$notify.success({
          title: '成功',
          message: '已取消赋权'
        })
      }).catch(() => {
        this.$notify.error({
          title: '失败',
          message: response.data.errmsg
        })
      })
    },
    updateData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          updateUser(this.dataForm)
            .then(response => {
              for (const v of this.list) {
                if (v.id === this.dataForm.id) {
                  const index = this.list.indexOf(v)
                  this.list.splice(index, 1, response.data.data)
                  break
                }
              }
              this.dialogFormVisible = false
              this.$notify.success({
                title: '成功',
                message: '更新会员信息成功'
              })
            })
            .catch(response => {
              this.$notify.error({
                title: '失败',
                message: response.data.errmsg
              })
            })
        }
      })
    },
    integralSave: function(e) {
      this.$refs['integralFrom'].validate(valid => {
        if (valid) {
          this.integralFrom['nickname'] = ''
          integralSave(this.integralFrom)
            .then(() => {
              for (const v of this.list) {
                if (v.id === this.integralFrom.userId) {
                  const index = this.list.indexOf(v)
                  this.list[index].integral += this.integralFrom.integral
                  break
                }
              }
              this.integralFormVisible = false
              this.$notify.success({
                title: '成功',
                message: '更新信息成功'
              })
            })
            .catch(response => {
              this.$notify.error({
                title: '失败',
                message: response.data.errmsg
              })
            })
        }
      })
    }
  }
}
</script>
