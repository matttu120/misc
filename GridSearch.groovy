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
	/*
	 * My first thought for this solution was to start from i=0 and j=0, and search every element somehow (whether by
	 * binary search or one by one). However, we come across a problem when we reach an element around the middle of 
	 * the grid. Consider the following: 
	 * 
	 *  1	2	3	4	5
	 *  2	3	6	8	7
	 *  3	5	10	11	12
	 *  4	7	11	12	15
	 *  4	8	12	15	18
	 *  
	 *  Say we wanted to do a search for 10. We'd have to throw out the binary search option because we have no way
	 *  of knowing which direction to search unless we search them all. This is fine and would take n(logn) time, but
	 *  we want to optimize it so that we don't have to recurse upon the entire grid.
	 *  
	 *  Instead, what if we search from the bottom left of the grid, at i=0 and j=n? We effectively only search a 
	 *  diagonal from the bottom left of the grid to where the element should be. This would take linear time in all cases,
	 *  and thankfully for me is much simpler to implement!
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