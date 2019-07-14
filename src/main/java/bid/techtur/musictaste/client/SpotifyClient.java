package bid.techtur.musictaste.client;

import bid.techtur.musictaste.dto.ArtistDTO;
import com.fasterxml.jackson.databind.JsonNode;
import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value = "spotify-client", url= "https://api.spotify.com/v1/", configuration = SpotifyClientConfig.class)
public interface SpotifyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/me/top/artists")
    JsonNode getArtists(@RequestHeader("Authorization") String accessToken);

}