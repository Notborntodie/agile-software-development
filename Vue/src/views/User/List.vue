<template>

<div class="container">
   
  <h1 class="page-title">学工管理</h1>

<el-collapse v-model="activeNames">
  <el-collapse-item title="导入评审名单" name="0">
    <el-table :data="pagedReviewers" style="width: 100%">
  
      <el-table-column prop="name" label="姓名">
        <template slot-scope="{ row, $index }">
          <el-input v-model="row.name" @change="updateName2(row, $index)"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="id" label="工号">
        <template slot-scope="{ row, $index }">
          <el-input v-model="row.id" @change="updateId2(row, $index)"></el-input>
        </template>
      </el-table-column>

      <el-table-column prop="level" label="评审类型">
    <template slot-scope="{ row, $index }">
        <el-select v-model="row.level" @change="updateLevel2(row,$index)"  multiple placeholder="请选择评审类型">
            <el-option
                v-for="item in levels"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
        </el-select>
    </template>
</el-table-column>


      <el-table-column label="操作" >
        <template slot-scope="{ row }">
          <el-button class="custom-button" size="small" plain @click="deleteRow2(row)" type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      @size-change="handleSizeChange2"
      @current-change="handleCurrentChange2"
      :current-page="currentPage2"
      :page-size="pageSize2"
      layout="total, sizes, prev, pager, next, jumper"
    >
    </el-pagination>

    <el-button class="custom-button" size="small" plain @click="addRow2">添加一行</el-button>

   
      <div class="action-buttons">
        <el-button class="custom-button" size="small" plain @click="save2">保存</el-button>
        <el-button class="custom-button" size="small" plain @click="submit2">上传评审名单</el-button>
      </div>
  
</el-collapse-item>


  <el-collapse-item title="导入学生名单" name="1">
     <el-table :data="pagedStudents" style="width: 100%">
  
      <el-table-column prop="name" label="姓名">
  <template slot-scope="{ row, $index }">
    <el-input v-model="row.name" @change="updateName(row, $index)"></el-input>
  </template>
</el-table-column>

<el-table-column prop="id" label="学号" >
  <template slot-scope="{ row, $index }">
    <el-input v-model="row.id" @change="updateId(row, $index)"></el-input>
  </template>
</el-table-column>

<el-table-column prop="gpa" label="GPA">
  <template slot-scope="{ row, $index }">
    <el-input v-model="row.gpa" @change="updateGPA(row, $index)"></el-input>
  </template>
</el-table-column>

<el-table-column label="操作" >
        <template slot-scope="{ row }">
          <el-button class="custom-button" size="small" plain  @click="deleteRow(row)" type="danger" >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
  @size-change="handleSizeChange"
  @current-change="handleCurrentChange"
  :current-page="currentPage"
  :page-size="pageSize"
  layout="total, sizes, prev, pager, next, jumper"
