package com.ra.ptit_cntt2_it211_ss7_ex5.dto;

public class TransactionRequest {
    private String toWalletAddress;
    private double amountInUsd;
    private String tokenSymbol;

    public String getToWalletAddress() { return toWalletAddress; }
    public void setToWalletAddress(String toWalletAddress) { this.toWalletAddress = toWalletAddress; }
    public double getAmountInUsd() { return amountInUsd; }
    public void setAmountInUsd(double amountInUsd) { this.amountInUsd = amountInUsd; }
    public String getTokenSymbol() { return tokenSymbol; }
    public void setTokenSymbol(String tokenSymbol) { this.tokenSymbol = tokenSymbol; }
}