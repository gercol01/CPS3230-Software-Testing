package mocks.api;

import Scan.ScanProduct;
import API.API;

public class Return200 extends API{
    public String post(ScanProduct Object) throws Exception {
        return "200";
    }
}
