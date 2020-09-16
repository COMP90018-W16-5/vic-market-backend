package group.unimeb.market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(required = true, value = "User id", dataType = "int", example = "1")
    private Integer uid;
    @ApiModelProperty(required = true, value = "User email", dataType = "String", example = "demo@demo.com")
    private String email;
    @JsonIgnore
    private String password;
    @ApiModelProperty(required = true, value = "User display name", dataType = "String", example = "Luke Skywalker")
    private String displayName;
    @ApiModelProperty(required = true, value = "Phone number", dataType = "String", example = "Luke Skywalker")
    private String phone;
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;
    @ApiModelProperty(required = true, value = "User photo URL", dataType = "String", example = "https://url/img.png")
    private String photo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}