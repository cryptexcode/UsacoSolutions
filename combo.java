
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
ID: cryptex1
LANG: JAVA
TASK: combo
*/

public class combo {
    static class Lock{
        int a,b,c;
        
        public Lock(int A, int B, int C){
            this.a = A;
            this.b = B;
            this.c = C;
        }
        
        void print(){
            System.out.println(this.a+" "+this.b+" "+this.c);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        Lock farmer = new Lock(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
                Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(f.readLine());
        Lock master = new Lock(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
                Integer.parseInt(st.nextToken()));
        
        int distance1 = Math.min(Math.abs(master.a-farmer.a), N-Math.max(master.a, farmer.a)+Math.min(farmer.a, master.a)) - 1;
        int distance2 = Math.min(Math.abs(master.b-farmer.b), N-Math.max(master.b, farmer.b)+Math.min(farmer.b, master.b)) - 1;
        int distance3 = Math.min(Math.abs(master.c-farmer.c), N-Math.max(master.c, farmer.c)+Math.min(farmer.c, master.c)) -1;
        
        
        int span1 = Math.min(Math.min(distance1, 4) + Math.min(N, 6), N);
        int span2 = Math.min(Math.min(distance2, 4) + Math.min(N, 6), N);
        int span3 = Math.min(Math.min(distance3, 4) + Math.min(N, 6), N);
               
        int dis = (Math.min(span1, 5)*Math.min(span2, 5)*Math.min(span3, 5));
        int dis2 = Math.min(span1,5)-(Math.max(Math.min(span1-5,5), 0));
        dis2 *= Math.min(span2,5)-(Math.max(Math.min(span2-5,5), 0));
        dis2 *= Math.min(span3,5)-(Math.max(Math.min(span3-5,5), 0));
        dis = dis + (dis-dis2);
                
        out.println(Math.max(dis, 1));
        
        out.close();
        System.exit(0); 
    }
}
