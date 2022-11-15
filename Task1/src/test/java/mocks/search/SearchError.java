package mocks.search;

import scanpageobjects.ScanSearchPageObject;

public class SearchError extends ScanSearchPageObject {

    @Override
    public int Search(){
        return -1;
    }
}
