package DynamicProgramming;

/**
 * LeetCode 第174题
 * 地下城游戏
 */
public class DungeonGame {
    /**
     * 倒序思考，逆推！！！
     * 正序思考不知道未来的情况
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] sav = new int[dungeon.length][dungeon[0].length];
        sav[dungeon.length - 1][dungeon[0].length - 1] = Math.max(0,-dungeon[dungeon.length - 1][dungeon[0].length - 1]);
        for (int i = dungeon[0].length - 2; i >= 0; i--) {
            sav[dungeon.length - 1][i] = Math.max(0,sav[dungeon.length - 1][i + 1] - dungeon[dungeon.length - 1][i]);
        }
        for(int i=dungeon.length-2;i>=0;i--){
            sav[i][dungeon[0].length - 1] = Math.max(0,sav[i + 1][dungeon[0].length - 1] - dungeon[i][dungeon[0].length - 1]);
        }
        for (int i = dungeon.length - 2; i >= 0; i--) {
            for (int j = dungeon[0].length - 2; j >= 0; j--) {
                int tmp=Math.min(sav[i+1][j],sav[i][j+1])-dungeon[i][j];
                sav[i][j]=Math.max(0,tmp);
            }
        }

        return sav[0][0]+1;
    }

    public static void main(String[] args) {
        DungeonGame dungeonGame = new DungeonGame();
        System.out.println(dungeonGame.calculateMinimumHP(new int[][]{{100}}));
    }
}
