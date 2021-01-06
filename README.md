# course-app-backend

## 基本需求
登录
查询某一周的课表、
推送当天课程
所有课程增删改查
根据每天的课表动态手机状态
查看所有作业（今天以后的所有作业）、前一天推送作业消息（未完成）
事件增删查


## 接口
### 已实现：
**用户info接口**
查询（用户学号，用户密码）、修改密码（id、旧密码、新密码）
```java
@PostMapping(value = "/verify",produces = "application/json;charset=utf-8")
@ResponseBody
public String verify(@RequestParam("num") String num,@RequestParam("pwd")String pwd){}

@PutMapping(value = "/updatePwd",produces = "application/json;charset=utf-8")
@ResponseBody
public String updatePwd(Integer userId,String oldPwd,String newPwd){}
```
### 未实现：
用户表接口：
添加（用户）、查询（用户id）

课程表接口：
getCourseOfWeek（用户id）

获取当天课程（用户id）

获取第二天的截止未完成事件（用户id）

事件接口：
获取（用户id）

增加（事件）
   
删除（事件id）

## 数据库：

```sql
create table info(
	user_id int primary key auto_increment comment '用户id',
    num varchar(12) comment '学号',
    pwd varchar(12) comment '密码',
    name varchar(12) comment '姓名',
    grade varchar(4) comment '年级',
    classes varchar(12) comment'班级'
) comment '用户表';

create table term(
	term_id int primary key auto_increment comment '学期id',
    years varchar(10) comment '学年',
    up_down int comment '上下学期，0表示上学期，1表示下学期',
    open_time date comment '开学时间',
    cur int default 0 comment'是否是当前学期'
)comment '学期表';

create table course(
	course_id int primary key auto_increment comment '课程id',
    user_id int comment '用户id',
    term_id int comment '学期id',
    course_name varchar(12) comment '课程名',
    start_week int comment '起始周',
    end_week int comment '结束周',
    foreign key (user_id) references info(user_id),
    foreign key (term_id) references term(term_id)
)comment '课程表';

create table course_time(
	course_time_id int primary key auto_increment comment '课程时间id',
    course_id int comment '课程id',
    weekday int comment '星期几上课0-6',
    classroom varchar(12) comment '课室',
    start_lesson varchar(12) comment '起始节',
    end_lesson varchar(12)  comment '终止节',
    foreign key (course_id) references course(course_id)
)comment '课程时间表';

create table item(
	item_id int primary key auto_increment comment '条目id',
    name varchar(20) comment '条目名',
    detail varchar(50) comment '详情',
    end_time date comment '截止时间',
    can_delete int default 1 comment '是否可删除，默认1表示可以，0表示不行',
    is_finish int default 0 comment '是否完成，1表示已完成，默认0表示未完成',
    user_id int comment '用户id',
    foreign key (user_id) references info(user_id)
)comment '条目表';

```
