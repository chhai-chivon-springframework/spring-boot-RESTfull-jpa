package com.chhaichivon.springbootRESTfulljpa.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/25/2017
 * TIME   : 1:09 PM
 */
@Data
public class RoleForm implements Serializable{
    @JsonProperty("ROLE_NAME")
    private String roleName;
    @JsonProperty("DESCRIPTION")
    private String description;
}
