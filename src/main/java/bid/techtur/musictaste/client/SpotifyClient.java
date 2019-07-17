package bid.techtur.musictaste.client;

import bid.techtur.musictaste.dto.ArtistDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spotify-client", url= "https://api.spotify.com/v1/", configuration = SpotifyClientConfig.class)
public interface SpotifyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/me/top/artists")
    ArtistDTO getArtists(@RequestHeader("Authorization") String accessToken, @RequestParam("time_range") String timeRange);

    @RequestMapping(method = RequestMethod.GET, value = "/me/top/tracks")
    JsonNode getTracks(@RequestHeader("Authorization") String accessToken);

}