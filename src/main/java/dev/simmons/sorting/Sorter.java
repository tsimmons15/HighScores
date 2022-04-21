package dev.simmons.sorting;

import dev.simmons.models.Score;

import java.util.List;
import java.util.stream.Collectors;

public class Sorter implements Sorting{
    @Override
    public List<Score> sortByInitials(List<Score> scores, String initials) {
        return scores.stream().filter(s -> s.getInitials().equals(initials)).collect(Collectors.toList());
    }

    @Override
    public List<Score> sortByScore(List<Score> scores) {
        scores.sort((s, o) -> Integer.compare(s.getPoints(), o.getPoints()));
        return scores;
    }
}
