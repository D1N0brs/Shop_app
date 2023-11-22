package com.example.shop.Helper;

import android.app.LauncherActivity;
import android.content.Context;
import android.widget.Toast;

import com.example.shop.Domain.PopularDomain;

import java.util.ArrayList;

public class ManagmentCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context){
        this.context=context;
        this.tinyDB=new TinyDB(context);
    }

    public void insertFood(PopularDomain item){
        ArrayList<PopularDomain> listpop=getListCart();
        boolean existAlready = false;
        int n=0;
        for(int i=0; 1<listpop.size(); i++){
            if (listpop.get(i).equals(item.getTitulo())){
                existAlready = true;
                n = 1;
                break;
            }
        }
        if (existAlready){
            listpop.get(n).setNumNoCarrinho(item.getNumNoCarrinho());
        }else{
            listpop.add(item);
        }
        tinyDB.putListObject("Carlist",listpop);
        Toast.makeText(context, "Adicionar ao Carrinho", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<PopularDomain> getListCart(){

        return tinyDB.getListObject("Carlist");
    }
    public Double getTotalFee(){
        ArrayList<PopularDomain> listItem=getListCart();
        double fee=0;
        for (int i=0; i<listItem.size();i++){
            fee=fee+(listItem.get(i).getPrice()*listItem.get(i).getNumNoCarrinho());
        }
        return fee;
    }
    public void minusNumberItem(ArrayList<PopularDomain> listItem,int position,ChangeNumberItemsListener changeNumberItemsListener){
        if(listItem.get(position).getNumNoCarrinho()==1){
            listItem.remove(position);
        }else {
            listItem.get(position).setNumNoCarrinho(listItem.get(position).getNumNoCarrinho()-1);
        }
        tinyDB.putListObject("Cartlist", listItem);
        changeNumberItemsListener.change();
    }
    public void plusNumberItem(ArrayList<PopularDomain> listItem,int position,ChangeNumberItemsListener changeNumberItemsListener){
        listItem.get(position).setNumNoCarrinho(listItem.get(position).getNumNoCarrinho()+1);
        tinyDB.putListObject("Cartlist",listItem);
        changeNumberItemsListener.change();
    }
}
