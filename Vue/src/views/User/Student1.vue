<template>
  <div class="container">
    <h1 class="page-title">学生页面</h1>


    <el-collapse v-model="activeNames">
      <el-collapse-item title="学生评测信息" name="0">
        </el-collapse-item>
  <el-collapse-item title="评测信息填报" name="1">
    <el-form ref="form" :model="user" :rules="rules" label-width="200px">
      <el-row>
        <el-col :span="8">
          <el-form-item label="姓名" prop="Name" class="inline-form-item">
            <el-input v-model="user.name" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="学号" prop="id" class="inline-form-item">
            <el-input v-model="user.studentNumber" readonly></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="GPA" prop="gpa" class="inline-form-item">
            <el-input v-model="user.academicGrade" readonly></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <el-form-item label="科研经历" prop="research">
        <el-input type="textarea" placeholder="请输入科研经历" v-model="user.researchContent" class="custom-input"></el-input>
      </el-form-item>
      
      <el-form-item label="学生骨干服务岗位" prop="backbone">
        <el-input type="textarea" placeholder="请输入学生骨干服务岗位" v-model="user.studentLeadershipContent" class="custom-input"></el-input>
      </el-form-item>
      
      <el-form-item label="社会实践经历" prop="social">
        <el-input type="textarea" placeholder="请输入社会实践经历" v-model="user.socialPracticeContent" class="custom-input"></el-input>
      </el-form-item>

      <el-form-item label="志愿服务经历" prop="event">
        <el-input type="textarea" placeholder="请输入志愿服务经历" v-model="user.volunteerServiceContent" class="custom-input"></el-input>
      </el-form-item>

      <el-form-item label="个人学年总结" prop="summary">
        <el-input type="textarea" placeholder="请输入个人学年总结" v-model="user.personalSummaryContent" class="custom-input"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button class="custom-button" size="small" plain  @click="saveForm">保存</el-button>
        <el-button class="custom-button" size="small" plain  @click="submitForm">提交</el-button>
      </el-form-item>
    </el-form>
  </el-collapse-item>




  <el-collapse-item title="学生基本信息" name="2">
    <el-form ref="form" :model="user2" :rules="rules2" label-width="120px">
        
        <el-row>
        <el-col :span="12">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="user2.name" readonly></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="12">
        <el-form-item label="学号" prop="StudentNumber">
          <el-input v-model="user2.studentNumber" readonly></el-input>
        </el-form-item>
    </el-col>
    </el-row>
    <el-row>
        <el-col :span="12">
        <el-form-item label="性别" prop="gender">
          <el-select v-model="user2.gender" >
            <el-option label="男" value="男"></el-option>
        <el-option label="女" value="女"></el-option>
        </el-select>
        </el-form-item>
    </el-col>
    <el-col :span="12">
        <el-form-item label="学生类型" prop="StudentType">
          <el-select v-model="user2.studentTypeDictionary" >
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
          <el-input v-model="user2.phoneNumber"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="Email">
          <el-input v-model="user2.email"></el-input>
        </el-form-item>
        <el-form-item label="年份" prop="year">
          <el-input v-model="user2.year"></el-input>
        </el-form-item>
        <el-form-item label="学苑" prop="Academy">
          <el-input v-model="user2.academyDictionary" ></el-input>
        </el-form-item>
        <el-form-item label="专业" prop="Major">
          <el-input v-model="user2.majorDictionary"></el-input>
        </el-form-item>
        <el-form-item label="政治面貌" prop="PoliticalStatus">
          <el-input v-model="user2.politicalStatusDictionary"></el-input>
        </el-form-item>
       
        <el-form-item>
          <el-button class="custom-button" size="small" plain  @click="saveForm2">保存</el-button>
          <el-button class="custom-button" size="small" plain  @click="submitForm2">提交</el-button>
        </el-form-item>
      </el-form>

  </el-collapse-item>
  
  
  
  
  
  
  <el-collapse-item title="学生成绩查看" name="3">
    <el-table :data="students" style="width: 100%">
    <el-table-column prop="name" label="姓名" width="10%">
        <template slot-scope="{row}">{{ row.name }}</template>
    </el-table-column>
    <el-table-column prop="id" label="学号" >
        <template slot-scope="{row}">{{ row.id }}</template>
    </el-table-column>
    <el-table-column prop="gpa" label="GPA">
        <template slot-scope="{row}">{{ row.gpa }}</template>
    </el-table-column>
    <el-table-column prop="grade1" label="科研成绩" >
        <template slot-scope="{row}">{{ row.grade1 }}</template>
    </el-table-column>
    <el-table-column prop="grade2" label="骨干服务成绩" >
        <template slot-scope="{row}">{{ row.grade2 }}</template>
    </el-table-column>
    <el-table-column prop="grade3" label="社会实践成绩">
        <template slot-scope="{row}">{{ row.grade3 }}</template>
    </el-table-column>
    <el-table-column prop="grade4" label="志愿服务成绩">
        <template slot-scope="{row}">{{ row.grade4 }}</template>
    </el-table-column>
    <el-table-column prop="grade5" label="学年总结成绩" >
        <template slot-scope="{row}">{{ row.grade5 }}</template>
    </el-table-column>
    <el-table-column prop="sumGrade" label="总成绩">
        <template slot-scope="{row, index}">{{ gradesum(index) }}</template>
    </el-table-column>
