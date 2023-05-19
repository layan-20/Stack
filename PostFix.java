/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datastructure.postfix.full;

/**
 *
 * @author layan
 */
public class PostFix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String infix = "3+2*2-9/3+4"; // 322*+93/-4+
//        String infix = "4*(3+2)/5-2*4/2"; // 432+*5/24*2/-
        PostFix p = new PostFix();
        String post = p.toPostfix(infix);
        float res= p.solve(post);
        
        System.out.println("Equation: "+infix);
        System.out.println("Postfix: "+post);
        System.out.println("result : "+res);
    }

    String toPostfix(String infix) {
        OperatorStack op = new OperatorStack();
        String post = "";
        int i;
        for(i = 0; i<infix.length(); i++){
            char c = infix.charAt(i);
            switch(getType(c)){
                case 1:
                    post+=c;
                    break;
                case 2:
                    while(!op.isEmpty() && pr(c) <= pr(op.peek())){
                        post+=op.pop();
                    }
                    op.push(c);
                    break;
                case 3:
                    op.push(c);
                    break;
                case 4:
                    char t = op.pop();
                    while(!op.isEmpty() && t != '('){
                        post+=t;
                        t = op.pop();
                    }
                    if(t != '('){
                        System.out.println("Equation error !!!");
                    }
                    break;
            }
        }
        while(!op.isEmpty()){
            post+=op.pop();
        }
        return post;
    }
    
    int getType(char c){
        if(c >='0' && c<= '9'){
            return 1;
        }
        else if(c == '+' || c == '-' || c == '*' || c == '/')
        {
            return 2;
        }
        else if(c == '('){
            return 3;
        }
        else if(c == ')'){
            return 4;
        }
        return 0;
    }
    int pr(char c){
        if(c=='+' || c=='-'){
            return 2;
        }
        if(c=='*' || c=='/'){
            return 3;
        }
        if(c == '('){
            return 1;
        }
        return 0;
        
    }

    private float solve(String post) {
        float res;
        OperandStack operand = new OperandStack();
        int i;
        for(i=0 ; i<post.length() ; i++){
            char c = post.charAt(i);
            switch(getType(c)){
                case 1:
                    operand.push(c - '0');
                    break;
                case 2:
                    float a,b, r;
                    if(!operand.isEmpty()){
                        b = operand.pop();
                        if(!operand.isEmpty()){
                            a = operand.pop();
                            operand.push(perform(a, b, c));
                        }
                        else{
                            System.out.println("Equation error !!!");
                            return -1.0f;
                        }                       
                    }
                    else{
                        System.out.println("Equation error !!!");
                        return -1.0f;
                    }
                    break;
            }
        }
        if(operand.isEmpty()){
            System.out.println("Equation error !!!");
            return -1.0f;
        }
        else{
            res = operand.pop();
        }
        if(!operand.isEmpty()){
            System.out.println("Equation error !!!");
            return -1.0f;
        }
        return res;
    }

    private float perform(float a, float b, char c) {
        float r = 0.0f;
        switch(c){
            case '+':
                r = a + b;
                break;
            case '-':
                r = a - b;
                break;
            case '*':
                r = a * b;
                break;
            case '/':
                r = a / b;
                break;
        }
        return r;
    }
}
