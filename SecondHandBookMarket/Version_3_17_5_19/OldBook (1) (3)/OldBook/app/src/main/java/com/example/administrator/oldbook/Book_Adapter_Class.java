package com.example.administrator.oldbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by YYS on 2017/5/14.
 */

public class Book_Adapter_Class extends ArrayAdapter<Book_Classify_Adapter> {

    private int rescourceid;

    public Book_Adapter_Class(Context context, int textViewResourceid, List<Book_Classify_Adapter> objects) {
        super(context, textViewResourceid, objects);
        rescourceid = textViewResourceid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book_Classify_Adapter book = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(rescourceid,null);
        ImageView Book_Image = (ImageView) view.findViewById(R.id.Book_Image);
        TextView Book_Text = (TextView) view.findViewById(R.id.Book_Information);

        Book_Text.setText(book.getBookInformation());
         Book_Image.setImageResource(book.getBookImageId());
        return view;
    }
}
