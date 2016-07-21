package com.pied.piper.core.db.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by palash.v on 21/07/16.
 */
@Data
@Entity
@EqualsAndHashCode
@JsonSnakeCase
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class User {
    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "version")
    @Version
    private Integer version;

    @OneToMany(mappedBy = "sourceUser", fetch = FetchType.LAZY)
    private List<UserRelations> followers = new ArrayList<>();

}
