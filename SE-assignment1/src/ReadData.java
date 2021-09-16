import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadData {
	
	 static final String file = "src//input.txt";
 
		
	
		public static char[][] readAndPlaceInGrid() {
			char[][] grid=new char[25][25];
			for(int i=0;i<25;i++) {
				for(int j=0;j<25;j++) {
					grid[i][j]='.';
				}
				
			}

	        try{
	            InputStream ips = new FileInputStream(file);
	            InputStreamReader ipsr = new InputStreamReader(ips);
	            BufferedReader br = new BufferedReader(ipsr);
	            String line;
	            int ll=0;
	            while ((line = br.readLine()) != null){
	            	
	                line=line.replaceAll("\\("," ");
	                line=line.replaceAll("\\)","");
	                line=line.trim();
	                String words[]=line.split(" ");
	                for(int carrier=0;carrier<5;carrier++) {
	                	String[] xy=words[carrier].split(",");
	                	grid[Integer.valueOf(xy[0])][Integer.valueOf(xy[1])]='c';
	                }
	                
	                for(int submarine=5;submarine<8;submarine++) {
	                	String[] xy=words[submarine].split(",");
	                	grid[Integer.valueOf(xy[0])][Integer.valueOf(xy[1])]='s';
	                }
	                ll++;
	               
	                
	            }
	        
	            br.close();
	        }
	        catch (Exception e){
	            System.out.println(e.toString());
	        }
	        return grid;
		}
		
		
		public static String[] getDataLineByLine() {
			String[] ans=new String[0];
			
			 try{
		            InputStream ips = new FileInputStream(file);
		            InputStreamReader ipsr = new InputStreamReader(ips);
		            BufferedReader br = new BufferedReader(ipsr);
		            String line;
		            while ((line = br.readLine()) != null){
		            	
		                line=line.replaceAll("\\("," ");
		                line=line.replaceAll("\\)","");
		                line=line.trim();
		                String words[]=line.split(" ");
		              
		                ans=Arrays.copyOf(ans, ans.length+1);
		            	ans[ans.length-1]=line;
		                
		            }
		        
		            br.close();
		        }
		        catch (Exception e){
		            System.out.println(e.toString());
		        }
			 return ans;
			}
			
			
		
}