>
</el-pagination>

    <el-button class="custom-button" size="small" plain  @click="addRow"  >添加一行</el-button>



       
    <div class="con">
  <div class="input-file">
    <label class="custom-file-upload">
        <input type="file" @change="handleFileUpload" class="file-input">
        导入学生名单
      </label>

    </div>
    <div class="action-buttons">
    
       
      <el-button class="custom-button" size="small" plain @click="save">保存</el-button>
      <el-button class="custom-button" size="small" plain  @click="submit1">上传学生名单</el-button>
    </div>
    </div>

  </el-collapse-item>
      <el-collapse-item title="学生评测表" name="2">
        <el-table :data=" pagedBackendStudents" style="width: 100%">
         
    <el-table-column prop="name" label="姓名" >
        <template slot-scope="{row}">{{ row.name }}</template>
    </el-table-column>
    <el-table-column prop="studentNumber" label="学号">
        <template slot-scope="{row}">{{ row.studentNumber }}</template>
    </el-table-column>
    <el-table-column prop="academicGrade" label="GPA">
        <template slot-scope="{row}">{{ row.academicGrade }}</template>
    </el-table-column>
    <el-table-column prop="researchScore" label="科研成绩" >
        <template slot-scope="{ row }">{{ row.researchGrade }}</template>
    </el-table-column>
    <el-table-column prop="studentLeadershipGrade" label="骨干服务成绩">
        <template slot-scope="{ row }">{{ row.studentLeadershipGrade }}</template>
    </el-table-column>
    <el-table-column prop="socialPracticeGrade " label="社会实践成绩">
        <template slot-scope="{ row }">{{ row.socialPracticeGrade }}</template>
    </el-table-column>
    <el-table-column prop="volunteerServiceGrade" label="志愿服务成绩" >
        <template slot-scope="{ row }">{{ row.volunteerServiceGrade }}</template>
    </el-table-column>
    <el-table-column prop="personalSummaryGrade" label="学年总结成绩">
        <template slot-scope="{ row }">{{ row.personalSummaryGrade }}</template>
    </el-table-column>
    <el-table-column prop="sumGrade" label="总成绩">
        <template slot-scope="{ row }">{{ row.sumGrade }}</template>
    </el-table-column>
   
        </el-table>

        <el-pagination
  @size-change="handleBackendSizeChange"
  @current-change="handleBackendCurrentChange"
  :current-page="backendCurrentPage"
  :page-size="backendPageSize"
  layout="total, sizes, prev, pager, next, jumper"
>
</el-pagination>


        <div class="action-buttons">
          <el-button class="custom-button" size="small" plain @click="fetchData">刷新</el-button>
    <el-button class="custom-button" size="small" plain @click="exportToExcel">导出 Excel</el-button>
    <el-button class="custom-button" size="small" plain @click="submit2">学生成绩发布</el-button>
    </div>
      </el-collapse-item>


    
     
    </el-collapse>
    
  </div>
</template>





<script>
import * as XLSX from 'xlsx'
import { subumitstulist } from '/api/stulist'
import {getstulist} from  '/api/stulist'
import {subumitrevlist} from  '/api/stulist'

