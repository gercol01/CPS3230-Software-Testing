package mocks.details;

import scanpageobjects.ScanDetailsPageObject;

public class UsernameError extends ScanDetailsPageObject {
    @Override
    public int getDetails(String webElement) {
        return 5;
    }
}
