import java.util.*;

public class PercolationBFS extends PercolationDFSFast {
	
	public PercolationBFS(int x) {
		super(x);
	}
	
	@Override
	protected void dfs(int row, int col) {
		if (! inBounds(row,col) || isFull(row, col) || !isOpen(row, col)) return;
		myGrid[row][col] = FULL;
		Queue<Integer> q = new LinkedList<>();
		q.add(row * myGrid.length + col);
		while(q.size() > 0) {
			int rcord = q.poll()/myGrid.length;
			int ccord = q.poll()%myGrid.length;
			
	    	 if(inBounds(rcord, ccord + 1) && myGrid[rcord][ccord + 1] == OPEN) 
	    	 {
	    		 myGrid[rcord][ccord + 1] = FULL;
	    		 q.add(rcord * myGrid.length + ccord + 1);
	    	 }
	    	 if(inBounds(rcord, ccord - 1) && myGrid[rcord][ccord - 1] == OPEN) 
	    	 {
	    		 myGrid[rcord][ccord - 1] = FULL;
	    		 q.add(rcord  *myGrid.length + ccord - 1);
	    	 }
			if(inBounds(rcord + 1, ccord) && myGrid[rcord + 1][ccord] == OPEN) 
			{
	    		 myGrid[rcord + 1][ccord] = FULL;
	    		 q.add((rcord+1)*myGrid.length + ccord);
	    	 }
	    	 if(inBounds(rcord - 1, ccord) && myGrid[rcord - 1][ccord] == OPEN) 
	    	 {
	    		 myGrid[rcord - 1][ccord] = FULL;
	    		 q.add((rcord - 1) * myGrid.length + ccord);
	    	 }
		}
	}
}
