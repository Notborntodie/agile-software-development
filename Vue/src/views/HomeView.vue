<template>
  <div class="container">


    <h1 class="page-title" >欢迎来到学生评测系统！</h1>
          <p style="font-size: 18px; text-align: center;color: #6699CC "> Welcome{{ username }} </p>
    


    <!--
          <el-container >
      <el-aside width="200px" >
      
      </el-aside>
      <el-main>
        <div class="content">
          <h1 style="color: black; text-align: center;">欢迎来到学生评测系统！</h1>
          <p style="font-size: 18px; text-align: center;">Welcome, <span style="font-weight: bold;">{{ username }}</span> </p>
        </div>
      </el-main>
    </el-container>
  -->
  </div>
</template>

<script>

import { getInfo } from "/api/login";

export default {
  name: "SuccessPage",
  data() {
    return {
      username: "",
    };
  },
  mounted() {
    getInfo().then((res) => {
      this.username = res.data.name;
    });
  },
};
</script>

<style scoped>
.success-page {
  height: 100%;
}

.container {
  padding: 20px;
}


.content {
  margin: 20px;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 4px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}


.page-title {
  font-family: 'San Francisco', Arial, sans-serif;
  font-size: 40px;
  font-weight: bold;
  color: #6699CC;
  letter-spacing: -0.5px;
  text-align: center;
}
</style>