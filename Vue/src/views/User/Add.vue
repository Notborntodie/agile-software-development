<template>
  <div class="container">
    <h1 class="page-title">用户信息</h1>

    <el-collapse v-model="activeNames"> 
      <el-collapse-item title="修改密码" name="1">
    <el-form ref="form" :model="user" :rules="rules" label-width="100px">
      <el-form-item label="旧密码" prop="oldpassword">
        <el-input v-model="user.oldpassword"></el-input>
      </el-form-item>
      <el-form-item label="新密码" prop="newpassword">
        <el-input v-model="user.newpassword"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button class="custom-button" size="small" plain @click="submitForm">提交</el-button>
        <el-button  class="custom-button" size="small" plain @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
    </el-collapse-item>
  </el-collapse>

   

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

.container {
  padding: 20px;
}

.page-title {
  font-family: 'San Francisco', Arial, sans-serif;
  font-size: 24px;
  font-weight: bold;
  color: #6699CC;
  letter-spacing: -0.5px;
  text-align: center;
}
</style>