package com.bareum.algorithm.day1;

import com.bareum.algorithm.example.HelloWorld;

public class HelloMain2 {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld(); // 인스턴스 생성
        String strResult = helloWorld.getString("HelloWorld"); // 멤버함수 호출

        int intResult = HelloWorld.getInt(10);// 전역함수 호출 (인스턴스 생성 필요 없음. 클래스 네임만)
        System.out.println(strResult + " " + intResult);

        // 멤버 변수 접근 - public 멤버 변수는 접근/수정 가능
        helloWorld.publicMemberVar = "Park (changed)";
        strResult = helloWorld.getString("HelloWorld");
        System.out.println(strResult + " " + intResult);

        // 접근 불가
//        helloWorld.privateMemberVar = "xxx";

        HelloWorld.PUBLIC_STATIC_VAR = 1000;
        intResult = HelloWorld.getInt(10);
        System.out.println(strResult + " " + intResult);
    }
}
