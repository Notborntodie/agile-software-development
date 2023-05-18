<template>
  <div>
    <label class="custom-file-upload">
      导入学生名单
      <input type="file" @change="handleFileUpload">
    </label>


    <table class="my-table">
    <thead>
      <tr>
        <th>姓名</th>
        <th>学号</th>
        <th>GPA</th>
        <th>科研成绩</th>
        <th>骨干服务成绩</th>
        <th>社会实践成绩</th>
        <th>志愿服务成绩</th>
        <th>学年总结成绩</th>
        <th>总成绩</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(student, index) in students" :key="index">
        <td contenteditable @input="editname($event, index)">{{ student.name }}</td>
        <td contenteditable @input="editid($event, index)">{{ student.id }}</td>
        <td contenteditable @input="editGPA($event, index)">{{ student.gpa }}</td>
        <td>{{ student.grade1 }}</td>
        <td>{{ student.grade2 }}</td>
        <td>{{ student.grade3 }}</td>
        <td>{{ student.grade4 }}</td>
        <td>{{ student.grade5 }}</td>
        <td>{{ gradesum(index) }}</td>
        <td> <button @click="addStudent(index)">添加</button></td>
        <td> <button @click="deleteStudent(index)">删除</button> </td>
      </tr>
    </tbody>
  </table>


  <el-button type="primary" @click="exportToExcel">导出 Excel</el-button>
  <el-button type="primary" @click="save">保存</el-button>
  <el-button type="primary" @click="submit">发布</el-button>
  </div>
</template>





<script>
import * as XLSX from 'xlsx'

export default {
  
  data() {
    return {
      students: [
       
        { name: '张三', id: '20210001', gpa: 3.5 },
        { name: '李四', id: '20210002', gpa: 3.2 },
        { name: '王五', id: '20210003', gpa: 3.8 },
      ]
    }

  },

  mounted() {
    const storedData = localStorage.getItem('students')
    if (storedData) {
      this.students = JSON.parse(storedData)
    }
  }
  ,
  methods: {
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
        localStorage.setItem('students', JSON.stringify(students))
      }
      reader.readAsArrayBuffer(file)
    }
    ,
    deleteStudent(index) {
      this.students.splice(index, 1)
    },

    addStudent() {
      this.students.splice(index + 1, 0, { name: '', id: '', gpa: 0 })
    },
    

    editGPA(event, index) {
      this.students[index].gpa = event.target.textContent.trim()
    },

    editname(event, index) {
      this.students[index].name = event.target.textContent.trim()
    },

    editid(event, index) {
      this.students[index].id = event.target.textContent.trim()
    },

    exportToExcel() {
      const worksheet = XLSX.utils.json_to_sheet(this.students)
      const workbook = XLSX.utils.book_new()
      XLSX.utils.book_append_sheet(workbook, worksheet, 'Sheet1')
      XLSX.writeFile(workbook, 'students.xlsx')
    }
,
    save(){
      localStorage.setItem('students', JSON.stringify(this.students))
      this.$message.success('保存成功')
    }
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
.custom-file-upload {
  display: inline-block;
  padding: 2px 6px;
  cursor: pointer;
  border: 0 px solid #ccc;
  border-radius: 0px;
  background-color: #ffffff;
}



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

</style>