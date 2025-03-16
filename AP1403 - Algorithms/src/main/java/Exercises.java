import java.util.ArrayList;

public class Exercises {

    /*
        there is an array of positive integers as input of function and another integer for the target value
        all the algorithm should do is to find those two integers in array which their multiplication is the target
        then it should return an array of their indices
        e.g. {1, 2, 3, 4} with target of 8 -> {1, 3}

        note: you should return the indices in ascending order and every array's solution is unique
    */
    public static int[] productIndices(int[] values, int target) {
        int len = values.length;
        for(int i = 0; i < len; i++){
            if(target % values[i] == 0){
                for(int j = 0; j < len; j++){
                    if(j == i)
                        continue;
                    if(values[j] * values[i] == target)
                        return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*
        given a matrix of random integers, you should do spiral traversal in it
        e.g. if the matrix is as shown below:
        1 2 3
        4 5 6
        7 8 9
        then the spiral traversal of that is:
        {1, 2, 3, 6, 9, 8, 7, 4, 5}

        so you should walk in that matrix in a curl and then add the numbers in order you've seen them in a 1D array
    */
    public static int[] spiralTraversal(int[][] values, int rows, int cols) {
        int[] result = new int[rows * cols];
        int x = 0, y = 0, index = 0;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        
        while(index < rows * cols){
            if(x == left && y == top){
                while(x <= right)
                    result[index++] = values[y][x++];
                top++; y++; x--;
            }
            else if(x == right && y == top){
                while(y <= bottom)
                    result[index++] = values[y++][x];               
                right--; y--; x--;
            }
            else if(x == right && y == bottom){
                while(x >= left)
                    result[index++] = values[y][x--];
                bottom--; y--; x++;
            }
            else if(x == left && y == bottom){
                while(y >= bottom)
                    result[index++] = values[y][x--];
                left++; y++; x++;
            }
        }
        return result;
    }

    /*
        integer partitioning is a combinatorics problem in discreet maths
        the problem is to generate sum numbers which their summation is the input number

        e.g. 1 -> all partitions of integer 3 are:
        3
        2, 1
        1, 1, 1

        e.g. 2 -> for number 4 goes as:
        4
        3, 1
        2, 2
        2, 1, 1
        1, 1, 1, 1

        note: as you can see in examples, we want to generate distinct summations, which means 1, 2 and 2, 1 are no different
        you should generate all partitions of the input number and

        hint: you can measure the size and order of arrays by finding the pattern of partitions and their number
        trust me, that one's fun and easy :)

        if you're familiar with lists and arraylists, you can also edit method's body to use them instead of array
    */
    public static ArrayList<ArrayList<Integer>> intPartitions(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int last = 0, count = 0;
        temp.add(last, n);
        while(true){
            result.add(temp);
  
            int rem = 0;
            while(last >= 0 && temp.get(last) == 1){
                rem += temp.get(last); 
                last--;
            }
            
            if(last < 0)  
                break;
  
            temp.add(last, temp.get(last) - 1);
            rem++;
  
            while(temp.get(last) < rem){
                temp.add(last + 1, temp.get(last));
                rem = rem - temp.get(last);
                last++;
            }
            
            temp.add(last + 1, rem);
            last++;
        }

        return result;
    }
    

    public static void main(String[] args) {
        // you can test your code here
    }
}
