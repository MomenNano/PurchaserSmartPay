package com.android.nfc.purchasersmartpay;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

class PurchaseInformation {
    private String purchaserID;
    private Wallet purchaserWallet;
    private String purchaserCard;
    private String sellerID;
    private double bill;

    public String getPurchaserID() {
        return purchaserID;
    }

    public void setPurchaserID(String purchaserID) {
        this.purchaserID = purchaserID;
    }

    public Wallet getPurchaserWallet() {
        return purchaserWallet;
    }

    public void setPurchaserWallet(Wallet purchaserWallet) {
        this.purchaserWallet = purchaserWallet;
    }

    public String getPurchaserCard() {
        return purchaserCard;
    }

    public void setPurchaserCard(String purchaserCard) {
        this.purchaserCard = purchaserCard;
    }

    public String getSellerID() {
        return sellerID;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public class lol extends AsyncTask<String,String,JSONObject> {

        protected void convertObjectToJSON() throws JSONException {
            JSONObject purchaseInformation = new JSONObject();
            try {
            //    purchaseInformation.put("purchaserID", this.purchaserID);
                purchaseInformation.put("purchaserWallet", purchaserWallet);
            } catch (Exception ex) {
            }


        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... params) {
            String newData;
            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                newData = StringToString(inputStream);
                publishProgress("lol");
            } catch (Exception ex) {
            }
            return null;
        }

        private String StringToString(InputStream inputStream) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String text = "";
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    text += line;
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return text;
        }
    }
}
