package com.example.administrator.oldbook;
/*create by 姚元帅*/

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SellingBooks extends SwipeBackActivity implements View.OnClickListener {

    private Button SellButton;
    private Button CancleButton;
    private EditText BookName;
    private EditText BookVersion;
    private EditText BookPublishCompany;
    private EditText BookAuthour;
    private EditText Location;
    private ImageView BookPicture;
    private String Ispersion;

    //相册选择照片
    public static final int CHOOSE_PHOTO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling_books);
        SellButton = (Button) findViewById(R.id.Scale_Book);
        CancleButton = (Button) findViewById(R.id.Cancle_Book);


        BookName = (EditText) findViewById(R.id.BookName_Editext);
        BookVersion = (EditText) findViewById(R.id.BookVersions_Editext);
        BookPublishCompany = (EditText) findViewById(R.id.PublishingCompany_Editext);
        BookAuthour = (EditText) findViewById(R.id.Author_Editext);
        Location = (EditText) findViewById(R.id.LocalTion_Editext);
        BookPicture = (ImageView) findViewById(R.id.Book_Picture);

        SellButton.setOnClickListener(this);
        CancleButton.setOnClickListener(this);
        BookPicture.setOnClickListener(this);
        //获取是否具有权限
        Intent IspersionIntent = getIntent();
        Ispersion = IspersionIntent.getStringExtra("Ispersion");
    }

    //从相册选取
                 /*打开相册*/
    private void open() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        //选择照片
        startActivityForResult(intent, CHOOSE_PHOTO);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Scale_Book:
                if (BookName.getText().toString().length() == 0) {
                    Toast.makeText(this, "书名不能为空", Toast.LENGTH_LONG).show();
                    break;
                }
                if (BookVersion.getText().toString().length() == 0) {
                    Toast.makeText(this, "版本不能为空", Toast.LENGTH_LONG).show();
                    break;
                }
                if (BookAuthour.getText().toString().length() == 0) {
                    Toast.makeText(this, "作者不能为空", Toast.LENGTH_LONG).show();
                    break;
                }
                if (BookPublishCompany.getText().toString().length() == 0) {
                    Toast.makeText(this, "出版社不能为空", Toast.LENGTH_LONG).show();
                    break;
                }
                if (Location.getText().toString().length() == 0) {
                    Toast.makeText(this, "当前位置不能为空", Toast.LENGTH_LONG).show();
                    break;
                }
             /*   if (BookPicture.) {
                    Toast.makeText(this, "请上传书籍图片", Toast.LENGTH_LONG).show();
                    break;
                }*/
                Toast.makeText(this, "已发布出售信息", Toast.LENGTH_LONG).show();
                break;
            case R.id.Cancle_Book:
                Toast.makeText(this, "已取消出售", Toast.LENGTH_LONG).show();
                break;
            case R.id.Book_Picture:
                //判断是否具有权限
                if (Ispersion.equals("true")) {
                    open();
                } else {
                    Toast.makeText(SellingBooks.this, "已拒绝上传照片的权限，请在手机中开启该权限", Toast.LENGTH_SHORT).show();

                }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK) {
                    //根据安卓版本选择解析照片方法
                    if (Build.VERSION.SDK_INT >= 19) {
                        handleImageOnKitKat(data);
                    } else
                        handleImageBefore(data);
                }
            default:
                break;
        }
    }

    //进行解析uri，获取选中的图片的路径，然后显示
    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        String imagepath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            String docid = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docid.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagepath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("contetn://downloads" + "/public_downloads"), Long.valueOf(docid));
                imagepath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            imagepath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            imagepath = uri.getPath();
        }
        displayImage(imagepath);
    }

    //不解析uri，直接获取路径显示
    private void handleImageBefore(Intent da) {
        Uri uri = da.getData();
        String imagepath = getImagePath(uri, null);
        displayImage(imagepath);

    }

    //显示
    private void displayImage(String imagepath) {
        if (imagepath != null) {
            //得到原图
            Bitmap bitmap = BitmapFactory.decodeFile(imagepath);
            //得到固定大小的缩略图
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, 200, 200);

            BookPicture.setImageBitmap(bitmap);
        }
    }

    //获得路径
    public String getImagePath(Uri uri, String selection) {
        String imagePath = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                imagePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return imagePath;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)       //抓取按键信息
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)       //抓取back按键
        {
            scrollToFinishActivity();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
