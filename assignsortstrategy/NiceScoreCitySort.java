package assignsortstrategy;

import common.Constants;
import enums.Cities;
import init.ChildrenInit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class NiceScoreCitySort implements AssignGiftsSortStrategy {
    @Override
    public ArrayList<ChildrenInit> sortChildren(final ArrayList<ChildrenInit> childrenInit) {
        Map<String, Double> mapSort = new HashMap<>();
        ArrayList<ChildrenInit> children = new ArrayList<>();

        for (Cities city : Cities.values()) {
            int size = 0;
            double sum = 0.0;
            for (ChildrenInit child : childrenInit) {
                if (city.value.equals(child.getCity())
                        && child.getAge() <= Constants.AGE_LIMIT) {
                    sum = sum + child.getAverage();
                    size = size + 1;
                }
            }

            if (size != 0) {
                mapSort.put(city.value, sum / size);
            }
        }

        List<Map.Entry<String, Double>> sortedMap = mapSort.entrySet().stream()
                .sorted(Collections
                        .reverseOrder(
                                Map.Entry.<String, Double>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());

        for (Map.Entry<String, Double> sorted : sortedMap) {
            for (ChildrenInit child : childrenInit) {
                if (sorted.getKey().equals(child.getCity())) {
                    children.add(child);
                }
            }
        }
        return children;
    }
}
