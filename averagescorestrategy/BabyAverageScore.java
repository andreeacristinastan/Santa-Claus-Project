package averagescorestrategy;

import common.Constants;
import init.ChildrenInit;

public final class BabyAverageScore implements AverageScoreStrategy {

    @Override
    public double getAverageScore(final ChildrenInit child) {
        return Constants.BABY_SCORE;
    }
}
