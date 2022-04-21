package dev.simmons.sorting;

import dev.simmons.models.Score;
import java.util.List;

public interface Sorting {
    List<Score> filterByInitials(List<Score> scores, String initials);
    List<Score> sortByScore(List<Score> scores);
}
