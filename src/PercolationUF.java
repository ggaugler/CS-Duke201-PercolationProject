
public class PercolationUF implements IPercolate {


	IUnionFind myFinder;
	boolean[][] myGrid;
	final int VTOP;
	final int VBOTTOM;
	int myOpenCount;
	
	public PercolationUF(IUnionFind finder, int size) {
		finder.initialize(size*size + 2);
		myFinder = finder;
		myGrid = new boolean[size][size];
		VTOP = size*size;
		VBOTTOM = size*size + 1;
	}
	
	@Override
	public void open(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if (myGrid[row][col]) {
			return;
		}
		myGrid[row][col] = true;
		myOpenCount += 1;
		doConnect(row,col);
		if (row == 0) {
			myFinder.union(getIndex(row,col), VTOP);
		}
		if (row == myGrid.length-1) {
			myFinder.union(getIndex(row,col), VBOTTOM);
		}
	}

	private void doConnect(int row, int col) {
		int[] dr = {-1,0,0,1}; //{-1,-1,-1,0,0,1,1,1};
		int[] dc = {0,-1,1,0}; //{-1,0,1,-1,1,-1,0,-1};
		int index = getIndex(row,col);
		for(int k=0; k < dr.length; k++) {
			int nr = row + dr[k];
			int nc = col + dc[k];
			if (inBounds(nr,nc) && isOpen(nr,nc)) {
				myFinder.union(index, getIndex(nr,nc));
			}
		}
	}

	private int getIndex(int row, int col) {
		return row*myGrid.length + col;
	}
	@Override
	public boolean isOpen(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myGrid[row][col];
	}

	@Override
	public boolean isFull(int row, int col) {
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		return myFinder.connected(getIndex(row,col), VTOP);
	}

	@Override
	public boolean percolates() {
	
		return myFinder.connected(VTOP, VBOTTOM);
	}

	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	
	private boolean inBounds(int row, int col) {
		return 0 <= row && 0 <= col && row < myGrid.length && col < myGrid[0].length;
	}

}
