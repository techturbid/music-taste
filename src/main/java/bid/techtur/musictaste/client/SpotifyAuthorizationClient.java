package bid.techtur.musictaste.client;

import bid.techtur.musictaste.dto.ArtistDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "spotify-authorization-client", url= "https://accounts.spotify.com/api/", configuration = {SpotifyClientConfig.class, SpotifyAuthorizationClientConfig.class})
public interface SpotifyAuthorizationClient {

    @RequestMapping(method = RequestMethod.POST, value = "/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    JsonNode getToken(@RequestParam Map<String, String> params);

}

