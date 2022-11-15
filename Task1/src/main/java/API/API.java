package API;

import Scan.ScanProduct;
import okhttp3.*;

import java.util.ArrayList;

public class API {
    ArrayList<ScanProduct> listOfObjects;

    public void setListOfObjects(ArrayList<ScanProduct> ListOfObjects){
        listOfObjects = ListOfObjects;
    }

    public String post(ScanProduct Object) throws Exception{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"alertType\": "+ Object.getAlertType() +",\r\n    \"heading\": \""+Object.getTitle()+"\" ,\r\n    \"description\": \""+Object.getDesc()+"\",\r\n    \"url\": \""+Object.getCurrentUrl()+"\",\r\n    \"imageUrl\": \""+Object.getImageUrl()+"\",\r\n    \"postedBy\": \""+Object.getUserName()+"\",\r\n    \"priceInCents\": \""+ Object.getPrice() +"\"\r\n}");
        Request request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        if(response.code() == 201){
            return "200";
        }
        else{
            return "0";
        }
    }

    public int postAlerts() throws Exception {
        String flag = "";


        for(int i=0; i<listOfObjects.size(); i++){
            flag = post(listOfObjects.get(i));
            if(flag.equals("0")){
                break;
            }
        }

        if(flag.equals("0")){
            return 0;
        }
        else{
            return 200;
        }
    }
}
