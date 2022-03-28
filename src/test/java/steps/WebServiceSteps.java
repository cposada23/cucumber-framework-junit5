package steps;

import com.google.gson.Gson;
import dto.Post;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class WebServiceSteps {
    private static final Logger LOGGER = LogManager.getLogger(WebServiceSteps.class);

    private Post post;

    @Given("The user consumes the web services to get the post with id {string}")
    public void theUserConsumesTheWebServicesToGetThePostWithId(String id) {
        String url = "https://jsonplaceholder.typicode.com/posts/"+ id;
        LOGGER.info(String.format("URL: %s", url));
        //ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);

        String response = target.request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);

        LOGGER.info(String.format("Response: %s", response));

        Gson gson = new Gson();
        post = gson.fromJson(response, Post.class);

        LOGGER.info(String.format("POST: %s", post));

    }

    @Then("the user validate that the response contains the correct title of the post")
    public void theUserValidateTheResponseContainsTheCorrectTitleOfThePost() {
        Assertions.assertEquals(
                post.getUserId(),
                1,
                "The post is not the expected one"
        );
    }
}
