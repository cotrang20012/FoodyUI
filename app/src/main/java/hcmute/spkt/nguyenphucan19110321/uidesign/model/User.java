package hcmute.spkt.nguyenphucan19110321.uidesign.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private int id;
    private String name;
    private String avatar;
    private String username;
    private String password;
    private String address;
    private String gender;
    private String phone;
}
