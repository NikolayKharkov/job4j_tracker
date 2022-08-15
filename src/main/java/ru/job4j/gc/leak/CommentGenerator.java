package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommentGenerator implements Generate {
    private final String pathPhrases = "src/main/java/ru/job4j/gc/leak/files/phrases.txt";
    private final String lineSeparator;
    private final Integer count = 50;
    private List<Comment> comments = new ArrayList<>();
    private List<String> phrases;
    private UserGenerator userGenerator;
    private Random random;

    public CommentGenerator(Random random, UserGenerator userGenerator, String lineSeparator) {
        this.userGenerator = userGenerator;
        this.random = random;
        this.lineSeparator = lineSeparator;
        read();
    }

    private void read() {
        try {
            phrases = read(pathPhrases);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void generate() {
        comments.clear();
        List<Integer> ints = new ArrayList<>(3);
        random.ints(0, phrases.size())
                .distinct().limit(3).forEach(ints::add);
        for (int i = 0; i < count; i++) {
            StringBuilder comment = new StringBuilder();
            comment
                    .append(phrases.get(ints.get(0)))
                    .append(lineSeparator)
                    .append(phrases.get(ints.get(1)))
                    .append(lineSeparator)
                    .append(phrases.get(ints.get(2)));
            comments.add(new Comment(comment.toString(), userGenerator.randomUser()));
        }
    }
}