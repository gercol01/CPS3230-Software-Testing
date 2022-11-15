package mocks.search;

import scanpageobjects.ScanSearchPageObject;

public class SearchIsInvalid extends ScanSearchPageObject {

    @Override
    public int Search() {
        return 0;
    }
}
