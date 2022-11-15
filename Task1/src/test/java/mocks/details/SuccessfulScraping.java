package mocks.details;

import scanpageobjects.ScanDetailsPageObject;

public class SuccessfulScraping extends ScanDetailsPageObject {
    @Override
    public int scrapeResults() {
        return 0;
    }
}
