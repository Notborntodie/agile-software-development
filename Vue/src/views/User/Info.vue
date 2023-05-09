<template>
    <div class="add-user">
      <h1>修改用户信息</h1>
      <el-form ref="form" :model="user" :rules="rules" label-width="100px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="user.name"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="user.phone"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="user.email"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">提交</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </template>
  
  <script>

import {changeinfo} from '/api/login.js'
  export default {


    name: "AddUser",
    data() {
      return {
        user: {
          username: '',
          name: '',
          phone: '',
          email: '',
        },
        rules: {
          username: [
            { required: true, message: "请输入用户名", trigger: "blur" },
          ],
          name: [{ required: true, message: "请输入姓名", trigger: "blur" }],
          phone: [{ required: true, message: "请输入手机号", trigger: "blur" }],
            email: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
        },
      };
    },
    methods: {
      submitForm() {
        this.$refs.form.validate(valid => {
          if (valid) {   
            changeinfo(this.user.username,this.user.name,this.user.phone,this.user.email)
            .then(res =>{
                if (res.code===200){
                  //this.$message.success(res.data.data.accessToken)
                  this.$message.success('修改信息成功')
                }else{
                  this.$message.error(res.message)
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