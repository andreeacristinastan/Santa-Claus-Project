package assignsortstrategy;

import init.ChildrenInit;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public final class NiceScoreSort implements AssignGiftsSortStrategy {
    @Override
    public ArrayList<ChildrenInit> sortChildren(final ArrayList<ChildrenInit> childrenInit) {
        ArrayList<ChildrenInit> children = new ArrayList<>();
        Map<Integer, Double> sort = new HashMap<>();

        for (ChildrenInit child : childrenInit) {
            sort.put(child.getId(), child.getAverage());
        }

        List<Map.Entry<Integer, Double>> sortedMap = sort.entrySet().stream()
                .sorted(Collections
                        .reverseOrder(
                                Map.Entry.<Integer, Double>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Double> sorted : sortedMap) {
            for (ChildrenInit child : childrenInit) {
                if (sorted.getKey() == child.getId()) {
                    children.add(child);
                }
            }
        }
        return children;
    }
}
