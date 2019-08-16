package com.bxg.community.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class AccesstokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;

}
