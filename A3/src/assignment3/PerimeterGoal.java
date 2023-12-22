package assignment3;

import java.awt.Color;

public class PerimeterGoal extends Goal {

	public PerimeterGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {
		Color[][] flatBoard = board.flatten();
		int sum = 0;
		for (int i = 0; i < flatBoard.length; i++) {
			for (int j = 0; j < flatBoard[0].length; j++) {
				if (flatBoard[i][j] == this.targetGoal
						&& (i == 0 || j == 0 || i == flatBoard.length - 1 || j == flatBoard[0].length - 1)) {
					if ((i == 0 && j == 0) || (i == 0 && j == flatBoard.length - 1)
							|| (i == flatBoard.length - 1 && j == 0)
							|| (i == flatBoard.length - 1 && j == flatBoard.length - 1)) {
						sum += 2;
					} else {
						sum += 1;
					}
				}
			}
		}
		return sum;
	}

	@Override
	public String description() {
		return "Place the highest number of " + GameColors.colorToString(targetGoal)
				+ " unit cells along the outer perimeter of the board. Corner cell count twice toward the final score!";
	}

}
