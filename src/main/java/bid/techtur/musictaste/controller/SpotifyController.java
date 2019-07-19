package bid.techtur.musictaste.controller;

import bid.techtur.musictaste.client.SpotifyAuthorizationClient;
import bid.techtur.musictaste.client.SpotifyClient;
import bid.techtur.musictaste.dto.ArtistDTO;
import bid.techtur.musictaste.dto.TrackDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SpotifyController {

    @Autowired
    SpotifyAuthorizationClient authorizationClient;

    @Autowired
    SpotifyClient client;

    @GetMapping("/")
    public ModelAndView index(@RequestParam(value = "code", required = false) String code) {
        if (code == null || code.isEmpty()) {
            String redirectUrl = "INSERT_URL_HERE";
            return new ModelAndView("redirect:" + redirectUrl);
        }

        Map<String, String> params = new HashMap<>();

        params.put("grant_type", "authorization_code");
        params.put("redirect_uri", "http://localhost:8080/");
        params.put("code", code);

        JsonNode json = authorizationClient.getToken(params);

        String token = json.get("access_token").asText();

        ModelAndView view = new ModelAndView("/choose");

        view.addObject("token", token);

        return view;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/artists")
    public ModelAndView getArtists(@RequestParam(value = "token") String token, @RequestParam(value = "time_range", defaultValue = "medium_term") String timeRange) {
        ArtistDTO artists = client.getArtists(String.format("Bearer %s", token), timeRange);

        ModelAndView view = new ModelAndView("/artists");

        view.addObject("artists", artists);

        return view;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/tracks")
    public ModelAndView getTracks(@RequestParam(value = "token") String token, @RequestParam(value = "time_range", defaultValue = "medium_term") String timeRange) {
        TrackDTO tracks = client.getTracks(String.format("Bearer %s", token), timeRange);

        ModelAndView view = new ModelAndView("/tracks");

        view.addObject("tracks", tracks);

        return view;
    }



}
