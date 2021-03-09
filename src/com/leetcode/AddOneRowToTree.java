package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class AddOneRowToTree {

	public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null)
          return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        if(level == d){
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            root = temp;
            return root;
        }
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0; i < len; i++){
                TreeNode temp = q.poll();
                if(level+1 == d){
                    TreeNode left = temp.left;
                    TreeNode right = temp.right;
                    temp.left = new TreeNode(v);
                    temp.right = new TreeNode(v);
                    temp.left.left = left;
                    temp.right.right = right; 
                } 
                if(temp.left!=null)
                   q.offer(temp.left);
                if(temp.right!=null)
                   q.offer(temp.right);
            }
            level++;
        }
        
        return root;
    }
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

	}
	
}
