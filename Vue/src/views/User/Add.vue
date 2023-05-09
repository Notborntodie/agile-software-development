<template>
  <div class="add-user">
    <h1>修改用户密码</h1>
    <el-form ref="form" :model="user" :rules="rules" label-width="100px">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="user.username"></el-input>
      </el-form-item>
      <el-form-item label="旧密码" prop="oldpassword">
        <el-input v-model="user.oldpassword"></el-input>
      </el-form-item>
      <el-form-item label="新密码" prop="newpassword">
        <el-input v-model="user.newpassword"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>


   

  </div>
</template>

<script>

import {changepass} from '/api/login.js'
export default {


  name: "AddUser",
  data() {
    return {
      user: {
        username: '',
        oldpassword: '',
        newpassword: '',
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        oldpassword: [{ required: true, message: "请输入旧密码", trigger: "blur" }],
        newpassword: [{ required: true, message: "请输入新密码", trigger: "blur" }],
      },

      tableData: [{
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: '2016-05-04',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1517 弄'
          }, {
            date: '2016-05-01',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1519 弄'
          }, {
            date: '2016-05-03',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1516 弄'
          }]

    };
  },
  methods: {
    submitForm() {
      this.$refs.form.validate(valid => {
        if (valid) {   
          changepass(this.user.username,this.user.oldpassword,this.user.newpassword)
          .then(res =>{
              if (res.code===200){
                //this.$message.success(res.data.data.accessToken)
                this.$message.success('修改密码成功')
              }else{
                this.$message.error("密码错误"+res.code)
                this.loading = false
              }
          }).catch(() => {
            // 登录失败，显示错误提示
            this.$message.error('错误1')
            this.loading = false
          })
          console.log(this.user);
        } else {
          this.$message.error('错误2')
        }
      });
    },
    resetForm() {
      this.$refs.form.resetFields();
    },
  },
};
</script>

<style>
.add-user {
  padding: 20px;
}
</style>