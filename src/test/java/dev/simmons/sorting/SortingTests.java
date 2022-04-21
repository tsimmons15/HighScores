package dev.simmons.sorting;

import dev.simmons.models.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class SortingTests {
    static Sorting sorter = null;
    @Test
    void filterByInitials() {
        sorter = new Sorter();
        Score score = new Score();
        score.setInitials("JHN");
        score.setPoints(50);
        Score score1 = new Score();
        score1.setInitials("ACR");
        score1.setPoints(400);
        Score score2 = new Score();
        score2.setInitials("ACR");
        score2.setPoints(200);
        Score score3 = new Score();
        score3.setInitials("BOB");
        score3.setPoints(1000);

        List<Score> scoreList = new ArrayList<>();
        scoreList.add(score);
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);

        List<Score> sortedScores = sorter.filterByInitials(scoreList, "ACR");
        Assertions.assertEquals(2, sortedScores.size());
    }

    @Test
    void sortByScore() {
        if (sorter == null) {
            sorter = new Sorter();
        }
        Score score = new Score();
        score.setInitials("JHN");
        score.setPoints(50);
        Score score1 = new Score();
        score1.setInitials("ACR");
        score1.setPoints(400);
        Score score2 = new Score();
        score2.setInitials("ACR");
        score2.setPoints(200);
        Score score3 = new Score();
        score3.setInitials("BOB");
        score3.setPoints(1000);

        List<Score> scoreList = new ArrayList<>();
        scoreList.add(score);
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);

        List<Score> sorted = sorter.sortByScore(scoreList);
        Assertions.assertTrue(sorted.get(0).getPoints() < sorted.get(sorted.size()-1).getPoints());
    }
}
