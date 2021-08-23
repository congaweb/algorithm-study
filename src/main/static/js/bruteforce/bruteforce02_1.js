/* 백준 15649번 N과 M(1)  */

/* https://www.acmicpc.net/problem/15649 */

function solution(N, M) {
    let answer = '';
    let selected = Array.from({length: M + 1}, () => 0);
    let used = [];

    function rec_func(k) {
        if (k === M + 1) {
            for (let i = 1; i <= M; i++) {
                answer += selected[i] + " ";
            }
            answer += "\n";
        } else {
            for (let cand = 1; cand <= N; cand++) {
                if (used[cand] === 1) continue;
                selected[k] = cand;
                used[cand] = 1;
                rec_func(k + 1);
                selected[k] = 0;
                used[cand] = 0;
            }
        }
    }

    rec_func(1);

    return answer;
}

console.log(solution(4, 2))