export default {
  
  data() {
    return {
      reviewers: [],
      pagedReviewers: [],
      currentPage2: 1,
      pageSize2: 10,

      students: [  
        //{ name: '张三', id: '20210001', gpa: 3.5,},
        //{ name: '李四', id: '20210002', gpa: 3.2 },
        //{ name: '王五', id: '20210003', gpa: 3.8 },
      ],
    pagedStudents: [], // the data to be displayed in the table
    currentPage: 1, // the current page
    pageSize: 10, // the number of items per page
    pagedBackendStudents: [], // 学生评测表在表格中显示的数据
    currentBackendPage: 1, // 学生评测表的当前页
    backendPageSize: 10, // 学生评测表每页的条目数

      backendStudents: [],


      levels: [
        { value: 3, label: '学年总结' },
        { value: 4, label: '科研情况' },
        { value: 5, label: '骨干服务' },
        {value: 6 ,label: '社会实践'},
        {value :7 ,label: '志愿服务'}
        // 添加更多选项
      ],
    }

  },

  async mounted() {
    
    const storedData = localStorage.getItem('students');
    if (storedData) {
      this.students = JSON.parse(storedData);
    }

    const storedData2 = localStorage.getItem('reviewers');
    if (storedData2) {
      this.reviewers = JSON.parse(storedData2);
    }
    

    this.handleDataChange();  // 更新分页数据
    this.handleDataChange2();
  
    await this.fetchData();
}

  ,
  methods: {
    handleFileUpload2(event) {
      const file = event.target.files[0];
      const reader = new FileReader();
      reader.onload = (event) => {
        const data = new Uint8Array(event.target.result);
        const workbook = XLSX.read(data, { type: 'array' });
        const sheetName = workbook.SheetNames[0];
        const worksheet = workbook.Sheets[sheetName];
        const rows = XLSX.utils.sheet_to_json(worksheet, { header: 1 });
        const headers = rows[0];
        const dataRows = rows.slice(1);
        const reviewers = dataRows.map(row => {
          const reviewer = {};
          headers.forEach((header, index) => {
            reviewer[header] = row[index];
          });
          return reviewer;
        });
        this.reviewers = reviewers;
        this.handleDataChange2();
        localStorage.setItem('reviewers', JSON.stringify(reviewers));
      };
      reader.readAsArrayBuffer(file);
    },

    addRow2() {
      this.reviewers.push({});
      this.handleDataChange2();
    },

    deleteRow2(row) {
      const index = this.reviewers.indexOf(row);
      if (index !== -1) {
        this.reviewers.splice(index, 1);
        this.handleDataChange2();
      }
    },


    /*
    
    updateName2(row, $index) {
      const globalIndex = (this.currentPage2 - 1) * this.pageSize2 + $index;
      this.reviewers[globalIndex].name = row.name;
    },
    updateId2(row, $index) {
      const globalIndex = (this.currentPage2 - 1) * this.pageSize2 + $index;
      this.reviewers[globalIndex].id = row.id;
    },
    updateLevel2(row, $index) {
      const globalIndex = (this.currentPage2 - 1) * this.pageSize2 + $index;
      this.reviewers[globalIndex].level = [...row.level];
    },
    */

    handleSizeChange2(val) {
      this.pageSize2 = val;
      this.updatePagedData2();
    },

    handleCurrentChange2(val) {
      this.currentPage2 = val;
      this.updatePagedData2();
    },

    updatePagedData2() {
      const start = (this.currentPage2 - 1) * this.pageSize2;
      const end = this.currentPage2 * this.pageSize2;
      this.pagedReviewers = this.reviewers.slice(start, end);
    },

    handleDataChange2() {
      this.updatePagedData2();
    },

    save2() {
      localStorage.setItem('reviewers', JSON.stringify(this.reviewers));
      //this.$message.success(this.reviewers[0].level.join(", "));

      this.$message.success('保存成功');
    },

    submit2() {
      let reviewers = JSON.parse(localStorage.getItem('reviewers'));
      subumitrevlist(reviewers)
      .then(res =>{
        if (res.code===200){
                //this.$message.success(res.data.data.accessToken)
          this.$message.success('上传评审名单成功')
        }else{
          this.$message.error("上传失败")
        }
        }).catch(() => {
          this.$message.error('上传失败')
        })
      
    },









    handleFileUpload(event) {
      const file = event.target.files[0]
      const reader = new FileReader()
      reader.onload = (event) => {
        const data = new Uint8Array(event.target.result)
        const workbook = XLSX.read(data, { type: 'array' })
        const sheetName = workbook.SheetNames[0]
        const worksheet = workbook.Sheets[sheetName]
        const rows = XLSX.utils.sheet_to_json(worksheet, { header: 1 })
        const headers = rows[0]
        const dataRows = rows.slice(1)
        const students = dataRows.map(row => {
          const student = {}
          headers.forEach((header, index) => {
            student[header] = row[index]
          })
          return student
        })
        this.students = students
        this.handleDataChange();  // 更新分页数据
        localStorage.setItem('students', JSON.stringify(students))
      }
      reader.readAsArrayBuffer(file)
  
    }
    ,

    async fetchData() {
      try {
        const response = await getstulist()
        if (response.code === 200) {
          //this.$message.success("刷新成功")
          this.backendStudents = response.data
          for (let index = 0; index < this.backendStudents.length; index++) {
            this.backendStudents[index].sumGrade=
            this.backendStudents[index].academicGrade+
            this.backendStudents[index].researchGrade+
            this.backendStudents[index].studentLeadershipGrade+
            this.backendStudents[index].socialPracticeGrade+
            this.backendStudents[index].volunteerServiceGrade+
            this.backendStudents[index].personalSummaryGrade
          }
          this.handleBackendDataChange()
        } else {
          this.$message.error('获取数据失败1')
        }
      } catch (error) {
        console.error(error)
        this.$message.error('获取数据失败2')
      }
    },


   // 添加行
addRow() {
  // 在 students 数组的末尾添加一个新的空对象
  this.students.push({});
  this.handleDataChange();  // 更新分页数据
},

// 删除行
deleteRow(row) {
  // 找到要删除的行的索引并从数组中删除
  const index = this.students.indexOf(row);
  if (index !== -1) {
    this.students.splice(index, 1);
    this.handleDataChange();  // 更新分页数据
  }
},

/*
    updateName(row, $index){
     const globalIndex = (this.currentPage - 1) * this.pageSize + $index;
     this.students[globalIndex].name= row.name;
  },


    updateId(row, $index) {
      const globalIndex = (this.currentPage - 1) * this.pageSize + $index;
      this.students[globalIndex].id = row.id;
    },

    updateGPA(row, $index){
      const globalIndex = (this.currentPage - 1) * this.pageSize + $index;
     this.students[globalIndex].gpa= row.gpa;
    },

*/

    exportToExcel() {
      const worksheet = XLSX.utils.json_to_sheet(this.backendStudents)
      const workbook = XLSX.utils.book_new()
      XLSX.utils.book_append_sheet(workbook, worksheet, 'Sheet1')
      XLSX.writeFile(workbook, 'students.xlsx')
    },
    save(){
      localStorage.setItem('students', JSON.stringify(this.students))
      this.$message.success('保存成功')
    },
    async submit1(){
        try {
        let students = JSON.parse(localStorage.getItem('students'));
        const res = await subumitstulist(students);

        if (res.code === 200) {
            this.$message.success('上传学生名单成功');
            await this.fetchData();
        } else {
            this.$message.error("上传失败");
        }
        } catch (error) {
          this.$message.error('上传失败');
        }

      }
,

      handleSizeChange(val) {
    this.pageSize = val;
    this.updatePagedData();
  },
  
  handleCurrentChange(val) {
    this.currentPage = val;
    this.updatePagedData();
  },
  
  updatePagedData() {
    const start = (this.currentPage - 1) * this.pageSize;
    const end = this.currentPage * this.pageSize;
    this.pagedStudents = this.students.slice(start, end);
  },
  
  // call this method after you get your data
  handleDataChange() {
    this.updatePagedData();
  },

  handleBackendSizeChange(val) {
  this.backendPageSize = val;
  this.updateBackendPagedData();
},

handleBackendCurrentChange(val) {
  this.currentBackendPage = val;
  this.updateBackendPagedData();
},

updateBackendPagedData() {
  const start = (this.currentBackendPage - 1) * this.backendPageSize;
  const end = this.currentBackendPage * this.backendPageSize;
  this.pagedBackendStudents = this.backendStudents.slice(start, end);
},

// 在获取你的数据后调用此方法
handleBackendDataChange() {
  this.updateBackendPagedData();
},

    }
,
  computed: {
    gradesum() {
    return function(index) {
      const { grade1, grade2, grade3, grade4, grade5 } = this.students[index];
      this.students[index].sum=grade1 + grade2 + grade3 + grade4 + grade5;
      return this.students[index].sum
    }
  }
}

}
</script>


