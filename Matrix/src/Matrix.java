//The instructions will be shown after running the code
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix{
    public static int[][] addition(int[][] arr1, int[][] arr2){
        int[][] arr3;
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length){
            throw new ArithmeticException("Matrix must have the same size");
        }
        else{
            arr3 = new int[arr1.length][arr1[0].length];
            for (int i = 0; i < arr1.length; i++){
                for (int j = 0; j < arr1[0].length; j++){
                    arr3[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            return arr3;
        }
    }
    public static int[][] subtraction(int[][] arr1, int[][] arr2){
        int[][] arr3;
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length){
            throw new ArithmeticException("Matrix must have the same size");
        }
        else{
            arr3 = new int[arr1.length][arr1[0].length];
            for (int i = 0; i < arr1.length; i++){
                for (int j = 0; j < arr1[0].length; j++){
                    arr3[i][j] = arr1[i][j] - arr2[i][j];
                }
            }
            return arr3;
        }
    }
    public static int[][] multiplication(int[][] arr1, int[][] arr2){
        if (arr1[0].length != arr2.length){
            throw new ArithmeticException("Invalid matrix type");
        }
        int row1 = arr1.length;
        int column2 = arr2[0].length;
        int elements_to_add = arr1[0].length;
        int[][] arr3 = new int[row1][column2];
        for (int i = 0; i < row1;i++){
            for (int j = 0; j < column2;j++){
                for (int k = 0; k < elements_to_add;k++){
                    arr3[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr3;
    }
    public static int[][] chain_multiplication(ArrayList<int[][]> arr){
        int[][] result = arr.get(0);
        for (int i = 1; i < arr.size();i++){
            result = multiplication(result,arr.get(i));
        }
        return result;
    }
    public static void printMatrix(int[][] arr3){
        int count1 = 0;
        int count2 = 0;
        String str = "";
        for (int i = 0; i < arr3.length; i++){
            str += "[";
            for (int j = 0; j < arr3[i].length; j++){
                if(j == arr3[i].length - 1){
                    str += arr3[i][j];
                }
                else{
                    str += arr3[i][j] + ",";
                }
            }
            if (i == arr3.length-1) {
                str += "]";
            }
            else{
                str += "]\n";
            }
        }
        System.out.println(str);
    }
    public static boolean isSymmetric(int[][] arr){
        if(arr.length != arr[0].length){
            return false;
        }
        for(int i = 0; i < arr.length;i++){
            for(int j = 0; j < arr[0].length;j++){
                if(arr[i][j] < arr[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static int[][] buildMatrix(){
        System.out.println("Input array row:");
        Scanner r = new Scanner(System.in);
        int row = r.nextInt();
        System.out.println("Input array column");
        Scanner c = new Scanner(System.in);
        int column = c.nextInt();
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row;i++){
            for (int j = 0; j < column;j++){
                System.out.println("Input element at row " + Integer.toString(i+1) + " and column " + Integer.toString(j+1) + ":");
                Scanner element = new Scanner(System.in);
                matrix[i][j] = element.nextInt();
            }
        }
        return matrix;
    }
    public static void main(String[] args){
        System.out.println("Which operation do you want to use? \n1.Addition \n2.Subtraction \n3.Multiplication \n4.Chain Multiplication");
        Scanner option = new Scanner(System.in);
        int o = option.nextInt();
        if (o == 1){
            System.out.println("Matrix A:\n");
            int[][] a = buildMatrix();
            System.out.println("Matrix B:\n");
            int[][] b = buildMatrix();
            System.out.println("Result:\n");
            printMatrix(addition(a,b));
        }
        if (o == 2){
            System.out.println("Matrix A:\n");
            int[][] a = buildMatrix();
            System.out.println("Matrix B:\n");
            int[][] b = buildMatrix();
            System.out.println("Result:\n");
            printMatrix(subtraction(a,b));
        }
        if (o == 3){
            System.out.println("Matrix A:\n");
            int[][] a = buildMatrix();
            System.out.println("Matrix B:\n");
            int[][] b = buildMatrix();
            System.out.println("Result:\n");
            printMatrix(multiplication(a,b));
        }
        if (o == 4){
            System.out.println("How many matrices are in the chain?");
            Scanner t = new Scanner(System.in);
            int total = t.nextInt();
            ArrayList<int[][]> chain = new ArrayList<>();
            for (int i = 1; i <= total;i++){
                System.out.println("Matrix " + Integer.toString(i) + ":\n");
                chain.add(buildMatrix());
            }
            System.out.println("Result:\n");
            printMatrix(chain_multiplication(chain));
        }
    }
}
