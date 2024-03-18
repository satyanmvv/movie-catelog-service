package org.javarevised.moviecatelogservice.resources;

import org.javarevised.moviecatelogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catelog")
public class MovieCatelogResource {
    @Value("${omdb.api.url}")
    private String apiUrl;
    @Value("${omdb.api.key}")
    private String apiKey;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
            @GetMapping
            public UserRating getUserRatings(@PathVariable String userId){
        String url = String.format("%s?apikey=%s&i=%s", apiUrl, apiKey, userId);

        return restTemplate.getForObject(url,UserRating.class);
    }
    {

    }

}
