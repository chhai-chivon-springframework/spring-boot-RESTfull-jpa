package com.chhaichivon.springbootRESTfulljpa.models;

import com.chhaichivon.springbootRESTfulljpa.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 1:03 PM
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_users")
public class User extends BaseEntity{
    @JsonProperty("USERNAME")
    private String username;
    @JsonProperty("EMAIL")
    private String email;
    @JsonProperty("PASSWORD")
    private String password;
}
