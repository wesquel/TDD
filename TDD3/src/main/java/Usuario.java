import java.util.Calendar;

public class Usuario {
    private String nome;
    private String dataNascimento;
    private long cpf;
    private boolean prioritario;
    private String profissao;
    private int senha;

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public Usuario(String nome, String dataNascimento, boolean prioritario, String cpf, int senha,String profissao) {
        this.setNome(nome);
        this.setPrioritario(prioritario);
        this.setDataNascimento(dataNascimento);
        this.setCpf(cpf);
        this.setProfissao(profissao);
        this.setSenha(senha);
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        try {
            if (cpf.length() == 11){
                this.cpf = Long.parseLong(cpf);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Cpf Invalido!");
        }

    }

    public boolean isPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws NumberFormatException{
        String[] data = dataNascimento.split("/");
        if (data.length == 3 && data[0].length() == 2 && data[1].length() == 2 && data[2].length() == 4){
            try {
                int day = Integer.parseInt(data[0]);
                int moth = Integer.parseInt(data[1]);
                int year = Integer.parseInt(data[2]);
                if (day > 31 || day < 1 || moth < 1 || moth > 12 || year < 1800) {
                    System.out.println("Data invalida");
                }
                else{
                    if (Calendar.getInstance().get(Calendar.YEAR) - year >= 60){
                        setPrioritario(true);
                    }
                    this.dataNascimento = dataNascimento;
                }
            }
            catch (NumberFormatException nfe){
                System.out.println("Formato de data invalido!");
            }
        }
    }
}
