package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {
    private final String registrationNumber;

    private final int price;

    private List<Feature> features = new ArrayList<>();

    public CatalogItem(String registrationNumber, int price, Feature feature, Feature... features) {
        if (feature == null) {
            throw new IllegalArgumentException();
        }
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.features.add(feature);
        if (features != null) {
            for (Feature newFeature : features) {
                this.features.add(newFeature);
            }
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPrice() {
        return price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int numberOfPagesAtOneItem() {
        int result = 0;
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                result += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return result;
    }

    public int fullLengthAtOneItem() {
        int result = 0;
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                result += ((AudioFeatures) feature).getLength();
            }
        }
        return result;
    }

    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        for (Feature feature : features) {
            for (int i = 0; i < feature.getContributors().size(); i++) {
                result.add(feature.getContributors().get(i));
            }
        }
        return result;
    }

    public List<String> getTitles() {
        List<String> result = new ArrayList<>();
        for (Feature feature : features) {
            result.add(feature.getTitle());
        }
        return result;
    }

    public boolean hasAudioFeature() {
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                return true;
            }
        }
        return false;
    }
}
