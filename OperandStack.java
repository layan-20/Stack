/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure.postfix.full;

/**
 *
 * @author layan
 */
public class OperandStack {
    private float []op;
    private int top;

    public OperandStack() {
        op = new float [20];
        top = -1;
    }
    boolean isEmpty(){
        return top == -1;
    }
    boolean isFull(){
        return top == op.length - 1;
    }
    void push(float c){
        if(!isFull()){
            op[++top] = c;
        }
    }
    float pop(){
        if(!isEmpty()){
            return op[top--];
        }
        return 0.0f;
    }
    float peek(){
        if(!isEmpty()){
            return op[top];
        }
        return 0.0f;
    }
    
    
}
