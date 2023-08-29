package co.edu.uco.carpooling.dto;


import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilUUID.getDefaultUUID;
import static co.edu.uco.crosscutting.util.UtilUUID.getNewUUID;


public class UserDTO {
    private UUID id;
    private String dni;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private int phone;
    private String companyEmail;

    public UserDTO(UUID id, String dni, String firstName, String secondName, String firstSurname,
                   String secondSurname, int phone, String companyEmail) {
        setId(id);
        setDni(dni);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstName(firstSurname);
        setSecondSurname(secondSurname);
        setPhone(phone);
        setCompanyEmail(companyEmail);
    }

    public UserDTO() {
        setId(UtilUUID.getNewUUID());
        setDni(UtilText.EMPTY);
        setFirstName(UtilText.EMPTY);
        setSecondName(UtilText.EMPTY);
        setFirstName(UtilText.EMPTY);
        setSecondSurname(UtilText.EMPTY);
        setPhone(UtilNumeric.ZERO);
        setCompanyEmail(UtilText.EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id == null ? getNewUUID() : getDefaultUUID(id);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = UtilText.getUtilText().trim(dni);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = UtilText.getUtilText().trim(firstName);
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = UtilText.getUtilText().trim(secondName);
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = UtilText.getUtilText().trim(firstSurname);
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = UtilText.getUtilText().trim(secondSurname);
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = (int) UtilNumeric.getUtilNumeric().getDefault(phone);
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = UtilText.getUtilText().trim(companyEmail);
    }
}
