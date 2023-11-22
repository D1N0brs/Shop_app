package com.example.shop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.shop.Adapter.PupolarAdapter;
import com.example.shop.Domain.PopularDomain;
import com.example.shop.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterPupolar;
private RecyclerView recyclerViewPupolar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBnt=findViewById(R.id.homeBnt);
        LinearLayout cartBnt=findViewById(R.id.cartBnt);

        homeBnt.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));

        cartBnt.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }

    private void initRecyclerView(){
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain("Camisa Preta","A tecnologia HDR (High Dynamic Range),\n" +
                "que é o padrão mais recente para conteúdo UHD,\n" +
                "oferece uma experiência superior com brilho impressionante,\n" +
                "detalhes de sombra excepcionais e cores vivas,\n" +
                "além disso o HRD 10 faz o mapeamento dinâmico de tons das cores e otimiza a qualidade da imagem,\n" +
                "bem como brilho e contraste. O conteúdo com mais nuances torna sua experiência mais divertida e agradável.\n" +
                "Sente-se e desfrute de detalhes de imagem incríveis como os cineastas pretendem.","item_1",15,4,500));
        items.add(new PopularDomain("Smart Watch","teste teste teste","item_2",10,4.5,450));
        items.add(new PopularDomain("Iphone 14","teste teste teste","item_3",15,4.3,800));
        items.add(new PopularDomain("VisionX Pro LED TV","teste teste teste","item_4",18,4.0,1500));

        recyclerViewPupolar=findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterPupolar=new PupolarAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
}