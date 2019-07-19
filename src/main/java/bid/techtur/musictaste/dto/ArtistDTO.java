package bid.techtur.musictaste.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArtistDTO {
    @JsonProperty("items")
    private List<Item> items = new ArrayList<>();

    @Getter
    @Setter
    public static class Item {
        @JsonProperty("name")
        private String name;

        @JsonProperty("href")
        private String albumHref;

        @JsonProperty("external_urls")
        private Map<String, String> externalUrls;

        @JsonProperty("images")
        private List<Image> images;

        public Item.Image getBestImage() {
            return images.stream()
                    .findFirst()
                    .orElse(new Image());
        }

        @Getter
        @Setter
        public static class Image {
            @JsonProperty("height")
            private int height;

            @JsonProperty("width")
            private int width;

            @JsonProperty("url")
            private String url;
        }
    }
}
