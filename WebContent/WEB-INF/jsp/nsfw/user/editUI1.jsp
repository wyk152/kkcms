<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>用户管理</title>
    <script type="text/javascript" src="${basePath }/js/datepicker/WdatePicker.js"></script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }/nsfw/user_save.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>用户管理</strong>&nbsp;-&nbsp;编辑用户</div></div>
    <div class="tableH2">编辑用户</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">所属部门：</td>
            <td>
            	<select name="user.dept">
           		 <option value="部门A">部门A</option>
           		  <option value="部门A1">部门A1</option>
           		   <option value="部门A2">部门A2</option>
           		    <option value="部门A3">部门A3</option>
            	</select>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">头像：</td>
            <td>
                
                    <img src="${basePath}/upload/${user.headImg}" width="100" height="100"/>
                
                <input type="file" name="headImg"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">用户名：</td>
            <td><input type="text" name="user.name" value="${user.name}"/> </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">帐号：</td>
            <td><input type="text" name="user.account" value="${user.account}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">密码：</td>
            <td><input type="text" name="user.password" value="${user.account}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td>
	           <c:if test="${user.gender}">
	           		男<input type="radio" name="user.gender" checked="checked" value="true"/>
	       			女<input type="radio" name="user.gender"  value="false"/></c:if> 
	            <c:if test="${!user.gender}">
				            男<input type="radio" name="user.gender" value="true"/>
				            女<input type="radio" name="user.gender" checked="checked" value="false"/></c:if>          
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">角色：</td>
            <td></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">电子邮箱：</td>
            <td><input type="text" name="user.email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">手机号：</td>
            <td><input type="text" name="user.mobile" value="${user.mobile}"/></td>
        </tr>        
        <tr>
            <td class="tdBg" width="200px">生日：</td>       
            <td><input type="text" id="birthday" name="user.birthday" value="${user.birthday}" readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});" /></td>
        </tr>
		<tr>
            <td class="tdBg" width="200px">状态：</td>
             <c:if test="${user.state=='1'}">有效<input type="radio" 
	            name="user.state" checked="checked" value="1"/></c:if> 
	            <c:if test="${user.state=='0'}">无效<input type="radio" 
	            name="user.state" checked="checked" value="0"/></c:if>                   
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td><input type="text" name="user.memo" value="${user.memo}"/></td>
        </tr>
    </table>
    <input type="hidden" name="user.id" value="${user.id}"/>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>