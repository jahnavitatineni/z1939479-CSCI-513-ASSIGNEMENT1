import java.util.*;
import java.io.*;
@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
		ReadData obj=new ReadData();
		char[][] grid=obj.readAndPlaceInGrid();
		
		int l=0;
		int i=1;
    
		String Lines[]=obj.getDataLineByLine();
		BattleshipSearch bobj=new BattleshipSearch();
		for(String line:Lines) {
	
			System.out.println("Game "+i+":"+"\n");
			
			System.out.println("Strategy: Horizontal Sweep");
			bobj.HorizontalSweepStrategy(line, grid);
			
			System.out.println("Strategy: Random Search");
			bobj.RandomSearchStrategy(line, grid);
			
			
		System.out.println("Strategy: Strategic Search");
		bobj.StrategicSearch(line, grid);
		i++;
		
		System.out.println();
		
			
		}
		
      	}

}