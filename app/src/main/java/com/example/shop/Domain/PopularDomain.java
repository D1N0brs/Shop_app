package com.example.shop.Domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String titulo;
    private String descricao;
    private String picURL;
    private int review;
    private double score;
    private int numNoCarrinho;
    private double price;

    public PopularDomain(String titulo, String descricao, String picURL, int review, double score, double price) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.picURL = picURL;
        this.review = review;
        this.score = score;

        this.price = price;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumNoCarrinho() {
        return numNoCarrinho;
    }

    public void setNumNoCarrinho(int numNoCarrinho) {
        this.numNoCarrinho = numNoCarrinho;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
