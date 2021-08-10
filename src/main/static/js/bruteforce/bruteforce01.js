/* 백준 15651번 N과 M(3)  */
/* https://www.acmicpc.net/problem/15651 */

function solution(N, M) {
    let answer = '';
    let selected = Array.from({length: M + 1}, () => 0);

    function rec_func(k) {
        if (k === M + 1) {
            for (let i = 1; i <= M; i++) {
                answer += selected[i] + " ";
            }
            answer += '\n';
        } else {
            for (let cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1);                selected[k] = 0;
            }
        }
    }

    rec_func(1);

    return answer;
}

console.log(solution(3, 2))