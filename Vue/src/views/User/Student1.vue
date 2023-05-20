<template>
  <div class="add-user">
    <h1>在线填报</h1>
    <el-form ref="form" :model="user" :rules="rules" label-width="200px">
      <el-row>
        <el-col :span="8">
          <el-form-item label="姓名" prop="name" class="inline-form-item">
            <el-input v-model="user.name" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="学号" prop="id" class="inline-form-item">
            <el-input v-model="user.id" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="GPA" prop="gpa" class="inline-form-item">
            <el-input v-model="user.gpa" readonly></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-form-item label="科研经历" prop="research">
      <el-input
        type="textarea"
        placeholder="请输入科研经历"
        v-model="user.research"
        class="custom-input"
      ></el-input>
    </el-form-item>
    <el-form-item label="学生骨干服务岗位" prop="backbone">
      <el-input
        type="textarea"
        placeholder="请输入学生骨干服务岗位"
        v-model="user.backbone"
        class="custom-input"
      ></el-input>
    </el-form-item>
    <el-form-item label="社会实践经历" prop="social">
      <el-input
        type="textarea"
        placeholder="请输入社会实践经历"
        v-model="user.social"
        class="custom-input"
      ></el-input>
    </el-form-item>
    <el-form-item label="志愿服务经历" prop="event">
      <el-input
        type="textarea"
        placeholder="请输入志愿服务经历"
        v-model="user.event"
        class="custom-input"
      ></el-input>
    </el-form-item>
    <el-form-item label="个人学年总结" prop="summary">
      <el-input
        type="textarea"
        placeholder="请输入个人学年总结"
        v-model="user.summary"
        class="custom-input"
      ></el-input>
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
          event: '',
          summary: '',
        },
        rules: {
          // name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
          // id: [{ required: true, message: '请输入学号', trigger: 'blur' }],
          // gpa: [{ required: true, message: '请输入GPA', trigger: 'blur' }],
          research: [{ required: true, message: '请输入科研经历', trigger: 'blur' }],
          backbone: [{ required: true, message: '请输入学生骨干经历', trigger: 'blur' }],
          social: [{ required: true, message: '请输入社会实践经历', trigger: 'blur' }],
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
        }
      }
  </script>
  

  <style scoped>
  .add-user {
    padding: 20px;
  }
  
  .custom-input .el-input__inner {
  height: 300px; /* 根据需要调整高度值 */
}
  </style>
  
  