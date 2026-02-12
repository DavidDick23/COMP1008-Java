package wk6;

public class Calculator {

    int add(){
        return 1 + 1;
    }
    int add(int num1, int num2){
        return num1 + num2;
    }
//    int add(int num2, int num1){return 1;}
    double add(double num1, double num2){
        return num1 + num2;
    }

    private int v1 = 1, v2 = 2;

    public String toString(){
        return "This a calculator object with values " + v1 + " and " + v2 + ".";
    }
}
