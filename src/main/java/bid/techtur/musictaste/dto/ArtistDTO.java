package bid.techtur.musictaste.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ArtistDTO {
    private List<Item> items = new ArrayList<>();

    @Getter
    @Setter
    public static class Item {
        private String name;
    }
}
