/*package numberpicker

import java.awt.im.InputContext;

import com.sun.org.apache.bcel.internal.generic.RETURN;

*//**
 * The number picker game.
 * <ul>
 *   <li>The game starts with a list of numbers that is completely visible to both players.</li>
 *   <li>Always assume you play first.</li>
 *   <li>When their turn comes, each player can choose a number from either end of the list.</li>
 *   <li>When there are no numbers left on the board, you sum all the numbers you've collected.</li>
 *   <li>The player with the greater sum wins.</li>
 *   <li>Assume both players have the best possible algorithm - your algorithm.</li>
 * </ul>
 * <p>You must find if the player who starts, i.e. you will win the game.</p>
 * <p>Oh, and this list can be really huge.</p>
 * <p>There are only acceptance tests. Feel free to add more unit tests</p>
 * @author rahulsomasunderam
 * @since 1/27/13 9:16 AM
 *//*
class NumberPicker {
	*//**
	 * This describes the result of a game.
	 *//*
	static enum Result {
		Win, Lose, Draw
	}

	*//**
	 * Summarizes a list into a single value.
	 * @param input the list of numbers
	 * @return
	 *//*
	private int valueOfListImpl(List<Integer> input) {
		if (input.isEmpty()) {
			// If the list is empty, you get 0 points
			return 0;
		} else if (input.size()==1) {
			// If the list has one element, you get the points from that element
			return input.get(0);
		} else {
			// If the list is larger, compute it's value.
			
			 * Left head is the first element of the list
			 * Right head is the last element of the list
			 * Left tail is whatever is left of the list when you remove the left head.
			 * Right tail is whatever is left of the list when you remove the right head.
			 
			int leftHead = input.get(0);
			List<Integer> leftTail = input.subList(1, input.size());
			int rightHead = input.get(input.size()-1);
			List<Integer> rightTail = input.subList(0, input.size()-1);

			int headVal = leftHead - valueOfList(leftTail);
			int tailVal = rightHead - valueOfList(rightTail);

			return Math.max(headVal, tailVal);
		}
	}

	*//**
	 * Given a list of numbers, tells who can win the game.
	 * @param input the list of numbers
	 * @return The result of the game
	 *//*
	public Result findWinner(List<Integer> input) {
		int firstPlayerValue = valueOfListImpl(input);
		System.out.println("FirstPlayerValue:" + firstPlayerValue);
		
		List<Integer> input2 = input;
		
		if (!input2.isEmpty() && input2.size()>1){
			if (input2.get(0) >= input2.get(input2.size()-1)){
				input2 = input2.subList(1,input.size()-1);
			}
			else if (input2.get(input2.size()-1) > input2.get(0)){
				input2.remove(input2.size()-1);
			}
		}
		else if (input2.size() == 1){
			input2.clear();
		}
		
		if (input.isEmpty()){
			return Result.Draw;
		}
		else if (input.size() == 1){
			input.clear();
		}
		else if (input.size()==2 && input.get(0) != input.get(1)){
			return Result.Win;
		}
		// Removing the larger of the two elements at the head or tail
		else if (input.get(0) > input.get(input.size()-1)){
			System.out.println(input);
			System.out.println("Head >= Tail secondplayer, removing head");
			input = input.subList(1, input.size());
			System.out.println(input);
		}
		else if (input.get(0) < input.get(input.size()-1)){
			System.out.println(input);
			System.out.println("Head < Tail secondplayer, removing tail");
			input = input.subList(0, input.size()-1);
			System.out.println(input);
		}
		System.out.println("Starting secondplayervalue");
		int secondPlayerValue = valueOfListImpl(input);
		System.out.println("Ending secondplayervalue");
		System.out.println(firstPlayerValue);
		System.out.println(secondPlayerValue);
		if (firstPlayerValue > secondPlayerValue) {
			return Result.Win;
		} else if (firstPlayerValue < secondPlayerValue) {
			return Result.Lose;
		} else if (firstPlayerValue == secondPlayerValue){
			return Result.Draw;
		}
	}



	private final valueOfListClosure = { List<Integer> input ->
		return this.valueOfListImpl(input)
	}

	private final valueOfList = valueOfListClosure.memoize()

	boolean  TODO 11: This method should have no users. Remove it.  implementBoolean() {
		throw new RuntimeException("implement this")
	}

	int  TODO 12: This method should have no users. Remove it.  implementInt() {
		throw new RuntimeException("implement this")
	}

	List<Integer>  TODO 13: This method should have no users. Remove it.  implementList() {
		throw new RuntimeException("implement this")
	}
}
*/

package numberpicker

/**
 * The number picker game.
 * <ul>
 *   <li>The game starts with a list of numbers that is completely visible to both players.</li>
 *   <li>Always assume you play first.</li>
 *   <li>When their turn comes, each player can choose a number from either end of the list.</li>
 *   <li>When there are no numbers left on the board, you sum all the numbers you've collected.</li>
 *   <li>The player with the greater sum wins.</li>
 *   <li>Assume both players have the best possible algorithm - your algorithm.</li>
 * </ul>
 * <p>You must find if the player who starts, i.e. you will win the game.</p>
 * <p>Oh, and this list can be really huge.</p>
 * <p>There are only acceptance tests. Feel free to add more unit tests</p>
 * @author rahulsomasunderam
 * @since 1/27/13 9:16 AM
 */
class NumberPicker {

	/**
	 * This describes the result of a game.
	 */
	static enum Result {
		Win, Lose, Draw
	}

	/**
	 * Summarizes a list into a single value.
	 * @param input the list of numbers
	 * @return
	 */
	private int valueOfListImpl(List<Integer> input) {
		if (input.isEmpty()) {
			// If the list is empty, you get 0 points
			0
		} else if (input.size()==1) {
			// If the list has one element, you get the points from that element
			input.get(0)
		} else {
			// If the list is larger, compute it's value.
			/*
			 * Left head is the first element of the list
			 * Right head is the last element of the list
			 * Left tail is whatever is left of the list when you remove the left head.
			 * Right tail is whatever is left of the list when you remove the right head.
			 */
			int leftHead = input.get(0)
			List<Integer> leftTail = input.subList(1,input.size())
			int rightHead = input.get(input.size()-1)
			List<Integer> rightTail = input.subList(0,input.size()-1)

			int headVal = leftHead - valueOfList(leftTail)
			int tailVal = rightHead - valueOfList(rightTail)

			Math.max(headVal, tailVal)
		}
	}

	/**
	 * Given a list of numbers, tells who can win the game.
	 * @param input the list of numbers
	 * @return The result of the game
	 */
	public Result findWinner(List<Integer> input) {
		int firstPlayerValue = valueOfListImpl(input)
		if (firstPlayerValue >0) {
			Result.Win
		} else if (firstPlayerValue < 0) {
			Result.Lose
		} else {
			Result.Draw
		}
	}


	private final valueOfListClosure = { List<Integer> input ->
		return this.valueOfListImpl(input)
	}

	private final valueOfList = valueOfListClosure.memoize()

	boolean /* TODO 11: This method should have no users. Remove it. */ implementBoolean() {
		throw new RuntimeException("implement this")
	}

	int /* TODO 12: This method should have no users. Remove it. */ implementInt() {
		throw new RuntimeException("implement this")
	}

	List<Integer> /* TODO 13: This method should have no users. Remove it. */ implementList() {
		throw new RuntimeException("implement this")
	}
}
