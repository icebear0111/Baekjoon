import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] bingo;
	static boolean[][] checked;
	static int count;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;
       
       bingo = new int[5][5];
       checked = new boolean[5][5];
       count = 0;
       
       for (int i = 0; i < 5; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   for (int j = 0; j < 5; j++) {
    		   bingo[i][j] = Integer.parseInt(st.nextToken());
    	   }
       }
       
       int answer = 0;
       for (int i = 0; i < 5; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   for (int j = 0; j < 5; j++) {
    		   int num = Integer.parseInt(st.nextToken());
    		   checkNumber(num);
    		   
    		   if (count > 2) continue;
    		   
    		   count = 0;
    		   checkHorizontal();
        	   checkVertical();
        	   checkLeftDiagonal();
        	   checkRightDiagonal();
        	   
        	   if (count > 2) {
        		   answer = i * 5 + j + 1;
        		   break;
        	   }
    	   }
       }
       
       bw.write(answer + "");
       bw.flush();
    }
    
    static void checkNumber(int num) {
    	for (int i = 0; i < 5; i++) {
    		for (int j = 0; j < 5; j++) {
    			if (bingo[i][j] == num) checked[i][j] = true;
    		}
    	}
    }
    
    static void checkHorizontal() {
    	for (int i = 0; i < 5; i++) {
    		boolean isBingo = true;
    		
    		for (int j = 0; j < 5; j++) {
    			if (checked[i][j] != true) {
    				isBingo = false;
    				break;
    			}
    		}
    		
    		if (isBingo) count++;
    	}
    }
    
    static void checkVertical() {
    	for (int i = 0; i < 5; i++) {
    		boolean isBingo = true;
    		
    		for (int j = 0; j < 5; j++) {
    			if (checked[j][i] != true) {
    				isBingo = false;
    				break;
    			}
    		}
    		if (isBingo) count++;
    	}
    }
    
    static void checkLeftDiagonal() {
    	for (int i = 0; i < 5; i++) {
    		if (checked[i][i] != true) return;
    	}
    	count++;
    }
    
    static void checkRightDiagonal() {
    	for (int i = 0; i < 5; i++) {
    		if (checked[4-i][i] != true) return;
    	}
    	count++;
    }
}