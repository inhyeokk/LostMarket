package com.sejong.unknown.view.upload;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.sejong.unknown.R;
import com.sejong.unknown.util.ImageUtil;
import com.sejong.unknown.util.NetworkUtil;
import com.sejong.unknown.util.PHPRequest;

import java.net.MalformedURLException;

public class UploadActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION = 1001;
    private static final int REQUEST_GALLERY = 5001;

    EditText get_date,get_place,store_place,tag_name,detail_name,detail;
    Button upload_btn;
    ImageView user_image;
    private Uri capuri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        NetworkUtil.setNetworkPolicy(); // 연결 초기 셋팅
        get_date = (EditText)findViewById(R.id.get_date);
        get_place = (EditText)findViewById(R.id.get_place);
        store_place = (EditText)findViewById(R.id.store_place);
        tag_name = (EditText)findViewById(R.id.tag_name);
        detail_name = (EditText)findViewById(R.id.detail_name);
        detail = (EditText)findViewById(R.id.detail);
        upload_btn = (Button) findViewById(R.id.upload_btn);
        user_image = (ImageView)findViewById(R.id.user_image);
        user_image.setOnClickListener(v -> requestPermission());

        upload_btn.setOnClickListener(v -> {
            PHPRequest request = null;
            try {
                request = new PHPRequest("http://interface518.dothome.co.kr/caps/lost_upload.php");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            String result = request.PhPtest(0, ImageUtil.toBase64(user_image).replace("\"", ""), get_date.getText().toString(),get_place.getText().toString(),store_place.getText().toString(),tag_name.getText().toString(),
                    detail_name.getText().toString(),0,"","",detail.getText().toString());
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_GALLERY:
                switch (resultCode) {
                    case RESULT_OK:
                        capuri = data.getData();
                        ImageUtil.setGalleryURI(user_image, capuri);
                        break;
                    case RESULT_CANCELED:
                        // do nothing
                        break;
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_PERMISSION:
                if (grantResults.length > 0 && grantResults[0]
                        == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
                    goToGallery();
                } else {
                    // permission denied
                    // do nothing
                }
                break;
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_PERMISSION
        );
    }

    private void goToGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, REQUEST_GALLERY);
    }
}
