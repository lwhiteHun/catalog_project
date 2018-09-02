package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private String title;

    private final int length;

    private List<String> performers;

    private List<String> composer;


    public AudioFeatures(String title, int length, List<String> performers) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length < 0 || performers.size() == 0) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = new ArrayList<>();
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);
        this.composer = composer;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContributors() {
        if (composer.size() > 0) {
            List<String> composerAndPerformers = new ArrayList<>(composer);
            for (String performer : performers) {
                composerAndPerformers.add(performer);
            }
            return composerAndPerformers;
        }
        return performers;
    }
}
