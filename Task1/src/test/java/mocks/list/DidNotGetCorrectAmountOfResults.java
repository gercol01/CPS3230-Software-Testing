package mocks.list;

import scanpageobjects.ScanProductListPageObject;

public class DidNotGetCorrectAmountOfResults extends ScanProductListPageObject {
    @Override
    public int getResults() {
        return 10;
    }
}
