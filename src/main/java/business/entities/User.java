package business.entities;

public class User
{

    public User(String email, String password, String role)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.saldo = saldo;
    }

    private int user_id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private int saldo;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getUserid()
    {
        return user_id;
    }

    public void setUserId(int id)
    {
        this.user_id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
