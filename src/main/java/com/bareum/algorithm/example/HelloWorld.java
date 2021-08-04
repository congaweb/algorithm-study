package com.bareum.algorithm.example;

public class HelloWorld {
    public static int PUBLIC_STATIC_VAR = 500;
    private static int PRIVATE_STATIC_VAR = 10000;

    public String publicMemberVar = " Park ";
    private String privateMemberVar = " Bareum ";

    // 전역함수
    public static int getInt(int number) {
        return number + PRIVATE_STATIC_VAR + PUBLIC_STATIC_VAR;
    }

    // 멤버함수
    public String getString(String message) {
        return message + privateMemberVar + publicMemberVar;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld(); // 인스턴스 생성
        String strResult = helloWorld.getString("HelloWorld"); // 멤버함수 호출

        // 문제 풀이 시에, 특정 문제 Class 내에서
        int intResult = getInt(10);// 전역함수 호출 (인스턴스 생성 필요 없음. 클래스 네임만)
        System.out.println(strResult + " " + intResult);

        // 멤버 변수 접근 - public 멤버 변수는 접근/수정 가능
        helloWorld.publicMemberVar = "Park (changed)";
        strResult = helloWorld.getString("HelloWorld");
        System.out.println(strResult + " " + intResult);

        // 접근 불가
//        helloWorld.privateMemberVar = "xxx";

        PUBLIC_STATIC_VAR = 1000;
        intResult = getInt(10);
        System.out.println(strResult + " " + intResult);
    }
}
