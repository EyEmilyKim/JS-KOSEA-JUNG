<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>study2</title>
</head>
<body>
<%
//자바의 배열(객체)
//1. 데이터가 들어있는 배열 생성
//ex1) 정수가 5개 들어있는 배열 생성
	int[] arr1 = {6,2,7,9,10};
//ex2) 실수가 4개 들어있는 배열 생성
	double[] arr2 = {1.1, 2.2, 3.3, 4.4};
//ex3) 불린이 3개 들어있는 배열 생성
	boolean[] arr3 = {true, true, false};
//ex4) 문자 하나가 4개 들어있는 배열 생성
	char[] arr4 = {'A','B','C','D'};
//ex5) 문자열이 5개 들어있는 배열 생성
	String[] arr5 = {"대한민국","일본","중국","대만","미국"};

//2. 데이터가 없는 배열 생성 (반드시 크기를 지정해야 한다!)
// ->객체 생성 방식을 사용 (new 명령어 사용)
//ex1) 정수가 3개 들어갈 수 있는 배열 생성
	int[] arrr1 = new int[3];
	arrr1[0] = 10;
	arrr1[1] = 20;
	arrr1[2] = 30;
//ex1) 정수가 4개 들어갈 수 있는 배열 생성
	double[] arrr2 = new double[4];
	arrr2[0] = 1.1;
	arrr2[1] = 2.2;
	arrr2[2] = 3.3;	
	arrr2[3] = 4.4;	
//ex3) 불린이 3개 들어갈 수 있는 배열 생성
	boolean[] arrr3 = new boolean[3];
	arrr3[0] = true;
	arrr3[1] = false;
	arrr3[2] = true;
//ex4) 문자 하나가 5개 들어갈 수 있는 배열 생성
	char[] arrr4 = new char[5];
	arrr4[0] = 'A';
	arrr4[1] = 'B';
	arrr4[2] = 'C';
	arrr4[3] = 'D';
	arrr4[4] = 'E';
//ex5) 문자열이 4개 들어갈 수 있는 배열 생성
	String[] arrr5 = new String[4];
	arrr5[0] = "대한민국";
	arrr5[1] = "일본";
	arrr5[2] = "중국";
	arrr5[3] = "대만";
%>
</body>
</html>