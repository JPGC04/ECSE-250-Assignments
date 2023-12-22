package assignment3;

import java.awt.Color;

public class BlobGoal extends Goal {

	public BlobGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {
		int maxScore = 0;
		int tempScore = 0;

		Color[][] flatBoard = board.flatten();

		for (int i = 0; i < flatBoard.length; i++) {
			for (int j = 0; j < flatBoard.length; j++) {
				tempScore = undiscoveredBlobSize(i, j, flatBoard, new boolean[flatBoard.length][flatBoard.length]);
				if (tempScore > maxScore) {
					maxScore = tempScore;
				}
				tempScore = 0;
			}
		}

		return maxScore;
	}

	@Override
	public String description() {
		return "Create the largest connected blob of " + GameColors.colorToString(targetGoal)
				+ " blocks, anywhere within the block";
	}

	public int undiscoveredBlobSize(int i, int j, Color[][] unitCells, boolean[][] visited) {
		if (visited[i][j] || (!(unitCells[i][j].equals(this.targetGoal)))) {
			return 0;
		}

		visited[i][j] = true;
		int blobSize = 0;

		if (i != 0) {
			blobSize += undiscoveredBlobSize(i - 1, j, unitCells, visited);
		}
		if (i != unitCells.length - 1) {
			blobSize += undiscoveredBlobSize(i + 1, j, unitCells, visited);
		}
		if (j != 0) {
			blobSize += undiscoveredBlobSize(i, j - 1, unitCells, visited);
		}
		if (j != unitCells.length - 1) {
			blobSize += undiscoveredBlobSize(i, j + 1, unitCells, visited);
		}

		return blobSize + 1;
	}

}
