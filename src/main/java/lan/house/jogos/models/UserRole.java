package lan.house.jogos.models;

public enum UserRole {
    Administrador ("administrador"),
    Jogador ("jogador");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
