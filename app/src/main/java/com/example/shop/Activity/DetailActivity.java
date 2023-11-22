package com.example.shop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shop.Domain.PopularDomain;
import com.example.shop.Helper.ManagmentCart;
import com.example.shop.R;

public class DetailActivity extends AppCompatActivity {
    private Button addToCartBnt;
    private TextView tituloTxt, feeTxt, descricaoTxt, reviewTxt, scoreTxt;
    private ImageView picItem, backBnt;
    private PopularDomain object;
    private int numberOrder=1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managmentCart=new ManagmentCart(this);

        initView();
        getBundle();
    }

    private void getBundle() {
        object= (PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(object.getPicURL(),"drawable",this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picItem);

        tituloTxt.setText(object.getTitulo());
        feeTxt.setText("$"+object.getPrice());
        descricaoTxt.setText(object.getDescricao());
        reviewTxt.setText(object.getReview()+"");
        scoreTxt.setText(object.getScore()+"");

        addToCartBnt.setOnClickListener(v -> {
            object.setNumNoCarrinho(numberOrder);
            managmentCart.insertFood(object);
        });
        backBnt.setOnClickListener(v -> finish());
    }

    private void initView() {
        addToCartBnt=findViewById(R.id.addToCartBnt);
        feeTxt=findViewById(R.id.priceTxt);
        tituloTxt=findViewById(R.id.tituloTxt);
        descricaoTxt=findViewById(R.id.descricaoTxt);
        picItem=findViewById(R.id.itemPic);
        reviewTxt=findViewById(R.id.reviewTxt);
        scoreTxt=findViewById(R.id.scoreTxt);
        backBnt=findViewById(R.id.backBnt);

    }
}