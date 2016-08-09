<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<html>
<head>
    <title>用户管理</title>
    <%@include file="/common/header.jsp" %>
    <script type="text/javascript">
    jQuery(document).ready(function(){
    	
    	//导出excel
      	jQuery("#ExportExcel_button").click(function() {
      		//alert("#ExportExcel_button");
      		 document.forms[0].action = "${basePath}/nsfw/user_exportExcel.action";
      		document.forms[0].submit(); 
      	});
      //导入excel
      	jQuery("#ImportExcel_button").click(function() {
      		//alert("#ExportExcel_button");
      		 document.forms[0].action = "${basePath}/nsfw/user_importExcel.action";
      		document.forms[0].submit(); 
      	});
      	//全选、全反选selAll
      	jQuery("#selAll").click(function() {
      	
      		$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
      	});
		/* function doSelectAll(){
			// jquery 1.6 前
			//$("input[name=selectedRow]").attr("checked", $("#selAll").is(":checked"));
			//prop jquery 1.6+建议使用
			$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
		} */
      	//新增Add_button
      	jQuery("#Add_button").click(function() {
      	
      		document.forms[0].action = "${basePath}/nsfw/user_addUI.action";
      		document.forms[0].submit();
      	});
      	/* function doAdd(){
      		document.forms[0].action = "${basePath}/nsfw/user_addUI.action";
      		document.forms[0].submit();
      	} */
      	//编辑
      	jQuery(".update").click(function() {
      	
      		var id = jQuery(this).attr("id");
      		 document.forms[0].action = "${basePath}/nsfw/user_editUI.action?user.id=" + id;
      		document.forms[0].submit(); 
      		//alert(id);
      	});
      	/* function doEdit(id){
      		document.forms[0].action = "${basePath}nsfw/user_editUI.action?user.id=" + id;
      		document.forms[0].submit();
      	} */
      	//删除
      	jQuery(".delete").click(function() {
      	
      		var id = jQuery(this).attr("id");
      		 document.forms[0].action = "${basePath}/nsfw/user_delete.action?user.id=" + id;
      		document.forms[0].submit(); 
      		//alert(id);
      	});
      	/* function doDelete(id){
      		document.forms[0].action = "${basePath}nsfw/user_delete.action?user.id=" + id;
      		document.forms[0].submit();
      	} */
      	
      	//批量删除DeleteAll_button
      	jQuery("#DeleteAll_button").click(function() {
      		alert(1);
      		var count = 0;// 勾选总数
      		var items = new Array();// 用于保存勾选的标签ID

      		var id = jQuery(this).attr("id");
      		/* document.forms[0].action = "${basePath}nsfw/user_delete.action?user.id=" + id;
      		document.forms[0].submit(); */
      		alert(id);
      		$('input[type=checkbox]').each(function(){
      	        var self=$(this);
      	        if(self.prop('checked')){
      	        	count += 1;
      				items.push(jQuery(this).attr("value"));
      	        }
      	    });
      		/* 	if ($("input[type='checkbox']").is(':checked')) {
      				count += 1;
      				items.push(jQuery(this).val());
      			} */
      		alert(items);
      	});
      /* 	function doDeleteAll(){
      		document.forms[0].action = "${basePath}nsfw/user_deleteSelected.action";
      		document.forms[0].submit();
      	} */
      	function selectAllType() {
      		if (jQuery("#allTypeCheckbox").attr("checked") == "checked") {// 全选
      			jQuery("input[id=typeCheckbox]").each(function() {
      				jQuery(this).attr("checked", "checked");
      			})
      		} else {// 反选
      			jQuery("input[id=typeCheckbox]").each(function() {
      				jQuery(this).removeAttr("checked");
      			})
      		}
      	}

    });
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>用户管理</strong></div> </div>
                <div class="search_art">
                    <li>
                        用户名：<input name="user.name" cssClass="s_text" id="userName"  cssStyle="width:160px;"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" id="Add_button" class="s_button" />&nbsp;
                        <input type="button" value="删除" id="DeleteAll_button" class="s_button"/>&nbsp;
                        <input type="button" value="导出" id="ExportExcel_button" class="s_button" />&nbsp;
                    	<input name="userExcel" type="file"/>
                        <input type="button" value="导入" id="ImportExcel_button" class="s_button" onclick="doImportExcel()"/>&nbsp;

                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onchange="selectAllType();" /></td>
                            <td width="140" align="center">用户名</td>
                            <td width="140" align="center">帐号</td>
                            <td width="160" align="center">所属部门</td>
                            <td width="80" align="center">性别</td>
                            <td align="center">电子邮箱</td>
                            <td width="100" align="center">操作</td>
                    
                        </tr>
                
                        <c:forEach items="${userList}" var="user">								
							 <tr >
                                <td align="center">
                                <input type="checkbox" name="selectedRow" id="selectedRow" value="${user.id}" /></td>
                                <td align="center">${user.name}</td>
                                <td align="center">${user.account}</td>
                                <td align="center">${user.dept}</td>
                                <td align="center"><c:if test="${user.gender!=true}">女</c:if>
                                <c:if test="${user.gender==true}">男</c:if>
                                <td align="center">${user.email}</td>
                                <td align="center">
                                    <a href="javascript:void(0);" class="update" 
	                       						id="${user.id}" >编辑</a>
                                    <a href="javascript:void(0);" class="delete" 
	                       						id="${user.id}">删除</a>
                                </td>
                            </tr>															
						</c:forEach>                
                    </table>
                </div>
            </div>
        <div class="c_pate" style="margin-top: 5px;">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right">
                 	总共1条记录，当前第 1 页，共 1 页 &nbsp;&nbsp;
                            <a href="#">上一页</a>&nbsp;&nbsp;<a href="#">下一页</a>
					到&nbsp;<input type="text" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="" value="1" /> &nbsp;&nbsp;
			    </td>
			</tr>
		</table>	
        </div>
        </div>
    </div>
</form>
</body>
</html>