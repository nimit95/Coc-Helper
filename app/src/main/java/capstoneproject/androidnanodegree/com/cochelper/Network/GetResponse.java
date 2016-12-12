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
                .url(url).header("Authorization","Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImRiZGQ2NWQxLTAwNTUtNDMwYi1hN2IyLWRjZjQwODM2M2IxOSIsImlhdCI6MTQ4MTU0MjkyMywic3ViIjoiZGV2ZWxvcGVyLzVkMGI0OGEwLTRhYTUtODg3ZS1kZjNiLWZiYTg0YWQ1MjQ3ZSIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjAuMC4wLjAiXSwidHlwZSI6ImNsaWVudCJ9XX0.MkLi3n7lQCCcJnmdyMW5u000ZSUU4JId1k8V4rfBO3hFDlhLvrKuXT7Urwa3u_sBZUK4lythJ4HhEZHO98zEbQ")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
