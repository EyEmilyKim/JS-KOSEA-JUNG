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
<h2>ȸ�� ���� �Է�</h2>
<form action="entryMember.do" method="post" name="fr"
		onSubmit="return check(this)">
<input type="hidden" name="idChecked"/>
�� �� : <input type="text" name="NAME" /><br/>
�� �� : <input type="text" name="ID" id="ID"/>
<input type="button" value="�ߺ� �˻�" 
		onClick="idCheck()"/><br/>
�� �� : <input type="text" name="ADDR"/><br/>
����ó : <input type="text" name="TEL"/><br/>
�� ȣ : <input type="password" name="PWD"/><br/>
��ȣ Ȯ�� : <input type="password" name="CONF"/><br/>
�� �� : ��<input type="radio" name="GENDER" value="M"/>,
	��<input type="radio" name="GENDER" value="F"/><br/>
�̸��� : <input type="text" name="EMAIL" /><br/>
�� �� : <select name="JOB">
	<option>--�����ϼ���--</option><option>�л�</option>
	<option>ȸ���</option><option>��Ÿ</option>
		</select><br/><br/>
<input type="submit" value="ȸ�� ����"/>
<input type="reset" value="�� ��"/>
</form>
</div>
<script type="text/javascript">
function idCheck(){
	if(document.fr.ID.value == ""){
		alert("������ �Է��ϼ���."); return;
	}
	var url="idCheck.do?USER_ID="+document.fr.ID.value;
	window.open(url,"_blank_","width=450,height=250");
}
function check(frm){
	if(frm.NAME.value == ""){
		alert("�̸��� �Է��ϼ���."); return false;
	}
	if(frm.ID.value == ""){
		alert("������ �Է��ϼ���."); return false;
	}
	if(frm.idChecked.value == ""){
		alert("���� �ߺ��˻縦 ���ּ���."); return false;
	}
	if(frm.TEL.value == ""){
		alert("����ó�� �Է��ϼ���."); return false;
	}
	if(frm.PWD.value == ""){
		alert("��ȣ�� �Է��ϼ���."); return false;
	}
	if(frm.PWD.value != frm.CONF.value){
		alert("��ȣ�� ��ġ���� �ʽ��ϴ�."); return false;
	}
	if( ! frm.GENDER[0].checked && 
			! frm.GENDER[1].checked){
		alert("������ �����ϼ���."); return false;
	}
	if(frm.JOB.selectedIndex < 1){
		alert("������ �����ϼ���."); return false;
	}
	if( ! confirm("�����Ͻðڽ��ϱ�?")) return false;
}
</script>
</body>
</html>









