package bid.techtur.musictaste.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackDTO {
    private List<Item> items = new ArrayList<>();

    @Getter
    @Setter
    public static class Item {
        private String name;
    }
}


