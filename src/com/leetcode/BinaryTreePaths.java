package com.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreePaths {

	public static void main(String[] args) {

	}
	
	public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return Arrays.asList();
        List<String> list = new ArrayList<>();
        traverse(root, "", list);
        //System.out.println(list);
        return list;
    }
    
    private void traverse(TreeNode root,String s, List<String> result){
        StringBuilder sb1 = new StringBuilder(s).append(!"".equals(s)?"->"+root.val:""+root.val);
        if(root.left==null && root.right==null){
            result.add(sb1.toString());
            return;
        }
        if(root.left!=null){
            traverse(root.left,sb1.toString(),result);
        }
       if(root.right!=null){
            traverse(root.right,sb1.toString(),result);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        
        traverse(root, new ArrayList<>(), 0, sum, result);
        //System.out.println(list);
        return result;
    }
    
    private void traverse(TreeNode root, List<Integer> sub, int count, int sum, List<List<Integer>> result){
        sub.add(root.val);
        count+=root.val;
        if(root.left==null && root.right==null){
            if(count==sum)result.add(sub);
            return;
        }
        if(root.left!=null){
            List<Integer> temp = new ArrayList<>(sub);
            traverse(root.left, temp, count, sum, result);
        }
        if(root.right!=null){
            List<Integer> temp = new ArrayList<>(sub);
            traverse(root.right, temp, count, sum, result);
        }
    }
    
    private class TreeNode{
    	int val;
    	TreeNode left,right;
    }
    
}
