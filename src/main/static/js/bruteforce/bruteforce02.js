/* 백준 15649번 N과 M(1)  */
/* https://www.acmicpc.net/problem/15649 */

function solution(N, M) {
    let answer = '';
    let selected = Array.from({length: M + 1}, () => 0);

    function rec_fuc(k) {
        if (k === M + 1) {
            for (let i = 1; i <= M; i++) {
                answer += selected[i] + " ";
            }
            answer += "\n";
        } else {
            for (let cand = 1; cand <= M; cand++) {
                let isUsed = false;
                for (let i = 1; i <= k; i++) {
                    if (cand === selected[i]) isUsed = true;
                }
                if (!isUsed) {
                    selected[k] = cand;
                    rec_fuc(k + 1);
                    selected[k] = 0;
                }
            }
        }
    }

    rec_fuc(1);
    return answer;
}

console.log(solution(3, 3))