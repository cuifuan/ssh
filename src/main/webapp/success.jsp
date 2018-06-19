<%--
  Created by IntelliJ IDEA.
  User: pony
  Date: 2018-06-09
  Time: 下午 2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>

</head>
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">

<body>
<h1>登陆成功</h1>
<div id="app">
    <template>
    <el-table
            :data="tableData"
            ref="tableData"
            stripe
            style="width: 100%" >
        <el-table-column>
            <template slot-scope="scope">
                <el-popover trigger="hover" placement="top">
                    <p>姓名: {{ scope.row.username }}</p>
                    <div slot="reference" class="name-wrapper">
                        <el-tag size="medium">{{ scope.row.username }}</el-tag>
                    </div>
                </el-popover>
            </template>
        </el-table-column>
        <el-table-column
                prop="username"
                label="姓名"
                width="180">
        </el-table-column>
        <el-table-column
                prop="password"
                label="密码">
        </el-table-column>
    </el-table>
    </template>
</div>

</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<!-- import JavaScript -->
<script>

    new Vue({
        el: '#app',
        data() {
            return {
                tableData: [{
                    id:1
                }]
            }
        },
        created () {
            const lef = this;
            axios.post('user_list.action')
                    .then(function (response) {
                         lef.tableData = response.data.sysuserEntities
                        console.log(lef.tableData)
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
        }
    })
    /*const Main = {
        data(){
            return {
                tableData: []
            }
        },
        created () {
            axios.post('user_list.action')
                .then(function (response) {
                    this.tableData = response.data.sysuserEntities
                    console.log(this.tableData)
                })
                .catch(function (error) {
                    console.log(error);
                });
            }
        }
    const Ctor = Vue.extend(Main);
    new Ctor().$mount('#app')*/
</script>
</html>
