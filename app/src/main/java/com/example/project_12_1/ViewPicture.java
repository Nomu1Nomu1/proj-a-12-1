package com.example.project_12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jsibbold.zoomage.ZoomageView;

import java.io.File;

public class ViewPicture extends AppCompatActivity {

    ZoomageView image;
    String image_file;
    LinearLayout detailLayout;
    TextView imageName, imageSize, imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);

        image_file = getIntent().getStringExtra("image_file");
        image = findViewById(R.id.image);
        detailLayout = findViewById(R.id.details_layout);
        imageName = findViewById(R.id.image_name);
        imageSize = findViewById(R.id.image_size);
        imagePath = findViewById(R.id.image_path);

        if (image_file != null) {
            Uri imageUri = Uri.parse(image_file);

            Glide.with(this)
                    .load(imageUri)
                    .into(image);

            File file = new File(image_file);
            imageName.setText("File: " + file.getName());
            imageSize.setText("Size: " + file.length() / 1024 + " KB");
            imagePath.setText("Path: " + file.getAbsolutePath());
        }

        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailLayout.getVisibility() == View.GONE) {
                    detailLayout.setVisibility(View.VISIBLE);
                } else {
                    detailLayout.setVisibility(View.GONE);
                }
            }
        });

        findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}