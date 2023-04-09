package averagescorestrategy;

import common.Constants;
import init.ChildrenInit;
import java.util.ArrayList;

public final class TeenAverageScore implements AverageScoreStrategy {

    @Override
    public double getAverageScore(final ChildrenInit child) {
        ArrayList<Double> score = child.getNiceScoreHistory();
        double averageScore = 0.0;
        int weight = 0;
        double multiply;

        for (int i = 0; i < score.size(); i++) {
            weight += (i + 1);
            multiply = score.get(i) * (i + 1);

            averageScore += multiply;
        }

        double result = averageScore / weight;

        if (child.getNiceScoreBonus() != null) {
            result += result * child.getNiceScoreBonus() / Constants.DIVISION;
        }

        return result;
    }
}
