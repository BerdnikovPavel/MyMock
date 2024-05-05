package org.example.Mock.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ClientInfo {

    private BigInteger id;
    private String clientName;
    private String status;
    private String clientCode;

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public BigInteger getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getStatus() {
        return status;
    }

    public String getClientCode() {
        return clientCode;
    }
}
