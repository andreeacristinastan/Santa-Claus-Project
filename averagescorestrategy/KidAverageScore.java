package averagescorestrategy;

import common.Constants;
import init.ChildrenInit;

import java.util.ArrayList;

public final class KidAverageScore implements AverageScoreStrategy {
    @Override
    public double getAverageScore(final ChildrenInit child) {
        ArrayList<Double> score = child.getNiceScoreHistory();
        double averageScore = 0.0;

        for (Double allScores : score) {
            averageScore += allScores;
        }

        double result = averageScore / score.size();

        if (child.getNiceScoreBonus() != null) {
            result += result * child.getNiceScoreBonus() / Constants.DIVISION;
        }

        return result;
    }
}
