import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Basic {

    public static void GetDetails() throws IOException, ParseException {
        // http://10.3.45.11:8080/myTeam/attendance/employeeLoginsBasedOnDate?empId=16374&fromDate=2020-02-01&toDate=2020-02-25
        RestAssured.baseURI = "http://10.3.45.11:8080/myTeam/attendance/employeeLoginsBasedOnDate";
        RequestSpecification httpRequest = RestAssured.given();
        Map<String, String> head = new HashMap<String, String>();
        head.put("empId", "16606");
        head.put("fromDate", "2020-02-01");
        head.put("toDate", "2020-02-25");
        Response response = httpRequest.queryParams(head).request(Method.GET);
        String responseBody = response.getBody().asString();
// System.out.println("Response Body is =>  " + responseBody);


        Response response1 = httpRequest.queryParam("empId", "16374")
                .queryParam("fromDate", "2020-02-01")
                .queryParam("toDate", "2020-02-19").request(Method.GET);
        String resp = response1.getBody().asString();
        System.out.println(response1.getBody().asString());


        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(resp);
        System.out.println(json.toJSONString());
        PrintWriter pw = new PrintWriter("JSONExample.json");
        pw.write(json.toJSONString());
        pw.close();

        JSONObject ja = (JSONObject) json.get(0);
        System.out.println("Total Average Time: "+ja.get("totalAvgTime"));
    }
}
