package com.example.asitakipprogrami;

public class TreeNode <T>{
    T data;
    TreeNode<T> left, right;

    public TreeNode(T data)
    {
        this.data = data;
        left = right = null;
    }
}
