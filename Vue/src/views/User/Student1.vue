<!-- <template>
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

import {changeinfo} from '@/api/login'
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
            this.$message.error('错误')
            this.loading = false
          })
          console.log(this.user);
        } else {
          this.$message.error('错误')
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
</style> -->


<!-- <template>
  <div class="add-user">
    <h1>在线填报</h1>
    <el-form ref="form" :model="user" :rules="rules" label-width="120px">
      <el-form-item label="name" prop="name">
        <el-input v-model="user.name" readonly></el-input>
      </el-form-item>
      <el-form-item label="student id" prop="id">
        <el-input v-model="user.id" readonly></el-input>
      </el-form-item>
      <el-form-item label="gpa" prop="gpa">
        <el-input v-model="user.gpa" readonly></el-input>
      </el-form-item>
      <el-form-item label="research" prop="research">
        <el-input v-model="user.research"></el-input>
      </el-form-item>
      <el-form-item label="backbone" prop="backbone">
        <el-input v-model="user.backbone"></el-input>
      </el-form-item>
      <el-form-item label="social" prop="social">
        <el-input v-model="user.social"></el-input>
      </el-form-item>
      <el-form-item label="volunteer time" prop="time">
        <el-input v-model="user.time" readonly></el-input>
      </el-form-item>
      <el-form-item label="volunteer event" prop="event">
        <el-input v-model="user.event"></el-input>
      </el-form-item>
      <el-form-item label="summary" prop="summary">
        <el-input v-model="user.summary"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="saveForm">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import {changeinfo} from '@/api/login'
export default {


  name: "AddUser",
  data() {
    return {
      user: {
        name: '',
        id: '',
        gpa: '',
        research: '',
        backbone: '',
        social: '',
        time: '',
        event: '',
        summary: ''
      },
      rules: {
        name: [{ required: true, message: "请输入姓名", trigger: "blur" },],
        id: [{ required: true, message: "请输入学号", trigger: "blur" }],
        gpa: [{ required: true, message: "请输入GPA", trigger: "blur" }],
        research: [{ required: true, message: "请输入科研经历", trigger: "blur" }],
        backbone: [{ required: true, message: "请输入学生骨干经历", trigger: "blur" }],
        social: [{ required: true, message: "请输入社会实践经历", trigger: "blur" }],
        time: [{ required: true, message: "请输入志愿时长", trigger: "blur" }],
        event: [{ required: true, message: "请输入志愿服务事项", trigger: "blur" }],
        summary: [{ required: true, message: "请输入志愿服务概述及总结", trigger: "blur" }],
      },
    };
  },
  methods: {
    submitForm() {
      this.$refs.form.validate(valid => {
        if (valid) {   
          changeinfo(this.user.name,this.user.id,this.user.gpa,this.user.email,this.user.research,this.user.backbone,this.user.social,this.user.time,this.user.event,this.user.summary)
          .then(res =>{
              if (res.code===200){
                //this.$message.success(res.data.data.accessToken)
                this.$message.success('提交信息成功')
              }else{
                this.$message.error(res.message)
                this.loading = false
              }
          }).catch(() => {
            // 登录失败，显示错误提示
            this.$message.error('错误')
            this.loading = false
          })
          console.log(this.user);
        } else {
          this.$message.error('错误')
        }
      });
    },
    saveForm() {
// 将当前表格数据存储到本地存储中
      localStorage.setItem(this.storageKey, JSON.stringify(this.tableData));
        console.log('评分数据已保存：', this.tableData);         
        this.$message({
        message: '保存成功！',
        type: 'success'
        });
      },

  },
};
</script>

<style>
.add-user {
  padding: 20px;
}
</style> -->


<template>
    <div class="add-user">
      <h1>在线填报</h1>
      <el-form ref="form" :model="user" :rules="rules" label-width="120px">
        <el-form-item label="name" prop="name">
          <el-input v-model="user.name" readonly></el-input>
        </el-form-item>
        <el-form-item label="student id" prop="id">
          <el-input v-model="user.id" readonly></el-input>
        </el-form-item>
        <el-form-item label="gpa" prop="gpa">
          <el-input v-model="user.gpa" readonly></el-input>
        </el-form-item>
        <el-form-item label="research" prop="research">
          <el-input v-model="user.research"></el-input>
        </el-form-item>
        <el-form-item label="backbone" prop="backbone">
          <el-input v-model="user.backbone"></el-input>
        </el-form-item>
        <el-form-item label="social" prop="social">
          <el-input v-model="user.social"></el-input>
        </el-form-item>
        <el-form-item label="volunteer time" prop="time">
          <el-input v-model="user.time" readonly></el-input>
        </el-form-item>
        <el-form-item label="volunteer event" prop="event">
          <el-input v-model="user.event"></el-input>
        </el-form-item>
        <el-form-item label="summary" prop="summary">
          <el-input v-model="user.summary"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">提交</el-button>
          <el-button @click="saveForm">保存</el-button>
        </el-form-item>
      </el-form>
    </div>
  </template>
  
  <script>
  //import { changeinfo } from '@/api/login'
  
  export default {
    name: 'AddUser',
    data() {
      return {
        user: {
          name: '',
          id: '',
          gpa: '',
          research: '',
          backbone: '',
          social: '',
          time: '',
          event: '',
          summary: '',
        },
        rules: {
          name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
          id: [{ required: true, message: '请输入学号', trigger: 'blur' }],
          gpa: [{ required: true, message: '请输入GPA', trigger: 'blur' }],
          research: [{ required: true, message: '请输入科研经历', trigger: 'blur' }],
          backbone: [{ required: true, message: '请输入学生骨干经历', trigger: 'blur' }],
          social: [{ required: true, message: '请输入社会实践经历', trigger: 'blur' }],
          time: [{ required: true, message: '请输入志愿时长', trigger: 'blur' }],
          event: [{ required: true, message: '请输入志愿服务事项', trigger: 'blur' }],
          summary: [{ required: true, message: '请输入志愿服务概述及总结', trigger: 'blur' }],
        },
        storageKey: 'user_data', // 存储在本地的键名
      }
    },
    mounted() {
      // 页面加载时从本地存储中读取用户数据
  this.getUserData()
  },
  methods: {
  submitForm() {
  this.$refs.form.validate((valid) => {
  if (valid) {
  changeinfo(this.user)
  .then(() => {
  this.$message.success('提交成功')
  this.$router.push('/')
  })
  .catch((err) => {
  console.error(err)
  this.$message.error('提交失败')
  })
  } else {
  console.log('error submit!!')
  return false
  }
  })
  },
  saveForm() {
  localStorage.setItem(this.storageKey, JSON.stringify(this.user))
  this.$message.success('保存成功')
  },
  getUserData() {
  const data = localStorage.getItem(this.storageKey)
  if (data) {
  this.user = JSON.parse(data)
  }
  },
  },
  }
  </script>
  
  <style scoped>
  .add-user {
    padding: 20px;
  }
  
  .el-form-item__label {
    font-size: 18px;
    font-weight: bold;
  }
  </style>
  