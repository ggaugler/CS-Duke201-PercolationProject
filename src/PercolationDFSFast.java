
public class PercolationDFSFast extends PercolationDFS {
	
	
	public PercolationDFSFast(int n) {
		super(n);
	}
	
	@Override
	protected void updateOnOpen(int row, int col) {
		boolean full = row == 0;
		int[] rd = {-1,0,0,1};
		int[] cd = {0,-1,1,0};
		for(int k=0; k < rd.length; k++) {
		    int nr = row + rd[k];
		    int nc = col + cd[k];
		    if (inBounds(nr,nc) && isFull(nr,nc)) {
		    	full = true;
		    }
		}
		if (full) {
			dfs(row,col);
		}
	}
}
