package gridsearch

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Grid Search
 *
 * You've been given a grid of dimensions M x N. This grid is special though. There are some rules for numbers
 * in this grid.
 *
 * <ul>
 *   <li><code>grid[i][j] > grid[i][j-1]</code> for <code>0 < j < N-1 </code></li>
 *   <li><code>grid[i][j] > grid[i-1][j]</code> for <code>0 < i < M-1 </code></li>
 * </ul>
 *
 * <p>You must find if a given number exists in this grid at all.</p>
 * <p>Oh, and this grid can be really huge, so optimize your execution speed.</p>
 * @author rahulsomasunderam
 * @since 1/27/13 9:58 AM
 */
class GridSearch {
	static class Position {
		int i, j
	}

	/**
	 * Finds the element in the grid
	 * @param grid The grid
	 * @param num the number to find
	 * @return the position of the number or null
	 */

	Position findInGrid(grid, int num) {
		int x = 0;
		int y = grid.findLastIndexOf{grid};
		Position result = new Position();
		result.i = 0;
		result.j = 0;
		while (x<grid[0].size() && y >=0){
			if (grid[x][y] == num){
				result.i = x;
				result.j = y;
				return result;
			}
			if (grid[x][y] > num){
				y--;
			}
			else x++;
		}
		return null;
	}
}
