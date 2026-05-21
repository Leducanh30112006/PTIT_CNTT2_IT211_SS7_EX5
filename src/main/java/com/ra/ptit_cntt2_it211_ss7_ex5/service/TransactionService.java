package com.ra.ptit_cntt2_it211_ss7_ex5.service;

import com.ra.ptit_cntt2_it211_ss7_ex5.dto.TransactionRequest;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    public String performTransaction(TransactionRequest request) {

        System.out.println("CORE SERVICE: Đang thực thi chuyển " + request.getAmountInUsd()
                + " USD tới ví " + request.getToWalletAddress());

        return "SUCCESS";
    }
}