package com.example.administrator.oldbook;

/**
 * Created by YYS on 2017/5/14.
 */

public class Book_Classify_Adapter {
    private String BookInformation;
    private int BookImageId;
    public Book_Classify_Adapter(String Bookinformation, int BookimageId){
        this.BookImageId=BookimageId;
        this.BookInformation=Bookinformation;

    }

    public String getBookInformation() {
        return BookInformation;
    }

    public int getBookImageId() {
        return BookImageId;
    }
}