<style>



.my-table {
  border-collapse: collapse;
  width: 100%;
}

.my-table th,
.my-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.my-table th {
  background-color: #f2f2f2;
}


  .el-button--primary {
    background-color: rgb(99, 101, 99);
    color: white;
    border: none;
    border-radius: 10px;
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

.custom-file-upload {
  display: inline-block;
  padding: 3px 6px; /* Adjust padding as per your need */
  cursor: pointer;
  background-color: #ecf5ff;
  border: 1px solid #c0c4cc;
  color: #606266;
  font-size: 14px; /* Adjust font-size as per your need */
  line-height: 1.5; /* Adjust line-height as per your need */
  transition: all .3s;
  text-align: center;
  border-radius: 4px; /* To match the border radius of the button */
}

.custom-file-upload:hover {
  color: #409eff;
  border-color: #409eff;
}

.file-input {
  display: none;
}

.upload-button-container {
  margin: 20px 0;
}

.action-buttons {
  display: flex;
  justify-content: flex-end;
  gap: 10px;
}

.input-file{
  display: flex;
  justify-content: flex-start;
  gap: 20px;
}


.custom-button {
  color: #606266;
  background-color: #ecf5ff;
  border-color: #c0c4cc;
}

.con {
  display: flex;
  align-items: center;
  justify-content: space-between;
}



</style>