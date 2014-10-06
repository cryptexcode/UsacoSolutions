
/*
ID: cryptex1
LANG: JAVA
TASK: skidesign
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;



/**
 *
 * @author macbookair
 */
public class skidesign {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        
        int N = Integer.parseInt( f.readLine() );
        int[] arr = new int[N];
        int[] tmp;
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt( f.readLine() );
        
        Arrays.sort(arr);
        tmp = Arrays.copyOf(arr, N);
        
        int lowerCounter = 0;
        int upperCounter = N-1;
        int cost = 9999999;
        int tmpCost, dif;        
        
        for(int i = 17 ;i <= 117; i++){
            dif= i - 17;
            tmpCost = 0;
            
            for(int j=0;j<N;j++){
                if(arr[j] < dif){
                    tmpCost += (dif - arr[j]) * (dif - arr[j]);
                } else if (arr[j] > i) {
                    tmpCost += (arr[j] - i) * (arr[j] - i);
                }
            }
            //System.out.println(tmpCost);
            cost = Math.min(cost, tmpCost);
        }
        
        
        //for(int i=0; i<N; i++) System.out.print(arr[i]+" ");
        out.println(cost);
        //for(int i=0; i<N; i++) System.out.print(tmp[i]+" ");
     
        out.close();
        System.exit(0); 
    }
}
