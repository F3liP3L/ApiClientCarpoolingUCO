package co.edu.uco.carpooling.service.domain;


import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;
import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;

@Getter
public class CustomerDomain {
    private UUID id;
    private String dni;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String password;
    private String companyEmail;
    private int phone;
    private int rol;

    public CustomerDomain(UUID id, String dni, String firstName, String secondName, String firstSurname,
                          String secondSurname,String password, int phone, String companyEmail, int rol) {
        setId(id);
        setDni(dni);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstSurname(firstSurname);
        setSecondSurname(secondSurname);
        setPassword(password);
        setPhone(phone);
        setCompanyEmail(companyEmail);
        setRol(rol);
    }

    public CustomerDomain() {
        setId(UtilUUID.getNewUUID());
        setDni(UtilText.EMPTY);
        setFirstName(UtilText.EMPTY);
        setSecondName(UtilText.EMPTY);
        setFirstName(UtilText.EMPTY);
        setFirstSurname(UtilText.EMPTY);
        setSecondSurname(UtilText.EMPTY);
        setPassword(UtilText.EMPTY);
        setPhone(UtilNumeric.ZERO);
        setCompanyEmail(UtilText.EMPTY);
        setRol(UtilNumeric.ZERO);
    }

    public void setId(UUID id) {
        this.id = id == null ? getNewUUID() : getDefaultUUID(id);
    }

    public void setDni(String dni) {
        this.dni = UtilText.getUtilText().trim(dni);
    }

    public void setFirstName(String firstName) {
        this.firstName = UtilText.getUtilText().trim(firstName);
    }

    public void setSecondName(String secondName) {
        this.secondName = UtilText.getUtilText().trim(secondName);
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = UtilText.getUtilText().trim(firstSurname);
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = UtilText.getUtilText().trim(secondSurname);
    }

    public void setPassword(String password) {
        this.password = UtilText.getUtilText().trim(password);
    }

    public void setPhone(int phone) {
        this.phone = (int) UtilNumeric.getUtilNumeric().getDefault(phone);
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = UtilText.getUtilText().trim(companyEmail);
    }

    public void setRol(int rol) {
        this.rol = (int) UtilNumeric.getUtilNumeric().getDefault(rol);
    }
}
