package Graph.DFS;

public class TargetNumber {
    static int ans = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return ans;
    }
    public void dfs(int[] numbers, int depth, int target, int sum) {
        if(depth == numbers.length) {
            if(target == sum) ans++;
        } else {
            //깊이우선탐색은 리프까지 내려가면서 검색하는 것을 우선순위로 하는 탐색방법
            //리프에 도달해 더이상 검색을 진행할 곳이 없는 경우 부모에게 돌아감.
            //Preorder(전위 순회) 형식인듯 노드 방문 -> 왼쪽 자식 방문 -> 오른쪽 자식 방문
            dfs(numbers, depth+1, target, sum + numbers[depth]);
            dfs(numbers, depth+1, target, sum - numbers[depth]);

        }
    }

    public static void main(String[] args) {
        int[] num = {4,1,2,1};
        int target = 4;

        TargetNumber test = new TargetNumber();
        System.out.println(test.solution(num, target));
    }
}