</el-table>

  </el-collapse-item>

  <el-collapse-item title="反馈" name="5">
        </el-collapse-item>
</el-collapse>

    
  </div>
</template>








  <script>
  //import { changeinfo } from '@/api/login'
  import { getEvainfo} from '/api/info'
  import { changeEvainfo } from '/api/info'
  import {getBasicinfo} from  '/api/info'
  import { changeBasicinfo } from '/api/info'
  export default {
    name: 'AddUser',
    data() {
      return {
        user: {
          name: '',
          studentNumber: '',
          academicGrade: '',
          researchContent: '',
          studentLeadershipContent: '',
          socialPracticeContent: '',
          volunteerServiceContent: '',
          personalSummaryContent: '',
        },
        rules: {
          // name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
          // id: [{ required: true, message: '请输入学号', trigger: 'blur' }],
          // gpa: [{ required: true, message: '请输入GPA', trigger: 'blur' }],
          researchContent: [{ required: true, message: '请输入科研经历', trigger: 'blur' }],
          studentLeadershipContent: [{ required: true, message: '请输入学生骨干经历', trigger: 'blur' }],
          socialPracticeContent: [{ required: true, message: '请输入社会实践经历', trigger: 'blur' }],
          volunteerServiceContent : [{ required: true, message: '请输入志愿服务事项', trigger: 'blur' }],
          personalSummaryContent: [{ required: true, message: '请输入个人总结', trigger: 'blur' }],
        },
        storageKey: 'user_data', // 存储在本地的键名



        user2: {
        name: '',
        studentNumber: '',
        gender: '',
        phoneNumber: '',
        Email: '',
        year: '', 
        academyDictionary: '',
        majorDictionary: '',
        politicalStatusDictionary: '',
        studentTypeDictionary: ''
        },
        rules2: {
        //   name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
        //   StudentNumber: [{ required: true, message: '请输入学号', trigger: 'blur' }],
          gender: [{ required: true, message: '请选择性别', trigger: 'blur' }],
          phoneNumber: [{ required: true, message: '请输入电话号码', trigger: 'blur' }],
          email: [{ required: true, message: '请输入邮箱', trigger: 'blur' }],
          year: [{ required: true, message: '请输入年份', trigger: 'blur' }],
          academyDictionary: [{ required: true, message: '请输入学苑', trigger: 'blur' }],
          majorDictionary: [{ required: true, message: '请输入专业', trigger: 'blur' }],
          politicalStatusDictionary: [{ required: true, message: '请输入政治面貌', trigger: 'blur' }],
          studentTypeDictionary: [{ required: true, message: '请选择学生类别', trigger: 'blur' }],
        },
        storageKey2: 'user2_data', // 存储在本地的键名


        students: [
           { name: '张三', id: '20210001', gpa: 3.5 , grade1: 3,grade2: 3,grade3: 3,grade4: 3,grade5: 3},
        ]

      }
    },
    async mounted() {
  // 页面加载时从本地存储中读取用户数据
          const response1 = await getEvainfo()
          if (response1.code==200){
            this.user=response1.data
            //this.$message.success(response.data.name)
          }
          const response2=await getBasicinfo()
          if (response2.code==200){
            this.user2=response2.data
            //this.$message.success(response.data.name)
          }
          this.getUserData()
          this.getUserData2()
        },
        methods: {
          submitForm() {
            const data = localStorage.getItem(this.storageKey)
            if (data) {
              this.user = JSON.parse(data)
            }
            //this.$message.success('开始')

            changeEvainfo(this.user)
            .then((res) => {
              if (res.code==200){
                this.$message.success('提交成功')
                localStorage.removeItem(this.storageKey)
              }
            })
            .catch((err) => {
              console.error(err)
              this.$message.error('提交失败')
            })
            /*this.$refs.form.validate((valid) => {
              if (valid) {
                changeEvainfo(this.user)
                  .then(() => {
                    this.$message.success('提交成功')
                    localStorage.removeItem(this.storageKey)
                  })
                  .catch((err) => {
                    console.error(err)
                    this.$message.error('提交失败')
                  })
              } else {
                console.log('error submit!!')
              }
            })*/
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
          
          
          
          submitForm2() {
            const data = localStorage.getItem(this.storageKey2)
            if (data) {
              this.user2 = JSON.parse(data)
            }
            //this.$message.success('开始')

            changeBasicinfo(this.user2)
            .then((res) => {
              if (res.code==200){
                this.$message.success('提交成功')
                localStorage.removeItem(this.storageKey)
              }
            })
            .catch((err) => {
              console.error(err)
              this.$message.error('提交失败')
            })
          },


          saveForm2() {
              localStorage.setItem(this.storageKey2, JSON.stringify(this.user2))
                  this.$message.success('保存成功')
              },
          getUserData2() {
              const data = localStorage.getItem(this.storageKey2)
              if (data) {
              this.user2 = JSON.parse(data)
              }
            },


        }
      }
  </script>
  

  <style scoped>
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
  
  .custom-input .el-input__inner {
  height: 300px; /* 根据需要调整高度值 */
}


.custom-button {
  color: #606266;
  background-color: #ecf5ff;
  border-color: #c0c4cc;
}
  </style>
  
  