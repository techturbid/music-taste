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

    String token = System.getenv("SPOTIFY_ACCESS_TOKEN");

    @Autowired
    SpotifyClient client;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/artists")
    public List<String> getArtists() {

        ArtistDTO artists = client.getArtists(String.format("Bearer %s", token));

        List<String> names = new ArrayList<>();
        Iterator<ArtistDTO> iterator = artists.get("items").elements();
        while(iterator.hasNext()) {
            ArtistDTO node = iterator.next();
            names.add(node.get("name").asText());
        }
        return names;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/tracks")
    public List<String> getTracks() {
        JsonNode tracks = client.getTracks(String.format("Bearer %s", token));

        List<String> names = new ArrayList<>();
        Iterator<JsonNode> iterator = tracks.get("items").elements();
        while(iterator.hasNext()) {
            JsonNode node = iterator.next();
            names.add(node.get("name").asText());
        }
        return names;
    }
}
