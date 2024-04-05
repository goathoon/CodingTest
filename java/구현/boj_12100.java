package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class boj_12100 {
    public class Main {
        static int ans = 0;
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] grid = new int[N][N];
            int[][] next = new int[N][N];
            for(int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int c = 0; c < N; c++) {
                    grid[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,grid,next);
            System.out.println(ans);

        }

        public static void dfs(int cnt, int[][] grid, int[][] next) {
            if(cnt == 5) {
                for(int r =0; r< grid.length; r++) {
                    for(int c = 0; c< grid[0].length; c++) {
                        ans = Math.max(ans, grid[r][c]);
                    }
                }
                return;
            }
            // 위로 이동
            // 먼저 합치기
            for(int c = 0; c < grid[0].length; c ++ ) {
                boolean isTop = false;
                int top = -1;
                int topR = -1;
                for(int r = 0; r < grid.length; r++) {
                    if(!isTop && grid[r][c] != 0) {
                        isTop = true;
                        top = grid[r][c];
                        topR = r;
                        next[r][c] = top;
                        continue;
                    }

                    if(isTop && grid[r][c] != 0) {
                        if(top == grid[r][c]) {
                            next[topR][c] = 2*top;
                            next[r][c] = 0;
                            isTop = false;
                        }else {
                            top = grid[r][c];
                            topR = r;
                            next[r][c] = top;
                        }

                    }
                }
                // 합친 숫자들 위로 올리기
                topR = 0;
                for(int r = 0; r < grid.length; r++) {
                    if(next[r][c] != 0) {
                        if(topR != r) {
                            next[topR][c] = next[r][c];
                            next[r][c] = 0;
                        }
                        topR++;
                    }
                }
            }

            dfs(cnt+1,next,new int[grid.length][grid.length]);
            initGrid(next);

            // 오른쪽 이동
            for(int r = 0; r < grid.length; r ++ ) {
                boolean isRight = false;
                int right = -1;
                int rightC = -1;
                for(int c = grid[0].length-1; c >= 0; c--) {
                    if(!isRight && grid[r][c] != 0) {
                        isRight = true;
                        right = grid[r][c];
                        rightC = c;
                        next[r][c] = right;
                        continue;
                    }

                    if(isRight && grid[r][c] != 0) {
                        if(right == grid[r][c]) {
                            next[r][rightC] = 2*right;
                            next[r][c] = 0;
                            isRight = false;
                        }else {
                            right = grid[r][c];
                            rightC = c;
                            next[r][c] = right;
                        }

                    }
                }
                // 합친 숫자들 위로 올리기
                rightC = grid[0].length-1;
                for(int c = grid[0].length-1; c >= 0; c--) {
                    if(next[r][c] != 0) {
                        if(rightC != c) {
                            next[r][rightC] = next[r][c];
                            next[r][c] = 0;
                        }
                        rightC--;
                    }
                }
            }

            dfs(cnt+1,next,new int[grid.length][grid.length]);
            initGrid(next);

            // 아래 이동
            for(int c = 0; c < grid[0].length; c ++ ) {
                boolean isDown = false;
                int bottom = -1;
                int bottomR = -1;
                for(int r = grid.length-1; r >= 0; r--) {
                    if(!isDown && grid[r][c] != 0) {
                        isDown = true;
                        bottom = grid[r][c];
                        bottomR = r;
                        next[r][c] = bottom;
                        continue;
                    }

                    if(isDown && grid[r][c] != 0) {
                        if(bottom == grid[r][c]) {
                            next[bottomR][c] = 2*bottom;
                            next[r][c] = 0;
                            isDown = false;
                        }else {
                            bottom = grid[r][c];
                            bottomR = r;
                            next[r][c] = bottom;
                        }

                    }
                }
                // 합친 숫자들 위로 올리기
                bottomR = grid.length-1;
                for(int r = grid.length-1; r >= 0; r--) {
                    if(next[r][c] != 0) {
                        if(bottomR != r) {
                            next[bottomR][c] = next[r][c];
                            next[r][c] = 0;
                        }
                        bottomR--;
                    }
                }
            }

            dfs(cnt+1,next,new int[grid.length][grid.length]);
            initGrid(next);

            // 왼쪽 이동
            for(int r = 0; r < grid.length; r ++ ) {
                boolean isLeft = false;
                int left = -1;
                int leftC = -1;
                for(int c = 0; c < grid[0].length; c++) {
                    if(!isLeft && grid[r][c] != 0) {
                        isLeft = true;
                        left = grid[r][c];
                        leftC = c;
                        next[r][c] = left;
                        continue;
                    }

                    if(isLeft && grid[r][c] != 0) {
                        if(left == grid[r][c]) {
                            next[r][leftC] = 2*left;
                            next[r][c] = 0;
                            isLeft = false;
                        }else {
                            left = grid[r][c];
                            leftC = c;
                            next[r][c] = left;
                        }

                    }
                }

                leftC = 0;
                for(int c = 0; c < grid[0].length; c++) {
                    if(next[r][c] != 0) {
                        if(leftC != c) {
                            next[r][leftC] = next[r][c];
                            next[r][c] = 0;
                        }
                        leftC++;
                    }
                }
            }
            dfs(cnt+1,next,new int[grid.length][grid.length]);
            initGrid(next);


        }

        public static void initGrid(int[][] grid) {
            for(int r = 0; r < grid.length; r++) {
                for(int c = 0; c < grid[0].length; c++) {
                    grid[r][c] = 0;
                }
            }
        }
    }

}
