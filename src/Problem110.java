import LinkedList.TreeNode;
public class Problem110 {
    class SubResult {
        Integer deep;
        Boolean isBalanced;
        public SubResult(Integer deep,Boolean isBalanced){
            this.deep = deep;
            this.isBalanced = isBalanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }

    public SubResult dfs(TreeNode root){
        if (null==root){
            return new SubResult(0,true);
        }
        SubResult left =dfs(root.left);
        SubResult right = dfs(root.right);

        return new SubResult(Math.max(left.deep,right.deep)+1,left.isBalanced&&right.isBalanced&&((left.deep-right.deep)>=-1)&&((left.deep-right.deep)<=1));
    }

}
