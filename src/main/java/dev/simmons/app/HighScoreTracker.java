package dev.simmons.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.simmons.models.Score;
import dev.simmons.sorting.Sorter;
import dev.simmons.sorting.Sorting;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

public class HighScoreTracker {
    private static List<Score> scoreList = new ArrayList<>();

    public static void main(String[] args) {
        Javalin app = Javalin.create();
        Gson gson = new GsonBuilder().create();
        Sorting sorter = new Sorter();
        app.get("/scores", ctx -> {
            if (ctx.queryString() == null) {
                ctx.status(200);
                ctx.result(gson.toJson(scoreList));
            } else {
                String initials = ctx.queryParam("initial");
                ctx.status(200);
                ctx.result(gson.toJson(sorter.filterByInitials(scoreList, initials)));
            }
        });

        app.post("/scores", ctx -> {
            Score score = gson.fromJson(ctx.body(), Score.class);
            if (score.getPoints() > 0) {
                scoreList.add(score);
                scoreList = sorter.sortByScore(scoreList);
                ctx.status(201);
                ctx.result("Score " + score + " was added.");
            } else {
                ctx.status(400);
                ctx.result("Score cannot be negative");
            }

        });

        app.exception(Exception.class, (err, ctx) -> {
            System.out.println("Oops... ");
            System.out.println(err.getMessage());
        });


        app.start(5000);
    }
}
