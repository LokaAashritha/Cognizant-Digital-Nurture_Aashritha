import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Exercise36_HTTPClient {

    public static void main(String[] args) {

        try {

            HttpClient httpClientValue = HttpClient.newHttpClient();

            HttpRequest httpRequestValue = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com"))
                    .GET()
                    .build();

            HttpResponse<String> httpResponseValue =
                    httpClientValue.send(
                            httpRequestValue,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println("Status Code: " + httpResponseValue.statusCode());

            System.out.println("\nResponse Body:\n" + httpResponseValue.body());

        } catch (Exception exceptionValue) {

            System.out.println("Error: " + exceptionValue.getMessage());
        }
    }
}