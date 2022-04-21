package dev.simmons.sorting;

import dev.simmons.models.Score;

import java.util.List;
import java.util.stream.Collectors;

public class Sorter implements Sorting{
    @Override
    public List<Score> filterByInitials(List<Score> scores, String initials) {
        return scores.stream().filter(s -> s.getInitials().equals(initials)).collect(Collectors.toList());
    }

    @Override
    public List<Score> sortByScore(List<Score> scores) {
        return scores.stream().sorted((s, o) -> -1*Integer.compare(s.getPoints(), o.getPoints())).collect(Collectors.toList());
    }
}
