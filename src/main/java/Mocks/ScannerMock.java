package Mocks;

import TQSGame.Game;
import UI.ScannerI;

public class ScannerMock implements ScannerI{
	private int game = 0;
	private int[][] movements = {{2, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 
			2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,   2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,
			2, 2, 1,  2, 2, 8,  2, 1, 8,  2, 3, 1,  2, 3, 2,  2, 3, 8,  2, 2, 8,  2, 1, 8, 2,4,3, 2,4,2, 2,4,1, 2,4,8, 2,1,8, 2,2,8, 2,3,8, 
			2,5,1, 2,5,2, 2,5,10, 2,2,10, 2,1,10, 2,5,4, 2,5,8, 2,4,8, 2,7,5, 2,7,4, 2,7,3, 2,7,11, 2,3,11, 2,4,11, 2,5,11, 2,0,11,1, 
			2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11, 2,6,1, 2,6,1, 2,6,1, 2,6,1, 2,6,1,
			2,6,10, 2,1,10, 2,1,10, 2,1,10, 2,1,10, 2,1,10, 2,7,6, 2,7,6, 2,7,10, 2,6,10, 2,6,10}, 
			{2,1,8, 2, 2, 1, 2,2,8, 2,1,8, 2,3,2, 2,3,1, 2,3,8, 2,1,8, 2,2,8, 2,4,2, 2,4,1, 2,4,3, 2,4,8, 2,3,8, 2,1,8, 2,2,8, 2,7,1, 2,7,2,
			2,7,3, 2,7,11, 2,3,11, 2,2,11, 2,1,11, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11, 2,5,1, 2,5,2,
			2,5,10, 2,2,10, 2,1,10, 2,5,4, 2,5,8, 2,4,8, 1, 
			2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,   2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9,
			2,7,2, 2,7,2, 2,7,2, 2,6,2, 2,6,2, 2,6,2, 2,6,2, 2,6,2, 2,6,2, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10},
			{2,1,8, 2,2,7, 2,2,8, 2,7,8, 2,5,7, 2,5,7, 2,5,7, 2,0,3, 3,7,3,4, 1, 2,3,10, 2,3,10, 2,3,10, 2,7,3, 2,7,3, 2,7,3,
			2,3,11, 2,3,11, 2,3,11, 2,3,11, 2,3,11, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1,
			2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,   2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9,
			2,3,2, 2,3,2, 2,3,8, 2,2,8, 2,2,8, 2,4,3, 2,4,3, 2,4,3, 2,4,8, 2,3,8, 2,3,8, 2,3,8, 2,5,4, 2,5,8, 2,4,8, 2,7,2, 2,7,2, 2,7,2,
			2,6,2, 2,6,2, 2,6,2, 2,6,2, 2,6,2, 2,6,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10, 2,2,10},
			{2, 1, 8, 1, 1, 1, 1, 1, 1, 1, 1, 
			2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,   2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,  2, 0 ,9, 1,
			2,5,7, 2,5,7, 2,5,10, 2,7,10, 2,7,10, 2,2,7, 2,2,8, 2,7,8, 2,3,2, 2,3,2, 2,3,8, 2,2,8, 2,2,8, 2,7,2, 2,7,2, 2,7,2, 2,7,11, 2,2,11, 2,2,11, 2,2,11,
			2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11,1, 2,0,11, 2,4,3, 2,4,3, 2,4,3, 2,4,8, 2,3,8, 2,3,8, 2,3,8, 2,5,4, 2,5,8, 2,4,8, 
			2,7,5, 2,7,5, 2,7,5, 2,6,5, 2,6,5, 2,6,5, 2,6,5, 2,6,5, 2,6,5, 2,5,10, 2,5,10, 2,5,10, 2,5,10, 2,5,10, 2,5,10, 2,5,10, 2,5,10, 2,5,10, 2,5,10 }
			};
	private int index = 0;
	public ScannerMock(int game) { this.game = game; }
	@Override
	public void close() {
		return;
	}
	
	@Override
	public int nextInt() {
		index = index+1;
		return movements[game][index-1];
	}

}
