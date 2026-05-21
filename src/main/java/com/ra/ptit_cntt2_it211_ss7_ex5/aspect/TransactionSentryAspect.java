package com.ra.ptit_cntt2_it211_ss7_ex5.aspect;

import com.ra.ptit_cntt2_it211_ss7_ex5.dto.TransactionRequest;
import com.ra.ptit_cntt2_it211_ss7_ex5.exception.HighRiskException;
import com.ra.ptit_cntt2_it211_ss7_ex5.exception.InvalidTransactionDataException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionSentryAspect {

    private static final double RISK_LIMIT_USD = 10000.0;

    @Before("execution(* com.ra.ptit_cntt2_it211_ss7_ex5.service.TransactionService.performTransaction(..))")
    public void inspectTransaction(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        if (args.length == 0 || !(args[0] instanceof TransactionRequest)) {
            return;
        }

        TransactionRequest request = (TransactionRequest) args[0];

        if (request.getAmountInUsd() <= 0) {
            throw new InvalidTransactionDataException("Giao dịch không hợp lệ: Số lượng tiền gửi phải lớn hơn 0 USD.");
        }

        if (request.getToWalletAddress() == null || request.getToWalletAddress().trim().length() < 5) {
            throw new InvalidTransactionDataException("Giao dịch không hợp lệ: Địa chỉ ví nhận không được trống và phải có độ dài từ 5 ký tự trở lên.");
        }

        if (request.getAmountInUsd() > RISK_LIMIT_USD) {
            System.err.println("ALERT: Phát hiện giao dịch giá trị cao cần đóng băng! Số tiền: " + request.getAmountInUsd() + " USD");
            throw new HighRiskException("Giao dịch bị tạm giữ: Giá trị vượt quá " + RISK_LIMIT_USD + " USD. Yêu cầu phê duyệt thủ công từ Quản trị viên.");
        }

        System.out.println("SENTRY LOG: Giao dịch hợp lệ. Cho phép gửi qua lõi xử lý.");
    }
}