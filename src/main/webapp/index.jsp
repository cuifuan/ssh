<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: pony
  Date: 2018-06-09
  Time: 下午 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<style>
    .from {
        width: 500px;
        margin: 200px auto;
        text-align: center;
    }

    .el-form-item__label {
        color: aliceblue;
    }

    /*.el-input__inner{
        background-color:transparent!important;
        color: aliceblue!important;
        border: none;
        border-bottom: 1px solid black;
    }*/
    body {
        padding: 0;
        background: url("static/images/bck.png") no-repeat;
        background-size: cover;
        width: 99%;
    }

    h1,h2,h3,h4,h5 {
        color: aliceblue;
    }
</style>
<body>
<div id="app">
    <el-form name="login" class="from" ref="form" :model="form" label-width="120px"
    action="user_login.action" method="post">
        <h4>ssh框架demo演示(用户名：admin  密码：123456)</h4>
        <h5><a href="https://github.com/cuifuan/ssh" target="_blank" style="color: white">GitHub地址</a></h5>
        <el-form-item label="用户名">
            <el-input v-model="form.username" name="user.username" style="width:200px" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input type="password" v-model="form.password" name="user.password" style="width:200px" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit('form')">登陆</el-button>
            <%--<el-button type="primary" native-type="submit">单点登陆</el-button>--%>
            <el-button type="info" native-type="reset">重置</el-button>
        </el-form-item>
    </el-form>
</div>
</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    const Main = {
        data() {
            return {
                form: {
                    username: '',
                    password: ''
                },
                user:{
                    username: '',
                    password: ''
                }
            }
        },
        methods: {
            onSubmit(form) {
                if (this.form.username.trim() !== '' && this.form.password.trim() !== '') {
                    axios({
                        url: 'user_login.action',
                        method: 'post',
                        data: {
                                'user.username':this.form.username,
                                'user.password':this.form.password
                        },//转换成FromData提交
                        transformRequest: [function (data) {
                            let ret = ''
                            for (let it in data) {
                                ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
                            }
                            return ret
                        }],
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        }
                    }).then((res) => {   //成功的回调
                        console.log(res.data.result)
                        if(res.data.result==1||res.data.result=='1'){
                            this.$message({
                                message: '登陆成功',
                                type: 'success'
                            });
                            window.location.href="success.jsp";
                        }else {
                            this.$message({
                                message: '用户名密码错误',
                                type: 'error'
                            });
                        }
                    })
                        .catch((res) => {  //失败的回调
                            console.log(res)
                        });
                } else {
                    this.$message({
                        message: '用户名密码不能为空',
                        type: 'error'
                    });
                }
            }
        }
    };
    const Ctor = Vue.extend(Main);
    new Ctor().$mount('#app')
</script>
</html>