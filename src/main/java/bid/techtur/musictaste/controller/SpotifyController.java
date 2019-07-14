package bid.techtur.musictaste.controller;

import bid.techtur.musictaste.client.SpotifyClient;
import bid.techtur.musictaste.dto.ArtistDTO;
import com.fasterxml.jackson.databind.JsonNode;
import feign.Feign;
import feign.codec.Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class SpotifyController {

    @Autowired
    SpotifyClient client;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/api/spotify/artists")
    public List<String> getArtists() {
        JsonNode artists = client.getArtists("Bearer BQDh6uAp2AMgk-RB0gF5zrq8cK8yiGr7cWizMAz9TgQCMh4nHCpLhdb57WYNzSny6-LceH1ChEE85f9Y5MnXS98aS1u8Y3TED76JNWuQ-6Bt-Kdu8xertPbiUs2aKZzYvNZDw5wxt91hmniaTN4NGzDiakLfAlKW0U4kZ2ckLDxfZYvobkKdS23Tx5aIwr1f9D-XFqsBNGk0y-kPosBIWbEcMS1Wh6a9RlvjDjNMmBZJXx6x-lIbZ3HKn2CbWAqJLFhzts_KK86sKdZDJuLFDVQkU14m1J-ezMuahN0");

        List<String> names = new ArrayList<>();
        Iterator<JsonNode> iterator = artists.get("items").elements();
        while(iterator.hasNext()) {
            JsonNode node = iterator.next();
            names.add(node.get("name").asText());
        }
        return names;
    }
}
