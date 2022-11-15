package mocks.details;

import scanpageobjects.ScanDetailsPageObject;

public class PriceError extends ScanDetailsPageObject {
    @Override
    public int getDetails(String webElement) {
        return 6;
    }
}
