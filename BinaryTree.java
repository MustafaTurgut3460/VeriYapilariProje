package com.example.asitakipprogrami;

import java.util.List;

public class BinaryTree <T>{
    TreeNode<T> root;

    public void traverseInOrder(TreeNode<T> node, LinkedList<T> list)
    {
        if(node != null)
        {
            traverseInOrder(node.left, list);
            list.add(node.data);
            traverseInOrder(node.right, list);
        }
    }
}
