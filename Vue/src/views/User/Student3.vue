<template>
    <div class="add-user">
      <h1>基本信息填报</h1>
      <el-form ref="form" :model="user" :rules="rules" label-width="120px">
        
        <el-row>
        <el-col :span="12">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="user.name" readonly></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="12">
        <el-form-item label="学号" prop="StudentNumber">
          <el-input v-model="user.StudentNumber" readonly></el-input>
        </el-form-item>
    </el-col>
    </el-row>
    <el-row>
        <el-col :span="12">
       
        <el-form-item label="性别" prop="gender">
          <el-select v-model="user.gender" >
            <el-option label="男" value="男"></el-option>
        <el-option label="女" value="女"></el-option>
        </el-select>
        </el-form-item>
    </el-col>
    <el-col :span="12">
        <el-form-item label="学生类型" prop="StudentType">
          <el-select v-model="user.StudentType" >
            <el-option label="二学位" value="二学位"></el-option>
        <el-option label="专业硕士" value="专业硕士"></el-option>
        <el-option label="工程博士" value="工程博士"></el-option>
        <el-option label="工学博士"  value="工学博士"></el-option>
        <el-option label="工程管理硕士" value="工程管理硕士"></el-option>
    </el-select>
        </el-form-item>
    </el-col>
    </el-row>
        <el-form-item label="手机号" prop="PhoneNumber">
          <el-input v-model="user.PhoneNumber"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="Email">
          <el-input v-model="user.Email"></el-input>
        </el-form-item>
        <el-form-item label="年份" prop="year">
          <el-input v-model="user.year"></el-input>
        </el-form-item>
        <el-form-item label="学苑" prop="Academy">
          <el-input v-model="user.Academy" ></el-input>
        </el-form-item>
        <el-form-item label="专业" prop="Major">
          <el-input v-model="user.Major"></el-input>
        </el-form-item>
        <el-form-item label="政治面貌" prop="PoliticalStatus">
          <el-input v-model="user.PoliticalStatus"></el-input>
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
        StudentNumber: '',
        gender: '',
        PhoneNumber: '',
        Email: '',
        year: '', 
        Academy: '',
        Major: '',
        PoliticalStatus: '',
        StudentType: ''
        },
        rules: {
        //   name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
        //   StudentNumber: [{ required: true, message: '请输入学号', trigger: 'blur' }],
          gender: [{ required: true, message: '请选择性别', trigger: 'blur' }],
          PhoneNumber: [{ required: true, message: '请输入电话号码', trigger: 'blur' }],
          Email: [{ required: true, message: '请输入邮箱', trigger: 'blur' }],
          year: [{ required: true, message: '请输入年份', trigger: 'blur' }],
          Academy: [{ required: true, message: '请输入学苑', trigger: 'blur' }],
          Major: [{ required: true, message: '请输入专业', trigger: 'blur' }],
          PoliticalStatus: [{ required: true, message: '请输入政治面貌', trigger: 'blur' }],
          StudentType: [{ required: true, message: '请选择学生类别', trigger: 'blur' }],
        },
        storageKey: 'user_data', // 存储在本地的键名
      }
    },
    mounted() {
      // 页面加载时从本地存储中读取用户数据
  this.getUserData()
  // getInfo().then((res) => {
  //     this.user.name = res.data.name;
  //     this.user.StudentNumber = res.data.StudentNumber;
  //   });
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