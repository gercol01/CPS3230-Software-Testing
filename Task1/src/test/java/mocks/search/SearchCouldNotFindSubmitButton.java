package mocks.search;

import scanpageobjects.ScanSearchPageObject;

public class SearchCouldNotFindSubmitButton extends ScanSearchPageObject {
    @Override
    public int inputText(){
        return 11;
    }

    @Override
    public int submitSearchButton(){
        return 110;
    }
}
