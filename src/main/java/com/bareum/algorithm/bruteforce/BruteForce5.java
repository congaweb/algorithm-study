package com.bareum.algorithm.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/* 백준 14888번 연산자 끼워넣기  */
/* https://www.acmicpc.net/problem/14888 */

public class BruteForce5 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5]; // 총 4가지 연산자가 있기때문에 길이 5짜리 배열이 필요함.
        order = new int[N + 1]; // +, -, *, /
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min; // 숫자의 갯수, 정답을 기록할 max, min
    static int[] nums, operators, order; // 숫자를 들고있을 nums, 각 operator가 몇개 있을지를 들고있을 배열, 어떤 순서로 operator를 나열했는지 들고있는 order

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2) {
            // value order[i] nums[i+1]
            if (operator == 1) // +
                return operand1 + operand2;
            else if (operator == 2) // -
                return operand1 - operand2;
            else if (operator == 3) // *
                return operand1 * operand2;
            else  // /
                return operand1 / operand2;
    }

    // order[1...N-1]에 연산자들이 순서대로 저장
    static void rec_func(int k, int value) {
        if (k == N) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // k번째 연산자는 무엇을 선택할 것인가?
            // cand는 연산자 후보
            for (int cand = 1; cand <=4; cand++ ) {
                if(operators[cand] >= 1){
                    operators[cand]--;
                    rec_func(k+1, calculator(value, cand, nums[k+1]));
                    operators[cand]++;
                }
            }

        }
    }

    public static void main(String[] args) {
        input();
        // 1번째 원소부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 탐색
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
