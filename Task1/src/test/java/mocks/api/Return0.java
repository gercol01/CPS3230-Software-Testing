package mocks.api;

import API.API;
import Scan.ScanProduct;

public class Return0 extends API{
    public String post(ScanProduct Object) throws Exception {
        return "0";
    }
}
