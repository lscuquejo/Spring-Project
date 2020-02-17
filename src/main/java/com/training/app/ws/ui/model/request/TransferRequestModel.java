package com.training.app.ws.ui.model.request;

import java.math.BigDecimal;

public class TransferRequestModel {
    private String sourceId;
    private BigDecimal sourceBalance;
    private String targetId;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public BigDecimal getSourceBalance() {
        return sourceBalance;
    }

    public void setSourceBalance(BigDecimal sourceBalance) {
        this.sourceBalance = sourceBalance;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

}