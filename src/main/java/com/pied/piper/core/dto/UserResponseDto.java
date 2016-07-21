package com.pied.piper.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pied.piper.core.db.model.User;
import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;

/**
 * Created by akshay.kesarwan on 21/07/16.
 */
@Data
@JsonSnakeCase
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseDto {
    private Long userId;

    private String accountId;

    private String name;

    private String avatarUrl;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.accountId = user.getAccountId();
        this.name = user.getName();
        this.avatarUrl = user.getAvatarUrl();
    }
}
