<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>��ǰ ���� ���</h2>
<form action="putItem.do" method="post" name="itemFrm" 
	onSubmit="return check(this)">
<input type="hidden" name="codeChecked"/>
<table>
<tr><th>��ǰ ��ȣ</th><td><input type="text" name="CODE"
	id="code"/><input type="button" value="�ߺ� �˻�"
	onClick="codeCheck()"/></td></tr>
<tr><th>��ǰ �̸�</th><td><input type="text" name="NAME"/>
	</td></tr>
<tr><th>��ǰ ����</th><td><input type="text" name="PRICE"/>
	</td></tr>
<tr><th>��ǰ ����</th><td><textarea rows="4" cols="50"
	name="INFO"></textarea></td></tr>
<tr><td colspan="2" align="center">
	<input type="submit" value="��ǰ ���"/>
	<input type="reset" value="�� ��"/></td></tr>
</table>
</form>	
</div>
<script type="text/javascript">
function codeCheck(){
	if(document.itemFrm.CODE.value == ''){
		alert("��ǰ��ȣ�� �Է��ϼ���."); return;//�Լ� ����
	}
	var url="codeCheck.do?CODE="+document.itemFrm.CODE.value;
	window.open(url,"_blank_",
			"width=450,height=200,top=150,left=200");
}//void �Լ�
function check(fm){
	if(fm.CODE.value == ''){
		alert("��ǰ ��ȣ�� �Է��ϼ���."); return false;
	}
	if(fm.codeChecked.value == ''){
		alert("��ǰ��ȣ �ߺ��˻縦 ���ּ���."); return false;
	}
	if(fm.NAME.value == ''){
		alert("��ǰ �̸��� �Է��ϼ���."); return false;
	}
	if(fm.PRICE.value == ''){
		alert("������ �Է��ϼ���."); return false;
	}else{
		if(isNaN(fm.PRICE.value)){
			alert("������ ���ڷ� �Է��ϼ���."); return false;
		}
	}
	if(fm.INFO.value == ''){
		alert("��ǰ ������ �Է��ϼ���."); return false;
	}
	if( ! confirm("�Է��� ������ �½��ϱ�?")) return false;
}
</script>
</body>
</html>










