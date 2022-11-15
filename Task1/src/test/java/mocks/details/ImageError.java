package mocks.details;

import scanpageobjects.ScanDetailsPageObject;

public class ImageError extends ScanDetailsPageObject {
    @Override
    public int getDetails(String webElement) {
        return 2;
    }
}
