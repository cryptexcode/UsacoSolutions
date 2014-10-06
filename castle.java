
/*
ID: cryptex1
LANG: JAVA
TASK: castle
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author macbookair
 */
public class castle {
    static int w,h;
    static int[][] map;
    static boolean visitList[][];
    static int counter = 0;
    static int[][] compList;
    
    static class Position{
        int x;
        int y;

        public Position(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
    
    static void exploreNode(List<Position> list, Position p, Queue q){
        int x = p.x;
        int y = p.y;
        visitList[x][y] = true;
        compList[x][y] = counter;
        //if(x == 6 && y==6)System.out.println(counter+" >>> "+ map[x][y]);
        if(map[x][y] == 0){ //left
            q.add(new Position(x, y+1));
            q.add(new Position(x-1, y));
            q.add(new Position(x+1, y));
            q.add(new Position(x, y-1));
        }else if(map[x][y] == 1){ //left
            q.add(new Position(x, y+1));
            q.add(new Position(x-1, y));
            q.add(new Position(x+1, y));
        }else if(map[x][y] == 2){ //up
            q.add(new Position(x, y+1));
            q.add(new Position(x, y-1));
            q.add(new Position(x+1, y));
        }else if(map[x][y] == 4){ // right 
            q.add(new Position(x, y-1));
            q.add(new Position(x-1, y));
            q.add(new Position(x+1, y));
        }else if(map[x][y] == 8){ // down _
            q.add(new Position(x, y+1));
            q.add(new Position(x, y-1));
            q.add(new Position(x-1, y));
        }else if(map[x][y] == 3){ // leftTop |-
            q.add(new Position(x, y+1));            
            q.add(new Position(x+1, y));
        }else if(map[x][y] == 5){ // leftRight ||
            q.add(new Position(x+1, y));
            q.add(new Position(x-1, y));            
        }else if(map[x][y] == 9){// LeftDown |_
            q.add(new Position(x-1, y));
            q.add(new Position(x, y+1));
        }else if(map[x][y] == 6){ // RightUp -|            
            q.add(new Position(x, y-1));
            q.add(new Position(x+1, y));
        }else if(map[x][y] == 10){  // upDown =
            q.add(new Position(x, y+1));
            q.add(new Position(x, y-1));
        }else if(map[x][y] == 12){ // rightDown _|
            q.add(new Position(x, y-1));
            q.add(new Position(x-1, y));
        }else if(map[x][y] == 7){ // down open (1+2+4)
            q.add(new Position(x+1, y));
        }else if(map[x][y] == 11){ // right open (2+1+8)
            q.add(new Position(x, y+1));
        }else if(map[x][y] == 13){ // up open (1+4+8)
            q.add(new Position(x-1, y));
        }else if(map[x][y] == 14){ // left open (2+4+8)
            q.add(new Position(x, y-1));
        }else if(map[x][y] == 15){            
        }        
    }
    
    public static void main(String[] args) throws IOException{        
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        
        StringTokenizer st = new StringTokenizer(f.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());        
        map = new int[h][w];
        visitList = new boolean[h][w];
        compList = new int[h][w];
        
        for(int i=0; i<h; i++){            
            String[] s = f.readLine().split(" ");
            for(int j=0; j<s.length; j++){
                map[i][j] = Integer.parseInt(s[j]);
                visitList[i][j] = false;
            }
        }
        
        List<List<Position>> comps = new ArrayList();
        int max = -1;
        
        for(int i=0; i<h; i++){            
            for(int j=0; j<w; j++){
                if(!visitList[i][j]){
                    List<Position> list = new ArrayList();                    
                    Queue queue = new LinkedList();
                    queue.add(new Position(i, j));
                    while( !queue.isEmpty() ){
                        Position p = (Position)queue.poll();
                        if( !visitList[p.x][p.y]){
                            list.add(p);
                            exploreNode(list, list.get(list.size()-1), queue);                            
                        }
                    }
                    //System.out.println(counter+" "+list.size());
                    if(list.size() > max) max = list.size();
                    comps.add(list);
                    counter++;
                }
            }
        }
//        System.out.println(counter+"\n"+max);
        
//        for(int i=0; i<h; i++){            
//            for(int j=0; j<w; j++){
//                System.out.print( String.format("%3s", compList[i][j])+" ");
//            }
//            System.out.println("");
//        }
//        
//        System.out.println("");
//        
        
        int max2 = -1;
        int dir = -1;
        int x1=-1, y1=-1;
        
        for(int j=w; j>=1; j--){            
            for(int i=1; i<=h; i++){
                int x = i-1;
                int y = j-1;                
//                if((x<h-1) && compList[x+1][y] != compList[x][y]){
//                    if( (comps.get(compList[x][y]).size() + comps.get(compList[x+1][y]).size()) >= max2){
//                        max2 = comps.get(compList[x][y]).size() + comps.get(compList[x+1][y]).size();
//                        x1=x;
//                        y1=y;
//                        System.out.println(i+" "+j+" "+max2+" S");
//                    }
//                }
                
                
                if((y<w-1) && compList[x][y+1] != compList[x][y]){
                    if( (comps.get(compList[x][y]).size() + comps.get(compList[x][y+1]).size()) >= max2) {
                        max2 = comps.get(compList[x][y]).size() + comps.get(compList[x][y+1]).size();
                        
                            x1=x;
                            y1=y;
                            dir = 4;
                            //System.out.println(i+" "+j+" "+max2+" E");    
                    }
                }
                
                if((x>0) && compList[x-1][y] != compList[x][y]){
                    if( (comps.get(compList[x][y]).size() + comps.get(compList[x-1][y]).size()) >= max2) {
                        max2 = comps.get(compList[x][y]).size() + comps.get(compList[x-1][y]).size();
                        x1=x;
                        y1=y;
                        dir = 3;
                        //System.out.println(i+" "+j+" "+max2+" N");
                    }
                }
//                if((y>0) && compList[x][y-1] != compList[x][y]){
//                    if( (comps.get(compList[x][y]).size() + comps.get(compList[x][y-1]).size()) >= max2) {
//                        max2 = comps.get(compList[x][y]).size() + comps.get(compList[x][y-1]).size();
//                        x1=x;
//                        y1=y;
//                        System.out.println(i+" "+j+" "+max2+" W");
//                    }
//                }
                
            }
//            System.out.println("");
        }
        out.println(counter+"\n"+max+"\n"+max2+"\n"+(x1+1)+" "+(y1+1)+" "+(dir==3?"N":"E"));
        
        out.close();
        System.exit(0); 
    }
}
