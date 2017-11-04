package com.vtrbtf.minibank.application.query.infrastructure;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailGateway {
    @Value("${mailing.api.endpoint}")
    String emailAPI;

    @Value("${mailing.api.key}")
    String emailAPIKey;

    public void send(String subject, String text, String targetEmail) {
        JSONObject object = emailAPIPayload(subject, text, targetEmail);

        try {
            Unirest.post(emailAPI)
                    .header("Authorization", emailAPIKey)
                    .header("Content-Type", "application/json")
                    .body(object)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    private JSONObject emailAPIPayload(String subject, String text, String targetEmail) {
        return new JSONObject().
                    put("options", new JSONObject().put("sandbox", true)).
                    put("content", new JSONObject().
                            put("from", "sandbox@sparkpostbox.com").
                            put("subject", subject).
                            put("text", text)).
                    put("recipients", new JSONArray().put(new JSONObject().put("address", targetEmail)));
    }

}
