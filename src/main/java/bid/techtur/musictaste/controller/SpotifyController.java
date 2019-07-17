package bid.techtur.musictaste.controller;

import bid.techtur.musictaste.client.SpotifyClient;
import bid.techtur.musictaste.dto.ArtistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;




@Controller
public class SpotifyController {

    @Autowired
    SpotifyClient client;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/index");

        return view;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/artists")
    public ModelAndView getArtists(@RequestParam(value = "token") String token, @RequestParam("time_range") String timeRange) {
        ArtistDTO artists = client.getArtists(String.format("Bearer %s", token), timeRange);

        ModelAndView view = new ModelAndView("/artists");

        view.addObject("artists", artists);

        return view;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/tracks")
    public List<String> getTracks() {
//        JsonNode tracks = client.getTracks(String.format("Bearer %s", token));
//
//        List<String> names = new ArrayList<>();
//        Iterator<JsonNode> iterator = tracks.get("items").elements();
//        while(iterator.hasNext()) {
//            JsonNode node = iterator.next();
//            names.add(node.get("name").asText());
//        }
//        return names;
        return null;
    }

}
