package mocks.search;

import scanpageobjects.ScanSearchPageObject;

public class SearchCorrectTitle extends ScanSearchPageObject {
    @Override
    public int inputText(){
        return 11;
    }

    @Override
    public int submitSearchButton(){
        return 111;
    }

    @Override
    public int getTitle(){
        return 1;
    }
}
