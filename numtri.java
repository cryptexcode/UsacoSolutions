/*
 ID: cryptex1
 LANG: JAVA
 TASK: numtri
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 *
 * @author macbookair
 */
public class numtri {
    static int[][] arr;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        
        n = Integer.parseInt(f.readLine());
        arr = new int[n][n];
        
        for(int i=0; i<n; i++){
            String s = f.readLine();            
            StringTokenizer st = new StringTokenizer(s);
            
            for(int j=0; j<=i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());                
            }            
        }
        
        for(int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                arr[i-1][j]+= Math.max(arr[i][j], arr[i][j+1]);
            }
        }
        
        out.println(arr[0][0]);
        
        out.close();
        System.exit(0);
    }
}
