package co.edu.uco.carpooling.dto;

import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;

import java.util.UUID;

public class CustomerDTO {
    private UUID id;
    private String dni;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private static String password;
    private static String companyEmail;
    private int phone;
    private static int rol;

    public CustomerDTO(UUID id, String dni, String firstName, String secondName, String firstSurname,
                       String secondSurname, String password, String companyEmail, int phone, int rol) {
        setId(id);
        setDni(dni);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstSurname(firstSurname);
        setSecondSurname(secondSurname);
        setPassword(password);
        setCompanyEmail(companyEmail);
        setPhone(phone);
        setRol(rol);
    }

    public CustomerDTO() {
        setId(UtilUUID.getDefaultUUID(id));
        setDni(UtilText.EMPTY);
        setFirstName(UtilText.EMPTY);
        setSecondName(UtilText.EMPTY);
        setFirstSurname(UtilText.EMPTY);
        setSecondSurname(UtilText.EMPTY);
        setPassword(UtilText.EMPTY);
        setCompanyEmail(UtilText.EMPTY);
        setPhone(UtilNumeric.ZERO);
        setRol(UtilNumeric.ZERO);
    }

    private CustomerDTO(String password, String companyEmail, int rol) {
        this.password = password;
        this.companyEmail = companyEmail;
        this.rol = rol;
    }

    public static CustomerDTO create() {
        return new CustomerDTO();
    }

    public static CustomerDTO createPatch() {
        return new CustomerDTO(password, companyEmail, rol);
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
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

    public void setPhone(int phone) {
        this.phone = (int) UtilNumeric.getUtilNumeric().getDefault(phone);
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = UtilText.getUtilText().trim(companyEmail);
    }

    public void setPassword(String password) {
        this.password = UtilText.getUtilText().trim(password);
    }

    public void setRol(int rol) {
        this.rol = (int) UtilNumeric.getUtilNumeric().getDefault(rol);
    }

    public UUID getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public int getPhone() {
        return phone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }
    public String getPassword() {
        return password;
    }
    public int getRol() {
        return rol;
    }
}
