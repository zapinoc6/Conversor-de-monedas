import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Principal {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "e188861c62c3591c7853ed4e";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public double convertToARS(double amountInUSD) {
        return convertCurrency(amountInUSD, "ARS");
    }

    public double convertToBOB(double amountInUSD) {
        return convertCurrency(amountInUSD, "BOB");
    }

    public double convertToBRL(double amountInUSD) {
        return convertCurrency(amountInUSD, "BRL");
    }

    public double convertToCLP(double amountInUSD) {
        return convertCurrency(amountInUSD, "CLP");
    }

    public double convertToRMB(double amountInUSD) {
        return convertCurrency(amountInUSD, "RMB");
    }

    public double convertToCOP(double amountInUSD) {
        return convertCurrency(amountInUSD,"COP");
    }

    public double convertToJPY(double amountInUSD) {
        return convertCurrency(amountInUSD,"JPY");
    }

    private double convertCurrency(double amountInUSD, String targetCurrency) {
        try {
            // Realizar solicitud HTTP para obtener las tasas de cambio
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + API_KEY + "/latest/USD"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Parsear la respuesta JSON
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

            // Obtener la tasa de cambio para la moneda de destino
            double exchangeRate = jsonObject.getAsJsonObject("conversion_rates").get(targetCurrency).getAsDouble();

            // Realizar la conversión de monedas
            return amountInUSD * exchangeRate;
        } catch (Exception e) {
            // Manejar errores
            e.printStackTrace();
            return 0; // Retornar 0 en caso de error
        }
    }


}
