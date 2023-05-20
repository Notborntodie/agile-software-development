<template>
  <div class="success-page">
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

.content {
  margin: 20px;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 4px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>