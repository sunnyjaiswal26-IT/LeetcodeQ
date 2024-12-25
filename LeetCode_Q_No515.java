import java.util.*;
class LeetCode_Q_No515 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    static int maxval(List<Integer>r){
        int max=r.get(0);
        for(int i=0;i<r.size();i++){
            if(r.get(i)>max)max=r.get(i);
        }
        return max;
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>q=new LinkedList<>();
        List<Integer>r=new ArrayList<>();
        q.add(root);
        q.add(null);
        while(q.size()!=0){
            TreeNode x=q.poll();
            if(x!=null){
                r.add(x.val);
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }else{
                ans.add(maxval(r));
                r=new ArrayList<>();
                if(q.size()==0)return ans;
                else q.add(null);
            }
        }
        return ans;
    }
}