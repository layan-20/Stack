/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.postfix.full;

/**
 *
 * @author layan
 */
public class OperatorStack {
    private char []op;
    private int top;

    public OperatorStack() {
        op = new char [5];
        top = -1;
    }
    boolean isEmpty(){
        return top == -1;
    }
    boolean isFull(){
        return top == op.length - 1;
    }
    void push(char c){
        if(!isFull()){
            op[++top] = c;
        }
    }
    char pop(){
        if(!isEmpty()){
            return op[top--];
        }
        return ' ';
    }
    char peek(){
        if(!isEmpty()){
            return op[top];
        }
        return ' ';
    }
    
}

    

