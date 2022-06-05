package com.example.asitakipprogrami;

public class GenericStack {

    static StackNode top;
    static int size;
    static int count;

    public GenericStack(int size)
    {
        top = null;
        GenericStack.size = size;
        count=0;
    }
    static void push(String data)
    {
        StackNode temp = new StackNode(data);
        if(isFull()){
            // stack dolu
            System.out.println("Stack full");
        }
        else{
            if(top == null){
                // stack bos ilk eleman eklendi
                top = temp;
            }
            else
            {
                // stack e eleman eklendi
                temp.next=top;
                top=temp;
            }
            count++;

        }



    }
    static StackNode pop(){

        StackNode node = null;
        if(isEmpty()){
            // stack boş
            System.out.println("Stack is empty nothing to delete ");
        }else{
            // stack ten eleman cikarma
            node = top;
            top=top.next;
            count--;

        }

        return node;
    }
    static boolean isFull()
    {
        return count>size;
    }
    static boolean isEmpty()
    {
        return count==0;
    }
}
