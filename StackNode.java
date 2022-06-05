package com.example.asitakipprogrami;

import javafx.scene.Parent;

public class StackNode {

    String data;
    StackNode next;

    public StackNode(String data)
    {
        this.data = data;
        this.next = null;
    }

    public StackNode(String data, StackNode next)
    {
        this.data = data;
        this.next = next;
    }

    public StackNode(){}
}
