package DadosHotel;

public class DadosHotel {
    
    private int id;
    private String nome;
    private String telefone;
    private String cpf;
    private String dataDaConsulta;
    private String jaEraPaciente;
    
    public DadosHotel(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDaConsulta() {
        return dataDaConsulta;
    }

    public void setDataDaConsulta(String dataDaConsulta) {
        this.dataDaConsulta = dataDaConsulta;
    }

    public String getJaEraPaciente() {
        return jaEraPaciente;
    }

    public void setJaEraPaciente(String jaEraPaciente) {
        this.jaEraPaciente = jaEraPaciente;
    }

}
