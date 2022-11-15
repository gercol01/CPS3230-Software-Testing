package mainMethod;

import API.API;
import Webscraper.Webscraper;
import scanpageobjects.ScanDetailsPageObject;
import scanpageobjects.ScanProductListPageObject;
import scanpageobjects.ScanSearchPageObject;

public class Runner {

    public static void main(String args[]) throws Exception {
        Webscraper webscraper = new Webscraper();
        ScanSearchPageObject searchPageObject = new ScanSearchPageObject();
        ScanProductListPageObject listPageObject = new ScanProductListPageObject();
        ScanDetailsPageObject detailsPageObject = new ScanDetailsPageObject();
        API api = new API();

        String listResult;

        searchPageObject.setText("Microsoft Laptop");
        searchPageObject.setSearchBarPath("//*[@id=\"search\"]");
        searchPageObject.setSubmitButtonPath("//*[@id=\"search_mini_form\"]/div[3]/button");
        webscraper.searchScanObject(searchPageObject);

        listPageObject.setNoProduct(2);
        listPageObject.setObjectPath1("//*[@id=\"maincontent\"]/div[3]/div[1]/div[5]/div[2]/ol/li[");
        listPageObject.setObjectPath2("]/div/div[2]/strong/a");
        webscraper.getResults(listPageObject);

        webscraper.scrapeResults(detailsPageObject);

        webscraper.postAlerts(api);
    }
}
