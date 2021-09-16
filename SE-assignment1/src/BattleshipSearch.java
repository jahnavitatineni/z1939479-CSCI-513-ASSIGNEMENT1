import java.util.*;

public class BattleshipSearch {
	
	static Random rr = new Random();
	static Random rc = new Random();
	
	static void HorizontalSweepStrategy(String line,char[][] grid) {
		String carrierS="",carrierE="",submarineS="",submarineE="";// stores starting, ending of carrier and submarine points
		boolean Cstart=false,Sstart=false; // reference variables for above and common for rest of two methods (random and efficient )
		int numberOfsearches=0;
		String sp[]=line.split(" ");
		for(int i=0;i<sp.length;i++) {
		   String xy[]=sp[i].split(",");
		   int x=Integer.valueOf(xy[0]);
		   int y=Integer.valueOf(xy[1]);
		  
		 
			int innsearch=0;
			
		 for(int r=0;r<25;r++) {
			 boolean found=false;
			 for(int c=0;c<25;c++,innsearch++) {
				 if(r==x && c==y) {
					 if(!Cstart && grid[r][c]=='c') {
						 
						 carrierS="("+r+","+c+")";
						 Cstart=true;
					 }
					 if(grid[r][c]=='c') {
					 carrierE="("+r+","+c+")";
					 }
					 
					 if(!Sstart && grid[r][c]=='s') {
						 
						 submarineS="("+r+","+c+")";
						 Sstart=true;
					 }
					 if(grid[r][c]=='s') {
						 submarineE="("+r+","+c+")";
					 }
					 
					 found=true;
					 break;
				 }
			 }
			 if(found) {
				 break;
			 }
		 }
		   numberOfsearches= Math.max(innsearch, numberOfsearches);
		   
		}
		System.out.println("Number of cells searched:"+ numberOfsearches);
		System.out.println("Carrier found:"+carrierS+" to "+carrierE+" Submarine found:"+submarineS+" to "+submarineE);
		
		
	}
	
	
	static void RandomSearchStrategy(String line,char[][] grid) {
		int numberOfsearches=0; 
		String carrierS="",carrierE="",submarineS="",submarineE="";
		boolean Cstart=false,Sstart=false;
		String sp[]=line.split(" ");
		for(int i=0;i<sp.length;i++) {
		   String xy[]=sp[i].split(",");
		   int x=Integer.valueOf(xy[0]);
		   int y=Integer.valueOf(xy[1]);
		  
			int innsearch=0;
		   
			List<Integer> rows=pickRandom(rr);
			List<Integer> cols=pickRandom(rc);
			//System.out.println(rows+"\n"+cols);
//			System.out.println(r+" "+c+" search");
		   for(int r:rows) {
			   boolean found=false;
			   for(int c:cols) {
				   innsearch++;
				   if(r==x && c==y) {
					   
					   if(!Cstart && grid[r][c]=='c') {
							// System.out.println(r+" "+c);
							 carrierS="("+r+","+c+")";
							 Cstart=true;
						 }
						 if(grid[r][c]=='c') {
						 carrierE="("+r+","+c+")";
						 }
						 
						 if(!Sstart && grid[r][c]=='s') {
							 
							 submarineS="("+r+","+c+")";
							 Sstart=true;
						 }
						 if(grid[r][c]=='s') {
							 submarineE="("+r+","+c+")";
						 }
						 found=true;
						 break;
					 }
				 }
				 if(found) {
					 break;
				 }
			 }
			   numberOfsearches= Math.max(innsearch, numberOfsearches);
			   
			}
		System.out.println("Number of cells searched:"+ numberOfsearches);
		System.out.println("Carrier found:"+carrierS+" to "+carrierE+" Submarine found:"+submarineS+" to "+submarineE);
		
	}
	
	
	
	static void StrategicSearch(String line,char[][] grid) {
		int numberOfsearches=0;
		
		String carrierS="",carrierE="",submarineS="",submarineE="";
		boolean Cstart=false,Sstart=false;
		
		String sp[]=line.split(" ");
		for(int i=0;i<sp.length;i++) {
		   String xy[]=sp[i].split(",");
		   int x=Integer.valueOf(xy[0]);
		   int y=Integer.valueOf(xy[1]);
		  // numberOfsearches+=EfficentSearch(grid,x,y);
		   
		   for(int r=0;r<25;r++){
		         boolean found=false;
		         if(r<x){
		        	 numberOfsearches++;
		             
		         }
		         else if(r==x){
		             for(int c=0;c<25;c++,numberOfsearches++){
		                 if(c==y){
		                     numberOfsearches+=1;
		                     
		                     if(!Cstart && grid[r][c]=='c') {
								 
								 carrierS="("+r+","+c+")";
								 Cstart=true;
							 }
							 if(grid[r][c]=='c') {
							 carrierE="("+r+","+c+")";
							 }
							 
							 if(!Sstart && grid[r][c]=='s') {
								 
								 submarineS="("+r+","+c+")";
								 Sstart=true;
							 }
							 if(grid[r][c]=='s') {
								 submarineE="("+r+","+c+")";
							 }
		                     
		                     found=true;
		                     break;
		                     
		                 }
		             }
		             if(found) {
		            	 break;
		             }
		         }
		     }
		}
		System.out.println("Number of cells searched:"+ numberOfsearches);
		System.out.println("Carrier found:"+carrierS+" to "+carrierE+" Submarine found:"+submarineS+" to "+submarineE);
		
	}
	
	
	
	
	
	
	 static  List<Integer> pickRandom(Random r) {
        final List<Integer> picked = new ArrayList<>();
        while (picked.size() < 25) {
        	int k=r.nextInt(24+ 1);
            if(!picked.contains(k)) {
            	picked.add(k);
            }
        }
       // Collections.sort(picked);
        return picked;
    }
	 
}
	