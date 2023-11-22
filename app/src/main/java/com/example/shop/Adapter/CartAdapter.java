package com.example.shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.shop.Domain.PopularDomain;
import com.example.shop.Helper.ChangeNumberItemsListener;
import com.example.shop.Helper.ManagmentCart;
import com.example.shop.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {
    ArrayList<PopularDomain> listItemSelected;
    private ManagmentCart managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdapter(ArrayList<PopularDomain> listItemSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listItemSelected = listItemSelected;
        managmentCart=new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);

        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Viewholder holder, int position) {
        holder.titulo.setText(listItemSelected.get(position).getTitulo());
        holder.feeEachTxt.setText("$"+listItemSelected.get(position).getPrice());
        holder.totalEachItem.setText("$"+Math.round((listItemSelected.get(position).getNumNoCarrinho()*listItemSelected.get(position).getPrice())));
        holder.num.setText(String.valueOf(listItemSelected.get(position).getNumNoCarrinho()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(listItemSelected.get(position).getPicURL()
                ,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,30,30))
                .into(holder.pic);

        holder.PlusItem.setOnClickListener(v -> managmentCart.plusNumberItem(listItemSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.change();
        }));

        holder.minusItem.setOnClickListener(v -> managmentCart.minusNumberItem(listItemSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.change();
        }));
    }

    @Override
    public int getItemCount() {
        return listItemSelected.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView titulo,feeEachTxt,PlusItem,minusItem;
        ImageView pic;
        TextView totalEachItem,num;

        public Viewholder(@NonNull View itemView){
            super(itemView);

            titulo=itemView.findViewById(R.id.tituloTxt);
            pic=itemView.findViewById(R.id.pic);
            feeEachTxt=itemView.findViewById(R.id.feeEachItem);
            totalEachItem=itemView.findViewById(R.id.totalEachItem);
            PlusItem=itemView.findViewById(R.id.PlusCartBnt);
            minusItem=itemView.findViewById(R.id.minusCartBnt);
            num=itemView.findViewById(R.id.numberItemTxt);
        }
    }
}
