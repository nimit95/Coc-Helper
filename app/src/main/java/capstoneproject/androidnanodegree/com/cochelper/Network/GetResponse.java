package capstoneproject.androidnanodegree.com.cochelper.network;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Nimit Agg on 12-12-2016.
 */

public class GetResponse {
    OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url).header("Authorization","Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjFiZjcxOWQ3LWNhNTctNGI1My1hODgwLTYyNDRkODE4MzI1NCIsImlhdCI6MTQ4MTU0NjkzNSwic3ViIjoiZGV2ZWxvcGVyLzVkMGI0OGEwLTRhYTUtODg3ZS1kZjNiLWZiYTg0YWQ1MjQ3ZSIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjEyMi4xNjEuMjEyLjIwNyJdLCJ0eXBlIjoiY2xpZW50In1dfQ.UPjfCg1ZXT4Bykzr2MajJWMX-lh_tU1whp-Zqw_pPOSuqTnwFFGixWb3uEZANx0aTw5SKIEyx3AU1As7YRcMbw")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
