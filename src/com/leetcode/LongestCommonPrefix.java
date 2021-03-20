package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class LongestCommonPrefix {

private TrieNode root = new TrieNode();
    
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        sb.append("");
        if(strs==null || strs.length==0){
            return sb.toString();
        }
        int minLength=Integer.MAX_VALUE;
        for(String b:strs){
            minLength=Math.min(minLength,b.length());
        }
        
        for(String word:strs){
            insert(word);
        }
        find(root,minLength,sb);
        return sb.toString(); 
    }
    
    
    public void find(TrieNode root,int minLength, StringBuilder sb){
        TrieNode current = root;
        if(sb.length()>=minLength || current.map.isEmpty() || current.map.size()>1)
            return;
        for(char key:current.map.keySet()){
            current = current.map.get(key);
              sb.append(key+"");
              find(current,minLength,sb);
        }
    }
    
    public void insert(String word){
        TrieNode current = root;
        for(char c:word.toCharArray()){
            if(!current.map.containsKey(c)){
                current.map.put(c,new TrieNode());
            }
            current = current.map.get(c);
        }
        current.isEndOfWord = true;
    }
    
    private class TrieNode{
		Map<Character, TrieNode> map = new HashMap<>();
        boolean isEndOfWord = false;
    }
    

}
