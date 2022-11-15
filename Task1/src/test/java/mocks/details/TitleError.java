package mocks.details;

import scanpageobjects.ScanDetailsPageObject;

public class TitleError extends ScanDetailsPageObject {
    @Override
    public int getDetails(String webElement) {
        return 1;
    }
}
