import java.util.*;

public class PercolationBFS extends PercolationDFSFast {

	public PercolationBFS(int n) {
		super(n);
	}

	@Override
	public void dfs(int row, int col) {
	    int[] rowDelta = {-1,1,0,0};
	    int[] colDelta = {0,0,-1,1};
	    Queue<Integer> q = new LinkedList<>();
	    int size = myGrid.length;
	    //System.out.printf("%d %d %d %d\n",myGrid.length, numberOfOpenSites(),row,col);
	    q.add(row*size + col);
	    myGrid[row][col] = FULL;
	    while (! q.isEmpty()) {
	    	int rem = q.remove();
	    	row = rem/size;
	    	col = rem%size;
	    	for(int k=0; k < rowDelta.length; k++) {
	    		int r = row + rowDelta[k];
	    		int c = col + colDelta[k];
	    		if (inBounds(r,c) && ! isFull(r,c) && isOpen(r,c)) {
	    			myGrid[r][c] = FULL;
	    			q.add(r*size + c);
	    		}
	    	}
	    	
	    }
	    
	}
}
