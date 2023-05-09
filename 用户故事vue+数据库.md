[TOC]

#  前端界面



## 学工管理



1.基本界面

![截屏2023-05-09 13.28.31](http://cdn.zhengyanchen.cn/img202305091328410.png)



2. 点击**选取文件**可上传文件

![截屏2023-05-09 13.29.30](http://cdn.zhengyanchen.cn/img202305091329534.png)



3. 总成绩会自动汇总

4. 姓名，学号和GPA是可编辑的，也可以删除改栏，或者在下方增加一栏

![截屏2023-05-09 13.31.35](http://cdn.zhengyanchen.cn/img202305091331775.png)



5. 点击**保存**，会把数据保存在浏览器本地

#  ![截屏2023-05-09 13.35.10](http://cdn.zhengyanchen.cn/img202305091336165.png)



6. 点击**导出excel**,可以下载此时学生名单各项的excel

 ![截屏2023-05-09 13.37.33](http://cdn.zhengyanchen.cn/img202305091337738.png)



7. 点击**发布**需要调用后端api,将数据发送到数据库

## 评审

1. 基本界面

![截屏2023-05-09 13.46.56](http://cdn.zhengyanchen.cn/img202305091346885.png)

2. 下拉菜单选择评审的类型

   

![截屏2023-05-09 13.47.39](http://cdn.zhengyanchen.cn/img202305091347950.png)



3. 评委可以对内容评审，并进行打分

![截屏2023-05-09 13.48.04](http://cdn.zhengyanchen.cn/img202305091348672.png)



4. 点击保存可以保存

 ![截屏2023-05-09 13.49.22](http://cdn.zhengyanchen.cn/img202305091349657.png)





## 学生页面



1. 基本界面

   

![截屏2023-05-09 13.51.24](http://cdn.zhengyanchen.cn/img202305091351269.png)



![截屏2023-05-09 13.51.41](http://cdn.zhengyanchen.cn/img202305091351796.png)



2. 信息填报学生填自己的信息，成绩查看自己的信息



# 数据库设计



​	学生表 (Student)

- id (主键)

- 姓名 (name)

- 学号 (student_id)

- 班级 (class)

  

  学生骨干服务岗位表 (StudentLeadershipPosition)

- id (主键)

- 学生id (student_id，外键：Student表的id)

- 岗位名称 (position_name)

- 岗位评分 (position_score)

  

  科研情况表 (Research)

- id (主键)

- 学生id (student_id，外键：Student表的id)

- 科研名称 (research_name)

- 科研成果 (research_result)

- 科研评分 (research_score)

  

  社会实践表 (SocialPractice)

- id (主键)

- 学生id (student_id，外键：Student表的id)

- 实践名称 (practice_name)

- 实践成果 (practice_result)

- 实践评分 (practice_score)

  志愿服务表 (VolunteerService)

- id (主键)

- 学生id (student_id，外键：Student表的id)

- 服务名称 (service_name)

- 服务时长 (service_duration)

- 服务评分 (service_score)

  

  个人学年总结表 (AnnualSummary)

- id (主键)

- 学生id (student_id，外键：Student表的id)

- 总结内容 (summary_content)

- 总结评分 (summary_score)

  

  学工管理员表 (Manager)

- id (主键)

- 姓名 (name)

- 工号 (job_id)

  

  学生信息导入表 (StudentImport)

- id (主键)

- 学生id (student_id，外键：Student表的id)

- 导入时间 (import_time)

  

  成绩汇总表 (ScoreSummary)

- id (主键)

- 成绩类型 (score_type)

- 总分数 (total_score)

- 操作人员id (operator_id，外键：Manager表的id)

  

  导出表 (Export)

- id (主键)

- 导出类型 (export_type)

- 导出时间 (export_time)

- 操作人员id (operator_id，外键：Manager表的id)

  

  用户表 (User)

- id (主键)

- 姓名 (name)

- 用户名 (username)

- 密码 (password)

  

  角色表 (Role)

- id (主键)

- 角色名称 (role_name)

  

  用户角色表 (UserRole)

- id (主键)
- 用户id (user_id，外键：User表的id)
- 角色id (role_id，外键：Role表的id)