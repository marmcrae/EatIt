package com.project.eatit.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.project.eatit.Model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME = "DB.db";
    private  static final int DB_VER = 1;


    public Database(Context context) { super(context, DB_NAME, null, DB_VER );}

    public List<Order> getCarts() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();


        String[] sqlSelect = {"ProductName", "ProductId", "Quantity", "Price", "Discount"};
        String sqlTable = "OrderDetail";


        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null );


        final List<Order> result = new ArrayList<>();
        if (c.moveToFirst()) {
            do{
                result.add(new Order(
                        c.getString(c.getColumnIndex("ProduceId")),
                        c.getString(c.getColumnIndex("ProduceName")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Price")),
                        c.getString(c.getColumnIndex("Discount"))
                        ));
            }while (c.moveToNext());
        }return result;



    }


    public void addToCart (Order order) {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO OrderDetail( ProductId, ProductName, Quantity, Price, Discount) VALUES ('%s','%s','%s','%s','%s');",
                order.getProduceId(),
                order.getProduceName(),
                order.getQuantity(),
                order.getPrice(),
                order.getDiscount());

            db.execSQL(query);


    }


    public  void clearCart() {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM OrderDetail");
        db.execSQL(query);
    }


    public void addToFavourites(String foodId) {
        SQLiteDatabase db = getReadableDatabase();
        String query =  String.format("INSERT INTO Favorites WHERE foodId=%s;", foodId);
        db.execSQL(query);
    }

    public void removeFromFavorites(String foodId) {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM Favorites WHERE foodId=%s;", foodId);
        db.execSQL(query);
    }

    public boolean isFavorites(String foodId) {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("SELECT * FROM Favorites WHERE foodId=%s;", foodId);
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.getCount() <= 0 ) {
            cursor.close();
            return false;
        } cursor.close();
        return  true;

    }

















}
