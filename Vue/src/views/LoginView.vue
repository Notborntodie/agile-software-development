<template>
  <body id="login-page">
    <div class="login-container">
      <div class="login-box">
        <div class="login-logo">
            <img src="../assets/pku.png" alt="">
        </div>
        <div class="login-form">
          <h3 class="login-title">学生评测系统</h3>
          <el-form ref="form" :model="loginForm" :rules="rules" label-position="left" label-width="0">
            <el-form-item prop="username">
              <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input type="password" v-model="loginForm.password" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="do_login" :loading="loading"  >登录</el-button>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="do_register" :loading="loading"  >注册</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
  </body>
  </template>
  
  <script>
  import {login} from '/api/login.js'
  import {setToken} from '/utils/auth'
  export default {
    data() {
      return {
        loginForm: {
          username: '',
          password: ''
        },
        rules: {
          username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
          password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
        },
        loading: false
      }
    },
    methods: {
      do_register(){
        this.$router.push({ path: '/register' })
      },
      do_login() {
        this.$refs.form.validate(valid => {
          if (valid) {
            this.loading = true
            
            this.$axios
            .post('http://localhost:28080/admin-api/auth/login',
            {
            username: this.loginForm.username,
            password: this.loginForm.password
            })
          

            login(this.loginForm.username,this.loginForm.password)
            .then(res =>{
                if (res.code===200){
                  setToken(res.data.accessToken)
                  //this.$message.success(res.data.data.accessToken)
                  this.$message.success('登录成功')
                  this.$router.push({ path: '/' })
                }else{
                  this.$message.error('密码错误')
                  this.loading = false
                }
            }).catch(() => {
              // 登录失败，显示错误提示
              this.$message.error('错误')
              this.loading = false
            })
            
            this.$router.push({ path: '/' })

          }
        })
      }
    }
  }
  </script>
  
  <style lang="scss">


#login-page {
  background: url("../assets/logo.png") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body {
  margin: 0px;
}


.login-logo img {
  width: 100; /* 设置宽度 */
  height: auto; /* 设置高度自动，以保持图像的纵横比 */
}


.login-title {
  font-style: oblique;
  font-weight: 600;
  font-family: 'Open Sans', sans-serif;
  font-size: 30px;
  color: #168973;
}




  .login-container {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  
    .login-box {
      width: 400px;
      height: 600px;
      border-radius: 5px;
      box-shadow: 0px 0px 10px #834673;
  
      .login-logo {
        height: 100px;
        width: 400px;
        display: flex;
        justify-content: center;
        align-items: center;
  
        img {
          height: 70%;
        }
      }
  
      .login-form {
  
        h3 {
          font-size: 24px;
          margin-bottom: 10px;
          text-align: center;
        }
      }
    }
  }
  </style>