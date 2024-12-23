import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LeetCode_Q_No2471 {
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
    public static int help(List<Integer> r){
        int w=0;

        int arr[]=new int[r.size()];
        for(int i=0;i<r.size();i++){
            arr[i]=r.get(i);
        }
        for(int i=0;i<arr.length-1;i++){
            int min =arr[i];
            int mind=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min = arr[j];
                    mind=j;
                }
            }
            if(arr[mind]<arr[i]){
                w++;
                int t=arr[i];
                arr[i]=arr[mind];
                arr[mind]=t;
            }
        }
        return w;
    }
    public int minimumOperations(TreeNode root) {
        if(root==null)return 0;
        int ans=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer>r=new ArrayList<>();
        while(q.size()!=0){
            TreeNode x=q.poll();
            if(x!=null){

                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
                r.add(x.val);
            }else{
                ans +=help(r);
                System.out.println(r);
                r=new ArrayList<>();
                if(q.size()==0)return ans;
                else q.add(null);
            }
        }
        return ans;

    }
}